package com.example.restassuredproject.features;

import com.example.restassuredproject.DTO.BusinessInfoBodyParams;
import com.example.restassuredproject.DTO.InsertBizInfoBodyParams;
import com.example.restassuredproject.DTO.WalletInfoBodyParams;
import com.example.restassuredproject.model.User;
import com.example.restassuredproject.testClasses.TestCaseForFoLogin;
import com.example.restassuredproject.testClasses.TestClassForSignUp;
import com.example.restassuredproject.utility.APIPath;
import com.example.restassuredproject.utility.UTIL;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.util.Properties;

public class InsertBizInfo {
    public Response InsertBizInfo(User user) throws IOException {
        RestAssured.baseURI= APIPath.hostURLMain;

        UTIL util=new UTIL();
        Properties prop = util.readPropData();

        String phn_number_prop = prop.getProperty("phn_number");

        InsertBizInfoBodyParams bizInfo = new InsertBizInfoBodyParams();

        BusinessInfoBodyParams businessInfo = new BusinessInfoBodyParams();
        businessInfo.setCity(businessInfo.getCity());
        businessInfo.setBizName(businessInfo.getBizName());
        businessInfo.setBizNameBn(businessInfo.getBizNameBn());
        businessInfo.setBizType(businessInfo.getBizType());
        businessInfo.setUpazila(businessInfo.getUpazila());
        businessInfo.setShopAddress(businessInfo.getShopAddress());
//        businessInfo.setMerchantCategoryCode(null);

        WalletInfoBodyParams walletInfo = new WalletInfoBodyParams();
        walletInfo.setUserType(walletInfo.getUserType());

        bizInfo.setBusinessInfo(businessInfo);
        bizInfo.setWalletInfo(walletInfo);

        //body declare
        RequestSpecification httpRequest =RestAssured.given().contentType(ContentType.JSON).headers("Authorization","token " + TestCaseForFoLogin.fo_token);

        // Convert the request body object to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonBody = objectMapper.writeValueAsString(bizInfo);

        // Print the JSON representation of the request body
        System.out.println("Request Body: " + jsonBody);

        //response
        Response response = httpRequest
                .header("Content-Type", "application/json")
                .when()
                .body(bizInfo)
                .header("Content-Type", "application/json")
                .post("/api/v1/external/biz/" + phn_number_prop).prettyPeek().then().extract().response();

        return response;
    }
}
