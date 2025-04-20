package com.example.restassuredproject.DTO;

import com.example.restassuredproject.utility.UTIL;

import java.io.IOException;
import java.util.Properties;

public class AddMoneyCardBodyParams {
    private String mobileNo;
    private String amount;

    private String URL;

    //Read data from property file
    UTIL util=new UTIL();
    Properties prop = util.readPropData();
    String mobile= prop.getProperty("phn_number");
    String amount2= prop.getProperty("add_money_card_amount");

    String url1= prop.getProperty("URL");

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = url1;
    }


    public AddMoneyCardBodyParams() throws IOException {
    }

}
