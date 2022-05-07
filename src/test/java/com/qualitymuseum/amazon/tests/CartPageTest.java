package com.qualitymuseum.amazon.tests;

import com.qualitymuseum.amazon.pages.CartPage;
import com.qualitymuseum.amazon.pages.HomePage;
import com.qualitymuseum.amazon.pages.ProductPage;
import com.qualitymuseum.amazon.pages.SearchPage;
import com.qualitymuseum.amazon.core.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class CartPageTest extends BaseTest {

    // Search "computer", add 1st product to cart and verify
    @Test
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

    // Empty cart and verify there is no product left
    @Test
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
