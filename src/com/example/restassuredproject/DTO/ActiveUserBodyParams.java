package com.example.restassuredproject.DTO;

import com.example.restassuredproject.utility.UTIL;

import java.io.IOException;
import java.util.Properties;

public class ActiveUserBodyParams {
    private String walletNo ;
    private String status;
    private String remarks;
    private  String externalUserName;

    //Read data from property file
    UTIL util=new UTIL();
    Properties prop = util.readPropData();

    String walletNo_prop= prop.getProperty("phn_number");
    String status_prop= prop.getProperty("status_prop");
    String remarks_prop= prop.getProperty("remarks_prop");
    String externalUserName_prop = prop.getProperty("externalUserName_prop");

    public ActiveUserBodyParams() throws IOException {
    }

    public String getWalletNo() {
        return walletNo;
    }

    public void setWalletNo(String walletNo) {
        this.walletNo = walletNo_prop;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status_prop;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks_prop;
    }

    public String getExternalUserName() {
        return externalUserName;
    }

    public void setExternalUserName(String externalUserName) {
        this.externalUserName = externalUserName_prop;
    }
}
