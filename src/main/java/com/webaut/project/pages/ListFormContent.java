package com.webaut.project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListFormContent extends AbstractPage{
    @FindBy (css = ".list-header-name")
    private WebElement listTitle;

    public String getListTitle(){
        return action.getText(listTitle);
    }
}
