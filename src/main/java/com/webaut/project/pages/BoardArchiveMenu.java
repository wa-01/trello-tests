package com.webaut.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BoardArchiveMenu extends AbstractPage{
    @FindBy (css = ".js-search")
    private WebElement searchTextField;

    @FindBy (css = ".js-switch-section")
    private WebElement switchToListButton;

    private String XPATH_SEARCH_RESULT_ITEM = "//span[text()='%s']";

    public void setTextSearch(String textSearch){
        action.setValue(searchTextField, textSearch);
    }

    public void clickSwitchToLists(){
        action.click(switchToListButton);
    }

    public boolean isElementInResults(String elementName){
        action.isElementPresent(By.xpath(String.format(XPATH_SEARCH_RESULT_ITEM, elementName)));
        return action.isElementVisible(By.xpath(String.format(XPATH_SEARCH_RESULT_ITEM, elementName)));
    }
}
