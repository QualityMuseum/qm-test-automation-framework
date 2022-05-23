package com.qualitymuseum.duckduckgo.tests;

import com.qualitymuseum.duckduckgo.core.BaseTest;
import com.qualitymuseum.duckduckgo.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

@Feature("Check search results")
@Epic("Regression Test")
public class HomePageTest extends BaseTest {

    @Test (priority = 0, description = "Search Van Gogh and assert first result")
    @Description("Search Van Gogh and assert first result")
    @Severity(SeverityLevel.CRITICAL)
    @Story("SP4568 - Check Search Result")
    public void testSearchText() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage.enterSearchText("Van Gogh");
        homePage.clickSearch();
        homePage.assertFirstResult("van Gogh");
    }

    @Test (priority = 0, description = "Search Van Gogh and assert first result")
    @Description("Search Van Gogh and assert first result")
    @Severity(SeverityLevel.CRITICAL)
    @Story("SP4568 - Check Search Result")
    public void testSearchTextFail() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage.enterSearchText("Van Gogh");
        homePage.clickSearch();
        homePage.assertFirstResult("Van Gogh");
    }


}
