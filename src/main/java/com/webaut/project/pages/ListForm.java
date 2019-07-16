package com.webaut.project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListForm extends AbstractPage{

    @FindBy(css = "list-name-input")
    private WebElement listNameTextField;

    @FindBy(css = "mod-list-add-button")
    private WebElement addListButton;

    private void setListTitle(String title){

    }

    public void addList(){
        action.click((addListButton));
    }
}
