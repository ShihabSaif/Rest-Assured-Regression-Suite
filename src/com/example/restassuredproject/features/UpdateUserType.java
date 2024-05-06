package com.example.restassuredproject.features;

import com.example.restassuredproject.DTO.SendMoneyBodyParams;
import com.example.restassuredproject.DTO.UserTypeUpdateBodyParam;
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

public class UpdateUserType {
    public Response updateUserType(User user) throws IOException {
        RestAssured.baseURI= APIPath.nobopay_backend;
        UserTypeUpdateBodyParam userType = new UserTypeUpdateBodyParam();
        userType.setWallet(userType.getWallet());
        userType.setUserType(userType.getUserType());
        userType.setRemarks(userType.getRemarks());

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
                .body(userType)
                .header("Content-Type", "application/json")
                .put("/api/profile/update/userType").prettyPeek().then().extract().response();

        return response;
    }
}
