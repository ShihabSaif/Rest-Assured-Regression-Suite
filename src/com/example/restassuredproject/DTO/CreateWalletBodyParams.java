package com.example.restassuredproject.DTO;

import com.example.restassuredproject.utility.UTIL;

import java.io.IOException;
import java.util.Properties;

import static com.example.restassuredproject.DTO.SignUpBodyParams.*;
import static com.example.restassuredproject.DTO.SignUpBodyParams.phnNumber;

public class CreateWalletBodyParams {
    private String name;
    private String pin;
    private String role;
    private String uuid;
    private String biller_code;
    private String mobile_number;
    private String device_id;


    //Read data from property file
    UTIL util=new UTIL();
    Properties prop = util.readPropData();
    String name_prop= prop.getProperty("name_prop");
    String pin_prop= prop.getProperty("pin_prop");
    String role_prop= prop.getProperty("role_prop");

    public CreateWalletBodyParams() throws IOException {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name_prop;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin_prop;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role_prop;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid1;
    }

    public String getBiller_code() {
        return biller_code;
    }

    public void setBiller_code(String biller_code) {
        this.biller_code = "";
    }
    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = phnNumber;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = deeviceID;
    }



}
