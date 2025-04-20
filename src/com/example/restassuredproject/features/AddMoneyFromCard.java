package com.example.restassuredproject.features;

import com.example.restassuredproject.BrowserOpen.BasePage;
import com.example.restassuredproject.utility.Path;
import com.example.restassuredproject.utility.UTIL;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

public class AddMoneyFromCard extends BasePage {
    public AddMoneyFromCard() throws Exception, IOException, InterruptedException {
        PageFactory.initElements(driver, this);
    }


    UTIL util=new UTIL();
    Properties prop = util.readPropData();
    String url1= prop.getProperty("URL");
    String cardName2= prop.getProperty("cardName");
    String cardNo= prop.getProperty("cardNo");
    String cardExpMonth= prop.getProperty("cardExpMonth");
    String cardExpYear= prop.getProperty("cardExpYear");
    String securityCodeInput= prop.getProperty("securityCode");

    JavascriptExecutor js = (JavascriptExecutor) driver;


    @FindBy(xpath = Path.xpathForCardNAme)
    public WebElement cardName;

    @FindBy(id = "number")
    public  WebElement cardName3;


    @Test(priority = 14)
    public void testLaunchBrowser() throws InterruptedException, IOException, URISyntaxException {

        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to(url1);
        //driver.navigate().to(UTIL.readConfigData()[1]);
        Thread.sleep(20000);
    }

    @Test(priority =15 )
    public void testCardName() throws InterruptedException, IOException, URISyntaxException {



        Thread.sleep(40000);
        Thread.sleep(10000);
        driver.switchTo().frame("#name-on-card-exactly-shown-on-card");
        Thread.sleep(2000);
        WebElement nameHolderOfCard = (WebElement) js.executeScript("return document.getElementById('nameOnCard');");
        System.out.println("card name" +nameHolderOfCard);
        Thread.sleep(5000);
        if (nameHolderOfCard != null ) {
            nameHolderOfCard.sendKeys(cardName2);
            Thread.sleep(1000);
        } else {
            System.out.println("Name input Element not found.");
        }
    }
    @Test(priority =16 )
    public void testCarNo() throws InterruptedException, IOException, URISyntaxException {
        // here start card number part
        driver.switchTo().defaultContent();

        Thread.sleep(1000);
        driver.switchTo().frame("#card-number");
        Thread.sleep(2000);
        String hiddenCardNo = "return document.getElementById('number');";
        WebElement hiddenCardNo2 = (WebElement) js.executeScript(hiddenCardNo);
        System.out.println("card no" +hiddenCardNo2);

        if (hiddenCardNo2 != null) {
            hiddenCardNo2.sendKeys(cardNo);
            Thread.sleep(1000);
        } else {
            System.out.println("card number input Element not found.");
        }
    }
    @Test(priority =17 )
    public void testCardExpMonth() throws InterruptedException, IOException, URISyntaxException {
        // here start expiry month part
        driver.switchTo().defaultContent();

        Thread.sleep(1000);
        driver.switchTo().frame("#expiry-month");
        Thread.sleep(2000);
        String hiddenExpiryMonth = "return document.getElementById('expiryMonth');";
        WebElement hiddenExpiryMonth2 = (WebElement) js.executeScript(hiddenExpiryMonth);
        System.out.println("Expiry Month" +hiddenExpiryMonth2);

        if (hiddenExpiryMonth2 != null) {
            hiddenExpiryMonth2.sendKeys(cardExpMonth);
            Thread.sleep(1000);

        } else {
            System.out.println("expiry month input Element not found.");
        }
    }
    @Test(priority =18 )
    public void testCardExpYear() throws InterruptedException, IOException, URISyntaxException {

        // here start expiry year part
        driver.switchTo().defaultContent();

        Thread.sleep(1000);
        driver.switchTo().frame("#expiry-year");
        Thread.sleep(2000);
        String hiddenExpiryYear = "return document.getElementById('expiryYear');";
        WebElement hiddenExpiryYear2 = (WebElement) js.executeScript(hiddenExpiryYear);
        System.out.println("Expiry year" +hiddenExpiryYear2);
        if (hiddenExpiryYear2 != null) {
            hiddenExpiryYear2.sendKeys(cardExpYear);
            Thread.sleep(1000);

        } else {
            System.out.println("Expiry year input Element not found.");
        }

    }

    @Test(priority = 19 )
    public void testCardSecurity() throws InterruptedException, IOException, URISyntaxException {
        driver.switchTo().defaultContent();

        Thread.sleep(1000);
        driver.switchTo().frame("#security-code");
        Thread.sleep(2000);
        String security = "return document.getElementById('securityCode');";
        WebElement securityCode = (WebElement) js.executeScript(security);
        System.out.println("security code is:" +securityCode);

        if (securityCode != null) {
            //System.out.println("Security code will insert soon");
            securityCode.sendKeys(securityCodeInput);
            //System.out.println("Security code inserted");
            Thread.sleep(1000);

        } else {
            System.out.println("Security code input Element not found.");
        }

    }
    @Test(priority = 20 )
    public void testConfirmButton() throws InterruptedException, IOException, URISyntaxException {
        driver.switchTo().defaultContent();
        Thread.sleep(2000);
        String confirmButton = "return document.getElementById('pay-button');";
        WebElement confirmButton2 = (WebElement) js.executeScript(confirmButton);
        System.out.println("confirm button" +confirmButton2);

        if (confirmButton2 != null) {
            // Click the button
            confirmButton2.click();
        } else {
            System.out.println("Button with ID 'spay-button' not found.");
        }

    }
}
