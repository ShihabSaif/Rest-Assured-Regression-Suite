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

    UTIL util=new UTIL();
    Properties prop = util.readPropData();

    String account_name_prop = prop.getProperty("account_name_prop");
    String account_no_prop = prop.getProperty("account_no_prop");
    String bank_name_prop = prop.getProperty("bank_name_prop");
    String request_id_prop = UTIL.generateRandomRequestId();
    String routing_no_prop = prop.getProperty("routing_no_prop");

    public AddBankBodyParams() throws IOException {
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name_prop;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_no_prop;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name_prop;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id_prop;
    }

    public String getRouting_number() {
        return routing_number;
    }

    public void setRouting_number(String routing_number) {
        this.routing_number = routing_no_prop;
    }
}
