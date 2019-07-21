package com.webaut.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListFormContent extends AbstractPage{

    @FindBy (css = ".mod-list-add-button")
    private WebElement addListButton;

    @FindBy (css = "textarea:focus")
    private WebElement listHeaderEditable;

    private String listActionsButton = "//h2[text()='%s']/following-sibling::div";

    private String listTitleLabel = ".list-header-name-assist";

    private String LIST_ITEM= "//h2[text()='%s']/ancestor::div[@class='js-list list-wrapper']";

    public static final String LIST_HEADER = "//h2[contains(text(),'%s')]/preceding-sibling::div[@class='js-list list-wrapper']";

    public static final String LIST_PRECEDING = "/preceding-sibling::div[@class='js-list list-wrapper']/descendant::h2[text()='%s']";

    public String getListTitle(){
        return action.getAttribute(By.cssSelector(listTitleLabel), "innerText");
    }
    public void clickEditListButton(String listTitle){
        action.click(By.xpath((String.format(LIST_HEADER, listTitle))));
    }

    public void setListTitle(String newTitle){
        action.setValue(listHeaderEditable, newTitle);
        action.click(addListButton);
    }

    public ListActions clickListActionsButton(String listTitle){
        action.click(By.xpath(String.format(listActionsButton, listTitle)));
        return new ListActions();
    }

    public void moveList(String listSource, String listTarget){
        action.moveElement(By.xpath(String.format(LIST_ITEM, listSource)), By.xpath(String.format(LIST_ITEM, listTarget)));
    }

    public boolean isListAfter(String precedingList, String followingList){
        return action.isElementVisible(By.xpath(String.format(LIST_ITEM + LIST_PRECEDING, followingList, precedingList)));
    }

}
