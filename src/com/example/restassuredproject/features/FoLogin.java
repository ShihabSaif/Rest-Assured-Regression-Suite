package com.example.restassuredproject.features;

import com.example.restassuredproject.DTO.FoLoginBodyParams;
import com.example.restassuredproject.model.User;
import com.example.restassuredproject.utility.APIPath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

public class FoLogin {
    public Response fologin(User user) throws IOException {
        RestAssured.baseURI= APIPath.hostURLMain;
        FoLoginBodyParams fo = new FoLoginBodyParams();
        fo.setExternalFi(fo.getExternalFi());
        fo.setUserId(fo.getUserId());
        fo.setPassword(fo.getPassword());

        //body declare
        RequestSpecification httpRequest =RestAssured.given().contentType(ContentType.JSON);
        //response
        Response response = httpRequest
                .header("Content-Type", "application/json")
                .when()
                .body(fo)
                .header("Content-Type", "application/json")
                .post("/api/v1/external/get/token").prettyPeek().then().extract().response();

        return response;
    }
}
