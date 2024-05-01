package com.example.restassuredproject.features;

import com.example.restassuredproject.DTO.RechargeBodyParams;
import com.example.restassuredproject.model.User;
import com.example.restassuredproject.testClasses.TestCaseForLogin;
import com.example.restassuredproject.utility.APIPath;
import com.example.restassuredproject.utility.UTIL;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.util.Properties;

public class Recharge {
    public Response recharge(User user) throws IOException {
        RestAssured.baseURI= APIPath.hostURLMain;
        RechargeBodyParams topup = new RechargeBodyParams();
        topup.setReceiver_mobile(topup.getReceiver_mobile());
        topup.setMobile_operator(topup.getMobile_operator());
        topup.setMobile_type(topup.getMobile_type());
        topup.setReceiver_name(topup.getReceiver_name());
        topup.setWallet(topup.getWallet());
        topup.setIs_fp_auth(topup.getIs_fp_auth());
        topup.setCredential(topup.getCredential());
        topup.setAmount(topup.getAmount());
        topup.setRequest_id(topup.getRequest_id());

        //Read data from property file
        UTIL util=new UTIL();
        Properties prop = util.readPropData();
        String auth_token= TestCaseForLogin.token;

        //body declare
        RequestSpecification httpRequest =RestAssured.given().contentType(ContentType.JSON).headers("Authorization","token " + auth_token);
        //response
        Response response = httpRequest
                .header("Content-Type", "application/json")
                .when()
                .body(topup)
                .header("Content-Type", "application/json")
                .post("/api/v1/transaction/recharge-mobile").prettyPeek().then().extract().response();


        return response;
    }

}
