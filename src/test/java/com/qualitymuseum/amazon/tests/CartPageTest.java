package com.qualitymuseum.amazon.tests;

import com.qualitymuseum.amazon.pages.CartPage;
import com.qualitymuseum.amazon.pages.HomePage;
import com.qualitymuseum.amazon.pages.ProductPage;
import com.qualitymuseum.amazon.pages.SearchPage;
import com.qualitymuseum.amazon.core.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

@Epic("Regression Test")
@Feature("Add product from search")
public class CartPageTest extends BaseTest {

    @Test (priority = 0, description = "Search product and add first result to the cart")
    @Description("Search product and add first result to the cart")
    @Severity(SeverityLevel.CRITICAL)
    @Story("SP4568 - Add product from search results")
    public void testAddProduct() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage.searchProduct();

        SearchPage searchPage = new SearchPage(getDriver());
        searchPage.clickFirstProduct();

        ProductPage productPage = new ProductPage(getDriver());
        productPage.addProductToCart();

        CartPage cartPage = new CartPage(getDriver());
        cartPage.assertProduct(getDriver());
    }

    @Test (priority = 0, description = "Delete product from Cart after adding ")
    @Description("Search product, add first result to the cart and delete")
    @Severity(SeverityLevel.BLOCKER)
    @Story("SP4567 - Delete product from search results")
    public void testEmptyCart() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage.searchProduct();

        SearchPage searchPage = new SearchPage(getDriver());
        searchPage.clickFirstProduct();

        ProductPage productPage = new ProductPage(getDriver());
        productPage.addProductToCart();

        CartPage cartPage = new CartPage(getDriver());
        cartPage.assertProduct(getDriver());

        getDriver().get("https://www.amazon.com/gp/cart/view.html?ref_=nav_cart");

        cartPage.emptyCart();
    }

}
