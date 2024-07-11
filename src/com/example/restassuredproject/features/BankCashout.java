package com.example.restassuredproject.features;

import com.example.restassuredproject.DTO.BankCashoutBodyParams;
import com.example.restassuredproject.model.User;
import com.example.restassuredproject.testClasses.TestClassForSignUp;
import com.example.restassuredproject.utility.APIPath;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

public class BankCashout {
    public Response bankCashout(User user) throws IOException {
        RestAssured.baseURI= APIPath.hostURLMain;

        BankCashoutBodyParams bankCashout = new BankCashoutBodyParams();
        bankCashout.setRouting_no(bankCashout.getRouting_no());
        bankCashout.setAccount_no(bankCashout.getAccount_no());
        bankCashout.setAmount(bankCashout.getAmount());
        bankCashout.setBankCode(bankCashout.getBankCode());
        bankCashout.setRequest_id(bankCashout.getRequest_id());

        //body declare
        RequestSpecification httpRequest =RestAssured.given().contentType(ContentType.JSON).headers("Authorization","token " + TestClassForSignUp.token);

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
