package com.example.restassuredproject.testClasses;

import com.example.restassuredproject.features.Recharge;
import com.example.restassuredproject.features.SendMoney;
import com.example.restassuredproject.model.User;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.annotations.Test;

import java.io.IOException;

@Test(priority = 10,alwaysRun = true, enabled = true)
public class TestCaseForSendMoney {
    public static User user = new User();
    public static SendMoney send = new SendMoney();
    public void testSendMoney() throws IOException {
        Response response= send.sendMoney(user);
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
