package com.example.restassuredproject.DTO;

import com.example.restassuredproject.utility.UTIL;

import java.io.IOException;
import java.util.Properties;

public class BankCashoutBodyParams {
    private String routing_no;
    private String account_no;
    private String amount;
    private String bankCode;
    private String instantTransfer;
    private String request_id;
    private String credential;

    UTIL util=new UTIL();
    Properties prop = util.readPropData();

    public BankCashoutBodyParams() throws IOException {
    }

    String request_id_prop = UTIL.generateRandomRequestId();
    String routing_no_prop = prop.getProperty("routing_no_prop");
    String account_no_prop = prop.getProperty("account_no_prop");
    String amount_bank_cashout_prop = prop.getProperty("amount_bank_cashout_prop");
    String bankCode_prop = prop.getProperty("bankCode_prop");
    String instantTransfer_prop = prop.getProperty("instantTransfer_prop");
    String credentials_prop = prop.getProperty("pin_prop");

    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credentials_prop;
    }

    public String getRouting_no() {
        return routing_no;
    }

    public void setRouting_no(String routing_no) {
        this.routing_no = routing_no_prop;
    }

    public String getAccount_no() {
        return account_no;
    }

    public void setAccount_no(String account_no) {
        this.account_no = account_no_prop;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount_bank_cashout_prop;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode_prop;
    }

    public String getInstantTransfer() {
        return instantTransfer;
    }

    public void setInstantTransfer(String instantTransfer) {
        this.instantTransfer = instantTransfer_prop;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id_prop;
    }
}
