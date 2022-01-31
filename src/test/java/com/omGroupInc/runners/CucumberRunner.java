package com.omGroupInc.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        plugin = {
                "rerun:target/rerun.txt",                  //creates path to failed tests (in target folder - rerun.txt), automatically generate list of failed test scenarios and provides point where we should search error/typo/mistakes
                // if no test failed => rerun.txt will be blank

                "html:target/cucumber-report.html",       //generates html report on a local machine (with step by step explanations)
                "json:target/cucumber.json"              //generates report (in json format), but because it does not look clear and understandable, we should convert it to the pretty CUCUMBER HTML report with diagram
        },

        features = "src/test/resources/features",          //path from content Root for features file
        glue = "com/omGroupInc/step_definitions",                 //path from source  Root for stepDefinitions
        tags = "@UI",                                      // for specific tag (from feature files)

        publish = true,                                        //for online cucumber report
        dryRun = false                                     //true - verification process without implementation actual code/ false=>code execution
)

public class CucumberRunner {

}
