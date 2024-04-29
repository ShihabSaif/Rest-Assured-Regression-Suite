package com.example.restassuredproject.testClasses;

import com.example.restassuredproject.features.NIDFrontUpload;
import com.example.restassuredproject.model.User;
import com.example.restassuredproject.utility.UTIL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

@Test(priority = 3,alwaysRun = true, enabled = true)
public class TestCaseForNIDFrontUpload {

    public static User user = new User();
    public static NIDFrontUpload nidFrontUpload=new NIDFrontUpload();
    UTIL util = new UTIL();
    Properties prop = util.readPropData();
    String ec_eng_name_prop= prop.getProperty("ec_eng_name_prop");
    public static String customerNameEn1;
    public static String customerNameBn1;
    public static String nidNo1;
    public static String gender1;
    public static String addressPermanent1;
    public static String addressPresent1;
    public static String birthday1;
    public static String fatherName1;
    public static String motherName1;
    public static String spouseName1;
    public static String occupation1;
    public static String bloodGroup1;
    public static String monthlyIncome1;



    public TestCaseForNIDFrontUpload() throws IOException {
    }

    public void testNIDFrontUplodad() throws IOException, InterruptedException {
        Response response=nidFrontUpload.nidFrontUpload(user);
        JsonPath jsonPathEvaluator = response.jsonPath();
        ResponseBody body = response.getBody();
        String bodyAsString = body.asString();
        customerNameEn1 = jsonPathEvaluator.get("customerNameEn");
        customerNameBn1 = jsonPathEvaluator.get("customerNameBn");
        nidNo1 = jsonPathEvaluator.get("nidNo");
        gender1 = jsonPathEvaluator.get("gender");
        addressPermanent1 = jsonPathEvaluator.get("addressPermanent");
        addressPresent1 = jsonPathEvaluator.get("addressPresent");
        birthday1 = jsonPathEvaluator.get("birthday");
        fatherName1 = jsonPathEvaluator.get("fatherName");
        motherName1 = jsonPathEvaluator.get("motherName");
        spouseName1 = jsonPathEvaluator.get("spouseName");
        occupation1 = jsonPathEvaluator.get("occupation");
        bloodGroup1 = jsonPathEvaluator.get("bloodGroup");
        monthlyIncome1 = jsonPathEvaluator.get("monthlyIncome");

        jsonPathEvaluator.prettyPrint();
        System.out.println("name received from Response: " + customerNameEn1);
        System.out.println("Response Body is: " + body.asString());

        response
                .then().log().all()
                .assertThat()
                .statusCode(200);
        //.body(name,containsString("OTP"));
        Assert.assertEquals(customerNameEn1,ec_eng_name_prop);
    }
}
