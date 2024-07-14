package com.example.restassuredproject.testClasses;

import com.example.restassuredproject.features.AddBank;
import com.example.restassuredproject.features.BankCashout;
import com.example.restassuredproject.model.User;
import com.example.restassuredproject.utility.UTIL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

@Test(priority = 18,alwaysRun = true, enabled = true)
public class TestCaseForAddbank {
    public static User user = new User();
    public static AddBank addBank = new AddBank();
    UTIL util = new UTIL();
    Properties prop = util.readPropData();

    public TestCaseForAddbank() throws IOException {
    }

    public void TestCaseForAddbank() throws IOException {
        Response response = addBank.addBank(user);
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
