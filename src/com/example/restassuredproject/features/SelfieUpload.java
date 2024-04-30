package com.example.restassuredproject.features;

import com.example.restassuredproject.DTO.SelfieUploadBodyParams;
import com.example.restassuredproject.model.User;
import com.example.restassuredproject.testClasses.TestClassForSignUp;
import com.example.restassuredproject.utility.APIPath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

public class SelfieUpload {
    public Response selfieUpload(User user) throws IOException {
        RestAssured.baseURI= APIPath.hostURLMain;
        SelfieUploadBodyParams selfieUp = new SelfieUploadBodyParams();
        selfieUp.setNidNo(selfieUp.getNidNo());
        selfieUp.setProfilePicture(selfieUp.getProfilePicture());
        selfieUp.setRequestId(selfieUp.getRequestId());

        //body declare
        RequestSpecification httpRequest =RestAssured.given().contentType(ContentType.JSON).headers("Authorization","token " + TestClassForSignUp.token);

        //response
        Response response = httpRequest
                .header("Content-Type", "application/json")
                .when()
                .body(selfieUp)
                .header("Content-Type", "application/json")
                .post("/api/v1/user/doc/face-image").prettyPeek().then().extract().response();

        return response;
    }
}
