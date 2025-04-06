package com.example.restassuredproject.DTO;

import com.example.restassuredproject.utility.UTIL;

import java.io.IOException;
import java.util.Properties;

public class VisaTransferBodyParams {
    private String wallet ;
    private String primaryAccountNumber;
    private Double amount;
    private String requestId;
    private String channel;
    private String txnType;
    private String cardType;
    private String credential;
    private String instantTransferEnabled;
    private String bankName;
    private String note;

    //Read data from property file
    UTIL util=new UTIL();
    Properties prop = util.readPropData();

    String wallet_prop= prop.getProperty("phn_number");
    String primaryAccountNumber_prop= prop.getProperty("primaryAccountNumber_prop");
    Double amount_prop = Double.valueOf(prop.getProperty("visa_amount_prop"));
    String requestId_prop = UTIL.generateRandomRequestId();
    String channel_prop = prop.getProperty("visa_channel_prop");
    String txnType_prop = prop.getProperty("txnType_prop");
    String cardType_prop = prop.getProperty("cardType_prop");
    String credential_prop = prop.getProperty("pin_prop");
    String instantTransferEnabled_prop = prop.getProperty("instantTransferEnabled_prop");
    String bankName_prop = prop.getProperty("bankName_prop");
    String note_prop = prop.getProperty("note_prop");

    public VisaTransferBodyParams() throws IOException {
    }

    public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = wallet_prop;
    }

    public String getPrimaryAccountNumber() {
        return primaryAccountNumber;
    }

    public void setPrimaryAccountNumber(String primaryAccountNumber) {
        this.primaryAccountNumber = primaryAccountNumber_prop;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount_prop;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId_prop;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel_prop;
    }

    public String getTxnType() {
        return txnType;
    }

    public void setTxnType(String txnType) {
        this.txnType = txnType_prop;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType_prop;
    }

    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential_prop;
    }

    public String getInstantTransferEnabled() {
        return instantTransferEnabled;
    }

    public void setInstantTransferEnabled(String instantTransferEnabled) {
        this.instantTransferEnabled = instantTransferEnabled_prop;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName_prop;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note_prop;
    }
}
