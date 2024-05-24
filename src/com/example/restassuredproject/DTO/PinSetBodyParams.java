package com.example.restassuredproject.DTO;

import com.example.restassuredproject.utility.UTIL;

import java.io.IOException;
import java.util.Properties;

public class PinSetBodyParams {
    private String new_pin ;
    private String uuid;
    private String wallet_no;

    //Read data from property file
    UTIL util=new UTIL();
    Properties prop = util.readPropData();

    public PinSetBodyParams() throws IOException {
    }
    String new_pin_prop= prop.getProperty("pin_prop");
    String uuid_prop= prop.getProperty("uuid_prop");
    String wallet_no_prop= prop.getProperty("phn_number");

    public String getNew_pin() {
        return new_pin;
    }

    public void setNew_pin(String new_pin) {
        this.new_pin = new_pin_prop;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid_prop;
    }

    public String getWallet_no() {
        return wallet_no;
    }

    public void setWallet_no(String wallet_no) {
        this.wallet_no = wallet_no_prop;
    }
}
