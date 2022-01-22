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
import com.ncl.nclcustomerservice.application.BackgroundService;
import com.ncl.nclcustomerservice.commonutils.Common;
import com.ncl.nclcustomerservice.commonutils.Constants;
import com.ncl.nclcustomerservice.database.DatabaseHandler;
import com.ncl.nclcustomerservice.network.RetrofitRequestController;
import com.ncl.nclcustomerservice.network.RetrofitResponseListener;
import com.ncl.nclcustomerservice.object.ApiRequestController;
import com.ncl.nclcustomerservice.object.ApiResponseController;
import com.ncl.nclcustomerservice.object.LeadInsertReqVo;
import com.ncl.nclcustomerservice.object.LeadsResVo;
import com.ncl.nclcustomerservice.object.LeftNav;
import com.ncl.nclcustomerservice.object.Team;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by SupraSoft on 10/1/2018.
 */

public class LeadsFragment extends BaseFragment implements RetrofitResponseListener, SwipeRefreshLayout.OnRefreshListener {
    private static final int LEAD_VALUE = 123;
    @BindView(R.id.leads_list)
    RecyclerView leadsList_recycler;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    private ImageView addView;
    private ImageView filterView;
    private LeftNav leads;
    DatabaseHandler db;
    String bundle;
    private boolean isRefreshing;
    private String queryString="%%";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.leads_layout, null);
        ButterKnife.bind(this, rootView);
        db = DatabaseHandler.getDatabase(getActivity());
//        bundle = getArguments().getString("notiffication_type_id", "");

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
                Common.getSelectedUser(LeadsFragment.this);
            }
        });

        addView = ((MainActivity) getActivity()).findViewById(R.id.add_task);
        leads = (LeftNav) getArguments().getSerializable("leads");
        if (leads.create.equals("1"))
            addView.setVisibility(View.VISIBLE);
        else
            addView.setVisibility(View.GONE);
        ((TextView) ((MainActivity) getActivity()).getSupportActionBar().getCustomView().findViewById(R.id.title_text)).setText("Leads");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        leadsList_recycler.setLayoutManager(linearLayoutManager);
        addView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addIntent = new Intent(getActivity(), InsertLeadActivity.class);
                addIntent.putExtra("form_type", "insert");
                startActivity(addIntent);
            }
        });

        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setRefreshing(false);

        ((SearchView)(((MainActivity) getActivity()).findViewById(R.id.searchView))).setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                Common.Log.i(s);
                queryString='%'+s+'%';
                List<LeadInsertReqVo> leads = db.commonDao().getLead(queryString);
                if (leads != null)
                    setListOnAdapter(leadsList_recycler, leads);
                return false;
            }
        });

        List<LeadInsertReqVo> leads = db.commonDao().getLead();
        if (leads != null)
            setListOnAdapter(leadsList_recycler, leads);


        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        List<LeadInsertReqVo> leads = db.commonDao().getLead(queryString);
        if (leads != null)
            setListOnAdapter(leadsList_recycler, leads);
//        callService(Common.getTeamUserIdFromSP(getContext()));
    }

    private void callService(String userId) {
        if (Common.haveInternet(getActivity())) {
            Team leadteam = new Team();
            leadteam.teamId = userId;
            new RetrofitRequestController(this).sendRequest(Constants.RequestNames.LEAD_LIST, leadteam, true);
        } else {
            List<LeadInsertReqVo> leads = db.commonDao().getLead();
            if (leads != null)
                setListOnAdapter(leadsList_recycler, leads);
        }
    }

    @Override
    public void onResponseSuccess(ApiResponseController objectResponse, ApiRequestController objectRequest, ProgressDialog progressDialog) {
        try {
            if (objectResponse.result != null) {
                LeadsResVo leadsResVo = Common.getSpecificDataObject(objectResponse.result, LeadsResVo.class);
                if (leadsResVo != null && leadsResVo.leadList != null && leadsResVo.leadList.size() > 0) {
                    List<LeadInsertReqVo> leadList = leadsResVo.leadList;
                    leadsList_recycler.setVisibility(View.VISIBLE);
                    db.commonDao().deleteLeadList();
                    db.commonDao().insertLeadList(leadList);
//                    if (bundle == null || bundle.equalsIgnoreCase(""))
                        setListOnAdapter(leadsList_recycler, leadList);
//                    else {
//                        for (int i = 0; i < leadList.size(); i++) {
//                            int lead = leadList.get(i).leadsId;
//                            if (lead == Integer.parseInt(bundle)) {
//                                Intent intent = new Intent(getActivity(), InsertLeadViewActivity.class);
//                                intent.putExtra("leadList", (Serializable) leadList.get(i));
//                                intent.putExtra("leads", leads);
//                                startActivityForResult(intent, LEAD_VALUE);
//                            }
//                        }
//                    }
                    swipeRefreshLayout.setRefreshing(false);
                    isRefreshing = false;
                }
            } else {
                leadsList_recycler.setVisibility(View.GONE);
                Toast.makeText(getActivity(), objectResponse.message, Toast.LENGTH_LONG).show();
            }
            Common.dismissProgressDialog(progressDialog);
        } catch (Exception e) {
            Common.disPlayExpection(e, progressDialog);
        }
    }

    private void setListOnAdapter(RecyclerView leadsList_recycler, List<LeadInsertReqVo> leadList) {

        LeadsAdapter leadsAdapter = new LeadsAdapter(getActivity(), leadList);
        leadsList_recycler.setAdapter(leadsAdapter);
        leadsAdapter.setOnItemClickListener(new LeadsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, View viewItem, int position) {
                Intent intent = new Intent(getActivity(), InsertLeadViewActivity.class);
                intent.putExtra("leadList", (Serializable) leadList.get(position));
                intent.putExtra("leads", leads);
                startActivityForResult(intent, LEAD_VALUE);
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
        callService(Common.getTeamUserIdFromSP(getContext()));
        swipeRefreshLayout.setRefreshing(true);
        isRefreshing = true;
    }
}
