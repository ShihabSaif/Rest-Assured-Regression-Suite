package com.example.restassuredproject.features;

import com.example.restassuredproject.DTO.WalletLookUpBodyParams;
import com.example.restassuredproject.utility.APIPath;
import com.example.restassuredproject.utility.UTIL;
import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.params.CoreConnectionPNames;
import org.hamcrest.Matchers;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
public class WalletLookup {
    public static RequestSpecification walletLookUp() throws IOException, InterruptedException {
        RestAssured.baseURI = APIPath.hostURLMain;

        //json body parse
        WalletLookUpBodyParams walletBodyParams = new WalletLookUpBodyParams();
        walletBodyParams.setUuid(walletBodyParams.getUuid());
        walletBodyParams.setDevice_id(walletBodyParams.getDevice_id());
        walletBodyParams.setApp_type(walletBodyParams.getApp_type());
        walletBodyParams.setDevice_type(walletBodyParams.getDevice_type());
        walletBodyParams.setMobile_number(walletBodyParams.getMobile_number());


        //request body declare

        RestAssuredConfig newConfig = RestAssured.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam(CoreConnectionPNames.CONNECTION_TIMEOUT, 10000)
                        .setParam(CoreConnectionPNames.SO_TIMEOUT, 10000));

        //Read data from property file
        UTIL util=new UTIL();
        Properties prop = util.readPropData();
        String auth_token= prop.getProperty("auth_token");

        RequestSpecification httpRequest = RestAssured.given().contentType(ContentType.JSON).config(newConfig).headers("Authorization","token " + auth_token);




        RequestSpecification request = httpRequest
                .header("Content-Type", "application/json")
                .when()
                .basePath("/api/v1/tk/user/wallet/lookup")
                .body(walletBodyParams)
                .header("Content-Type", "application/json");

        //delay

        //request

        return request;


    }



}

