package com.example.restassuredproject.testClasses;

import com.example.restassuredproject.features.CashOut;
import com.example.restassuredproject.features.SendMoney;
import com.example.restassuredproject.model.User;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.annotations.Test;

import java.io.IOException;

@Test(priority = 11,alwaysRun = true, enabled = true)
public class TestCaseForCashOut {
    public static User user = new User();
    public static CashOut cash = new CashOut();
    public void testCashOut() throws IOException {
        Response response= cash.cashOut(user);
        JsonPath jsonPathEvaluator = response.jsonPath();
        ResponseBody body = response.getBody();
        String bodyAsString = body.asString();
        jsonPathEvaluator.prettyPrint();
        System.out.println("Response Body is: " + body.asString());

        response
                .then().log().all()
                .assertThat()
                .statusCode(200);
    }
}
