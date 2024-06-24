package com.example.restassuredproject.features;

import com.example.restassuredproject.model.User;
import com.example.restassuredproject.testClasses.TestClassForSignUp;
import com.example.restassuredproject.utility.APIPath;
import com.example.restassuredproject.utility.UTIL;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.util.Properties;

public class WalletStatement {
    public Response WalletStatement() throws IOException {
        RestAssured.baseURI= APIPath.nobopay_backend;

        UTIL util=new UTIL();
        Properties prop = util.readPropData();

        String phn_number_prop = prop.getProperty("phn_number");

        //body declare
        RequestSpecification httpRequest =RestAssured.given().contentType(ContentType.JSON).headers("Authorization","token " + TestClassForSignUp.token);

        //response
        Response response = httpRequest
                .when()
                .header("Content-Type", "application/json")
                .get("/api/txn/statement/wallet/" + phn_number_prop).prettyPeek().then().extract().response();

        return response;
    }
}
