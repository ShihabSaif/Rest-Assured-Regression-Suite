package com.example.restassuredproject.testClasses;

import com.example.restassuredproject.features.AttachBank;
import com.example.restassuredproject.utility.UTIL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

@Test(priority = 7,alwaysRun = true, enabled = true)
public class TestAttachBank {
    public static AttachBank attachBank = new AttachBank();
    UTIL util = new UTIL();
    Properties prop = util.readPropData();

    public TestAttachBank() throws IOException {
    }

    public void testAttachBank() throws IOException {
        Response response=attachBank.attachBank();
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
