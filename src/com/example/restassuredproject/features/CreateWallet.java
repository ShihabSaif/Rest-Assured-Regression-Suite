package com.example.restassuredproject.features;

import com.example.restassuredproject.DTO.CreateWalletBodyParams;
import com.example.restassuredproject.model.User;
import com.example.restassuredproject.utility.APIPath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

public class CreateWallet {
    public Response createWallet(User user) throws IOException {
        RestAssured.baseURI= APIPath.createWallet;

        //json body parse
        CreateWalletBodyParams createWalletBodyParams=new CreateWalletBodyParams();
        createWalletBodyParams.setName(createWalletBodyParams.getName());
        createWalletBodyParams.setPin(createWalletBodyParams.getPin());
        createWalletBodyParams.setRole(createWalletBodyParams.getRole());
        createWalletBodyParams.setBiller_code(createWalletBodyParams.getBiller_code());
        createWalletBodyParams.setDevice_id(createWalletBodyParams.getDevice_id());
        createWalletBodyParams.setUuid(createWalletBodyParams.getUuid());
        createWalletBodyParams.setMobile_number(createWalletBodyParams.getMobile_number());

        //body declare
        RequestSpecification httpRequest =RestAssured.given().contentType(ContentType.JSON);
        //response
        Response response = httpRequest
                .header("Content-Type", "application/json")
                .when()
                .body(createWalletBodyParams)
                .header("Content-Type", "application/json")
                .post().prettyPeek().then().extract().response();


        return response;
    }
}
