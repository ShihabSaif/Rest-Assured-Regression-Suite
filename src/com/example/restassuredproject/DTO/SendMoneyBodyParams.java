package com.example.restassuredproject.DTO;

import com.example.restassuredproject.utility.UTIL;

import java.io.IOException;
import java.util.Properties;

public class SendMoneyBodyParams {
    private String amount ;
    private String credential;
    private String receiver;
    private String request_id;
    private String receiver_wallet_no;

    //Read data from property file
    UTIL util=new UTIL();
    Properties prop = util.readPropData();

    String amount_prop= prop.getProperty("amount_prop");
    String credential_prop= prop.getProperty("pin_prop");
    String receiver_prop= prop.getProperty("receiver_prop");
    String request_id_prop = UTIL.generateRandomRequestId();
    String receiver_wallet_no_prop = prop.getProperty("receiver_prop");

    public SendMoneyBodyParams() throws IOException {
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount_prop;
    }

    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential_prop;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver_prop;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id_prop;
    }

    public String getReceiver_wallet_no() {
        return receiver_wallet_no;
    }

    public void setReceiver_wallet_no(String receiver_wallet_no) {
        this.receiver_wallet_no = receiver_wallet_no_prop;
    }
}
