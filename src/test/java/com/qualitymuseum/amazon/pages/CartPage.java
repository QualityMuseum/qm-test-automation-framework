package com.qualitymuseum.amazon.pages;

import com.qualitymuseum.framework.core.Asserts;
import com.qualitymuseum.framework.core.Commands;
import com.qualitymuseum.framework.core.Conditions;
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
        Asserts.AssertTrue(Conditions.isDisplayed(productLink));
    }

    public void emptyCart() {
        Commands.Click(deleteButton);
    }
}
