package com.example.restassuredproject.testClasses;

import com.example.restassuredproject.features.AttachBank;
import com.example.restassuredproject.features.Login;
import com.example.restassuredproject.features.SignUpWallet;
import com.example.restassuredproject.model.User;
import com.example.restassuredproject.utility.UTIL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

@Test(priority = 10,alwaysRun = true, enabled = true)
public class TestCaseForLogin {

    public static User user = new User();
    public static Login login = new Login();
    public static String token;

    public TestCaseForLogin() throws IOException {
    }

    public void testLogin() throws IOException {
        Response response= login.login(user);
        JsonPath jsonPathEvaluator = response.jsonPath();
        ResponseBody body = response.getBody();
        String bodyAsString = body.asString();
        token = jsonPathEvaluator.get("token");
        jsonPathEvaluator.prettyPrint();
        System.out.println("Response Body is: " + body.asString());
        System.out.println("Login token is: " + token);

        response
                .then().log().all()
                .assertThat()
                .statusCode(200);
    }
}
