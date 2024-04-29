package com.example.restassuredproject.features;


import com.example.restassuredproject.DTO.SignUpWalletBodyParams;
import com.example.restassuredproject.model.User;
import com.example.restassuredproject.utility.APIPath;
import com.example.restassuredproject.utility.UTIL;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;


public class SignUpWallet {


public Response signUp(User user) throws IOException {

    RestAssured.baseURI= APIPath.hostURLMain;

    //json body parse
    SignUpWalletBodyParams signUpBodyParams=new SignUpWalletBodyParams();
    signUpBodyParams.setRole(signUpBodyParams.getRole());
    signUpBodyParams.setName(signUpBodyParams.getName());
    signUpBodyParams.setPin(signUpBodyParams.getPin());
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
                        .post("/api/v1/tk/user/signup/wallet").prettyPeek().then().extract().response();


    return response;

}
}
