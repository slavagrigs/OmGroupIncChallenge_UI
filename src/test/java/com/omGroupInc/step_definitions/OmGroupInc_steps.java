package com.omGroupInc.step_definitions;

import com.omGroupInc.pages.OmGroupPage;
import com.omGroupInc.utils.BrowserUtils;
import com.omGroupInc.utils.ConfigurationReader;
import com.omGroupInc.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class OmGroupInc_steps {
    OmGroupPage omGroupPage = new OmGroupPage();

    @Given("user is on a main page of the app_OmGroupInc")
    public void user_is_on_a_main_page_of_the_app_om_group_inc() {
        Driver.getDriver().get(ConfigurationReader.getProperty("urlOmGroupInc"));
        String actualTitle = Driver.getDriver().getTitle();
        System.out.println("Actual title is "+actualTitle);
        String expectedTitle = "OM GROUP INC";
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @When("user clicks on About Us button")
    public void user_clicks_on_about_us_button()  {

         omGroupPage.hoverToAboutAs();
         BrowserUtils.wait(3);
         omGroupPage.clickAboutOmGroupBtn();
         BrowserUtils.wait(3);
    }
    @Then("user should be able to redirect to the page with additional info")
    public void user_should_be_able_to_redirect_to_the_page_with_additional_info() {
        String actualURL = Driver.getDriver().getCurrentUrl();
        System.out.println("Actual url is "+actualURL);
        String expectedURL = "https://omgroupinc.us/aboutus.html";
        Assert.assertEquals(actualURL,expectedURL);
    }
    @Then("user should be able to perform CssValue verification for fontSize_color_fontWeight")
    public void user_should_be_able_to_perform_css_value_verification_for_font_size_color_font_weight() {
        omGroupPage.CssValueVerificationForAboutOmGroupHeader_fontSize();
        omGroupPage.CssValueVerificationForAboutOmGroupHeader_color();
        omGroupPage.CssValueVerificationForAboutOmGroupHeader_fontWeight();
    }
}