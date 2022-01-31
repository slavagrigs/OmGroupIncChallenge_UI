package com.omGroupInc.step_definitions;

import com.omGroupInc.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;

public class Hooks {

    @Before("@UI")         // must be from cucumber io not from Junit
    public void setup() {
        System.out.println("=======Starting Automation========");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After("@UI")         // must be from cucumber io not from Junit
    public void tearDown(Scenario scenario) {
        //this is a hook runs automatically after each test

        //method for screenshots for failed tests during the execution process
        if (scenario.isFailed()) {
            byte[] data = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(data, "image/png", scenario.getName());
        }
        Driver.closeDriver();
        System.out.println("========End of test execution process=======");
    }

    @Before("@API")
    public void setUp() {
        // Saving baseurl inside this variable for reusability
        baseURI = "http://18.119.130.103:8082";
        basePath = "/odos3-api";
    }

    @After("@API")
    public void tearDown() {
        reset();
    }
}
