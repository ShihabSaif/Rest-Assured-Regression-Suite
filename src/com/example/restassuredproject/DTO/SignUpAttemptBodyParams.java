package com.example.restassuredproject.DTO;

import com.example.restassuredproject.utility.UTIL;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.IOException;
import java.util.Properties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class SignUpAttemptBodyParams {
    private String name;
    private String mobile_number;
    private String device_type;
    private String uuid;
    private String device_id;
    public static final String phnNumber = UTIL.generateRandomMobileNumber();
    public static final String uuid1 = UTIL.generateRandomUUID();
    public static final String deeviceID = UTIL.generateRandomDeviceUD();


    //Read data from property file
    UTIL util=new UTIL();
    Properties prop = util.readPropData();
    String name_prop= prop.getProperty("name_prop");
    String deviceType= prop.getProperty("deviceType");

    public SignUpAttemptBodyParams() throws IOException {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name_prop;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = phnNumber;
    }

    public String getDevice_type() {
        return device_type;
    }

    public void setDevice_type(String device_type) {
        this.device_type = deviceType;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid1;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = deeviceID;
    }


}
