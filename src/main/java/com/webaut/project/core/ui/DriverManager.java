package com.webaut.project.core.ui;

import com.webaut.project.core.Environment;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    private static DriverManager ourInstance = new DriverManager();

    public static DriverManager getInstance() {
        return ourInstance;
    }

    private WebDriver driver;


    private DriverManager() {
        String browser = Environment.getInstance().getValue("$['browser']");
        driver = DriverFactory.getDriver(browser);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
