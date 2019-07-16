package com.webaut.project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Board extends AbstractPage {
    @FindBy(css = ".open-add-list")
    private WebElement addListButton;

    public ListForm clickCreateProjectButton() {
        action.click(addListButton);
        return new ListForm();
    }

}
