package com.example.restassuredproject.features;

import com.example.restassuredproject.BrowserOpen.BasePage;
import com.example.restassuredproject.DTO.TmPurchaseBodyParams;
import com.example.restassuredproject.model.User;
import com.example.restassuredproject.testClasses.TestCaseForLogin;
import com.example.restassuredproject.testClasses.TestClassForSignUp;
import com.example.restassuredproject.utility.APIPath;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

public class TmPurchase {
    public Response tmPurchase(User user) throws IOException {
        RestAssured.baseURI= APIPath.hostURLMain;

        TmPurchaseBodyParams tmpurchase = new TmPurchaseBodyParams();
        tmpurchase.setCredential(tmpurchase.getCredential());
        tmpurchase.setNote(tmpurchase.getNote());
        tmpurchase.setExternalData(tmpurchase.getExternalData());
        tmpurchase.setAmount(tmpurchase.getAmount());
        tmpurchase.setOrderId(tmpurchase.getOrderId());

        //body declare
        RequestSpecification httpRequest =RestAssured.given().contentType(ContentType.JSON).headers("Authorization","token " + TestCaseForLogin.token);

        // Convert the request body object to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonBody = objectMapper.writeValueAsString(tmpurchase);

        // Print the JSON representation of the request body
        System.out.println("Request Body: " + jsonBody);

        //response
        Response response = httpRequest
                .header("Content-Type", "application/json")
                .when()
                .body(tmpurchase)
                .header("Content-Type", "application/json")
                .post("/api/v1/transaction/tk/tm-purchase").prettyPeek().then().extract().response();

        return response;

    }

}
