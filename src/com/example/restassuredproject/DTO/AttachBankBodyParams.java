package com.example.restassuredproject.DTO;

import com.example.restassuredproject.utility.UTIL;

import java.io.IOException;
import java.util.Properties;

public class AttachBankBodyParams {
    private String otpVerified ;
    private String accountType;
    private String account_type;
    private  String mfs_type;
    private  String wallet_no;

    //Read data from property file
    UTIL util=new UTIL();
    Properties prop = util.readPropData();

    String otp_verified_prop= prop.getProperty("otp_verified_prop");
    String accountType_prop= prop.getProperty("accountType_prop");
    String account_type_prop= prop.getProperty("account_type_prop");
    String mfs_type_prop = prop.getProperty("mfs_type_prop");
    String wallet_no_prop = prop.getProperty("wallet_no_prop");

    public AttachBankBodyParams() throws IOException {
    }

    public String getOtpVerified() {
        return otpVerified;
    }

    public void setOtpVerified(String otpVerified) {
        this.otpVerified = otp_verified_prop;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType_prop;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type_prop;
    }

    public String getMfs_type() {
        return mfs_type;
    }

    public void setMfs_type(String mfs_type) {
        this.mfs_type = mfs_type_prop;
    }

    public String getWallet_no() {
        return wallet_no;
    }

    public void setWallet_no(String wallet_no) {
        this.wallet_no = wallet_no_prop;
    }
}
