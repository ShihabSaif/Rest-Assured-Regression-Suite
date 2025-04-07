package com.example.restassuredproject.testClasses;

import com.example.restassuredproject.features.AddMoneyFromNagad;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;

public class TestCaseForAddMoneyNagad {
    AddMoneyFromNagad addMoneyFromNagad;
    Date time = new Date(System.currentTimeMillis());

    @BeforeTest
    public void init() throws Exception {
        addMoneyFromNagad = new AddMoneyFromNagad();
    }
    @Test(priority = 21)
    public void testNagadAddMoneyLauchBrowser() throws IOException, InterruptedException, URISyntaxException {
        addMoneyFromNagad.testLaunchBrowser();
    }

    @Test(priority = 22)
    public void testNagadAddMoneyNameField() throws IOException, InterruptedException, URISyntaxException {
        addMoneyFromNagad.giveNagadAccNo();
    }

   @Test(priority = 23)
   public void testNagadAddMoneyForwardButton() throws IOException, InterruptedException, URISyntaxException {
       addMoneyFromNagad.clickForwardButton();
   }

//    @Test(priority = 24)
//    public void testNagadAddMoneyOTP() throws IOException, InterruptedException, URISyntaxException {
//        addMoneyFromNagad.giveOTP();
//    }

    @Test(priority = 25)
    public void testNagadAddMoneyOTPConfirmButton() throws IOException, InterruptedException, URISyntaxException {
        addMoneyFromNagad.clickOTPConfirmButton();
    }
    @Test(priority = 26)
    public void testNagadAddMoneyPINConfirmButton() throws IOException, InterruptedException, URISyntaxException {
        try{
            if((addMoneyFromNagad.confirmButton.isDisplayed())){
                Assert.assertTrue(true);
            }
            else
                Assert.fail();
        }catch (Exception e){
            Assert.fail();
        }
        addMoneyFromNagad.givePinConfirm();

    }
//    @AfterMethod
//    public void afterMethod(ITestResult result) {
//        System.out.println("Executed method name:" + result.getMethod().getMethodName());
//    }
}
