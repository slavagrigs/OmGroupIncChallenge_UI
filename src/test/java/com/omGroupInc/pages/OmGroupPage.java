package com.omGroupInc.pages;

import com.omGroupInc.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;

public class OmGroupPage extends BasePage {

    @FindBy(xpath = "(//*[text()='About Us'])[1]")
     WebElement aboutUsBtn;

    @FindBy(xpath = "(//*[text()='About OM GROUP'])[1]")
    WebElement aboutOMGROUP;


    public void clickAboutAs(){
        aboutUsBtn.click();
    }
    public void  clickAboutOmGroupBtn(){
        aboutOMGROUP.click();
    }

    public void hoverToAboutAs(){
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(aboutUsBtn).perform();
    }





}
