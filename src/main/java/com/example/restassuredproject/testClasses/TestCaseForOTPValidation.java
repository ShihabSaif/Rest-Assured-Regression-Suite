package com.example.restassuredproject.testClasses;

import com.example.restassuredproject.features.OTPValidationForSignUP;
import com.example.restassuredproject.features.SignUp;
import com.example.restassuredproject.model.User;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(priority = 3,alwaysRun = true, enabled = true)
public class TestCaseForOTPValidation {
    public static User user = new User();
    public static OTPValidationForSignUP otpValidationForSignUP=new OTPValidationForSignUP();

    public void testOTPValidation(){
        Response response=otpValidationForSignUP.otpValidation(user);
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
        Assert.assertEquals(name,"OTP verification success");
    }


}
