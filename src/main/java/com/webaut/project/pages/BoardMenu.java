package com.webaut.project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BoardMenu extends AbstractPage {
    @FindBy (css = ".js-open-more")
    WebElement moreOption;

    public BoardMoreMenu clickMore(){
        action.click(moreOption);
        return new BoardMoreMenu();
    }

}
