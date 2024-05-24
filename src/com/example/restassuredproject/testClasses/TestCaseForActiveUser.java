package com.example.restassuredproject.testClasses;

import com.example.restassuredproject.features.ActiveUser;
import com.example.restassuredproject.features.AttachBank;
import com.example.restassuredproject.utility.UTIL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

@Test(priority = 8,alwaysRun = true, enabled = true)
public class TestCaseForActiveUser {

    public static ActiveUser activeUser = new ActiveUser();
    UTIL util = new UTIL();
    Properties prop = util.readPropData();

    public TestCaseForActiveUser() throws IOException {
    }

    public void testActiveUser() throws IOException {
        Response response=activeUser.activeuser();
        JsonPath jsonPathEvaluator = response.jsonPath();
        ResponseBody body = response.getBody();
        String bodyAsString = body.asString();
        jsonPathEvaluator.prettyPrint();
        System.out.println("Response Body is: " + body.asString());

        response
                .then().log().all()
                .assertThat()
                .statusCode(200);
        //.body(name,containsString("OTP"));
        //Assert.assertEquals(name,ec_eng_name_prop);
    }
}
