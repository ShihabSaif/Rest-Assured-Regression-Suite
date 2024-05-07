package com.example.restassuredproject.features;

import com.example.restassuredproject.DTO.AdditionalDataParams;
import com.example.restassuredproject.DTO.NPSBCreditBodyParam;
import com.example.restassuredproject.model.User;
import com.example.restassuredproject.testClasses.TestClassForSignUp;
import com.example.restassuredproject.utility.APIPath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class NPSBCredit {
    public Response npsbCredit(User user) throws IOException {
        RestAssured.baseURI= APIPath.bankConsumer;

        NPSBCreditBodyParam npsb = new NPSBCreditBodyParam();
        npsb.setAmount(npsb.getAmount());
        npsb.setExternal_account_name(npsb.getExternal_account_name());
        npsb.setExternal_account_no(npsb.getExternal_account_no());
        npsb.setExternal_FI(npsb.getExternal_FI());
        npsb.setExternal_txn_id(npsb.getExternal_txn_id());
        npsb.setReceiver_wallet_no(npsb.getReceiver_wallet_no());
        npsb.setTrace_id(npsb.getTrace_id());

        AdditionalDataParams additionalData = new AdditionalDataParams();
        additionalData.setStoreLabel(additionalData.getStoreLabel());
        additionalData.setTerminalLabel(additionalData.getTerminalLabel());

        npsb.setAdditionalData(additionalData);

        //body declare
        RequestSpecification httpRequest =RestAssured.given().contentType(ContentType.JSON).headers("Authorization","token " + TestClassForSignUp.token);

        //response
        Response response = httpRequest
                .header("Content-Type", "application/json")
                .when()
                .body(npsb)
                .header("Content-Type", "application/json")
                .post("/api/v1/internal/npsb/transfer/credit").prettyPeek().then().extract().response();

        return response;
    }
}
