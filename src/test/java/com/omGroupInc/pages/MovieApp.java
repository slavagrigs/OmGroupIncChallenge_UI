package com.omGroupInc.pages;

import com.omGroupInc.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MovieApp extends BasePage {

    @FindBy(xpath = "//input[@type='text']")
    WebElement searchBox;

    @FindBy(xpath = "//img[@class='searchBarImage']")
    WebElement searchButton;
//============================================================
    @FindBy(xpath="//p[@class='movieTitle']")
    WebElement AceVenturaHeaderAfterSearch;

//======================================================================
    public void inputTextIntoSearchBox(){
        searchBox.sendKeys("Ace Ventura: When Nature Calls");
    }

    public void clickSearchBtn(){
        searchButton.click();
    }

    public String getTextOfAceVenturaHeaderAfterSearch(){
       return AceVenturaHeaderAfterSearch.getText();
    }
}