package com.example.restassuredproject.BrowserOpen;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

import java.io.IOException;

public class BrowserOpening {
    public static WebDriver driver;
    public static BrowserOpening instance;


    private BrowserOpening() throws IOException {
        setUp();
    }

    public static BrowserOpening getInstance() throws Exception, ArrayIndexOutOfBoundsException, IndexOutOfBoundsException, IOException, InterruptedException {
        if (instance == null) {
            instance = new BrowserOpening();
        }
        return instance;
    }
    private void setUp() throws IOException {
/*        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriverManager.chromedriver().clearResolutionCache().setup();
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");  // Example for headless mode*/
        //options.addArguments("window-size=1200x600"); // Example to specify window size
        // driver = new FirefoxDriver();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver= new ChromeDriver(options);
        //windows
        System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
        //linux
        //System.setProperty("webdriver.chrome.driver","./chromedriver");
        //System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
        driver.manage().window().maximize();

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
