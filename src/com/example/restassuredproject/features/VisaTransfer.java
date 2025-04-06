package com.example.restassuredproject.features;

import com.example.restassuredproject.DTO.RechargeBodyParams;
import com.example.restassuredproject.DTO.VisaTransferBodyParams;
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

public class VisaTransfer {
    public Response VisaTransfer(User user) throws IOException {
        RestAssured.baseURI= APIPath.hostURLMain;
        VisaTransferBodyParams visa = new VisaTransferBodyParams();
        visa.setWallet(visa.getWallet());
        visa.setPrimaryAccountNumber(visa.getPrimaryAccountNumber());
        visa.setAmount(visa.getAmount());
        visa.setRequestId(visa.getRequestId());
        visa.setChannel(visa.getChannel());
        visa.setTxnType(visa.getTxnType());
        visa.setCardType(visa.getCardType());
        visa.setCredential(visa.getCredential());
        visa.setInstantTransferEnabled(visa.getInstantTransferEnabled());
        visa.setBankName(visa.getBankName());
        visa.setNote(visa.getNote());

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
                .body(visa)
                .post("/api/v1/visa/transfer").prettyPeek().then().extract().response();

        return response;
    }
}
