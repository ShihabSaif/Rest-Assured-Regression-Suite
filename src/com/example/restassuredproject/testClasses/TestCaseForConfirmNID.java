package com.example.restassuredproject.testClasses;

import com.example.restassuredproject.DTO.ConfirmNIDInfoParams;
import com.example.restassuredproject.features.ConfirmNID;
import com.example.restassuredproject.features.NIDBackUpload;
import com.example.restassuredproject.utility.UTIL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

@Test(priority = 5,alwaysRun = true, enabled = true)
public class TestCaseForConfirmNID {
    public static NIDBackUpload nidBackUpload=new NIDBackUpload();
    public static ConfirmNID confirmNID = new ConfirmNID();
    UTIL util = new UTIL();
    Properties prop = util.readPropData();
    String ec_eng_name_prop= prop.getProperty("ec_eng_name_prop");

    public TestCaseForConfirmNID() throws IOException {
    }

    public void testConfirmNID() throws IOException {
        Response response=confirmNID.confirmNIDResponse();
        JsonPath jsonPathEvaluator = response.jsonPath();
        ResponseBody body = response.getBody();
        String bodyAsString = body.asString();
        String name = jsonPathEvaluator.get("customerNameEn");
        jsonPathEvaluator.prettyPrint();
        System.out.println("name received from Response: " + name);
        System.out.println("Response Body is: " + body.asString());

        response
                .then().log().all()
                .assertThat()
                .statusCode(200);
        //.body(name,containsString("OTP"));
        //Assert.assertEquals(name,ec_eng_name_prop);
    }
}
