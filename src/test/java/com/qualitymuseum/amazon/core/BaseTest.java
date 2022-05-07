package com.qualitymuseum.amazon.core;

import com.qualitymuseum.framework.core.CommonTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static java.lang.Thread.sleep;

public class BaseTest extends CommonTest {

    // @BeforeMethod
    // Runs before each method
    @BeforeMethod
    public void start(){
        getDriver().get("https://amazon.com");
    }

    // @AfterMethod
    // Runs after each method
    @AfterMethod
    public void end() throws InterruptedException {
    }
}
