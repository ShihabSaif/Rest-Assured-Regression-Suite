package com.example.restassuredproject.testClasses;

import com.example.restassuredproject.features.WalletStatement;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.annotations.Test;

import java.io.IOException;

@Test(priority = 18,alwaysRun = true, enabled = true)
public class TestCaseForWalletStatement {
    public static WalletStatement walletStmt = new WalletStatement();

    public void TestCasesForWalletStatement() throws IOException {
        Response response = walletStmt.WalletStatement();
        JsonPath jsonPathEvaluator = response.jsonPath();
        ResponseBody body = response.getBody();
        String bodyAsString = body.asString();

        jsonPathEvaluator.prettyPrint();
//        System.out.println("name received from Response: " + customerNameEn1);
        System.out.println("Response Body is: " + body.asString());

        response
                .then().log().all()
                .assertThat()
                .statusCode(200);
    }
}
