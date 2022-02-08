package com.example.restassuredproject.testClasses;

import com.example.restassuredproject.features.CreateWallet;
import com.example.restassuredproject.model.User;
import com.example.restassuredproject.utility.UTIL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

@Test(priority = 4,alwaysRun = true, enabled = true)
public class TestClassForCreateWallet {
    public static User user = new User();
    public static CreateWallet createWallet=new CreateWallet();
    UTIL util = new UTIL();
    Properties prop = util.readPropData();
    String name_prop= prop.getProperty("name_prop");
    public static String token;

    public TestClassForCreateWallet() throws IOException {
    }

    public void testCreateWallet() throws IOException {
        Response response=createWallet.createWallet(user);
        JsonPath jsonPathEvaluator = response.jsonPath();
        ResponseBody body = response.getBody();
        String bodyAsString = body.asString();
        String name = jsonPathEvaluator.get("name");
        token = jsonPathEvaluator.get("token");
        jsonPathEvaluator.prettyPrint();
        System.out.println("name received from Response: " + name);
        System.out.println("Response Body is: " + body.asString());

        response
                .then().log().all()
                .assertThat()
                .statusCode(200);
        //.body(name,containsString("OTP"));
        Assert.assertEquals(name,name_prop);

    }
}
