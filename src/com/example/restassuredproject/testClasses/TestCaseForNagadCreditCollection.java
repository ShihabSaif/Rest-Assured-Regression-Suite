package com.example.restassuredproject.testClasses;

import com.example.restassuredproject.features.AddMoneyFromNagad;
import com.example.restassuredproject.features.NagadCreditCollection;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;

public class TestCaseForNagadCreditCollection {
    NagadCreditCollection nagadcc = new NagadCreditCollection();
    AddMoneyFromNagad nagadAddMoney =new AddMoneyFromNagad();
    Date time = new Date(System.currentTimeMillis());


    public TestCaseForNagadCreditCollection() throws Exception {
    }

    @Test(priority = 27)
    public void testLauchBrowserCcNagad() throws IOException, InterruptedException, URISyntaxException {

        nagadcc.testLaunchBrowser();
    }

    @Test(priority = 28)
    public void testCCFromNagadPressPorishodButton() throws IOException, InterruptedException, URISyntaxException {
        nagadcc.pressPorishodButton();
    }

    @Test(priority = 29)
    public void testCCFromNagadBakiAmount() throws IOException, InterruptedException, URISyntaxException {
        nagadcc.enterBakiAmount();
    }

    @Test(priority = 30)
    public void testCCFromNagadpressEnter() throws IOException, InterruptedException, URISyntaxException {
        nagadcc.pressEnter();
    }

    @Test(priority = 31)
    public void testCCFromNagadclickNagadButton() throws IOException, InterruptedException, URISyntaxException {

        nagadcc.clickNagadButton();
    }

    @Test(priority = 32)
    public void testCCFromNagadCardNameField() throws IOException, InterruptedException, URISyntaxException {
        nagadcc.giveNagadAccNo();
    }

    @Test(priority = 33)
    public void testCCFromNagadForwardButton() throws IOException, InterruptedException, URISyntaxException {
        nagadcc.clickForwardButton();
    }
//
//    @Test(priority = 34)
//    public void testCCFromNagadOTP() throws IOException, InterruptedException, URISyntaxException {
//        addMoneyFromNagadJS.giveOTP();
//    }
//
    @Test(priority = 35)
    public void testCCFromNagadOTPConfirmButton() throws IOException, InterruptedException, URISyntaxException {
        nagadAddMoney.clickOTPConfirmButton();
    }
    @Test(priority = 36)
    public void testCCFromNagadPINConfirmButton() throws IOException, InterruptedException, URISyntaxException {
        nagadAddMoney.givePinConfirm();
    }
//    @AfterMethod
//    public void afterMethod(ITestResult result) {
//        System.out.println("Executed method name:" + result.getMethod().getMethodName());
//    }
}
