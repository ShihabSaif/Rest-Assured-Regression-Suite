package com.example.restassuredproject.DTO;

import com.example.restassuredproject.utility.UTIL;

import java.io.IOException;
import java.util.Properties;

public class BusinessInfoBodyParams {
    private String city;
    private String bizName;
    private String bizNameBn;
    private String bizType;
    private String upazila;
    private String shopAddress;
    private String merchantCategoryCode;

    UTIL util=new UTIL();
    Properties prop = util.readPropData();

    String city_prop = prop.getProperty("city_prop");
    String bizName_prop = prop.getProperty("bizName_prop");
    String bizNameBn_prop = prop.getProperty("bizNameBn_prop");
    String bizType_prop = prop.getProperty("bizType_prop");
    String upazila_prop = prop.getProperty("upazila_prop");
    String shopAddress_prop = prop.getProperty("shopAddress_prop");
    String merchantCategoryCode_prop = prop.getProperty("merchantCategoryCode_prop");

    public BusinessInfoBodyParams() throws IOException {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city_prop;
    }

    public String getBizName() {
        return bizName;
    }

    public void setBizName(String bizName) {
        this.bizName = bizName_prop;
    }

    public String getBizNameBn() {
        return bizNameBn;
    }

    public void setBizNameBn(String bizNameBn) {
        this.bizNameBn = bizNameBn_prop;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType_prop;
    }

    public String getUpazila() {
        return upazila;
    }

    public void setUpazila(String upazila) {
        this.upazila = upazila_prop;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress_prop;
    }

    public String getMerchantCategoryCode() {
        return merchantCategoryCode;
    }

    public void setMerchantCategoryCode(String merchantCategoryCode) {
        this.merchantCategoryCode = merchantCategoryCode_prop;
    }
}
