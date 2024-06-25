package com.example.restassuredproject.DTO;

import com.example.restassuredproject.utility.UTIL;

import java.io.IOException;
import java.util.Properties;

public class WalletInfoBodyParams {
    private String userType;

    UTIL util=new UTIL();
    Properties prop = util.readPropData();

    String userType_prop = prop.getProperty("userType_prop");

    public WalletInfoBodyParams() throws IOException {
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType_prop;
    }
}
