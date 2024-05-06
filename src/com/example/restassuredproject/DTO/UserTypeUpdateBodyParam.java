package com.example.restassuredproject.DTO;

import com.example.restassuredproject.utility.UTIL;

import java.io.IOException;
import java.util.Properties;

public class UserTypeUpdateBodyParam {
    private String wallet ;
    private String userType;
    private String remarks;

    //Read data from property file
    UTIL util=new UTIL();
    Properties prop = util.readPropData();

    String wallet_prop= prop.getProperty("phn_number");
    String userType_prop= prop.getProperty("userType_prop");
    String remarks_prop= prop.getProperty("remarks_prop");

    public UserTypeUpdateBodyParam() throws IOException {
    }

    public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = wallet_prop;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType_prop;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks_prop;
    }
}
