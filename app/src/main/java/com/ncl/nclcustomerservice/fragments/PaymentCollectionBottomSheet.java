package com.ncl.nclcustomerservice.fragments;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.textfield.TextInputLayout;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.gson.Gson;
import com.kenmeidearu.searchablespinnerlibrary.SearchableSpinner;
import com.kenmeidearu.searchablespinnerlibrary.mListString;
import com.squareup.picasso.Picasso;
import com.ncl.nclcustomerservice.R;
import com.ncl.nclcustomerservice.adapter.CustomSpinnerAdapter;
import com.ncl.nclcustomerservice.adapter.FileDetails;
import com.ncl.nclcustomerservice.application.MyApplication;
import com.ncl.nclcustomerservice.commonutils.Common;
import com.ncl.nclcustomerservice.commonutils.Constants;
import com.ncl.nclcustomerservice.database.DatabaseHandler;
import com.ncl.nclcustomerservice.network.RetrofitRequestController;
import com.ncl.nclcustomerservice.network.RetrofitResponseListener;
import com.ncl.nclcustomerservice.object.ApiRequestController;
import com.ncl.nclcustomerservice.object.ApiResponseController;
import com.ncl.nclcustomerservice.object.Contact;
import com.ncl.nclcustomerservice.object.CustomerDropDown;
import com.ncl.nclcustomerservice.object.CustomerList;
import com.ncl.nclcustomerservice.object.DropDownData;
import com.ncl.nclcustomerservice.object.DropDownDataReqVo;
import com.ncl.nclcustomerservice.object.MastersResVo;
import com.ncl.nclcustomerservice.object.PaymentCollectionList;
import com.ncl.nclcustomerservice.object.PaymentCollectionReqVo;
import com.ncl.nclcustomerservice.object.RelatedList;
import com.ncl.nclcustomerservice.object.SpinnerModel;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

public class PaymentCollectionBottomSheet extends BottomSheetDialogFragment
        implements View.OnClickListener, RetrofitResponseListener {
    public static final String TAG = "ActionBottomDialog";
    private ItemClickListener mListener;
    @BindView(R.id.title_text)
    TextView title_text;
    @BindView(R.id.back_button)
    ImageView back_button;
    @BindView(R.id.payment_insert_customer_spinner)
    SearchableSpinner payment_insert_customer_spinner;
    @BindView(R.id.payment_insert_contact_spinner)
    Spinner payment_insert_contact_spinner;
    //    @BindView(R.id.payment_insert_invoicenumber)
//    TextInputLayout payment_insert_invoicenumber;
    @BindView(R.id.paymenttype_spinner_insert)
    Spinner paymenttype_spinner_insert;
    @BindView(R.id.pcash_paymentdate)
    TextView pcash_paymentdate;

    @BindView(R.id.cash_linear)
    LinearLayout cash_linear;
    @BindView(R.id.pcash_insert_amount)
    TextInputLayout pcash_insert_amount;

    @BindView(R.id.check_linear)
    LinearLayout check_linear;
    //    @BindView(R.id.pcheckinsert_check_date)
//    TextView pcheckinsert_check_date;
    @BindView(R.id.pcheck_insert_bankname)
    TextInputLayout pcheck_insert_bankname;
    @BindView(R.id.pcheck_insert_checknumber)
    TextInputLayout pcheck_insert_checknumber;
    @BindView(R.id.pcheck_insert_amount)
    TextInputLayout pcheck_insert_amount;
    @BindView(R.id.payment_status_spinner_insert)
    Spinner payment_status_spinner_insert;

    @BindView(R.id.online_linear)
    LinearLayout online_linear;
    @BindView(R.id.payment_insert_bankname)
    TextInputLayout payment_insert_bankname;
    @BindView(R.id.transactiontype_spinner_insert)
    Spinner transactiontype_spinner_insert;
    @BindView(R.id.payment_insert_transaction_number)
    TextInputLayout payment_insert_transaction_number;
    //    @BindView(R.id.ponline_paymentdate)
//    TextView ponline_paymentdate;
    @BindView(R.id.ponline_insert_amount)
    TextInputLayout ponline_insert_amount;
    @BindView(R.id.customer_location)
    TextInputLayout customer_location;
    @BindView(R.id.comments_by_commercial_team)
    TextInputLayout comments_by_commercial_team;
    @BindView(R.id.save_payment)
    Button save_payment;
    @BindView(R.id.cancel)
    Button cancel;
    @BindView(R.id.parent)
    View parent;
    @BindView(R.id.tvCurrency)
    TextView tvCurrency;
    @BindView(R.id.tvdate)
    TextView tvdate;
    @BindView(R.id.cheque_Deposit_Date)
    TextView cheque_Deposit_Date;
    @BindView(R.id.iv_file_preview)
    ImageView iv_file_preview;
    @BindView(R.id.customerHint)
    TextView customerHint;
    @BindView(R.id.transactiontypeTv)
    TextView transactiontypeTv;
    @BindView(R.id.sapCode)
    TextView sapCode;

    private final String[] PAYMENT_TYPE = new String[]{"Select", "Cash", "Cheque", "Online"};
    private final String[] STATUS = new String[]{"Select", "Pending", "Deposit", "Bouns"};
    private final String[] TRANSACTION_TYPE = new String[]{"Select", "RTGS", "NEFT", "IMPS"};
    String customerId;
    String contactId;
    String contactName;
    String paymenttypeId;
    String statusId;
    String transcationId;
    private List<Contact> contact;
    private String isEdit;
    PaymentCollectionList paymentCollectionList;
    DatabaseHandler db;
    private DatePickerDialog datePickerDialog;
    private String serverDate;
    private Date startdateobj, enddateobj;
    private String selectStartDate;
    private List<CustomerDropDown> customers;
    private ProgressDialog progressD;
    private String filePath = null;
    private Activity activity;
    private String sales_calls_temp_id = "";
    private RelatedList releatedItem = null;
    private int selectedCustomerPosition = 0;


    public static PaymentCollectionBottomSheet newInstance() {
        return new PaymentCollectionBottomSheet();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_payment_collections_insert, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /*view.findViewById(R.id.textView).setOnClickListener(this);
        view.findViewById(R.id.textView2).setOnClickListener(this);
        view.findViewById(R.id.textView3).setOnClickListener(this);
        view.findViewById(R.id.textView4).setOnClickListener(this);*/

        ButterKnife.bind(this, view);
        db = DatabaseHandler.getDatabase(activity);
        Common.setupUI(parent, activity);
        title_text.setText("Add Payment Collection ");
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onCancel(2);
                dismiss();
            }
        });
        setCancelable(false);
        payment_insert_customer_spinner.setEnabled(false);
        payment_insert_customer_spinner.setClickable(false);
        isEdit = "false";// = getIntent().getStringExtra("form_key");
        if (isEdit.equalsIgnoreCase("edit")) {
            //   paymentCollectionList = (PaymentCollectionList) getIntent().getSerializableExtra("payment");
        }

        if (Common.getProfileId(activity) != null && !Common.getProfileId(activity).equalsIgnoreCase("11")) {
            comments_by_commercial_team.setEnabled(false);
            comments_by_commercial_team.setClickable(false);

        }
        customerHint.setText(Common.setSppanableText("* Customer"));
        transactiontypeTv.setText(Common.setSppanableText("* Transfer Type/Payment type"));
        pcash_insert_amount.setHint(Common.setSppanableText("* Amount"));
        pcash_insert_amount.getEditText().setHint(Common.setSppanableText("* Amount"));
        pcheck_insert_bankname.setHint(Common.setSppanableText("* Bank Name"));
        pcheck_insert_bankname.getEditText().setHint(Common.setSppanableText("* Bank Name"));
        payment_insert_bankname.setHint("Bank Name");
        pcheck_insert_checknumber.setHint(Common.setSppanableText("* Cheque/DD No*"));
        pcheck_insert_checknumber.getEditText().setHint(Common.setSppanableText("* Cheque/DD No*"));
        pcash_insert_amount.setHint(Common.setSppanableText("* Amount"));
        pcash_insert_amount.getEditText().setHint(Common.setSppanableText("* Amount"));
        customer_location.getEditText().setHint(Common.setSppanableText("* Customer location"));
        customer_location.setHint(Common.setSppanableText("* Customer location"));
        pcheck_insert_amount.setHint(Common.setSppanableText("* Amount"));
        pcheck_insert_amount.getEditText().setHint(Common.setSppanableText("* Amount"));
        payment_insert_transaction_number.setHint(Common.setSppanableText("* Transaction Ref.No"));
        payment_insert_transaction_number.getEditText().setHint(Common.setSppanableText("* Transaction Ref.No"));
        comments_by_commercial_team.setHint("Comments By Commercial Team");
        ponline_insert_amount.setHint(Common.setSppanableText("* Amount"));
        ponline_insert_amount.getEditText().setHint(Common.setSppanableText("* Amount"));
        pcheck_insert_amount.getEditText().setRawInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_NUMBER_FLAG_SIGNED);
        pcheck_insert_amount.getEditText().setKeyListener(DigitsKeyListener.getInstance(false, false));
        pcash_insert_amount.getEditText().setRawInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_NUMBER_FLAG_SIGNED);
        pcash_insert_amount.getEditText().setKeyListener(DigitsKeyListener.getInstance(false, false));
        ponline_insert_amount.getEditText().setRawInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_NUMBER_FLAG_SIGNED);
        ponline_insert_amount.getEditText().setKeyListener(DigitsKeyListener.getInstance(false, false));
        //numberToCurrencyFormat(12928282727.9);
        List<SpinnerModel> paymentType = new ArrayList<>();
        for (int i = 0; i < PAYMENT_TYPE.length; i++) {
            SpinnerModel spinner = new SpinnerModel();
            spinner.setTitle(PAYMENT_TYPE[i]);
            paymentType.add(spinner);
        }
        CustomSpinnerAdapter customSpinnerAdapter = new CustomSpinnerAdapter(activity, 0, paymentType);
        paymenttype_spinner_insert.setAdapter(customSpinnerAdapter);
        paymenttype_spinner_insert.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0)
                    paymenttypeId = PAYMENT_TYPE[position];

                if (position == 1) {
                    tvdate.setText("Payment date");
                    cash_linear.setVisibility(View.VISIBLE);
                    check_linear.setVisibility(View.GONE);
                    online_linear.setVisibility(View.GONE);
                } else if (position == 2) {
                    tvdate.setText(Common.setSppanableText("* Cheque date"));
                    check_linear.setVisibility(View.VISIBLE);
                    cash_linear.setVisibility(View.GONE);
                    online_linear.setVisibility(View.GONE);
                } else if (position == 3) {
                    tvdate.setText(Common.setSppanableText("* Payment Date/Transaction Date"));
                    online_linear.setVisibility(View.VISIBLE);
                    check_linear.setVisibility(View.GONE);
                    cash_linear.setVisibility(View.GONE);
                } else {
                    paymenttypeId = "";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        List<SpinnerModel> status = new ArrayList<>();
        for (int i = 0; i < STATUS.length; i++) {
            SpinnerModel statusSpinner = new SpinnerModel();
            statusSpinner.setTitle(STATUS[i]);
            status.add(statusSpinner);
        }
        CustomSpinnerAdapter statusCustomSpinnerAdapter = new CustomSpinnerAdapter(activity, 0, status);
        payment_status_spinner_insert.setAdapter(statusCustomSpinnerAdapter);
        payment_status_spinner_insert.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0)
                    statusId = STATUS[position];
                else
                    statusId = "";

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        List<SpinnerModel> transactionType = new ArrayList<>();
        for (int i = 0; i < TRANSACTION_TYPE.length; i++) {
            SpinnerModel transactionSpinner = new SpinnerModel();
            transactionSpinner.setTitle(TRANSACTION_TYPE[i]);
            transactionType.add(transactionSpinner);
        }
        CustomSpinnerAdapter transactionCustomSpinnerAdapter = new CustomSpinnerAdapter(activity, 0, transactionType);
        transactiontype_spinner_insert.setAdapter(transactionCustomSpinnerAdapter);
        transactiontype_spinner_insert.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0)
                    transcationId = TRANSACTION_TYPE[position];
                else
                    transcationId = "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        DropDownDataReqVo dropDownDataReqVo = new DropDownDataReqVo();
        dropDownDataReqVo.customerList = "customer_list";
        dropDownDataReqVo.teamId = Common.getTeamUserIdFromSP(activity);
        new RetrofitRequestController(this).sendRequest(Constants.RequestNames.DROP_DOWN_LIST, dropDownDataReqVo, true);

        pcash_paymentdate.setText(Common.getCurrentDate());
        selectStartDate = Common.getCurrentDate();
        pcash_paymentdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFilterPopup(true);
            }
        });


        cheque_Deposit_Date.setText(Common.getCurrentDate());
        cheque_Deposit_Date.setTag(Common.getCurrentDate());
        cheque_Deposit_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFilterPopup();
            }
        });


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onCancel(2);
                dismiss();
            }
        });

//        pcheckinsert_check_date.setText(Common.getCurrentDate());
//        pcheckinsert_check_date.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                chequedate(true);
//            }
//        });

//        ponline_paymentdate.setText(Common.getCurrentDate());
//        ponline_paymentdate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onlineDate(true);
//            }
//        });

        textChangeListner();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ItemClickListener) {
            mListener = (ItemClickListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement ItemClickListener");
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {
        TextView tvSelected = (TextView) view;
        mListener.onItemClick(tvSelected.getText().toString());
        dismiss();
    }

    public void sales_calls_temp_id(String sales_calls_temp_id, RelatedList releatedItem) {
        this.sales_calls_temp_id = sales_calls_temp_id;
        this.releatedItem = releatedItem;
    }

    public interface ItemClickListener {
        void onItemClick(String item);

        void onCancel(int from);

    }


    @Override
    public void onResponseSuccess(ApiResponseController objectResponse, ApiRequestController objectRequest, ProgressDialog progressDialog) {
        try {
            switch (objectRequest.requestname) {
                case Constants.RequestNames.DROP_DOWN_LIST:
                    DropDownData dropDownData = Common.getSpecificDataObject(objectResponse.result, DropDownData.class);
                    if (dropDownData != null) {
                        customers = dropDownData.customerList;
                        if (customers != null) {
                            CustomerDropDown cus = new CustomerDropDown();
                            cus.customerId = "0";
                            cus.customerName = "Select Customer";
                            customers.add(0, cus);
                            List<SpinnerModel> customerSpinner = new ArrayList<>();
                            ArrayList<mListString> stringStates = new ArrayList<>();
                            for (int i = 0; i < customers.size(); i++) {
                                SpinnerModel spinnerModel = new SpinnerModel();
                                spinnerModel.setTitle(customers.get(i).customerName);
                                spinnerModel.setId(customers.get(i).customerId);
                                customerSpinner.add(spinnerModel);
                                stringStates.add(new mListString(Integer.parseInt(Common.isNull(customers.get(i).customerId)), customers.get(i).customerName));
                                if (releatedItem != null && releatedItem.Company != null) {
                                    if (releatedItem.Company.equalsIgnoreCase(customers.get(i).customerId))
                                        selectedCustomerPosition = i;
                                }
                            }
                            //  CustomSpinnerAdapter customSpinnerAdapter = new CustomSpinnerAdapter(this, 0, customerSpinner);
                            payment_insert_customer_spinner.setAdapter(stringStates, 1, 1);
                            payment_insert_customer_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    if (position > 0) {
                                        customerId = String.valueOf(((mListString) payment_insert_customer_spinner.getSelectedItem()).get_id());
                                        CustomerList customer = db.commonDao().getCustomerListById(Integer.parseInt(customerId));
                                        if (customer != null)
                                            sapCode.setText("" + customer.customerSAPCode);
                                    } else customerId = "";

                                    //contact = customers.get(position).contactList;
                                    if (contact == null)
                                        contact = new ArrayList<>();
                                    setContactSpinner();
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });

                            payment_insert_customer_spinner.setSelection(selectedCustomerPosition);

                        }

                        if (isEdit.equalsIgnoreCase("edit")) {
                            setIntentData();
                        }
                    }
                    break;

                case Constants.RequestNames.PAYMENT_COLLECTION_INSERT:
                    MastersResVo mastersResVo = Common.getSpecificDataObject(objectResponse.result, MastersResVo.class);
                    if (mastersResVo != null && mastersResVo.paymentCollectionList != null && mastersResVo.paymentCollectionList.size() > 0) {
                        db.commonDao().insertPaymentCollection(mastersResVo.paymentCollectionList);
                        Toast.makeText(activity, objectResponse.message, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(activity, PaymentCollectionViewActivity.class);
                        intent.putExtra("paymentList", mastersResVo.paymentCollectionList.get(0));
                        intent.putExtra("leftNav", Common.getLeftNav(activity, Constants.MethodNames.PAYMENT_COLLECTIONS));
                        // startActivity(intent);
                        dismiss();
                    }
                    break;

                case Constants.RequestNames.PAYMENT_COLLECTION_EDIT:
                    MastersResVo mastersResVo1 = Common.getSpecificDataObject(objectResponse.result, MastersResVo.class);
                    if (mastersResVo1 != null && mastersResVo1.paymentCollectionList != null && mastersResVo1.paymentCollectionList.size() > 0) {
                        db.commonDao().insertPaymentCollection(mastersResVo1.paymentCollectionList);
                        Toast.makeText(activity, objectResponse.message, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(activity, PaymentCollectionViewActivity.class);
                        intent.putExtra("paymentList", mastersResVo1.paymentCollectionList.get(0));
                        intent.putExtra("leftNav", Common.getLeftNav(activity, Constants.MethodNames.PAYMENT_COLLECTIONS));
                        // startActivity(intent);
                        dismiss();
                    }
                    break;
            }
            Common.dismissProgressDialog(progressDialog);
        } catch (Exception e) {
            Common.disPlayExpection(e, progressDialog);
        }
    }

    private void setIntentData() {
//       payment_insert_invoicenumber.getEditText().setText(paymentCollectionList.invoiceNumber);
        payment_insert_bankname.getEditText().setText(Common.nullChecker(paymentCollectionList.bankName));
        pcash_paymentdate.setText(Common.nullChecker(paymentCollectionList.paymentDate));
        for (int i = 0; i < customers.size(); i++) {
            if (Common.nullChecker(paymentCollectionList.customerId).equalsIgnoreCase(customers.get(i).customerId)) {
                payment_insert_customer_spinner.setSelection(i);
            }
        }

        for (int i = 0; i < contact.size(); i++) {
            if (Common.nullChecker(paymentCollectionList.contactId).equalsIgnoreCase(contact.get(i).contactId)) {
                payment_insert_contact_spinner.setSelection(i);
            }
        }

        for (int i = 0; i < PAYMENT_TYPE.length; i++) {
            if (Common.nullChecker(paymentCollectionList.paymentMode).equalsIgnoreCase(PAYMENT_TYPE[i])) {
                paymenttype_spinner_insert.setSelection(i);
            }
        }

        if (paymentCollectionList.paymentMode.equalsIgnoreCase("Cash")) {
            cash_linear.setVisibility(View.VISIBLE);

            pcash_insert_amount.getEditText().setText(Common.nullChecker(paymentCollectionList.amount));

        } else if (paymentCollectionList.paymentMode.equalsIgnoreCase("Cheque")) {
            check_linear.setVisibility(View.VISIBLE);

            pcheck_insert_checknumber.getEditText().setText(Common.nullChecker(paymentCollectionList.chequeNo));
            pcheck_insert_bankname.getEditText().setText(Common.nullChecker(paymentCollectionList.bankName));
            pcheck_insert_amount.getEditText().setText(Common.nullChecker(paymentCollectionList.amount));
//           pcheckinsert_check_date.setText(paymentCollectionList.paymentDate);

            for (int i = 0; i < STATUS.length; i++) {
                if (paymentCollectionList.status.equalsIgnoreCase(STATUS[i])) {
                    payment_status_spinner_insert.setSelection(i);
                }
            }
        } else {
            online_linear.setVisibility(View.VISIBLE);
            payment_insert_transaction_number.getEditText().setText(Common.nullChecker(paymentCollectionList.transactionRefNo));
//           ponline_paymentdate.setText(paymentCollectionList.paymentDate);
            ponline_insert_amount.getEditText().setText(Common.nullChecker(paymentCollectionList.amount));

            for (int i = 0; i < TRANSACTION_TYPE.length; i++) {
                if (Common.nullChecker(paymentCollectionList.transferType).equalsIgnoreCase(TRANSACTION_TYPE[i])) {
                    transactiontype_spinner_insert.setSelection(i);
                }
            }
        }


    }

    private void setContactSpinner() {
        Contact cont = new Contact();
        cont.contactId = "0";
        cont.contactName = "Select Contact";
        if (contact.size() > 0) {
            if (!contact.get(0).contactName.equalsIgnoreCase("Select Contact"))
                contact.add(0, cont);
        } else {
            contact.add(0, cont);
        }
        List<SpinnerModel> contactSpinner = new ArrayList<>();
        for (int i = 0; i < contact.size(); i++) {
            SpinnerModel spinnerModel = new SpinnerModel();
            spinnerModel.setId(contact.get(i).contactName);
            spinnerModel.setTitle(contact.get(i).contactName);
            contactSpinner.add(spinnerModel);
        }

        CustomSpinnerAdapter customSpinnerAdapter = new CustomSpinnerAdapter(activity, 0, contactSpinner);
        payment_insert_contact_spinner.setAdapter(customSpinnerAdapter);
        payment_insert_contact_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    contactName = contact.get(position).contactName;
                    contactId = contact.get(position).contactId;
                } else {
                    contactName = "";
                    contactId = "";
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
    }

    @OnClick(R.id.iv_file_preview)
    void captureImage() {
        ImagePicker.Companion.with(this)
                .compress(1024)            //Final image size will be less than 1.0 MB(Optional)
                .maxResultSize(1080, 1080)    //Final image resolution will be less than 1080 x 1080(Optional)
                .start();
    }

    @OnClick(R.id.save_payment)
    void setSave() {
        if (!isValidated())
            return;

        PaymentCollectionReqVo paymentCollectionReqVo = new PaymentCollectionReqVo();
        paymentCollectionReqVo.customerId = customerId;
        paymentCollectionReqVo.requesterid = Common.getUserIdFromSP(activity);
//        paymentCollectionReqVo.contactId = contactId;
//        paymentCollectionReqVo.invoiceNumber = payment_insert_invoicenumber.getEditText().getText().toString();
        paymentCollectionReqVo.paymentMode = paymenttypeId;
        paymentCollectionReqVo.paymentDate = pcash_paymentdate.getText().toString();
        paymentCollectionReqVo.customerLocation = customer_location.getEditText().getText().toString();
        paymentCollectionReqVo.commentsByCommercialTeam = comments_by_commercial_team.getEditText().getText().toString();
        paymentCollectionReqVo.insert_by = "Sales Call";
        paymentCollectionReqVo.sales_calls_temp_id = sales_calls_temp_id;


        if (paymentCollectionReqVo.paymentMode.equalsIgnoreCase("Cash")) {
            paymentCollectionReqVo.amount = pcash_insert_amount.getEditText().getText().toString();


        } else if (paymentCollectionReqVo.paymentMode.equalsIgnoreCase("Cheque")) {
            paymentCollectionReqVo.chequeDate = "";
            if (cheque_Deposit_Date.getTag() != null)
                paymentCollectionReqVo.chequeDate = cheque_Deposit_Date.getTag().toString();
            paymentCollectionReqVo.amount = pcheck_insert_amount.getEditText().getText().toString();
            paymentCollectionReqVo.bankName = pcheck_insert_bankname.getEditText().getText().toString();
            paymentCollectionReqVo.chequeNo = pcheck_insert_checknumber.getEditText().getText().toString();
            paymentCollectionReqVo.status = statusId;

        } else if (paymentCollectionReqVo.paymentMode.equalsIgnoreCase("Online")) {
            paymentCollectionReqVo.bankName = payment_insert_bankname.getEditText().getText().toString();
//            paymentCollectionReqVo.paymentDate = ponline_paymentdate.getText().toString();
            paymentCollectionReqVo.transactionRefNo = payment_insert_transaction_number.getEditText().getText().toString();
            paymentCollectionReqVo.transferType = transcationId;
            paymentCollectionReqVo.amount = ponline_insert_amount.getEditText().getText().toString();
        }

        if (isEdit.equalsIgnoreCase("edit")) {
            paymentCollectionReqVo.paymentCollectionId = String.valueOf(paymentCollectionList.paymentCollectionId);
            new RetrofitRequestController(this).sendRequest(Constants.RequestNames.PAYMENT_COLLECTION_EDIT, paymentCollectionReqVo, true);
        } else {
            paymentCollectionReqVo.requestname = Constants.RequestNames.PAYMENT_COLLECTION_INSERT;
            sendImage(filePath, paymentCollectionReqVo);
            // new RetrofitRequestController(this).sendRequest(Constants.RequestNames.PAYMENT_COLLECTION_INSERT, paymentCollectionReqVo, true);
        }

    }

    private boolean isValidated() {

        if (payment_insert_customer_spinner.getSelectedItemPosition() == 0) {
            payment_insert_customer_spinner.requestFocusFromTouch();
            payment_insert_customer_spinner.requestFocus();
            Toast.makeText(activity, "Please select Customer", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (customer_location.getEditText().getText().toString().trim().length() < 3) {
            customer_location.requestFocus();
            Toast.makeText(activity, "Please enter customer location", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (paymenttype_spinner_insert.getSelectedItemPosition() == 0) {
            payment_insert_customer_spinner.requestFocusFromTouch();
            paymenttype_spinner_insert.requestFocus();
            Toast.makeText(activity, "Please select Payment Type", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (paymenttypeId.equalsIgnoreCase(PAYMENT_TYPE[1])) {
            if (!Common.validate(activity, pcash_insert_amount.getEditText(), "Please Enter Amount")) {
                return false;
            }
            if (selectStartDate == null) {
                Toast.makeText(activity, "Please select Payment Date/Transaction Date * ", Toast.LENGTH_SHORT).show();
                return false;
            }

        }
        if (paymenttypeId.equalsIgnoreCase(PAYMENT_TYPE[2])) {
            if (!Common.validate(activity, pcheck_insert_amount.getEditText(), "Please Enter Amount")) {
                return false;
            }
            if (!Common.validate(activity, pcheck_insert_bankname.getEditText(), "Please Enter Bank Name")) {
                return false;
            }
            if (!Common.validate(activity, pcheck_insert_checknumber.getEditText(), "Please Enter Cheque/DD No")) {
                return false;
            }
            if (selectStartDate == null) {
                Toast.makeText(activity, "Please select Payment Date/Transaction Date * ", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        if (paymenttypeId.equalsIgnoreCase(PAYMENT_TYPE[3])) {
            if (!Common.validate(activity, ponline_insert_amount.getEditText(), "Please Enter Amount")) {
                return false;
            }
            if (transactiontype_spinner_insert.getSelectedItemPosition() == 0) {
                transactiontype_spinner_insert.requestFocusFromTouch();
                transactiontype_spinner_insert.requestFocus();
                Toast.makeText(activity, "Please select Transfer Type/Payment type ", Toast.LENGTH_SHORT).show();
                return false;
            }
            if (!Common.validate(activity, payment_insert_transaction_number.getEditText(), "Please Enter Transaction Ref.No")) {
                return false;
            }
            if (selectStartDate == null) {
                Toast.makeText(activity, "Please select Payment Date/Transaction Date * ", Toast.LENGTH_SHORT).show();
                return false;
            }

        }

        return true;
    }

    private void openFilterPopup(Boolean b) {

        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(activity, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                SimpleDateFormat serverDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd");

                serverDate = sfd.format(newDate.getTime());
                if (b) {
                    startdateobj = newDate.getTime();

                    pcash_paymentdate.setText(serverDate);
                    selectStartDate = Common.getDatenewFormat(serverDate)[1];

//                    }

                } else {
                    enddateobj = newDate.getTime();

                    if (pcash_paymentdate.getText().toString().equalsIgnoreCase("")) {
                        pcash_paymentdate.requestFocus();
                        pcash_paymentdate.setError("Please select Payment date");
                        return;
                    }
                    pcash_paymentdate.setError(null);

                }
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

//        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);

        datePickerDialog.show();
    }

    private void openFilterPopup() {

        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(activity, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                cheque_Deposit_Date.setText(year + "-" + Common.addZero((monthOfYear + 1)) + "-" + Common.addZero(dayOfMonth));
                cheque_Deposit_Date.setTag(year + "-" + Common.addZero((monthOfYear + 1)) + "-" + Common.addZero(dayOfMonth));

            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

//        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);

        datePickerDialog.show();
    }

    public String numberToCurrencyFormat(double value) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        String output = nf.format(value);
        System.out.println(value + " " + output);
        return output;
        // numberToCurrencyFormat2(output.substring(3));
    }

    public void numberToCurrencyFormat2(String value) {
//    NumberFormat nf = NumberFormat.getNumberInstance(new Locale("en", "IN"));
//    String output = nf.format(value);
        // System.out.println(value + " " + output);
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.getDefault()); // make locale-specific
        try {
            double i1 = nf.parse(value).doubleValue();
//        String s2 = String.valueOf(i1);
            System.out.println(i1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    public void textChangeListner() {
        ponline_insert_amount.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable != null && Common.isNumeric(editable.toString()))
                    tvCurrency.setText(numberToCurrencyFormat(Double.parseDouble(editable.toString())));
            }
        });
        pcheck_insert_amount.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable != null && Common.isNumeric(editable.toString()))
                    tvCurrency.setText(numberToCurrencyFormat(Double.parseDouble(editable.toString())));
            }
        });
        pcash_insert_amount.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable != null && Common.isNumeric(editable.toString()))
                    tvCurrency.setText(numberToCurrencyFormat(Double.parseDouble(editable.toString())));
                else
                    tvCurrency.setText(numberToCurrencyFormat(0.0));
            }
        });
    }


    private void sendImage(String filesPath, PaymentCollectionReqVo obj) {
        progressD = new ProgressDialog(activity);
        progressD.setMessage("Please Wait....");
        progressD.setCancelable(false);
        progressD.show();
        List<MultipartBody.Part> muPartList = new ArrayList<>();
        if (filesPath != null && new File(filesPath).exists()) {
            //..  for (int i = 0; i < files.size(); i++) {
            muPartList.add(prepareFilePart("payment_image[]", Uri.fromFile(new File(filesPath)), new File(filesPath)));
            //  }

        }
        Common.Log.i("Request obj " + new Gson().toJson(obj));
        MultipartBody.Part[] fileParts = muPartList.toArray(new MultipartBody.Part[muPartList.size()]);
        Call<ResponseBody> abc = MyApplication.getInstance().getAPIInterface().uploadPaymentCollection(Constants.API, fileParts, obj);
        abc.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                if (response.body() == null) {
                    //CommonUtils.dismissProgressDialog(progressDialog);
                    Toast.makeText(activity, "Intenal Server Error", Toast.LENGTH_SHORT).show();
                    progressD.dismiss();
                    return;
                }
                if (isEdit.equalsIgnoreCase("edit"))
                    Toast.makeText(activity, "Payment Collection Successfully Updated.", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(activity, "Payment Collection Inserted Successfully.", Toast.LENGTH_SHORT).show();

                ApiResponseController apiResponseController = null;
                try {
                    apiResponseController = new Gson().fromJson(response.body().string(), ApiResponseController.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                MastersResVo mastersResVo = Common.getSpecificDataObject(apiResponseController.result, MastersResVo.class);
                if (mastersResVo != null && mastersResVo.paymentCollectionList != null && mastersResVo.paymentCollectionList.size() > 0) {
                    mListener.onItemClick(mastersResVo.paymentCollectionList.get(0).sales_calls_temp_id);

                    db.commonDao().insertPaymentCollection(mastersResVo.paymentCollectionList);
                    Intent intent = new Intent(activity, PaymentCollectionViewActivity.class);
                    intent.putExtra("paymentList", mastersResVo.paymentCollectionList.get(0));
                    intent.putExtra("leftNav", Common.getLeftNav(activity, Constants.MethodNames.PAYMENT_COLLECTIONS));
                    // startActivity(intent);
                    progressD.dismiss();
                    dismiss();
                }


            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                progressD.dismiss();

            }
        });
    }

    private MultipartBody.Part prepareFilePart(String file_i, Uri uri, File file) {
        RequestBody requestFile =
                RequestBody.create(
                        MediaType.parse(getMimeType(activity, uri)),
                        file
                );

        // MultipartBody.Part is used to send also the actual file name
        return MultipartBody.Part.createFormData(file_i, file.getName(), requestFile);
    }

    private String getMimeType(Activity context, Uri uri) {
        String extension;

        //Check uri format to avoid null
        if (uri.getScheme().equals(ContentResolver.SCHEME_CONTENT)) {
            //If scheme is a content
            final MimeTypeMap mime = MimeTypeMap.getSingleton();
            extension = mime.getExtensionFromMimeType(context.getContentResolver().getType(uri));
        } else {
            //If scheme is a File
            //This will replace white spaces with %20 and also other special characters. This will avoid returning null values on file name with spaces and special characters.
            extension = MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(new File(uri.getPath())).toString());

        }

        return extension;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            File file = ImagePicker.Companion.getFile(data);
            filePath = file.getAbsolutePath();
            Picasso.with(activity)
                    .load("file:///" + file.getAbsolutePath())
                    .resize(50, 50)
                    /*.skipMemoryCache(true)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)*/
                    .error(R.drawable.ic_baseline_camera_alt_24)
                    .into(iv_file_preview);
            String firstlink1 = file.getAbsolutePath().subSequence(0, file.getAbsolutePath().lastIndexOf('/')).toString();
            File testFile2 = new File(file.getAbsolutePath()); // Assuming it is in Internal Storage
            System.out.println("## firstlink:" + firstlink1);
            FileDetails fileDetails = new FileDetails();
            fileDetails.filePath = file.getAbsolutePath();

        }
    }

}