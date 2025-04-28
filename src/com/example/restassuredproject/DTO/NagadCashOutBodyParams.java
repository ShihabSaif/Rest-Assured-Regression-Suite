package com.example.restassuredproject.DTO;

import com.example.restassuredproject.utility.UTIL;

import java.io.IOException;
import java.util.Properties;

public class NagadCashOutBodyParams {
    private String fromAc ;
    private String amount;
    private String requestId;
    private String financialInstitute;
    private String toAc;
    private String channel;


    public NagadCashOutBodyParams(String financialInstituteInput, String toAcInput) throws IOException {
        //Read data from property file
        UTIL util=new UTIL();
        Properties prop = util.readPropData();

        this.fromAc = prop.getProperty("phn_number");
        this.amount = prop.getProperty("amount_prop");
        this.requestId = UTIL.generateRandomRequestId();
        this.financialInstitute = financialInstituteInput;
        this.toAc = toAcInput;
        this.channel = prop.getProperty("channel_prop");
    }

    public String getFromAc() {
        return fromAc;
    }
    public String getAmount() {
        return amount;
    }
    public String getRequestId() {
        return requestId;
    }
    public String getFinancialInstitute() {
        return financialInstitute;
    }
    public String getToAc() {
        return toAc;
    }
    public String getChannel() {
        return channel;
    }
}
