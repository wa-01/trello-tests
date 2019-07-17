package com.webaut.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Home extends AbstractPage {
    //Auxiliar class to go to a hardcoded empty project
    @FindBy (css = "div[data-test-id=\"header-container\"]")
    private WebElement header;
    public Home() {
    wait.until(ExpectedConditions.visibilityOf(header));
    driver.get("https://trello.com/b/4XjH8TJX/empty");
}
}
