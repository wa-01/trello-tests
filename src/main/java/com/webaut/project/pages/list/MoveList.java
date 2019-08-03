package com.webaut.project.pages.list;

import com.webaut.project.pages.AbstractPage;
import org.openqa.selenium.By;

public class MoveList extends AbstractPage {
    private String selectorPosition = ".js-select-list-pos";

    private String moveButton = ".js-commit-position";

    public void selectPosition(String position){
        action.setValueNonVisibleElement(By.cssSelector(selectorPosition), position);
        action.click(By.cssSelector(moveButton));
    }

}
