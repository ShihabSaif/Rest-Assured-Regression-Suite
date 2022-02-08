package com.example.restassuredproject.features;

import com.example.restassuredproject.DTO.GetOTPForSignUPBodyParams;
import com.example.restassuredproject.model.User;
import com.example.restassuredproject.utility.APIPath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class GetOTPForSignUP {

    public static Response getOTPResult(User user) throws IOException {
        RestAssured.baseURI= APIPath.hostURL3;

        GetOTPForSignUPBodyParams getOTPForSignUPBodyParams=new GetOTPForSignUPBodyParams();


        Response response = given()
                .contentType(ContentType.JSON)
                .param("wallet", getOTPForSignUPBodyParams.wallet)
                .when()
                .get("/get/otp")
                .then()
                .extract().response();
        return response;
    }
}
