package com.example.restassuredproject.testClasses;

import com.example.restassuredproject.features.NIDFrontUpload;
import com.example.restassuredproject.features.SelfieUpload;
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
public class TestCasesForSelfieUpload {
    public static User user = new User();
    public static SelfieUpload selfieUpload = new SelfieUpload();
    UTIL util = new UTIL();
    Properties prop = util.readPropData();

    String ec_eng_name_prop= prop.getProperty("ec_eng_name_prop");

    public static String requestId;
    public static String nid_no;

    public TestCasesForSelfieUpload() throws IOException {
    }

    public void TestCasesForSelfieUpload() throws IOException {
        Response response=selfieUpload.selfieUpload(user);
        JsonPath jsonPathEvaluator = response.jsonPath();
        ResponseBody body = response.getBody();
        String bodyAsString = body.asString();
//        requestId = jsonPathEvaluator.get("customerNameEn");
//        nid_no = jsonPathEvaluator.get("customerNameBn");

        jsonPathEvaluator.prettyPrint();
//        System.out.println("name received from Response: " + customerNameEn1);
        System.out.println("Response Body is: " + body.asString());

        response
                .then().log().all()
                .assertThat()
                .statusCode(200);
        //.body(name,containsString("OTP"));
//        Assert.assertEquals(customerNameEn1,ec_eng_name_prop);
    }
}
