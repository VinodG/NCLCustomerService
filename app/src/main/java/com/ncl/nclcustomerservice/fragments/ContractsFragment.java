package com.ncl.nclcustomerservice.fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ncl.nclcustomerservice.R;
import com.ncl.nclcustomerservice.activity.MainActivity;
import com.ncl.nclcustomerservice.adapter.ContractsAdapter;
import com.ncl.nclcustomerservice.application.BackgroundService;
import com.ncl.nclcustomerservice.commonutils.Common;
import com.ncl.nclcustomerservice.commonutils.Constants;
import com.ncl.nclcustomerservice.database.DatabaseHandler;
import com.ncl.nclcustomerservice.network.RetrofitRequestController;
import com.ncl.nclcustomerservice.network.RetrofitResponseListener;
import com.ncl.nclcustomerservice.object.ApiRequestController;
import com.ncl.nclcustomerservice.object.ApiResponseController;
import com.ncl.nclcustomerservice.object.ApprovalReqvo;
import com.ncl.nclcustomerservice.object.ContractList;
import com.ncl.nclcustomerservice.object.ContractsResVo;
import com.ncl.nclcustomerservice.object.LeftNav;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ContractsFragment extends BaseFragment implements RetrofitResponseListener , SwipeRefreshLayout.OnRefreshListener{

    @BindView(R.id.contracts_recycleview)
    RecyclerView contracts_recycleview;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.error_message)
    TextView error_message;
    @BindView(R.id.error_image)
    ImageView error_image;
    private ImageView addView;
    private LeftNav contracts;
    DatabaseHandler db;
    private ImageView filterView;
    String bundle;
    private boolean isRefreshing;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_contracts, container, false);
        ButterKnife.bind(this, view);
        db = DatabaseHandler.getDatabase(getActivity());
        bundle = getArguments().getString("notiffication_type_id", "");

        if (Common.haveInternet(getActivity())){
            Common.startService(getActivity(), BackgroundService.class);
        }


        filterView = ((MainActivity) getActivity()).findViewById(R.id.filter_task);
        if (Common.getUserTeam(getActivity()).size() > 1)
            filterView.setVisibility(View.VISIBLE);
        else
            filterView.setVisibility(View.GONE);
        filterView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Common.getSelectedUser(ContractsFragment.this);
            }
        });
        addView = ((MainActivity) getActivity()).findViewById(R.id.add_task);
        contracts = (LeftNav) getArguments().getSerializable("contracts");
        if (contracts.create.equals("1"))
            addView.setVisibility(View.VISIBLE);
        else
            addView.setVisibility(View.GONE);
        ((TextView) ((MainActivity) getActivity()).getSupportActionBar().getCustomView().findViewById(R.id.title_text)).setText("CONTRACTS");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        contracts_recycleview.setLayoutManager(linearLayoutManager);
        addView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addIntent = new Intent(getActivity(), ContractsInsertActivity.class);
                addIntent.putExtra("form_key", "new");
                startActivity(addIntent);
            }
        });

        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setRefreshing(false);

        List<ContractList> contractList = db.commonDao().getContractList(25,0);
        if (contractList != null)
            setOnAdapterContractList(contracts_recycleview, contractList);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        List<ContractList> contractList = db.commonDao().getContractList(25,0);
        if (contractList != null)
            setOnAdapterContractList(contracts_recycleview, contractList);

//        callService(Common.getTeamUserIdFromSP(getActivity()));

    }

    private void callService(String userId) {
        if (Common.haveInternet(getActivity())) {
            ApprovalReqvo approvalReqvo = new ApprovalReqvo();
            approvalReqvo.loggedUserRoleId = Common.getRoleIdFromSP(getActivity());
            approvalReqvo.teamId = userId;
            new RetrofitRequestController(this).sendRequest(Constants.RequestNames.CONTRACTS_LIST, approvalReqvo, true);
        } else {
            List<ContractList> contractList = db.commonDao().getContractList(25,0);
            if (contractList != null)
                setOnAdapterContractList(contracts_recycleview, contractList);
        }
    }

    @Override
    public void onResponseSuccess(ApiResponseController objectResponse, ApiRequestController objectRequest, ProgressDialog progressDialog) {
        try {
            switch (objectRequest.requestname) {
                case Constants.RequestNames.CONTRACTS_LIST:
                    if (objectResponse.result != null) {
                        ContractsResVo contractsResVo = Common.getSpecificDataObject(objectResponse.result, ContractsResVo.class);
                        if (contractsResVo != null && contractsResVo.contractList != null && contractsResVo.contractList.size() > 0) {
                            List<ContractList> contractLists = contractsResVo.contractList;

                            error_image.setVisibility(View.GONE);
                            error_message.setVisibility(View.GONE);

                            contracts_recycleview.setVisibility(View.VISIBLE);
                            db.commonDao().deleteContractList();
                            for (int i = 0; i < contractLists.size(); i++) {
                                db.commonDao().insertContractList(contractLists.get(i));
                                if (contractLists.get(i).contractProduct != null) {
                                    for (int j = 0; j < contractLists.get(i).contractProduct.size(); j++) {
                                        contractLists.get(i).contractProduct.get(j).lineItemId = contractLists.get(i).contractId;
                                    }
                                    db.commonDao().insertContractLineItems(contractLists.get(i).contractProduct);
                                }
                            }
//                            if (bundle == null || bundle.equalsIgnoreCase(""))
                            setOnAdapterContractList(contracts_recycleview, contractLists);
//                            else {
//                                for (int i=0;i<contractLists.size();i++) {
//                                    int contract = Integer.parseInt(contractLists.get(i).contractId);
//                                    if (contract == Integer.parseInt(bundle)) {
//                                        Intent intent = new Intent(getActivity(), ContractViewActivity.class);
//                                        intent.putExtra("contractList", (Serializable) contractLists.get(i));
//                                        intent.putExtra("leftnav", (Serializable) contracts);
//                                        startActivity(intent);
//                                    }
//                                 }
//                                }
                            swipeRefreshLayout.setRefreshing(false);
                            isRefreshing = false;
                        }
                    } else {
                        contracts_recycleview.setVisibility(View.GONE);
                        Toast.makeText(getActivity(), "no data", Toast.LENGTH_SHORT).show();
                        contracts_recycleview.setVisibility(View.GONE);
                        error_image.setVisibility(View.VISIBLE);
                        error_message.setVisibility(View.VISIBLE);
                    }
                    break;
            }
            Common.dismissProgressDialog(progressDialog);
        }catch (Exception e){
            Common.disPlayExpection(e,progressDialog);
        }
    }

    public void setOnAdapterContractList(RecyclerView contracts_recycleview, List<ContractList> contractLists) {
        ContractsAdapter contractsAdapter = new ContractsAdapter(getActivity(), contractLists);
        contracts_recycleview.setAdapter(contractsAdapter);
        contractsAdapter.setOnItemClickListener(new ContractsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, View viewItem, int position) {
                Intent intent = new Intent(getActivity(), ContractViewActivity.class);
                intent.putExtra("contractList", (Serializable) contractLists.get(position));
                intent.putExtra("view","list");
                intent.putExtra("leftnav",(Serializable) contracts);
                startActivity(intent);
            }
        });
    }

    @Override
    public void setUserId(String userId) {
        super.setUserId(userId);
        callService(userId);
    }

    @Override
    public void onRefresh() {
        callService(Common.getTeamUserIdFromSP(getActivity()));
        swipeRefreshLayout.setRefreshing(true);
        isRefreshing = true;
    }
}
