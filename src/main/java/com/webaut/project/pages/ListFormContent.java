package com.webaut.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListFormContent extends AbstractPage{

    @FindBy (css = "textarea:focus")
    private WebElement listHeaderEditable;

    private String listTitleLabel = ".list-header-name-assist";
    public static final String LIST_HEADER = "//h2[contains(text(),'%s')]/preceding-sibling::div";

    public String getListTitle(){
        return action.getTextFromHiddenElement(By.cssSelector(listTitleLabel));
    }
    public void clickEditListButton(String listTitle){
        action.click(By.xpath((String.format(LIST_HEADER, listTitle))));
    }

    public void setListTitle(String newTitle){
        action.setValue(listHeaderEditable, newTitle);
        action.setValue(listHeaderEditable, Keys.ENTER);
    }

}
