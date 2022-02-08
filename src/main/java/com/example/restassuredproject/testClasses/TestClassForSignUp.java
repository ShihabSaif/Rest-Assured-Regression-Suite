package com.example.restassuredproject.testClasses;

import com.example.restassuredproject.features.SignUp;
import com.example.restassuredproject.model.User;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.*;
import org.springframework.stereotype.Service;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.hamcrest.Matchers.*;


@Test(priority = 0,alwaysRun = true, enabled = true)
public class TestClassForSignUp {

    public static User user = new User();
    public static SignUp signUp=new SignUp();

    public void testSignUpPage() throws IOException {
        Response response=signUp.signUp(user);
        JsonPath jsonPathEvaluator = response.jsonPath();
        ResponseBody body = response.getBody();
        String bodyAsString = body.asString();
        String name = jsonPathEvaluator.get("message");
        jsonPathEvaluator.prettyPrint();
        System.out.println("name received from Response: " + name);
        System.out.println("Response Body is: " + body.asString());

        response
                .then().log().all()
                .assertThat()
                .statusCode(200);
                //.body(name,containsString("OTP"));
        Assert.assertEquals(name,"OTP send success");


    }

}
