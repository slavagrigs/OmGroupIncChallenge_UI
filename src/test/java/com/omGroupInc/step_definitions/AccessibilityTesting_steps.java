package com.omGroupInc.step_definitions;

import com.deque.axe.AXE;
import com.omGroupInc.AccessibilityTesting.AccessibilityTesting;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;
import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class AccessibilityTesting_steps {

    WebDriver driver;
    private static final URL scriptUrl = AccessibilityTesting.class.getResource("/axe.min.js");

    @Given("User is on the www.omgroupinc.us page")
    public void user_is_on_the_www_omgroupinc_us_page() {
        System.out.println("User is on the https://omgroupinc.us/ page");
    }
    @Then("Using Axe core tool user should be able to run accessibility testing and get the report")
    public void using_axe_core_tool_user_should_be_able_to_run_accessibility_testing_and_get_the_report() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://omgroupinc.us/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        JSONObject responseJSON = new AXE.Builder(driver, scriptUrl)
                .analyze();

        JSONArray violations = responseJSON.getJSONArray("violations");

        if (violations.length() == 0) {
            assertTrue("No violations found", true);
        } else {
            AXE.writeResults("OmGroupAccessibilityTestReport", responseJSON);
            assertTrue(AXE.report(violations),false);

        }
        driver.quit();
    }
}
