package com.example.restassuredproject.features;

import com.example.restassuredproject.DTO.AttachBankBodyParams;
import com.example.restassuredproject.DTO.NIDFrontUploadBodyParams;
import com.example.restassuredproject.model.User;
import com.example.restassuredproject.testClasses.TestClassForSignUp;
import com.example.restassuredproject.utility.APIPath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

public class AttachBank {
    public Response attachBank() throws IOException {
        RestAssured.baseURI= APIPath.hostURLMain;

        //json body parse
        AttachBankBodyParams attachBankBodyParam = new AttachBankBodyParams();
        attachBankBodyParam.setAccount_type(attachBankBodyParam.getAccount_type());
        attachBankBodyParam.setAccountType(attachBankBodyParam.getAccountType());
        attachBankBodyParam.setMfs_type(attachBankBodyParam.getMfs_type());
        attachBankBodyParam.setOtpVerified(attachBankBodyParam.getOtpVerified());
        attachBankBodyParam.setWallet_no(attachBankBodyParam.getWallet_no());

        //body declare
        RequestSpecification httpRequest =RestAssured.given().contentType(ContentType.JSON).headers("Authorization","token " + TestClassForSignUp.token);

        //response
        Response response = httpRequest
                .header("Content-Type", "application/json")
                .when()
                .body(attachBankBodyParam)
                .header("Content-Type", "application/json")
                .post("/api/v1/account").prettyPeek().then().extract().response();

        return response;
    }
}
