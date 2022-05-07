package com.qualitymuseum.framework.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static java.lang.Thread.sleep;

public class CommonTest {

    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    // @BeforeMethod
    // Runs before each method
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver());
    }

    public WebDriver getDriver(){
        return driver.get();
    }

    // @AfterMethod
    // Runs after each method
    @AfterMethod
    public void tearDown() throws InterruptedException {
        getDriver().quit();
    }
}
