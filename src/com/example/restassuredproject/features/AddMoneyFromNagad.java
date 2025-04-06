package com.example.restassuredproject.features;

import com.example.restassuredproject.BrowserOpen.BasePage;
import com.example.restassuredproject.utility.Path;
import com.example.restassuredproject.utility.UTIL;
import io.restassured.response.Response;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

public class AddMoneyFromNagad extends BasePage {

    public AddMoneyFromNagad() throws Exception, IOException, InterruptedException {
        PageFactory.initElements(driver, this);
    }


    public String otpValue;
    UTIL util=new UTIL();
    Properties prop = util.readPropData();
    String url1= prop.getProperty("URLNagad");
    String[] accNo = new String[]{prop.getProperty("NagadAcc")};
    String[] nagadPin = new String[]{prop.getProperty("NagadPIN")};
    String number;



    @FindBy(xpath = Path.xPathForNagadAcc1)
    public WebElement accNo1;

    @FindBy(xpath = Path.xPathForNagadForwardButton)
    public  WebElement forwardButton;

    @FindBy(id = "otp")
    public  WebElement otp2;

    @FindBy(xpath = Path.xPathForErrorMessage)
    public WebElement errorMessage;

    @FindBy(xpath = Path.xPathForPin)
    public WebElement inputPin;

    @FindBy(id = "confirmButton")
    public  WebElement confirmButton;



    @Test
    public void testLaunchBrowser() throws InterruptedException, IOException, URISyntaxException {
        driver.navigate().to(url1);
        Thread.sleep(2000);
    }

    @Test
    public void giveNagadAccNo() throws InterruptedException, IOException, URISyntaxException {

        Thread.sleep(8000);
        accNo1.sendKeys(accNo[0]);
        Thread.sleep(2000);

    }

    @Test
    public Response clickForwardButton() throws InterruptedException, IOException, URISyntaxException {

        Thread.sleep(2000);
        forwardButton.click();
        Thread.sleep(10000);
        return null;
    }
//
//    @Test(priority =9 )
//    public void giveOTP() throws InterruptedException, IOException, URISyntaxException {
//
//        Thread.sleep(30000);
//        System.out.println("give otp");
//        Thread.sleep(15000);
//        otp2.sendKeys("123456");
//        Thread.sleep(5000);
//
//    }
//
//    @Test(priority =10 )
//    public void clickOTPConfirmButton() throws InterruptedException, IOException, URISyntaxException {
//
//        Thread.sleep(2000);
//        forwardButton.click();
//        Thread.sleep(2000);
//
//    }
//    @Test(priority =11 )
//    public void givePinConfirm() throws InterruptedException, IOException, URISyntaxException {
//
//        Thread.sleep(10000);
//        inputPin.sendKeys(nagadPin[0]);
//        Thread.sleep(6000);
//        confirmButton.click();
//
//    }
}
