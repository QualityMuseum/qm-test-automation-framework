package com.qualitymuseum.duckduckgo.pages;

import com.qualitymuseum.framework.core.Asserts;
import com.qualitymuseum.framework.core.Commands;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {

    /***********Page Elements*************/
    @FindBy( id = "search_form_input_homepage")
    public WebElement textBox;

    @FindBy( id = "search_button_homepage")
    public WebElement searchButton;

    @FindBy( id = "r1-0")
    public WebElement firstResult;

    /***********Constructor*************/
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    /***********Methods*************/
    @Step("Enter text to search box")
    public void enterSearchText(String string){
        Commands.SendKeys(textBox, string);
    }

    @Step("Click on searchButton")
    public void clickSearch(){
        Commands.Click(searchButton);
    }

    @Step("Get first results and verify that Van Gogh is written in the results")
    public void assertFirstResult(String string){
        Asserts.AssertTrue(firstResult, string);
    }


}
