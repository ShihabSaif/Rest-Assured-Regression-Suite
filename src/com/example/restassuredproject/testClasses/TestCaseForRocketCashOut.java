package com.example.restassuredproject.testClasses;

import com.example.restassuredproject.features.RocketCashOut;
import com.example.restassuredproject.features.nagadCashOut;
import com.example.restassuredproject.model.User;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.annotations.Test;

import java.io.IOException;

@Test(priority = 38,alwaysRun = true, enabled = true)
public class TestCaseForRocketCashOut {
    public static User user = new User();
    public static RocketCashOut cashout = new RocketCashOut();
    public void testCashOut() throws IOException {
        Response response= cashout.rocketCashOut(user);
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
