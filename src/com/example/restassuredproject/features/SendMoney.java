package com.example.restassuredproject.features;

import com.example.restassuredproject.DTO.SendMoneyBodyParams;
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

public class SendMoney {
    public Response sendMoney(User user) throws IOException {
        RestAssured.baseURI= APIPath.hostURLMain;
        SendMoneyBodyParams sendMoney = new SendMoneyBodyParams();
        sendMoney.setAmount(sendMoney.getAmount());
        sendMoney.setCredential(sendMoney.getCredential());
        sendMoney.setReceiver(sendMoney.getReceiver());
        sendMoney.setRequest_id(sendMoney.getRequest_id());
        sendMoney.setReceiver_wallet_no(sendMoney.getReceiver_wallet_no());

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
                .body(sendMoney)
                .header("Content-Type", "application/json")
                .post("/api/v1/transaction/tk/send-money").prettyPeek().then().extract().response();

        return response;
    }
}
