package com.webaut.project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BoardDetails extends AbstractPage{

    @FindBy(css = ".open-add-list.js-open-add-list>span")
    private WebElement addListbutton;
}
