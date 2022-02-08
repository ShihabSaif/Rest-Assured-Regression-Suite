package com.example.restassuredproject.features;


import com.example.restassuredproject.DTO.SignUpBodyParams;
import com.example.restassuredproject.model.User;
import com.example.restassuredproject.utility.APIPath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

import static io.restassured.RestAssured.given;


public class SignUp {


public Response signUp(User user) throws IOException {

    RestAssured.baseURI= APIPath.hostURL2;

    //json body parse
    SignUpBodyParams signUpBodyParams=new SignUpBodyParams();
    signUpBodyParams.setDevice_id(signUpBodyParams.getDevice_id());
    signUpBodyParams.setName(signUpBodyParams.getName());
    signUpBodyParams.setDevice_type(signUpBodyParams.getDevice_type());
    signUpBodyParams.setMobile_number(signUpBodyParams.getMobile_number());
    signUpBodyParams.setUuid(signUpBodyParams.getUuid());

    //body declare
    RequestSpecification httpRequest =RestAssured.given().contentType(ContentType.JSON);
    //response
    Response response = httpRequest
                        .header("Content-Type", "application/json")
                        .when()
                        .body(signUpBodyParams)
                        .header("Content-Type", "application/json")
                        .post().prettyPeek().then().extract().response();


    return response;

}
}
