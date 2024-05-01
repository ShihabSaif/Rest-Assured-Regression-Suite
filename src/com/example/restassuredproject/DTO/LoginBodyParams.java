package com.example.restassuredproject.DTO;

import com.example.restassuredproject.utility.UTIL;

import java.io.IOException;
import java.util.Properties;

public class LoginBodyParams {
    private String appType ;
    private String deviceId;
    private String device_type;
    private  String mobile_number;
    private  String password;
    private  String uuid;

    //Read data from property file
    UTIL util=new UTIL();
    Properties prop = util.readPropData();

    String appType_prop= prop.getProperty("role_prop");
    String deviceId_prop= prop.getProperty("deviceId_prop");
    String device_type_prop= prop.getProperty("device_type_prop");
    String mobile_number_prop = prop.getProperty("phn_number");
    String password_prop = prop.getProperty("pin_prop");
    String uuid_prop = prop.getProperty("uuid_prop");

    public LoginBodyParams() throws IOException {
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType_prop;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId_prop;
    }

    public String getDevice_type() {
        return device_type;
    }

    public void setDevice_type(String device_type) {
        this.device_type = device_type_prop;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number_prop;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password_prop;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid_prop;
    }
}
