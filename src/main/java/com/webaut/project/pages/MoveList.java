package com.webaut.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MoveList extends AbstractPage {
    private String selectorPosition = ".js-select-list-pos";

    private String moveButton = ".js-commit-position";

    public void selectPosition(String position){
        action.setValue(By.cssSelector(selectorPosition), position);
        action.click(By.cssSelector(moveButton));
    }

}
