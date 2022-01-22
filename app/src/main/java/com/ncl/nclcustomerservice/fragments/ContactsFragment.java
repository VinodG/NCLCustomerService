package com.ncl.nclcustomerservice.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ncl.nclcustomerservice.R;
import com.ncl.nclcustomerservice.network.RetrofitResponseListener;
import com.ncl.nclcustomerservice.object.ApiRequestController;
import com.ncl.nclcustomerservice.object.ApiResponseController;
import com.ncl.nclcustomerservice.object.ContactList;

import java.util.List;

/**
 * Created by sowmy on 10/1/2018.
 */

public class ContactsFragment extends BaseFragment implements RetrofitResponseListener, SwipeRefreshLayout.OnRefreshListener  {
//    @BindView(R.id.contact_recycler)
//    RecyclerView contact_recycler;
//    @BindView(R.id.swipe_layout)
//    SwipeRefreshLayout swipeRefreshLayout;
//    @BindView(R.id.error_message)
//    TextView error_message;
//    @BindView(R.id.error_image)
//    ImageView error_image;
//    private ImageView addView;
//    private LeftNav leftNav;
//    int page;
//    DatabaseHandler db;
//    private ImageView filterView;
//    String bundle;
//    private boolean isRefreshing;
//    private EndlessRecyclerOnScrollListener mScrollListener = null;
//    private ContactAdapter contactAdapter;
//    private String queryString="%%";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_contact, container, false);
//        ButterKnife.bind(this, view);
//        db = DatabaseHandler.getDatabase(getActivity());
//
//        if (Common.haveInternet(getActivity())){
//            Common.startService(getActivity(), BackgroundService.class);
//        }
//
////        bundle = getArguments().getString("notiffication_type_id", "");
//
//        filterView = ((MainActivity) getActivity()).findViewById(R.id.filter_task);
//        if (Common.getUserTeam(getActivity()).size() > 1)
//            filterView.setVisibility(View.VISIBLE);
//        else
//            filterView.setVisibility(View.GONE);
//        filterView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Common.getSelectedUser(ContactsFragment.this);
//            }
//        });
//        addView = ((MainActivity) getActivity()).findViewById(R.id.add_task);
////        leftNav = (LeftNav) getArguments().getSerializable("contacts");
////        if (leftNav != null) {
////            if (leftNav.create.equals("1"))
////                addView.setVisibility(View.VISIBLE);
////            else
////                addView.setVisibility(View.GONE);
////        }
//        ((TextView) ((MainActivity) getActivity()).getSupportActionBar().getCustomView().findViewById(R.id.title_text)).setText("CONTACTS");
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
//        contact_recycler.setLayoutManager(linearLayoutManager);
//        addView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent addIntent = new Intent(getActivity(), CreateNewContactActivity.class);
//                addIntent.putExtra("form_key", "new");
//                startActivity(addIntent);
//            }
//        });
//
//        swipeRefreshLayout.setOnRefreshListener(this);
//        swipeRefreshLayout.setRefreshing(false);
//
//        List<ContactList> contact = db.commonDao().getContactList(100,0, queryString);
//        if (contact != null)
//            setOnAdapter(contact_recycler, contact);
//
//
//        mScrollListener = new EndlessRecyclerOnScrollListener(linearLayoutManager) {
//            @Override
//            public void onLoadMore(int current_page) {
//
//                Log.d("onLoadMore","OnLoadMore.." + current_page);
//
//                int offset = 0;
//                if (contact != null && contact.size() > 0){
//                    offset = (contact.get(contact.size() - 1)).contactId;
//                }
//                List<ContactList> list = db.commonDao().getContactList(100,offset, queryString);
//                if (list != null && list.size() > 0){
//                    contact.addAll(list);
//                    contact_recycler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            Log.d("Pa:", "" + contact.size());
//                            contactAdapter.notifyItemInserted(contact.size() - 1);
//                        }
//                    });
//                }
//                mScrollListener.setLoading(false);
//            }
//        };
//        contact_recycler.addOnScrollListener(mScrollListener);
//
//        ((SearchView)(((MainActivity) getActivity()).findViewById(R.id.searchView))).setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String s) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String s) {
//                Common.Log.i(s);
//                queryString='%'+s+'%';
//                List<ContactList> contact = db.commonDao().getContactList(100,0,queryString);
//                if (contact != null)
//                    setOnAdapter(contact_recycler, contact);
//                return false;
//            }
//        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
//        List<ContactList> contact = db.commonDao().getContactList(100,0, queryString);
//        if (contact != null)
//            setOnAdapter(contact_recycler, contact);

//        callService(Common.getTeamUserIdFromSP(getActivity()));


    }

    private void callService(String userId) {
//        if (Common.haveInternet(getActivity())) {
//            Team contactTeam = new Team();
//            contactTeam.teamId = userId;
//            new RetrofitRequestController(this).sendRequest(Constants.RequestNames.CONTACT_LIST, contactTeam, true);
//        } else {
//
//            List<ContactList> contact = db.commonDao().getContactList(100,0, queryString);
//            if (contact != null)
//                setOnAdapter(contact_recycler, contact);
//        }
    }

    @Override
    public void onResponseSuccess(ApiResponseController objectResponse, ApiRequestController objectRequest, ProgressDialog progressDialog) {
//        try {
//            switch (objectRequest.requestname) {
//                case Constants.RequestNames.CONTACT_LIST:
//                    if (objectResponse.result != null) {
//                        swipeRefreshLayout.setRefreshing(false);
//                        isRefreshing = false;
//                        ContactResVo contactResVo = Common.getSpecificDataObject(objectResponse.result, ContactResVo.class);
//                        if (contactResVo != null && contactResVo.contactList != null && contactResVo.contactList.size() > 0) {
//                            List<ContactList> contactLists = contactResVo.contactList;
//                            contact_recycler.setVisibility(View.VISIBLE);
//                            db.commonDao().deleteContactList();
//                            db.commonDao().insertContact(contactLists);
////                            if (bundle == null || bundle.equalsIgnoreCase(""))
//                            setOnAdapter(contact_recycler, contactLists);
////                            else {
////                                for (int i=0;i<contactLists.size();i++){
////                                    int contacts = contactLists.get(i).contactId;
////                                    if (contacts == Integer.parseInt(bundle)){
////                                        Intent intent = new Intent(getActivity(), ContactViewActivity.class);
////                                        intent.putExtra("contactlist", (Serializable) contactLists.get(i));
////                                        intent.putExtra("leftnav", leftNav);
////                                        startActivity(intent);
////                                    }
////                                }
////                            }
//                            swipeRefreshLayout.setRefreshing(false);
//                            isRefreshing = false;
//                        }
//                    } else {
//                        contact_recycler.setVisibility(View.GONE);
//                        Toast.makeText(getActivity(), objectResponse.message, Toast.LENGTH_SHORT).show();
//                    }
//
//                    break;
//
//            }
//            Common.Log.i("result-->" + objectResponse.result);
//            Common.dismissProgressDialog(progressDialog);
//        } catch (Exception e) {
//            Common.disPlayExpection(e, progressDialog);
//        }
    }

    private void setOnAdapter(RecyclerView contact_recycler, List<ContactList> contactLists) {
//        contactAdapter = new ContactAdapter(getContext(), contactLists);
//        contact_recycler.setAdapter(contactAdapter);
//        contactAdapter.setOnItemClickListener(new ContactAdapter.OnItemClickListener() {
//            @Override
//            public void OnItemClick(View view, View viewItem, int position) {
//                Intent intent = new Intent(getActivity(), ContactViewActivity.class);
//                intent.putExtra("contactlist", (Serializable) contactLists.get(position));
//                intent.putExtra("leftnav", leftNav);
//                startActivity(intent);
//            }
//        });
    }

    @Override
    public void setUserId(String userId) {
        super.setUserId(userId);
//        callService(userId);
    }

    @Override
    public void onRefresh() {
//        callService(Common.getTeamUserIdFromSP(getActivity()));
//        swipeRefreshLayout.setRefreshing(true);
//        isRefreshing = true;
    }
}
