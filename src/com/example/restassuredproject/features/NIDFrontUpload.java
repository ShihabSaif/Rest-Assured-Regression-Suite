package com.example.restassuredproject.features;

import com.example.restassuredproject.DTO.NIDFrontUploadBodyParams;
import com.example.restassuredproject.model.User;
import com.example.restassuredproject.testClasses.TestClassForSignUp;
import com.example.restassuredproject.utility.APIPath;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

public class NIDFrontUpload {

    public Response nidFrontUpload(User user) throws IOException {
        RestAssured.baseURI= APIPath.hostURLMain;

        //json body parse
        NIDFrontUploadBodyParams nidFrontUploadBodyParams=new NIDFrontUploadBodyParams();
        nidFrontUploadBodyParams.setNidNo(nidFrontUploadBodyParams.getNidNo());
        nidFrontUploadBodyParams.setNidType(nidFrontUploadBodyParams.getNidType());
        nidFrontUploadBodyParams.setRequestId(nidFrontUploadBodyParams.getRequestId());
        nidFrontUploadBodyParams.setPhotoFrontSide(nidFrontUploadBodyParams.getPhotoFrontSide());
        nidFrontUploadBodyParams.setTkMobileNo(nidFrontUploadBodyParams.getTkMobileNo());

        //body declare
        RequestSpecification httpRequest =RestAssured.given().contentType(ContentType.JSON).headers("Authorization","token " + TestClassForSignUp.token);

        // Convert the request body object to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonBody = objectMapper.writeValueAsString(nidFrontUploadBodyParams);

        // Print the JSON representation of the request body
        System.out.println("Request Body: " + jsonBody);

        //response
        Response response = httpRequest
                .header("Content-Type", "application/json")
                .when()
                .body(nidFrontUploadBodyParams)
                .header("Content-Type", "application/json")
                .post("/api/v1/user/doc/nid-front").prettyPeek().then().extract().response();


        return response;
    }
}
