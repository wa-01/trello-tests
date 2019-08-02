package com.webaut.project.hooks;

import com.webaut.project.core.ui.DriverManager;
import cucumber.api.java.Before;

public class Hooks {
    @Before
    public void setUp() {
        //DriverManager.getInstance().getDriver().get("https://trello.com/login");
    }
}
