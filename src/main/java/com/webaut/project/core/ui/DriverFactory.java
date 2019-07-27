package com.webaut.project.core.ui;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory {

    private static final Map<String, Supplier<AbstractDriver>> DRIVERS = new HashMap<>();
    static {
        DRIVERS.put("chrome", Chrome::new);
        DRIVERS.put("firefox", Firefox::new);
        DRIVERS.put("headless", ChromeHeadless::new);

    }

    public static WebDriver getDriver(String browser) {
        return DRIVERS.get(browser).get().initDriver();
    }
}
