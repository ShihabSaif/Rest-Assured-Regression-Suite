package com.example.restassuredproject.testClasses;

import com.example.restassuredproject.features.GetOTPForSignUP;
import com.example.restassuredproject.model.User;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

@Test(priority = 1,alwaysRun = true, enabled = true)
public class TestCaseForGetOTPForSignUp {
    public static User user = new User();
    GetOTPForSignUP getOTPForSignUP=new GetOTPForSignUP();
    public static String otpCode;

    public void getOTPForSignUpTest() throws IOException {
        Response response=getOTPForSignUP.getOTPResult(user);
        JsonPath jsonPathEvaluator = response.jsonPath();
        ResponseBody body = response.getBody();
        otpCode =  body.asString();
        //jsonPathEvaluator.prettyPrint();
        System.out.println("name received from Response: " + otpCode);
        System.out.println("Response Body is: " + body.asString());

        response
                .then().log().all()
                .assertThat()
                .statusCode(200);
        //.body(name,containsString("OTP"));

    }
}
