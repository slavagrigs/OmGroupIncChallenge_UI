package com.omGroupInc.pages;

import com.google.gson.internal.bind.util.ISO8601Utils;
import com.omGroupInc.utils.BrowserUtils;
import com.omGroupInc.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
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

    @FindBy(xpath ="//*[text()='About OM Group']")   //located this element to perform testing for CssValue
     WebElement aboutOmGroupHeader;

    public void CssValueVerificationForAboutOmGroupHeader_fontSize(){
        String actual_fontSize = aboutOmGroupHeader.getCssValue("font-size");
        System.out.println("Actual font-size is " + actual_fontSize);
        String expected_fontSize = "28px";
        Assert.assertEquals(actual_fontSize,expected_fontSize);
    }

    public void CssValueVerificationForAboutOmGroupHeader_color(){
    String colorOfAboutOmGroupHeader = aboutOmGroupHeader.getCssValue("color");
    String expectedColor = "#ff9966";
    String ActualColor = Color.fromString(colorOfAboutOmGroupHeader).asHex();

    System.out.println("Actual color - " + ActualColor);
    Assert.assertEquals(ActualColor, expectedColor);
}

    public void CssValueVerificationForAboutOmGroupHeader_fontWeight() {
        String actualFontWeight = aboutOmGroupHeader.getCssValue("font-weight");
        System.out.println("Actual font-weight - " + actualFontWeight);
        System.out.println("==================================================================");
        String expectedFontWeight = "600";

        Assert.assertEquals(actualFontWeight, expectedFontWeight);
    }



}
