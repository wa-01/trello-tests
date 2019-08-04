package com.webaut.project.core.ui;

import org.openqa.selenium.WebDriver;

abstract class AbstractDriver {
    //comment to test travis with dev branch
    abstract WebDriver initDriver();
}
