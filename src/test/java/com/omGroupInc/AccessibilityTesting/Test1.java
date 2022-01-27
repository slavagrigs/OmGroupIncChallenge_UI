package com.omGroupInc.AccessibilityTesting;

import com.deque.axe.AXE;
import com.omGroupInc.utils.ConfigurationReader;
import com.omGroupInc.utils.Driver;
import io.cucumber.java.After;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;

public class Test1 {

    WebDriver driver;
    private static final URL scriptUrl = Test1.class.getResource("/axe.min.js");

    @Test
    public void testAccessibility() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://omgroupinc.us/");

        JSONObject responseJSON = new AXE.Builder(driver, scriptUrl)
                .analyze();

        JSONArray violations = responseJSON.getJSONArray("violations");

        if (violations.length() == 0) {
            Assertions.assertTrue(true,"No violations found");
        } else {
            AXE.writeResults("OmGroupAccessibilityTestReport", responseJSON);
            Assertions.assertTrue(false, AXE.report(violations));
        }
    }

    @Test
    public void testAccessibilityWithSkipFrames() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://omgroupinc.us/");

        JSONObject responseJSON = new AXE.Builder(driver, scriptUrl)
                .skipFrames()
                .analyze();

        JSONArray violations = responseJSON.getJSONArray("violations");

        if (violations.length() == 0) {
            Assert.assertTrue("No violations found", true);
        } else {
            AXE.writeResults("OmGroupAccessibilityTestReport", responseJSON);
            Assert.assertTrue(AXE.report(violations), false);
        }
    }


    /**@Test
    public void testAccessibilityWithWebElement() {

        Driver.getDriver().get(ConfigurationReader.getProperty("urlOmGroupInc"));
        JSONObject responseJSON = new AXE.Builder(driver, scriptUrl)
               .analyze(driver.findElement(By.xpath("//*[text()='About Us'])[1]");

        JSONArray violations = responseJSON.getJSONArray("violations");

        if (violations.length() == 0) {
            Assert.assertTrue("No violations found", true);
        } else {
            AXE.writeResults("OmGroupAccessibilityTestReport", responseJSON);
            Assert.assertTrue(AXE.report(violations), false);
        }
    } */

    @After
    public void tearDown(){
        driver.quit();
    }
}
