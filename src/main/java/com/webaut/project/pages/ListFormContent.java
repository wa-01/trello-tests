package com.webaut.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListFormContent extends AbstractPage{
    @FindBy (css = ".list-header-name-assist")
    private WebElement listTitleLabel;

    @FindBy (css = "textarea:focus")
    private WebElement listHeaderEditable;

    public static final String LIST_HEADER = "//h2[contains(text(),'%s')]/preceding-sibling::div";
    //public static final String TEXT_AREA = "textarea:focus";

    public String getListTitle(){
        return action.getText(listTitleLabel);
    }
    public void clickEditListButton(String listTitle){
        action.click(By.xpath((String.format(LIST_HEADER, listTitle))));
    }

    public void setListTitle(String newTitle){
        action.setValue(listHeaderEditable, newTitle);//By.xpath(String.format(TEXT_AREA, oldTitle)), newTitle);
        action.setValue(listHeaderEditable, Keys.ENTER);
    }

}
