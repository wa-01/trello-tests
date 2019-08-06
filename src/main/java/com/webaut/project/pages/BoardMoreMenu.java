package com.webaut.project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BoardMoreMenu extends AbstractPage{
    @FindBy (css = ".js-open-archive")
    WebElement archivedItemsOption;

    public BoardArchiveMenu clickArchivedItems(){
        action.click(archivedItemsOption);
        return new BoardArchiveMenu();
    }
}
