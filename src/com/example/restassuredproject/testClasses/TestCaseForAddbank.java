package com.example.restassuredproject.testClasses;

import com.example.restassuredproject.features.AddBank;
import com.example.restassuredproject.features.BankCashout;
import com.example.restassuredproject.model.User;
import com.example.restassuredproject.utility.UTIL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class TestCaseForAddbank {
    public static User user = new User();
    public static AddBank addBank = new AddBank();
    UTIL util = new UTIL();
    Properties prop = util.readPropData();

    public TestCaseForAddbank() throws IOException {
    }

    @DataProvider(name = "addBankData")
    public Object[][] getAddBankData() throws IOException {
        UTIL util = new UTIL();
        Properties prop = util.readPropData();
        return new Object[][] {
                { prop.getProperty("account_name_prop_1"), prop.getProperty("account_no_prop_1"), prop.getProperty("bank_name_prop_1"), prop.getProperty("routing_no_prop_1") },
                { prop.getProperty("account_name_prop_2"), prop.getProperty("account_no_prop_2"), prop.getProperty("bank_name_prop_2"), prop.getProperty("routing_no_prop_2") },
                { prop.getProperty("account_name_prop_3"), prop.getProperty("account_no_prop_3"), prop.getProperty("bank_name_prop_3"), prop.getProperty("routing_no_prop_3") },
        };
    }

    @Test(priority = 18,alwaysRun = true, enabled = true, dataProvider = "addBankData")
    public void TestCaseForAddbank(String accountName, String accountNumber, String bankName, String routingNumber) throws IOException {
        Response response = addBank.addBank(user, accountName, accountNumber, bankName, routingNumber);
        JsonPath jsonPathEvaluator = response.jsonPath();
        ResponseBody body = response.getBody();
        String bodyAsString = body.asString();

        jsonPathEvaluator.prettyPrint();
//        System.out.println("name received from Response: " + customerNameEn1);
        System.out.println("Response Body is: " + body.asString());

        response
                .then().log().all()
                .assertThat()
                .statusCode(200);
    }
}
