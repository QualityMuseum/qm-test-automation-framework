package com.qualitymuseum.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static java.lang.Thread.sleep;

public class ProductPage {

    /***********Page Elements*************/
    @FindBy( id = "add-to-cart-button")
    public WebElement addtoCartButton;

    @FindBy( css = ".a-size-medium-plus.a-color-base.sw-atc-text.a-text-bold")
    public WebElement addedToCartText;

    /***********Constructor***************/
    public ProductPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    /***********Methods*******************/
    public void addProductToCart() throws InterruptedException {
        addtoCartButton.click();
        assertAddedToCartText();
    }

    public void assertAddedToCartText() throws InterruptedException {
        sleep(3000);
        String string = addedToCartText.getText();
        Assert.assertTrue(string.contains("Added to Cart"));
    }
}
