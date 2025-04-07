package com.example.restassuredproject.features;

import com.example.restassuredproject.BrowserOpen.BasePage;
import com.example.restassuredproject.utility.Path;
import com.example.restassuredproject.utility.UTIL;
import io.restassured.response.Response;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

public class NagadCreditCollection extends BasePage {
    public NagadCreditCollection() throws Exception, IOException, InterruptedException {
        PageFactory.initElements(driver, this);
    }

    public String otpValue;
    UTIL util=new UTIL();
    Properties prop = util.readPropData();
    String url2= prop.getProperty("CCUrl");
    String amountNagadCC = prop.getProperty("CCNagadAmount");
    String url1= prop.getProperty("URLNagad");
    String accNo = prop.getProperty("NagadAcc");
    String nagadPin = prop.getProperty("NagadPIN");
    String number;

    public String successMsg;

    @FindBy(xpath = Path.xPathForPorishodButton)
    public WebElement porishodButton;

    @FindBy(id = "id_amount")
    public  WebElement amount;

    @FindBy(xpath = Path.xPathForClickNagadButton)
    public WebElement clickNagadButton;

    @FindBy(id = "next_button")
    public  WebElement bakiNextButton;

    @FindBy(xpath = Path.xPathForNagadAcc1)
    public  WebElement accNo1;

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

    @FindBy(xpath = Path.xPathCCNagadError)
    public WebElement ccNagadError;

    @Test(priority = 27)
    public void testLaunchBrowser() throws InterruptedException, IOException, URISyntaxException {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to(url2);
        Thread.sleep(2000);
    }

    @Test(priority = 28)
    public void pressPorishodButton() throws InterruptedException, IOException, URISyntaxException {

        Thread.sleep(4000);
        porishodButton.click();
        Thread.sleep(2000);

    }

    @Test(priority = 29)
    public void enterBakiAmount() throws InterruptedException, IOException, URISyntaxException {

        Thread.sleep(2000);
        amount.sendKeys(amountNagadCC);
        Thread.sleep(2000);
    }

    @Test(priority = 30)
    public void pressEnter() throws InterruptedException, IOException, URISyntaxException {

        Thread.sleep(4000);
        bakiNextButton.click();
        Thread.sleep(2000);

    }

    @Test(priority = 31)
    public void clickNagadButton() throws InterruptedException, IOException, URISyntaxException {

        Thread.sleep(3000);
        clickNagadButton.click();
        Thread.sleep(2000);

    }

    @Test(priority = 32)
    public void giveNagadAccNo() throws InterruptedException, IOException, URISyntaxException {

        Thread.sleep(8000);
        accNo1.sendKeys(accNo);
        Thread.sleep(2000);

    }

    @Test(priority = 33)
    public Response clickForwardButton() throws InterruptedException, IOException, URISyntaxException {

        Thread.sleep(2000);
        forwardButton.click();
        Thread.sleep(2000);
        return null;
    }

//    @Test(priority =34)
//    public void giveOTP() throws InterruptedException, IOException, URISyntaxException {
//
//        Thread.sleep(2000);
//        Thread.sleep(20000);
//        System.out.println("give otp");
//        Thread.sleep(15000);
//        otp2.sendKeys(TestExecutionController.retrivedOTP);
//        Thread.sleep(5000);
//    }

    @Test(priority =35)
    public void clickOTPConfirmButton() throws InterruptedException, IOException, URISyntaxException {
        Thread.sleep(55000);
        forwardButton.click();
        Thread.sleep(2000);

    }
    @Test(priority =36)
    public void givePinConfirm() throws InterruptedException, IOException, URISyntaxException {

        Thread.sleep(10000);
        inputPin.sendKeys(nagadPin);
        Thread.sleep(6000);
        confirmButton.click();

    }
//
//    @Test(priority =33 )
//    public void successPage() throws InterruptedException, IOException, URISyntaxException {
//
//        Thread.sleep(10000);
//        successMsg=ccNagadError.getAttribute("value");
//        Thread.sleep(6000);
//        confirmButton.click();
//
//    }
}
