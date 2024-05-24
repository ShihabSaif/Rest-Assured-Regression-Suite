package com.example.restassuredproject.features;

import com.example.restassuredproject.DTO.ActiveUserBodyParams;
import com.example.restassuredproject.DTO.AttachBankBodyParams;
import com.example.restassuredproject.testClasses.TestClassForSignUp;
import com.example.restassuredproject.utility.APIPath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

public class ActiveUser {
    public Response activeuser() throws IOException {
        RestAssured.baseURI = APIPath.nobopay_backend;

        //json body parse
        ActiveUserBodyParams activeuser = new ActiveUserBodyParams();
        activeuser.setWalletNo(activeuser.getWalletNo());
        activeuser.setStatus(activeuser.getStatus());
        activeuser.setRemarks(activeuser.getRemarks());
        activeuser.setExternalUserName(activeuser.getExternalUserName());

        //body declare
        RequestSpecification httpRequest =RestAssured.given().contentType(ContentType.JSON).headers("Authorization","token " + TestClassForSignUp.token);

        //response
        Response response = httpRequest
                .when()
                .body(activeuser)
                .header("Content-Type", "application/json")
                .post("/api/biz/update/user/status").prettyPeek().then().extract().response();

        return response;
    }
}
