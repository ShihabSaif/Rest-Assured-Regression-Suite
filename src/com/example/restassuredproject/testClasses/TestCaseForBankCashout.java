package com.example.restassuredproject.testClasses;

import com.example.restassuredproject.features.BankCashout;
import com.example.restassuredproject.features.NPSBCredit;
import com.example.restassuredproject.model.User;
import com.example.restassuredproject.utility.UTIL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class TestCaseForBankCashout {
    public static User user = new User();
    public static BankCashout bankCashout = new BankCashout();
    UTIL util = new UTIL();
    Properties prop = util.readPropData();

    public TestCaseForBankCashout() throws IOException {
    }

    @DataProvider(name = "bankCashoutData")
    public Object[][] getBankCashoutData() throws IOException {
        UTIL util = new UTIL();
        Properties prop = util.readPropData();
        return new Object[][] {
                { prop.getProperty("routing_no_prop_1"), prop.getProperty("account_no_prop_1"), prop.getProperty("bankCode_prop_1"), prop.getProperty("instantTransfer_prop_1"), prop.getProperty("amount_bank_cashout_prop_1")},
                { prop.getProperty("routing_no_prop_2"), prop.getProperty("account_no_prop_2"), prop.getProperty("bankCode_prop_2"), prop.getProperty("instantTransfer_prop_2"), prop.getProperty("amount_bank_cashout_prop_2")},
                { prop.getProperty("routing_no_prop_3"), prop.getProperty("account_no_prop_3"), prop.getProperty("bankCode_prop_3"), prop.getProperty("instantTransfer_prop_3"), prop.getProperty("amount_bank_cashout_prop_3") },
                { prop.getProperty("routing_no_prop_3"), prop.getProperty("account_no_prop_3"), prop.getProperty("bankCode_prop_3"), prop.getProperty("instantTransfer_prop_4"), prop.getProperty("amount_bank_cashout_prop_4")}
        };
    }

    @Test(priority = 19,alwaysRun = true, enabled = true, dataProvider = "bankCashoutData")
    public void TestCaseForBankCashout(String routing_no, String account_no, String bankCode, String instantTransfer, String amount) throws IOException {
        Response response = bankCashout.bankCashout(user, routing_no, account_no, bankCode, instantTransfer, amount);
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
