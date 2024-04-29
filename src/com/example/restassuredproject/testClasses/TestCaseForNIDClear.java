package com.example.restassuredproject.testClasses;

import com.example.restassuredproject.features.NIDClear;
import com.example.restassuredproject.model.User;
import com.example.restassuredproject.utility.UTIL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

@Test(priority = 2,alwaysRun = true, enabled = true)
public class TestCaseForNIDClear {
    public static User user = new User();
    public static NIDClear nidClear=new NIDClear();

    //Read from properties
    UTIL util = new UTIL();
    Properties prop = util.readPropData();
    String nid_no_prop= prop.getProperty("nid_no_prop");

    public TestCaseForNIDClear() throws IOException {
    }

    public void testNIDClear() throws IOException {
        Response response=nidClear.nidClear(user);
        JsonPath jsonPathEvaluator = response.jsonPath();
        ResponseBody body = response.getBody();
        String bodyAsString = body.asString();
        String message = jsonPathEvaluator.get("message");
        jsonPathEvaluator.prettyPrint();
        System.out.println("name received from Response: " + message);
        System.out.println("Response Body is: " + body.asString());
        System.out.println("nid no" +nid_no_prop);

        response
                .then().log().all()
                .assertThat()
                .statusCode(200);
        //.body(name,containsString("OTP"));
        Assert.assertEquals(message,"NID number: "+nid_no_prop+" reset success");
    }
}
