package com.example.restassuredproject.features;

import com.example.restassuredproject.DTO.OTPValidationBodyParams;
import com.example.restassuredproject.model.User;
import com.example.restassuredproject.utility.APIPath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class OTPValidationForSignUP {

    public static Response otpValidation(User user) {
        RestAssured.baseURI = APIPath.otpValidationPath;
        OTPValidationBodyParams otpValidationBodyParams=new OTPValidationBodyParams();
        otpValidationBodyParams.setMobile_number(otpValidationBodyParams.getMobile_number());
        otpValidationBodyParams.setOtp(otpValidationBodyParams.getOtp());
        otpValidationBodyParams.setOtp_type(otpValidationBodyParams.getOtp_type());

        //body declare
        RequestSpecification httpRequest =RestAssured.given().contentType(ContentType.JSON);

        //response
        Response response = httpRequest
                .header("Content-Type", "application/json")
                .when()
                .body(otpValidationBodyParams)
                .header("Content-Type", "application/json")
                .post().prettyPeek().then().extract().response();


        return response;

    }
}
