package com.webaut.project.pages.list;

import com.webaut.project.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListCreateForm extends AbstractPage {

    @FindBy(css = ".list-name-input")
    private WebElement listNameTextField;

    @FindBy(css = ".mod-list-add-button")
    private WebElement addListButton;

    @FindBy(css = ".js-cancel-edit")
    private WebElement cancelEditListButton;

    public void addList(String listTitle){
        action.setValue(listNameTextField, listTitle);
        action.click((addListButton));
    }

    public void clickCancelButton(){
        action.click(cancelEditListButton);
    }
}
