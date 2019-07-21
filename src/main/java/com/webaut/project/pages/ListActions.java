package com.webaut.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public class ListActions extends AbstractPage{

/*    @FindBy(css = ".js-close-list")
    private WebElement archiveThisListOption;*/
    private Map<String, By> actions;
    private String archiveThisListAction = ".js-close-list";
    private String moveListAction = ".js-move-list";

    public ListActions(){
        actions = new HashMap<>();
        actions.put("Archive This List", By.cssSelector(archiveThisListAction));
        actions.put("Move List", By.cssSelector(moveListAction));
    }
    public void selectArchiveThisList(){
        action.click(By.cssSelector(archiveThisListAction));
    }

    public void selectAction(String listAction){
        action.click(actions.get(listAction));
    }
}
