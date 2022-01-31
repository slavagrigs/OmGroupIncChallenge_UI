package com.omGroupInc.AccessibilityTesting;

import com.deque.axe.AXE;
import com.omGroupInc.pages.OmGroupPage;
import io.cucumber.java.After;
import org.junit.jupiter.api.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;
import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class AccessibilityTesting {

OmGroupPage omGroupPage = new OmGroupPage();

    WebDriver driver;
    private static final URL scriptUrl = AccessibilityTesting.class.getResource("/axe.min.js");

    @Test
    public void testAccessibility() {
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

    @Test
    public void testAccessibilityWithSkipFrames() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.uscis.gov/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        JSONObject responseJSON = new AXE.Builder(driver, scriptUrl)
                .skipFrames()
                .analyze();

        JSONArray violations = responseJSON.getJSONArray("violations");

        if (violations.length() == 0) {
            assertTrue("No violations found", true);
        } else {
            AXE.writeResults("OmGroupAccessibilityTestReport", responseJSON);
            assertTrue(AXE.report(violations), false);
        }
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}