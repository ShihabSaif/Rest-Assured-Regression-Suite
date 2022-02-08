package com.example.restassuredproject.DTO;

import com.example.restassuredproject.testClasses.TestCaseForGetOTPForSignUp;

import static com.example.restassuredproject.DTO.SignUpBodyParams.phnNumber;
import static com.example.restassuredproject.testClasses.TestCaseForGetOTPForSignUp.otpCode;

public class OTPValidationBodyParams {
    private String otp;
    private String mobile_number;
    private String otp_type;



    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp =TestCaseForGetOTPForSignUp.otpCode;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = phnNumber;
    }

    public String getOtp_type() {
        return otp_type;
    }

    public void setOtp_type(String otp_type) {
        this.otp_type = "REGISTRATION";
    }


}
