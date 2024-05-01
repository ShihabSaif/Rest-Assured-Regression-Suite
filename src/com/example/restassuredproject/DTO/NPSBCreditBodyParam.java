package com.example.restassuredproject.DTO;

import com.example.restassuredproject.utility.UTIL;

import java.io.IOException;
import java.util.Properties;

public class NPSBCreditBodyParam {
    private String receiver_wallet_no;
    private String external_account_no;
    private String external_account_name;
    private String external_txn_id;
    private String external_FI;
    private String amount;
    private String trace_id;
    private AdditionalDataParams additionalData;

    UTIL util=new UTIL();
    Properties prop = util.readPropData();

    public NPSBCreditBodyParam() throws IOException {
    }

    String external_txn_id_prop = UTIL.generateRandomRequestId();
    String receiver_wallet_no_prop = prop.getProperty("receiver_wallet_no");
    String external_account_no_prop = prop.getProperty("external_account_no");
    String external_FI_prop = prop.getProperty("external_FI");
    String external_account_name_prop = prop.getProperty("external_account_name");
    String amount_prop = prop.getProperty("amount");
    String trace_id_prop = prop.getProperty("trace_id");

    public String getReceiver_wallet_no() {
        return receiver_wallet_no;
    }

    public void setReceiver_wallet_no(String receiver_wallet_no) {
        this.receiver_wallet_no = receiver_wallet_no_prop;
    }

    public String getExternal_account_no() {
        return external_account_no;
    }

    public void setExternal_account_no(String external_account_no) {
        this.external_account_no = external_account_no_prop;
    }

    public String getExternal_account_name() {
        return external_account_name;
    }

    public void setExternal_account_name(String external_account_name) {
        this.external_account_name = external_account_name_prop;
    }

    public String getExternal_txn_id() {
        return external_txn_id;
    }

    public void setExternal_txn_id(String external_txn_id) {
        this.external_txn_id = external_txn_id_prop;
    }

    public String getExternal_FI() {
        return external_FI;
    }

    public void setExternal_FI(String external_FI) {
        this.external_FI = external_FI_prop;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount_prop;
    }

    public String getTrace_id() {
        return trace_id;
    }

    public void setTrace_id(String trace_id) {
        this.trace_id = trace_id_prop;
    }

    public AdditionalDataParams getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(AdditionalDataParams additionalData) {
        this.additionalData = additionalData;
    }
}
