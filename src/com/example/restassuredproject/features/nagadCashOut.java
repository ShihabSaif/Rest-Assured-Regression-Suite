package com.example.restassuredproject.features;

import com.example.restassuredproject.DTO.NagadCashOutBodyParams;
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

public class nagadCashOut {
    public Response nagadcashOut(User user, String financialInstitute, String toAc) throws IOException {
        RestAssured.baseURI= APIPath.tallypay_to_fi_producer;
        NagadCashOutBodyParams cashout = new NagadCashOutBodyParams(financialInstitute, toAc);

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
                .body(cashout)
                .header("Content-Type", "application/json")
                .post("api/v1/external/send/money").prettyPeek().then().extract().response();

        return response;
    }
}
