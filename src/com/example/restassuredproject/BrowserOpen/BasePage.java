package com.example.restassuredproject.BrowserOpen;

import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class BasePage {
    public WebDriver driver = BrowserOpening.getInstance().driver;
    public BasePage() throws Exception, IOException, InterruptedException {
    }
}
