package com.example.restassuredproject.testClasses;

import com.example.restassuredproject.features.SignUpWallet;
import com.example.restassuredproject.model.User;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.annotations.Test;

import java.io.IOException;


@Test(priority = 1,alwaysRun = true, enabled = true)
public class TestClassForSignUp {

    public static User user = new User();
    public static SignUpWallet signUp=new SignUpWallet();
    public static String token;

    public void testSignUpPage() throws IOException {
        Response response=signUp.signUp(user);
        JsonPath jsonPathEvaluator = response.jsonPath();
        ResponseBody body = response.getBody();
        String bodyAsString = body.asString();
        token = jsonPathEvaluator.get("token");
        jsonPathEvaluator.prettyPrint();
        System.out.println("token received from Response: " + token);
        System.out.println("Response Body is: " + body.asString());

        response
                .then().log().all()
                .assertThat()
                .statusCode(200);
                //.body(name,containsString("OTP"));
        //Assert.assertEquals(name,"OTP send success");


    }

}
