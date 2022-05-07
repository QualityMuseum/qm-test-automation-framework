package com.qualitymuseum.duckduckgo.tests;

import com.qualitymuseum.duckduckgo.core.BaseTest;
import com.qualitymuseum.duckduckgo.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void testSearchText() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage.enterSearchText("Van Gogh");
        homePage.clickSearch();
        homePage.assertFirstResult("Van Gogh");
    }
}
