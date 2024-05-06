package com.example.restassuredproject.DTO;

import com.example.restassuredproject.utility.UTIL;

import java.io.IOException;
import java.util.Properties;

public class CashOutBodyParams {
    private String fromAc ;
    private String amount;
    private String requestId;
    private String financialInstitute;
    private String toAc;
    private String channel;

    //Read data from property file
    UTIL util=new UTIL();
    Properties prop = util.readPropData();

    String fromAc_prop= prop.getProperty("phn_number");
    String amount_prop= prop.getProperty("amount_prop");
    String requestId_prop = UTIL.generateRandomRequestId();
    String financialInstitute_prop = prop.getProperty("financialInstitute_prop");
    String toAc_prop = prop.getProperty("toAc_prop");
    String channel_prop = prop.getProperty("channel_prop");


    public CashOutBodyParams() throws IOException {
    }

    public String getFromAc() {
        return fromAc;
    }

    public void setFromAc(String fromAc) {
        this.fromAc = fromAc_prop;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount_prop;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId_prop;
    }

    public String getFinancialInstitute() {
        return financialInstitute;
    }

    public void setFinancialInstitute(String financialInstitute) {
        this.financialInstitute = financialInstitute_prop;
    }

    public String getToAc() {
        return toAc;
    }

    public void setToAc(String toAc) {
        this.toAc = toAc_prop;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel_prop;
    }
}
