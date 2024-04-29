package com.example.restassuredproject.DTO;

import com.example.restassuredproject.utility.UTIL;

import java.io.IOException;
import java.util.Properties;

public class WalletLookUpBodyParams {
    private String uuid;
    private String app_type;
    private String device_id;
    private String device_type;
    private String mobile_number;
    public static final String phnNumber = UTIL.generateRandomMobileNumber();
    public static final String uuid1 = UTIL.generateRandomUUID();
    public static final String deeviceID = UTIL.generateRandomDeviceUD();


    //Read data from property file
    UTIL util=new UTIL();
    Properties prop = util.readPropData();
    String name_prop= prop.getProperty("name_prop");
    String pin_prop= prop.getProperty("pin_prop");
    String role_prop= prop.getProperty("role_prop");

    public WalletLookUpBodyParams() throws IOException {
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid1;
    }

    public String getApp_type() {
        return app_type;
    }

    public void setApp_type(String app_type) {
        this.app_type = "CUSTOMER";
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = deeviceID;
    }

    public String getDevice_type() {
        return device_type;
    }

    public void setDevice_type(String device_type) {
        this.device_type = "ANDROID";
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = phnNumber;
    }

}
