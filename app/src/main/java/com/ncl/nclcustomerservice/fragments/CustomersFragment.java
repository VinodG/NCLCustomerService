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
import com.ncl.nclcustomerservice.adapter.CustomersAdapter;
import com.ncl.nclcustomerservice.application.BackgroundService;
import com.ncl.nclcustomerservice.commonutils.Common;
import com.ncl.nclcustomerservice.commonutils.Constants;
import com.ncl.nclcustomerservice.database.DatabaseHandler;
import com.ncl.nclcustomerservice.network.RetrofitRequestController;
import com.ncl.nclcustomerservice.network.RetrofitResponseListener;
import com.ncl.nclcustomerservice.object.ApiRequestController;
import com.ncl.nclcustomerservice.object.ApiResponseController;
import com.ncl.nclcustomerservice.object.CustomerList;
import com.ncl.nclcustomerservice.object.CustomerListresVo;
import com.ncl.nclcustomerservice.object.LeftNav;
import com.ncl.nclcustomerservice.object.Team;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomersFragment extends BaseFragment implements RetrofitResponseListener , SwipeRefreshLayout.OnRefreshListener{

    @BindView(R.id.customer_recyclerview)
    RecyclerView customer_recyclerview;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    private ImageView addView;
    private LeftNav customers;
    public static final int DELETE_VALUE = 12;
    DatabaseHandler db;
    private ImageView filterView;
    String bundle;
    private boolean isRefreshing;
    String queryString="%%";
    private String navigationFrom;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_customers, container, false);
        ButterKnife.bind(this, view);
        db = DatabaseHandler.getDatabase(getActivity());

        if (Common.haveInternet(getActivity())){
            getActivity().startService(new Intent(getActivity(), BackgroundService.class));
        }

        customers = (LeftNav) getArguments().getSerializable("customers");
        navigationFrom = getArguments().getString("from");
        addView = ((MainActivity) getActivity()).findViewById(R.id.add_task);
        if (customers.create.equals("1"))
            addView.setVisibility(View.VISIBLE);
        else
            addView.setVisibility(View.GONE);
        filterView = ((MainActivity) getActivity()).findViewById(R.id.filter_task);
        if (Common.getUserTeam(getActivity()).size() > 1)
            filterView.setVisibility(View.VISIBLE);
        else
            filterView.setVisibility(View.GONE);
        filterView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Common.getSelectedUser(CustomersFragment.this);
            }
        });
        ((TextView) ((MainActivity) getActivity()).getSupportActionBar().getCustomView().findViewById(R.id.title_text)).setText("Customers");
        addView = ((MainActivity) getActivity()).findViewById(R.id.add_task);
        addView.setVisibility(View.VISIBLE);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        customer_recyclerview.setLayoutManager(linearLayoutManager);
        addView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addIntent = new Intent(getActivity(), CustomersInsertActivity.class);
                addIntent.putExtra("form_type", "create");
                addIntent.putExtra("customerType", "Direct party");
                if (navigationFrom.equalsIgnoreCase(Constants.MethodNames.CUSTOMER_LIST_THIRDPARTY))
                    addIntent.putExtra("customerType", "Third party Customer");
                startActivityForResult(addIntent, DELETE_VALUE);
            }
        });

        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setRefreshing(false);

        if (navigationFrom.equalsIgnoreCase(Constants.MethodNames.CUSTOMER_LIST_THIRDPARTY)){
            ((TextView) ((MainActivity) getActivity()).getSupportActionBar().getCustomView().findViewById(R.id.title_text)).setText("Third Party Customers");

        }else{
            ((TextView) ((MainActivity) getActivity()).getSupportActionBar().getCustomView().findViewById(R.id.title_text)).setText("Direct Customers");

        }
        ((SearchView)(((MainActivity) getActivity()).findViewById(R.id.searchView))).setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                Common.Log.i(s);
                queryString='%'+s+'%';
                List<CustomerList> customerLists = getSalesOrderList();
                if (customerLists != null)
                    setListOnAdapter(customer_recyclerview, customerLists);
                return false;
            }
        });
        List<CustomerList> customerLists = getSalesOrderList();
        if (customerLists != null)
            setListOnAdapter(customer_recyclerview, customerLists);


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        List<CustomerList> customerLists =getSalesOrderList();
        if (customerLists != null)
            setListOnAdapter(customer_recyclerview, customerLists);



//        callService(Common.getTeamUserIdFromSP(getActivity()));

    }
    public List<CustomerList> getSalesOrderList(){
        if (navigationFrom != null && !navigationFrom.equalsIgnoreCase(Constants.MethodNames.CUSTOMER_LIST_THIRDPARTY)) {

            return db.commonDao().searchCustomerList(queryString);
        }
        return db.commonDao().searchThirdPartyCustomerList(queryString);
    }

    private void callService(String userId) {
        if (Common.haveInternet(getActivity())) {
            Team customerTeam =new Team();
            customerTeam.teamId = userId;
            customerTeam.roleId = String.valueOf(Common.getRoleIdFromSP(getActivity()));
            new RetrofitRequestController(this).sendRequest(Constants.RequestNames.CUSTOMER_LIST, customerTeam, true);
        } else {
            List<CustomerList> customerLists =getSalesOrderList();
            if (customerLists != null)
            setListOnAdapter(customer_recyclerview, customerLists);
        }
    }

    @Override
    public void onResponseSuccess(ApiResponseController objectResponse, ApiRequestController objectRequest, ProgressDialog progressDialog) {
try{
        switch (objectRequest.requestname) {
            case Constants.RequestNames.CUSTOMER_LIST:
                if (objectResponse.result != null) {
                    db.commonDao().deleteCustomerList();
                    CustomerListresVo customerListresVo = Common.getSpecificDataObject(objectResponse.result, CustomerListresVo.class);
                    if (customerListresVo.customerList != null  && customerListresVo.customerList.size() > 0) {
                        List<CustomerList> customerLists = customerListresVo.customerList;
                        customer_recyclerview.setVisibility(View.VISIBLE);
                        for (int i = 0; i < customerLists.size(); i++) {
                            long key = db.commonDao().insertCustomerList(customerLists.get(i));
                            if (customerLists.get(i).customerUserList!=null) {
                                for (int j = 0; j < customerLists.get(i).customerUserList.size(); j++) {
                                    customerLists.get(i).customerUserList.get(j).lineitemid = (int) key;
                                }
                                db.commonDao().insertCustomerLineItems(customerLists.get(i).customerUserList);
                            }
                        }
                        List<CustomerList> customerLists1 =getSalesOrderList();
                        if (customerLists1 != null)
                            setListOnAdapter(customer_recyclerview, customerLists1);

                        swipeRefreshLayout.setRefreshing(false);
                        isRefreshing = false;
                    }
                } else {
                    customer_recyclerview.setVisibility(View.GONE);
                    Toast.makeText(getActivity(), objectResponse.message, Toast.LENGTH_SHORT).show();
                }
                break;
        }
        Common.dismissProgressDialog(progressDialog);
}catch (Exception e){
    Common.disPlayExpection(e,progressDialog);
}
    }

    private void setListOnAdapter(RecyclerView customer_recyclerview, List<CustomerList> customerLists) {
        CustomersAdapter customersAdapter = new CustomersAdapter(getActivity(), customerLists,db,navigationFrom);
        customer_recyclerview.setAdapter(customersAdapter);
        customersAdapter.setOnItemClickListener(new CustomersAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, View viewItem, int position) {
                Intent intent = new Intent(getActivity(), CustomerViewActivity.class);
                intent.putExtra("customers", customers);
                intent.putExtra("customer", (Serializable) customerLists.get(position));
                startActivityForResult(intent, DELETE_VALUE);
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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<CustomerList> customerLists =getSalesOrderList();
        if (customerLists != null)
            setListOnAdapter(customer_recyclerview, customerLists);


    }
}
