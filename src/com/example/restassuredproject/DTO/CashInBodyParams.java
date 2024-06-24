package com.example.restassuredproject.DTO;

import com.example.restassuredproject.utility.UTIL;

import java.io.IOException;
import java.util.Properties;

public class CashInBodyParams {
    private String wallet_no ;
    private String amount;
    private String card_gateway;
    private String card_no_mask;
    private String card_type;
    private String request_id;

    //Read data from property file
    UTIL util=new UTIL();
    Properties prop = util.readPropData();

    String wallet_no_prop = prop.getProperty("phn_number");
    String amount_prop= prop.getProperty("cash_in_amount_prop");
    String card_gateway_prop= prop.getProperty("card_gateway_prop");
    String card_no_mask_prop = prop.getProperty("card_no_mask_prop");
    String card_type_prop = prop.getProperty("card_type_prop");
    String request_id_prop = UTIL.generateRandomRequestId();

    public CashInBodyParams() throws IOException {
    }

    public String getWallet_no() {
        return wallet_no;
    }

    public void setWallet_no(String wallet_no) {
        this.wallet_no = wallet_no_prop;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount_prop;
    }

    public String getCard_gateway() {
        return card_gateway;
    }

    public void setCard_gateway(String card_gateway) {
        this.card_gateway = card_gateway_prop;
    }

    public String getCard_no_mask() {
        return card_no_mask;
    }

    public void setCard_no_mask(String card_no_mask) {
        this.card_no_mask = card_no_mask_prop;
    }

    public String getCard_type() {
        return card_type;
    }

    public void setCard_type(String card_type) {
        this.card_type = card_type_prop;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id_prop;
    }
}
