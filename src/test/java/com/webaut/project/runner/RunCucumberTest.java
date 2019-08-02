package com.webaut.project.runner;

import com.webaut.project.core.ui.DriverManager;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * Class which runs all features.
 */
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.webaut.project"},
        plugin = {"pretty"}
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {

    /**
     * this method execute before the tests.
     */
    @BeforeTest
    public void open() {
        // Implement.
    }

    /**
     * this method close the browser after the features finish.
     */
    @AfterTest
    public void close() {
        // Implement.
        DriverManager.getInstance().getDriver().quit();
    }
}