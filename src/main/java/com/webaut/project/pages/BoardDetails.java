package com.webaut.project.pages;

import com.webaut.project.pages.list.ListForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BoardDetails extends AbstractPage{

    @FindBy(css = ".open-add-list")
    private WebElement addListButton;

    private String LIST_TITLE = "//h2[text()='%s']/parent::div";

    public ListForm clickAddListButton() {
        action.click(addListButton);
        return new ListForm();
    }

    public boolean isListVisible(String listName) {
        return action.isElementVisible(By.xpath(String.format(LIST_TITLE,listName)));
    }
}
