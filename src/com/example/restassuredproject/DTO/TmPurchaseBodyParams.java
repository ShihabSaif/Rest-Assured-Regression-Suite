package com.example.restassuredproject.DTO;

import com.example.restassuredproject.utility.UTIL;

import java.io.IOException;
import java.util.Properties;

public class TmPurchaseBodyParams {
    private String amount;
    private String credential;
    private String externalData;
    private String note;
    private String orderId;

    UTIL util=new UTIL();
    Properties prop = util.readPropData();

    public TmPurchaseBodyParams() throws IOException {
    }

    String tm_purchase_amount_prop = prop.getProperty("tm_purchase_amount_prop");
    String credential_prop = prop.getProperty("pin_prop");
    String tm_purchase_externalData_prop = prop.getProperty("tm_purchase_externalData_prop");
    String note_prop = prop.getProperty("note_prop");
    String orderId_prop = UTIL.generateRandomRequestId();

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = tm_purchase_amount_prop;
    }

    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential_prop;
    }

    public String getExternalData() {
        return externalData;
    }

    public void setExternalData(String externalData) {
        this.externalData = tm_purchase_externalData_prop;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note_prop;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId_prop;
    }
}
