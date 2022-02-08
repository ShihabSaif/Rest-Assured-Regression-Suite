package com.example.restassuredproject.DTO;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import static com.example.restassuredproject.DTO.SignUpBodyParams.phnNumber;

public class GetOTPForSignUPBodyParams {

    SignUpBodyParams signUpBodyParams=new SignUpBodyParams();

    /*public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = "01600000447";
    }*/

    public String wallet=phnNumber;

    public GetOTPForSignUPBodyParams() throws IOException {
    }
    // public String wallet="01600000447";

}
