package com.qualitymuseum.duckduckgo.pages;

import com.qualitymuseum.framework.core.Asserts;
import com.qualitymuseum.framework.core.Commands;
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
    //Write Van Gogh in textbox
    public void enterSearchText(String string){
        Commands.SendKeys(textBox, string);
    }

    //Click on searchButton
    public void clickSearch(){
        Commands.Click(searchButton);
    }

    //Get first results and verify that Van Gogh is written in the results
    public void assertFirstResult(String string){
        Asserts.AssertTrue(firstResult, string);
    }


}
