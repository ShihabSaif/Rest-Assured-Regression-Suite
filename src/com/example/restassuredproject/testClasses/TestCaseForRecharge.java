package com.example.restassuredproject.testClasses;

import com.example.restassuredproject.features.Login;
import com.example.restassuredproject.features.Recharge;
import com.example.restassuredproject.model.User;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.annotations.Test;

import java.io.IOException;

@Test(priority = 9,alwaysRun = true, enabled = true)
public class TestCaseForRecharge {
    public static User user = new User();
    public static Recharge topup = new Recharge();
    public void testRecharge() throws IOException {
        Response response= topup.recharge(user);
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
