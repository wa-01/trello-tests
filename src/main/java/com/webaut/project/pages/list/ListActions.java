package com.webaut.project.pages.list;

import com.webaut.project.pages.AbstractPage;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

public class ListActions extends AbstractPage {

    private Map<String, By> actions;
    private String archiveThisListAction = ".js-close-list";
    private String moveListAction = ".js-move-list";

    public ListActions(){
        actions = new HashMap<>();
        actions.put("Archive This List", By.cssSelector(archiveThisListAction));
        actions.put("Move List", By.cssSelector(moveListAction));
    }

    public void selectAction(String listAction) throws InterruptedException {
        action.isElementPresent(actions.get(listAction));
        Thread.sleep(600);
        action.click(actions.get(listAction));
    }
}
