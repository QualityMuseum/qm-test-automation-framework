package com.qualitymuseum.amazon.pages;

import com.qualitymuseum.framework.core.Asserts;
import com.qualitymuseum.framework.core.Commands;
import io.qameta.allure.Step;
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
    @Step("Click addtoCartButton and call assertAddedToCartText methoıg")
    public void addProductToCart() throws InterruptedException {
        Commands.Click(addtoCartButton);
        assertAddedToCartText();
    }

    @Step("Assert Added to Cart text")
    public void assertAddedToCartText() throws InterruptedException {
        sleep(3000);
        Asserts.AssertTrue(addedToCartText, "Added to Cart");
    }
}
