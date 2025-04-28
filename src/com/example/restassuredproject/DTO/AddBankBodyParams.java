package com.example.restassuredproject.DTO;

import com.example.restassuredproject.utility.UTIL;

import java.io.IOException;
import java.util.Properties;

public class AddBankBodyParams {
    private String account_name;
    private String account_number;
    private String bank_name;
    private String request_id;
    private String routing_number;

    public AddBankBodyParams(String accountName, String accountNumber, String bankName, String routingNumber) throws IOException {
        UTIL util=new UTIL();
        Properties prop = util.readPropData();

        this.account_name = accountName;
        this.account_number = accountNumber;
        this.bank_name = bankName;
        this.request_id = UTIL.generateRandomRequestId();
        this.routing_number = routingNumber;
    }

    public String getAccount_name() {
        return account_name;
    }
    public String getAccount_number() {
        return account_number;
    }
    public String getBank_name() {
        return bank_name;
    }
    public String getRequest_id() {
        return request_id;
    }
    public String getRouting_number() {
        return routing_number;
    }
}
