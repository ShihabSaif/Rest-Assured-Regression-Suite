package com.example.restassuredproject.testClasses;

import com.example.restassuredproject.features.SendMoney;
import com.example.restassuredproject.features.TmPurchase;
import com.example.restassuredproject.model.User;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.example.restassuredproject.testClasses.TestCaseForSendMoney.send;

@Test(priority = 37)
public class TestCaseForTmPurchase
{
    public static User user = new User();
    public static TmPurchase tm = new TmPurchase();
    public void testTmPurchase() throws IOException {
        Response response= tm.tmPurchase(user);
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
