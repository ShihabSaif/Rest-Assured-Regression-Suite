package com.example.restassuredproject.features;

import com.example.restassuredproject.DTO.AttachBankBodyParams;
import com.example.restassuredproject.DTO.PinSetBodyParams;
import com.example.restassuredproject.testClasses.TestClassForSignUp;
import com.example.restassuredproject.utility.APIPath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

public class PinSet {
    public Response pinSet() throws IOException {
        RestAssured.baseURI = APIPath.tallyKhataUrlMain;

        //json body parse
        PinSetBodyParams pinsetBodyParam = new PinSetBodyParams();
        pinsetBodyParam.setNew_pin(pinsetBodyParam.getNew_pin());
        pinsetBodyParam.setUuid(pinsetBodyParam.getUuid());
        pinsetBodyParam.setWallet_no(pinsetBodyParam.getWallet_no());

        //body declare
        RequestSpecification httpRequest =RestAssured.given().contentType(ContentType.JSON)
                .headers("Authorization","Basic cHNsX3FhOnBzbHFhQDAwNyE=")
                .headers("x-auth-token", "GyE7nOpiJMnIiTAFUIocjJ8tEpLLBMSyamKqlKx3")
                .headers("x-device-id", "bd5b6dbd-f479-433e-8fb3-d4eda8fa5906")
                .headers("x-user-mobile", pinsetBodyParam.getWallet_no());

        //response
        Response response = httpRequest
                .headers("Content-Type", "application/json")
                .when()
                .body(pinsetBodyParam)
                .put("/wallet/api/tp-proxy/pin/set").prettyPeek().then().extract().response();

        return response;

    }
}
