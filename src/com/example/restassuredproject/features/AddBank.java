package com.example.restassuredproject.features;

import com.example.restassuredproject.DTO.AddBankBodyParams;
import com.example.restassuredproject.model.User;
import com.example.restassuredproject.testClasses.TestCaseForLogin;
import com.example.restassuredproject.utility.APIPath;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

public class AddBank {
    public Response addBank(User user) throws IOException {
        RestAssured.baseURI= APIPath.hostURLMain;

        AddBankBodyParams addBank = new AddBankBodyParams();
        addBank.setAccount_name(addBank.getAccount_name());
        addBank.setBank_name(addBank.getBank_name());
        addBank.setAccount_number(addBank.getAccount_number());
        addBank.setRequest_id(addBank.getRequest_id());
        addBank.setRouting_number(addBank.getRouting_number());

        //body declare
        RequestSpecification httpRequest =RestAssured.given().contentType(ContentType.JSON).headers("Authorization","token " + TestCaseForLogin.token);

        // Convert the request body object to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonBody = objectMapper.writeValueAsString(addBank);

        // Print the JSON representation of the request body
        System.out.println("Request Body: " + jsonBody);

        //response
        Response response = httpRequest
                .header("Content-Type", "application/json")
                .when()
                .body(addBank)
                .header("Content-Type", "application/json")
                .post("/api/v1/account/bank").prettyPeek().then().extract().response();

        return response;
    }
}
