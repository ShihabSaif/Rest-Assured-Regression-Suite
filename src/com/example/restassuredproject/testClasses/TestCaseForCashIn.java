package com.example.restassuredproject.testClasses;

import com.example.restassuredproject.features.CashIn;
import com.example.restassuredproject.features.NPSBCredit;
import com.example.restassuredproject.model.User;
import com.example.restassuredproject.utility.UTIL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

@Test(priority = 12,alwaysRun = true, enabled = true)
public class TestCaseForCashIn {
    public static User user = new User();
    public static CashIn cashin = new CashIn();
    UTIL util = new UTIL();
    Properties prop = util.readPropData();

    public TestCaseForCashIn() throws IOException {
    }

    public void TestCasesForCashIn() throws IOException {
        Response response = cashin.CashIn(user);
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
