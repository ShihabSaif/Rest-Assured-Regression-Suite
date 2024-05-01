package com.example.restassuredproject.DTO;

import com.example.restassuredproject.utility.UTIL;

import java.io.IOException;
import java.util.Properties;

public class RechargeBodyParams {
    private String receiver_mobile ;
    private String mobile_operator;
    private String mobile_type;
    private  String receiver_name;
    private  String wallet;
    private  String is_fp_auth;
    private  String credential;
    private  String amount;
    private  String request_id;

    //Read data from property file
    UTIL util=new UTIL();
    Properties prop = util.readPropData();

    String receiver_mobile_prop= prop.getProperty("phn_number");
    String mobile_operator_prop= prop.getProperty("mobile_operator_prop");
    String mobile_type_prop= prop.getProperty("mobile_type_prop");
    String receiver_name_prop = prop.getProperty("name_prop");
    String wallet_prop = prop.getProperty("phn_number");
    String is_fp_auth_prop = prop.getProperty("is_fp_auth_prop");
    String credential_prop = prop.getProperty("pin_prop");
    String amount_prop = prop.getProperty("amount_prop");
    String request_id_prop = UTIL.generateRandomRequestId();

    public RechargeBodyParams() throws IOException {
    }

    public String getReceiver_mobile() {
        return receiver_mobile;
    }

    public void setReceiver_mobile(String receiver_mobile) {
        this.receiver_mobile = receiver_mobile_prop;
    }

    public String getMobile_operator() {
        return mobile_operator;
    }

    public void setMobile_operator(String mobile_operator) {
        this.mobile_operator = mobile_operator_prop;
    }

    public String getMobile_type() {
        return mobile_type;
    }

    public void setMobile_type(String mobile_type) {
        this.mobile_type = mobile_type_prop;
    }

    public String getReceiver_name() {
        return receiver_name;
    }

    public void setReceiver_name(String receiver_name) {
        this.receiver_name = receiver_name_prop;
    }

    public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = wallet_prop;
    }

    public String getIs_fp_auth() {
        return is_fp_auth;
    }

    public void setIs_fp_auth(String is_fp_auth) {
        this.is_fp_auth = is_fp_auth_prop;
    }

    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential_prop;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount_prop;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id_prop;
    }
}
