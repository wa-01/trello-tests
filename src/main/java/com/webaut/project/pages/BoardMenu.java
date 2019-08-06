package com.webaut.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BoardMenu extends AbstractPage {
    @FindBy (css = ".js-open-more")
    WebElement moreOption;

    public BoardMoreMenu clickMore(){
        action.isElementPresent(By.cssSelector(".js-open-more"));
        action.click(moreOption);
        return new BoardMoreMenu();
    }

}
