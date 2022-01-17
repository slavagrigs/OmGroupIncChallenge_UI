package com.omGroupInc.pages;

import com.omGroupInc.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MovieApp {

    @FindBy(xpath = "//input[@type='text']")
    WebElement searchBox;

    @FindBy(xpath = "//img[@class='searchBarImage']")
    WebElement searchButton;

    @FindBy(xpath = "//button[@id='details-button']")
  public  WebElement advanceBtn;

    @FindBy(xpath = "//a[@id='proceed-link']")
   public WebElement proceedLink;

    public void clickAdvanceBtn(){
        advanceBtn.click();
    }

    public void inputTextIntoSearchBox(){
        searchBox.sendKeys("Ace Ventura: When Nature Calls");
    }

    public void clickSearchBtn(){
        searchButton.click();
    }



}