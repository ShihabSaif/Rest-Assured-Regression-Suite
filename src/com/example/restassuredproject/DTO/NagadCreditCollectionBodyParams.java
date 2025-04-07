package com.example.restassuredproject.DTO;

import com.example.restassuredproject.utility.UTIL;

import java.io.IOException;
import java.util.Properties;

public class NagadCreditCollectionBodyParams {
    private String amount;
    private String receiverWallet;
    private String invoiceNo;
    private String externalFI;
    private String externalCustomerId;
    private String externalCustomerName;
    private String externalAccount;
    private String requestId;

    public static final String request_id1 = UTIL.generateRandomRequestId();
    public static final String invoiceNo1 = UTIL.generateInvoiceNo();
    public static final String deeviceID = UTIL.generateRandomDeviceUD();

    //Read data from property file
    UTIL util=new UTIL();
    Properties prop = util.readPropData();
    String amount_sendMoney= prop.getProperty("amount_CreditCollection");
    String credit_collection_receiver= prop.getProperty("credit_collection_receiver");
    String srcbKashNo=prop.getProperty("srcNagadNo");
    String externalFI_prop = prop.getProperty("externalFI_prop");

    public NagadCreditCollectionBodyParams() throws IOException {
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount_sendMoney;
    }

    public String getReceiverWallet() {
        return receiverWallet;
    }

    public void setReceiverWallet(String receiverWallet) {
        this.receiverWallet = credit_collection_receiver;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo1;
    }

    public String getExternalFI() {
        return externalFI;
    }

    public void setExternalFI(String externalFI) {
        this.externalFI = externalFI_prop;
    }

    public String getExternalCustomerId() {
        return externalCustomerId;
    }

    public void setExternalCustomerId(String externalCustomerId) {
        this.externalCustomerId = "5";
    }

    public String getExternalCustomerName() {
        return externalCustomerName;
    }

    public void setExternalCustomerName(String externalCustomerName) {
        this.externalCustomerName = "Sqa-test";
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = request_id1;
    }
    public String getExternalAccount() {
        return externalAccount;
    }

    public void setExternalAccount(String externalAccount) {
        this.externalAccount = srcbKashNo;
    }

}
