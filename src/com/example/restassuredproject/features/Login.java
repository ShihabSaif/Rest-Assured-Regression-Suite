package com.example.restassuredproject.features;

import com.example.restassuredproject.DTO.LoginBodyParams;
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

public class Login {
    public Response login(User user) throws IOException {
        RestAssured.baseURI= APIPath.hostURLMain;
        LoginBodyParams login = new LoginBodyParams();
        login.setAppType(login.getAppType());
        login.setDeviceId(login.getDevice_type());
        login.setDevice_type(login.getDevice_type());
        login.setMobile_number(login.getMobile_number());
        login.setPassword(login.getPassword());
        login.setUuid(login.getUuid());

        //Read data from property file
        UTIL util=new UTIL();
        Properties prop = util.readPropData();
        String auth_token= prop.getProperty("auth_token");

        //body declare
        RequestSpecification httpRequest =RestAssured.given().contentType(ContentType.JSON).headers("Authorization","token " + auth_token);
        //response
        Response response = httpRequest
                .header("Content-Type", "application/json")
                .when()
                .body(login)
                .header("Content-Type", "application/json")
                .post("/api/v2/tk/user/login").prettyPeek().then().extract().response();

        return response;
    }

}
