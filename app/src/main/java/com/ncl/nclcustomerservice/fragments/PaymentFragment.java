package com.ncl.nclcustomerservice.fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.ncl.nclcustomerservice.R;
import com.ncl.nclcustomerservice.activity.MainActivity;
import com.ncl.nclcustomerservice.commonutils.Common;
import com.ncl.nclcustomerservice.commonutils.Constants;
import com.ncl.nclcustomerservice.database.DatabaseHandler;
import com.ncl.nclcustomerservice.network.RetrofitRequestController;
import com.ncl.nclcustomerservice.network.RetrofitResponseListener;
import com.ncl.nclcustomerservice.object.ApiRequestController;
import com.ncl.nclcustomerservice.object.ApiResponseController;
import com.ncl.nclcustomerservice.object.LeftNav;
import com.ncl.nclcustomerservice.object.PaymentCollectionList;
import com.ncl.nclcustomerservice.object.PaymentCollectionResVo;
import com.ncl.nclcustomerservice.object.Team;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by SupraSoft on 3/6/2019.
 */

public class PaymentFragment extends BaseFragment implements RetrofitResponseListener, SwipeRefreshLayout.OnRefreshListener{
    @BindView(R.id.payment_list)
    RecyclerView payment_recycler;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    private ImageView addView;
    private ImageView filterView;
    private LeftNav paymentLeftNav;
    private List<PaymentCollectionList> paymentCollectionLists;
    DatabaseHandler db;
    private boolean isRefreshing;
    private String queryString="%%";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.payment_fragment,container,false);
        ButterKnife.bind(this,view);
        db = DatabaseHandler.getDatabase(getActivity());

        ((TextView) ((MainActivity) getActivity()).getSupportActionBar().getCustomView().findViewById(R.id.title_text)).setText("Payment Collection");

        filterView = ((MainActivity)getActivity()).findViewById(R.id.filter_task);
        filterView.setVisibility(View.GONE);
        addView = ((MainActivity) getActivity()).findViewById(R.id.add_task);
        paymentLeftNav = (LeftNav) getArguments().getSerializable("payment");

        if (paymentLeftNav.create.equals("1")){
            addView.setVisibility(View.VISIBLE);
        }else {
            addView.setVisibility(View.GONE);
        }
        addView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PaymentCollectionsInsertActivity.class);
                intent.putExtra("form_key", "insert");
                startActivity(intent);
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        payment_recycler.setLayoutManager(linearLayoutManager);

        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setRefreshing(false);


        List<PaymentCollectionList> paymentCollectionLists = db.commonDao().getPaymentCollectionList(500,0);
        if (paymentCollectionLists != null)
            setPaymentAdapter(payment_recycler , paymentCollectionLists);

        ((SearchView)(((MainActivity) getActivity()).findViewById(R.id.searchView))).setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                Common.Log.i(s);
                queryString='%'+s+'%';
                List<PaymentCollectionList> paymentCollectionLists= db.commonDao().getPaymentCollectionList(100,0,queryString);
                if (paymentCollectionLists != null)
                    setPaymentAdapter(payment_recycler,paymentCollectionLists);
                return false;
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        callService(Common.getTeamUserIdFromSP(getActivity()));
    }

    @Override
    public void onResume() {
        super.onResume();

        List<PaymentCollectionList> paymentCollectionLists = db.commonDao().getPaymentCollectionList(500,0);
        if (paymentCollectionLists != null)
            setPaymentAdapter(payment_recycler , paymentCollectionLists);

    }

    @Override
    public void onRefresh() {
        callService(Common.getTeamUserIdFromSP(getActivity()));
        swipeRefreshLayout.setRefreshing(true);
        isRefreshing = true;
    }

    @Override
    public void onResponseSuccess(ApiResponseController objectResponse, ApiRequestController objectRequest, ProgressDialog progressDialog) {
        try{
            switch (objectResponse.requestname){
                case Constants.RequestNames.PAYMENT_COLLECTION_LIST:
                    PaymentCollectionResVo paymentCollectionResVo = Common.getSpecificDataObject(objectResponse.result,PaymentCollectionResVo.class);
                    if (paymentCollectionResVo != null && paymentCollectionResVo.paymentCollectionList != null && paymentCollectionResVo.paymentCollectionList.size() > 0){
                        paymentCollectionLists = paymentCollectionResVo.paymentCollectionList;
                        payment_recycler.setVisibility(View.VISIBLE);
                        db.commonDao().deletePaymentCollectionList();
                        db.commonDao().insertPaymentCollection(paymentCollectionLists);
                        Collections.reverse(paymentCollectionLists);
                        setPaymentAdapter(payment_recycler,paymentCollectionLists);
                    }else {
                        payment_recycler.setVisibility(View.GONE);
                        Toast.makeText(getActivity(),objectResponse.message,Toast.LENGTH_SHORT).show();
                    }

                    swipeRefreshLayout.setRefreshing(false);
                    isRefreshing = false;
            }

            Common.dismissProgressDialog(progressDialog);
        }catch (Exception e){
            Common.disPlayExpection(e, progressDialog);

        }

    }

    private void setPaymentAdapter(RecyclerView payment_recycler, List<PaymentCollectionList> paymentCollectionLists) {
        PaymentAdapter paymentAdapter = new PaymentAdapter(getActivity(),paymentCollectionLists);
        payment_recycler.setAdapter(paymentAdapter);
        paymentAdapter.setOnItemClickListener(new PaymentAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, View itemView, int position) {
                Intent intent = new Intent(getActivity(), PaymentCollectionViewActivity.class);
                intent.putExtra("paymentList",paymentCollectionLists.get(position));
                intent.putExtra("leftNav",paymentLeftNav);
                startActivity(intent);
            }
        });
    }

    @Override
    public void setUserId(String userId) {
        super.setUserId(userId);
        callService(userId);
    }

    private void callService(String userId) {
        if (Common.haveInternet(getActivity())){
            Team team = new Team();
            team.teamId = userId;
            new RetrofitRequestController(this).sendRequest(Constants.RequestNames.PAYMENT_COLLECTION_LIST,team,true);
        }else {
            List<PaymentCollectionList> paymentCollectionLists = db.commonDao().getPaymentCollectionList(500,0);
            if (paymentCollectionLists != null)
                setPaymentAdapter(payment_recycler , paymentCollectionLists);

        }

    }
}
