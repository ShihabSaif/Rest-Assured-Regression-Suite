package com.example.restassuredproject.features;

import com.example.restassuredproject.DTO.BankCashoutBodyParams;
import com.example.restassuredproject.model.User;
import com.example.restassuredproject.testClasses.TestCaseForLogin;
import com.example.restassuredproject.testClasses.TestClassForSignUp;
import com.example.restassuredproject.utility.APIPath;
import com.example.restassuredproject.utility.UTIL;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.util.Properties;

public class BankCashout {
    public Response bankCashout(User user, String routing_no, String account_no, String bankCode, String instantTransfer, String amount) throws IOException {
        RestAssured.baseURI= APIPath.hostURLMain;

        BankCashoutBodyParams bankCashout = new BankCashoutBodyParams(routing_no, account_no, bankCode, instantTransfer, amount);

        //Read data from property file
        UTIL util=new UTIL();
        Properties prop = util.readPropData();
        String auth_token= TestCaseForLogin.token;

        //body declare
        RequestSpecification httpRequest =RestAssured.given().contentType(ContentType.JSON).headers("Authorization","token " + TestCaseForLogin.token);

        // Convert the request body object to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonBody = objectMapper.writeValueAsString(bankCashout);

        // Print the JSON representation of the request body
        System.out.println("Request Body: " + jsonBody);

        //response
        Response response = httpRequest
                .header("Content-Type", "application/json")
                .when()
                .body(bankCashout)
                .header("Content-Type", "application/json")
                .post("/api/v1/transaction/cash-out/bank").prettyPeek().then().extract().response();

        return response;
    }
}
