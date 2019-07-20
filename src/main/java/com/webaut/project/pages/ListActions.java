package com.webaut.project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListActions extends AbstractPage{

    @FindBy(css = ".js-close-list")
    private WebElement archiveThisListOption;

    public void selectArchiveThisList(){
        action.click(archiveThisListOption);
    }
}
