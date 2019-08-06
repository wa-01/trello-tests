package com.webaut.project.pages.list;

import com.webaut.project.pages.AbstractPage;
import org.openqa.selenium.By;

public class MoveList extends AbstractPage {
    private String selectorPosition = ".js-select-list-pos";

    private String moveButton = ".js-commit-position";

    private String currentPositionOption = ".js-select-list-pos>option[selected='selected']";

    private String XPATH_POSITION_DIV = "//select[@class='js-select-list-pos']/parent::div";

    private String positionLabel = ".js-pos-value";

    public void selectPosition(String position){
        action.setValueNonVisibleElement(By.cssSelector(selectorPosition), position);
        action.click(By.cssSelector(moveButton));
    }

    public String getPositionDisplayed(){
        action.isElementPresent(By.cssSelector(positionLabel));
        return action.getAttributeFromNonVisible(By.cssSelector(positionLabel), "innerText");
    }

    public void clickPosition(){
        action.click(By.xpath(XPATH_POSITION_DIV));
    }

    public String getCurrentPosition(){
        return action.getText(By.cssSelector(currentPositionOption));
    }
}
