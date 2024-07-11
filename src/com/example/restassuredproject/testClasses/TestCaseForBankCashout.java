package com.example.restassuredproject.testClasses;

import com.example.restassuredproject.features.BankCashout;
import com.example.restassuredproject.features.NPSBCredit;
import com.example.restassuredproject.model.User;
import com.example.restassuredproject.utility.UTIL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import java.io.IOException;
import java.util.Properties;

public class TestCaseForBankCashout {
    public static User user = new User();
    public static BankCashout bankCashout = new BankCashout();
    UTIL util = new UTIL();
    Properties prop = util.readPropData();

    public TestCaseForBankCashout() throws IOException {
    }

    public void TestCaseForBankCashout() throws IOException {
        Response response = bankCashout.bankCashout(user);
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
