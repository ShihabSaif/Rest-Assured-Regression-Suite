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



    public BankCashoutBodyParams(String routing_no, String account_no, String bankCode, String instantTransfer, String amount) throws IOException {
        UTIL util=new UTIL();
        Properties prop = util.readPropData();

        this.routing_no = routing_no;
        this.account_no = account_no;
        this.amount = amount;
        this.bankCode = bankCode;
        this.instantTransfer = instantTransfer;
        this.request_id = UTIL.generateRandomRequestId();
        this.credential = prop.getProperty("pin_prop");

    }

    public String getCredential() {
        return credential;
    }

    public String getRouting_no() {
        return routing_no;
    }

    public String getAccount_no() {
        return account_no;
    }

    public String getAmount() {
        return amount;
    }

    public String getBankCode() {
        return bankCode;
    }

    public String getInstantTransfer() {
        return instantTransfer;
    }

    public String getRequest_id() {
        return request_id;
    }
}
