package com.qualitymuseum.amazon.tests;

import com.qualitymuseum.amazon.pages.CartPage;
import com.qualitymuseum.amazon.pages.HomePage;
import com.qualitymuseum.amazon.pages.ProductPage;
import com.qualitymuseum.amazon.pages.SearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class CartPageTest {


    // Search "computer", add 1st product to cart and verify
    @Test
    public void testAddProduct() throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://amazon.com");

        HomePage homePage = new HomePage(driver);
        homePage.searchProduct();

        SearchPage searchPage = new SearchPage(driver);
        searchPage.clickFirstProduct();

        ProductPage productPage = new ProductPage(driver);
        productPage.addProductToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.assertProduct(driver);

        sleep(1000);
        driver.quit();

    }

    // Empty cart and verify there is no product left
    @Test
    public void testEmptyCart() throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://amazon.com");

        HomePage homePage = new HomePage(driver);
        homePage.searchProduct();

        SearchPage searchPage = new SearchPage(driver);
        searchPage.clickFirstProduct();

        ProductPage productPage = new ProductPage(driver);
        productPage.addProductToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.assertProduct(driver);

        driver.get("https://www.amazon.com/gp/cart/view.html?ref_=nav_cart");

        cartPage.emptyCart();

        sleep(1000);
        driver.quit();
    }

}
