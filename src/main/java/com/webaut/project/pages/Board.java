package com.webaut.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Board extends AbstractPage {

    private String listTile = ".list-header-name-assist";

    @FindBy(css = ".open-add-list")
    private WebElement addListButton;

    public ListForm clickAddListButton() {
        action.click(addListButton);
        return new ListForm();
    }

    public boolean isListElementVisible(){
        return action.isElementVisible(By.cssSelector(listTile));
    }

}
