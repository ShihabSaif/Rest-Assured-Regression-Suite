package com.example.restassuredproject.DTO;

import com.example.restassuredproject.utility.UTIL;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.IOException;
import java.util.Properties;

import static com.example.restassuredproject.DTO.WalletLookUpBodyParams.*;


@JsonIgnoreProperties(ignoreUnknown = true)
public class SignUpWalletBodyParams {
    private String name;
    private String mobile_number;
    private String role;
    private String uuid;
    private String pin;

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = "9999";
    }





    //Read data from property file
    UTIL util=new UTIL();
    Properties prop = util.readPropData();
    String name_prop= prop.getProperty("name_prop");

    public SignUpWalletBodyParams() throws IOException {
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


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid1;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = "CUSTOMER";
    }
}
