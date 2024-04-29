package com.example.restassuredproject.features;


import com.example.restassuredproject.DTO.SignUpAttemptBodyParams;
import com.example.restassuredproject.model.User;
import com.example.restassuredproject.utility.APIPath;
import com.example.restassuredproject.utility.UTIL;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.util.Properties;


public class SignUpAttempt {


public Response signUp(User user) throws IOException {

    RestAssured.baseURI= APIPath.hostURLMain;

    //json body parse
    SignUpAttemptBodyParams signUpBodyParams=new SignUpAttemptBodyParams();
    signUpBodyParams.setDevice_id(signUpBodyParams.getDevice_id());
    signUpBodyParams.setName(signUpBodyParams.getName());
    signUpBodyParams.setDevice_type(signUpBodyParams.getDevice_type());
    signUpBodyParams.setMobile_number(signUpBodyParams.getMobile_number());
    signUpBodyParams.setUuid(signUpBodyParams.getUuid());

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
                        .body(signUpBodyParams)
                        .header("Content-Type", "application/json")
                        .post("/api/v1/user/signup/attempt").prettyPeek().then().extract().response();


    return response;

}
}
