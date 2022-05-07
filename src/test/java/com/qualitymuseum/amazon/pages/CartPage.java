package com.qualitymuseum.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage {

    /***********Page Elements*************/
    @FindBy( css = ".a-truncate-cut")
    public WebElement productLink;

    @FindBy( css = "[value=Delete]")
    public WebElement deleteButton;

    /***********Constructor***************/
    public CartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    /***********Methods*******************/
    public void assertProduct(WebDriver driver) {
        driver.get("https://www.amazon.com/gp/cart/view.html?ref_=nav_cart");
        Assert.assertTrue(productLink.isDisplayed());
    }

    public void emptyCart() {
        deleteButton.click();
    }
}
