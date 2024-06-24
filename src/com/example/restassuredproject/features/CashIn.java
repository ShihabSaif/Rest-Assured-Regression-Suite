package com.example.restassuredproject.features;

import com.example.restassuredproject.DTO.CashInBodyParams;
import com.example.restassuredproject.DTO.CashOutBodyParams;
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

public class CashIn {
    public Response CashIn(User user) throws IOException {
        RestAssured.baseURI= APIPath.npapi;
        CashInBodyParams cashin = new CashInBodyParams();
        cashin.setWallet_no(cashin.getWallet_no());
        cashin.setAmount(cashin.getAmount());
        cashin.setCard_gateway(cashin.getCard_gateway());
        cashin.setCard_no_mask(cashin.getCard_no_mask());
        cashin.setCard_type(cashin.getCard_type());
        cashin.setRequest_id(cashin.getRequest_id());

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
                .body(cashin)
                .header("Content-Type", "application/json")
                .post("api/transaction/add-money/card").prettyPeek().then().extract().response();

        return response;
    }
}
