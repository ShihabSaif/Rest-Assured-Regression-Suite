package com.example.restassuredproject.testClasses;

import com.example.restassuredproject.features.AttachBank;
import com.example.restassuredproject.features.PinSet;
import com.example.restassuredproject.utility.UTIL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

@Test(priority = 7,alwaysRun = true, enabled = true)
public class TestCaseForPinSet {
    public static PinSet pinset = new PinSet();
    UTIL util = new UTIL();
    Properties prop = util.readPropData();

    public TestCaseForPinSet() throws IOException {
    }

    public void testPinSet() throws IOException {
        Response response=pinset.pinSet();
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
