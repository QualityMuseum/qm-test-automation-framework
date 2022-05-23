package com.qualitymuseum.amazon.pages;

import com.qualitymuseum.framework.core.Commands;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    /***********Page Elements*************/
    @FindBy( id = "twotabsearchtextbox")
    public WebElement searchTextBox;

    @FindBy( id = "nav-search-submit-button")
    public WebElement searchSubmitButton;


     /***********Constructor***************/
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    /***********Methods*******************/
    @Step("Type Computer to searchTextBox and click searchSubmitButton")
    public void searchProduct() {
        Commands.SendKeys(searchTextBox, "Computer");
        Commands.Click(searchSubmitButton);
    }
}
