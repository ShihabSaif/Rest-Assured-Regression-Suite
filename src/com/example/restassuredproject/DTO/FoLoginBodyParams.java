package com.example.restassuredproject.DTO;

import com.example.restassuredproject.utility.UTIL;

import java.io.IOException;
import java.util.Properties;

public class FoLoginBodyParams {
    private String externalFi;
    private String userId;
    private String password;

    //Read data from property file
    UTIL util=new UTIL();
    Properties prop = util.readPropData();

    String externalFi_prop= prop.getProperty("externalFi_prop");
    String userId_prop= prop.getProperty("userId_prop");
    String password_prop= prop.getProperty("password_prop");

    public FoLoginBodyParams() throws IOException {
    }

    public String getExternalFi() {
        return externalFi;
    }

    public void setExternalFi(String externalFi) {
        this.externalFi = externalFi_prop;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId_prop;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password_prop;
    }
}
