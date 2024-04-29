package com.example.restassuredproject.testClasses;

import com.example.restassuredproject.features.WalletLookup;
import com.example.restassuredproject.utility.UTIL;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

@Test(priority = 0, alwaysRun = true, enabled = true)
public class TestClassForLookUpWallet {

        UTIL util = new UTIL();
        Properties prop = util.readPropData();
        String name_prop = prop.getProperty("name_prop");
        public static String message;
        public static int code;

        public TestClassForLookUpWallet() throws IOException {
        }

        public void testCreateWallet() throws IOException, InterruptedException {
            Response response = WalletLookup.walletLookUp().post();
            long responseTime = response.time();
            System.out.println("time taken: " + responseTime);
            JsonPath jsonPathEvaluator = response.jsonPath();
            ResponseBody body = response.getBody();
            String bodyAsString = body.asString();
            message = jsonPathEvaluator.get("message");
            code = jsonPathEvaluator.get("code");
            jsonPathEvaluator.prettyPrint();
            System.out.println("message received from Response: " + message);
            System.out.println("Response Body is: " + body.asString());

            response
                    .then().log().all()
                    .assertThat()
                    .statusCode(400);
            //.body(name,containsString("OTP"));
            Assert.assertEquals(message, "User profile not found");
            Assert.assertEquals(code, 4004);

        }
    }

