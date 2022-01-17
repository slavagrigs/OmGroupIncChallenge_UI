package com.omGroupInc.step_definitions;

import com.omGroupInc.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Hooks {

    //Hooks class contains setup and tear down methods

    @Before // must be from cucumber io not from Junit (Similar with BeforeMethod in TestNG)
    public void setup(){
        System.out.println("=======Starting Automation========");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @After  // must be from cucumber io not from Junit (Similar with AfterMethod in TestNG)
    public void tearDown(Scenario scenario){
        //this is a hook runs automatically after each test


        //method for screenshots for failed tests during the execution process
        if (scenario.isFailed()){
            byte[] data = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(data,"image/png", scenario.getName());
        }


        Driver.closeDriver();

        System.out.println("========End of test execution process=======");
    }
}
