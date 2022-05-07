package com.qualitymuseum.amazon.pages;

import com.qualitymuseum.framework.core.Commands;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    /***********Page Elements*************/
    @FindBy( css = ".a-link-normal.s-underline-text.s-underline-link-text.s-link-style.a-text-normal")
    public WebElement productLink;

    /***********Constructor***************/
    public SearchPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    /***********Methods*******************/
    public void clickFirstProduct() {
        Commands.Click(productLink);
    }
}
