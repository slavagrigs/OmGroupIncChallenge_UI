package com.omGroupInc.step_definitions;

import com.omGroupInc.pages.MovieApp;
import com.omGroupInc.utils.ConfigurationReader;
import com.omGroupInc.utils.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;


public class MovieApp_steps {

    MovieApp movieApp = new MovieApp();

    @Given("user is on a main page of the app")
    public void user_is_on_a_main_page_of_the_app() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        wait(2000);
        movieApp.clickAdvanceBtn();
        wait(2000);
        movieApp.proceedLink.click();

        String expectedTitle = "React App";
        String actualTitle = Driver.getDriver().getTitle();
        System.out.println(actualTitle);

        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @When("user clicks on a search box and user provides specific movie's name_title")
    public void user_clicks_on_a_search_box_and_user_provides_specific_movie_s_name_title() {
         movieApp.inputTextIntoSearchBox();
    }

    @When("user clicks to the search button")
    public void user_clicks_to_the_search_button() {
        movieApp.clickSearchBtn();
    }

    @Then("user should be able to see movie's title that he_she was searching for")
    public void user_should_be_able_to_see_movie_s_title_that_he_she_was_searching_for() {
        String actualURL = Driver.getDriver().getCurrentUrl();
        System.out.println(actualURL);
    }
}