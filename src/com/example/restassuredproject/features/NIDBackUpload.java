package com.example.restassuredproject.features;

import com.example.restassuredproject.DTO.NIDBackUploadBodyParams;
import com.example.restassuredproject.DTO.NIDFrontUploadBodyParams;
import com.example.restassuredproject.model.User;
import com.example.restassuredproject.testClasses.TestClassForSignUp;
import com.example.restassuredproject.utility.APIPath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

public class NIDBackUpload {

    public Response nidBackUpload() throws IOException {
        RestAssured.baseURI= APIPath.hostURLMain;

        //json body parse
        NIDBackUploadBodyParams nidFrontUploadBodyParams=new NIDBackUploadBodyParams();
        nidFrontUploadBodyParams.setNidNo(nidFrontUploadBodyParams.getNidNo());
        nidFrontUploadBodyParams.setNidType(nidFrontUploadBodyParams.getNidType());
        nidFrontUploadBodyParams.setRequestId(nidFrontUploadBodyParams.getRequestId());
        nidFrontUploadBodyParams.setPhotoBackSide(nidFrontUploadBodyParams.getPhotoBackSide());

        //body declare
        RequestSpecification httpRequest =RestAssured.given().contentType(ContentType.JSON).headers("Authorization","token " + TestClassForSignUp.token);

        //response
        Response response = httpRequest
                .header("Content-Type", "application/json")
                .when()
                .body(nidFrontUploadBodyParams)
                .header("Content-Type", "application/json")
                .post("/api/v1/user/doc/nid-back").prettyPeek().then().extract().response();


        return response;
    }
}
