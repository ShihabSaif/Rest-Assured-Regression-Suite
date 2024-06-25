package com.example.restassuredproject.testClasses;

import com.example.restassuredproject.features.FoLogin;
import com.example.restassuredproject.features.Login;
import com.example.restassuredproject.model.User;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.annotations.Test;

import java.io.IOException;

@Test(priority = 11,alwaysRun = true, enabled = true)
public class TestCaseForFoLogin {
    public static User user = new User();
    public static FoLogin fologin = new FoLogin();
    public static String fo_token;

    public void testFoLogin() throws IOException {
        Response response= fologin.fologin(user);
        JsonPath jsonPathEvaluator = response.jsonPath();
        ResponseBody body = response.getBody();
        String bodyAsString = body.asString();
        fo_token = jsonPathEvaluator.get("token");
        jsonPathEvaluator.prettyPrint();
        System.out.println("Response Body is: " + body.asString());
        System.out.println("FO Login token is: " + fo_token);

        response
                .then().log().all()
                .assertThat()
                .statusCode(200);
    }
}
