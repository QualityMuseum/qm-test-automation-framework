package com.qualitymuseum.duckduckgo.tests;

import com.qualitymuseum.duckduckgo.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;


public class HomePageTest {

    @Test
    public void testSearchText() throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://duckduckgo.com");
        String title = driver.getTitle();
        System.out.println(title);

        HomePage homePage = new HomePage(driver);
        homePage.enterSearchText("Van Gogh");
        homePage.clickSearch();
        homePage.assertFirstResult("Van Gogh");

        sleep(1000);
        driver.quit();
    }
}
