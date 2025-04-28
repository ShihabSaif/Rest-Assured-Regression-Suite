package com.example.restassuredproject.testClasses;

import com.example.restassuredproject.features.nagadCashOut;
import com.example.restassuredproject.model.User;
import com.example.restassuredproject.utility.UTIL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class TestCaseForNagadCashOut {
    public static User user = new User();
    public static nagadCashOut cashout = new nagadCashOut();

    @DataProvider(name = "cashoutData")
    public Object[][] getCashoutData() throws IOException {
        UTIL util = new UTIL();
        Properties prop = util.readPropData();
        return new Object[][] {
                { prop.getProperty("financialInstitute_prop1"), prop.getProperty("toAc_prop1") },
                { prop.getProperty("financialInstitute_prop2"), prop.getProperty("toAc_prop2") }
        };
    }

    @Test(priority = 15,alwaysRun = true, enabled = true, dataProvider = "cashoutData")
    public void testCashOut(String financialInstitute, String toAc) throws IOException {
        Response response= cashout.nagadcashOut(user, financialInstitute, toAc);
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
