package com.example.restassuredproject.features;

import com.example.restassuredproject.DTO.NIDFrontUploadBodyParams;
import com.example.restassuredproject.model.User;
import com.example.restassuredproject.testClasses.TestClassForCreateWallet;
import com.example.restassuredproject.utility.APIPath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

public class NIDFrontUpload {

    public Response nidFrontUpload(User user) throws IOException {
        RestAssured.baseURI= APIPath.nidFrontUpload;

        //json body parse
        NIDFrontUploadBodyParams nidFrontUploadBodyParams=new NIDFrontUploadBodyParams();
        nidFrontUploadBodyParams.setNidNo(nidFrontUploadBodyParams.getNidNo());
        nidFrontUploadBodyParams.setNidType(nidFrontUploadBodyParams.getNidType());
        nidFrontUploadBodyParams.setRequestId(nidFrontUploadBodyParams.getRequestId());
        nidFrontUploadBodyParams.setPhotoFrontSide(nidFrontUploadBodyParams.getPhotoFrontSide());

        //body declare
        RequestSpecification httpRequest =RestAssured.given().contentType(ContentType.JSON).headers("Authorization","token " + TestClassForCreateWallet.token);

        //response
        Response response = httpRequest
                .header("Content-Type", "application/json")
                .when()
                .body(nidFrontUploadBodyParams)
                .header("Content-Type", "application/json")
                .post().prettyPeek().then().extract().response();


        return response;
    }
}
