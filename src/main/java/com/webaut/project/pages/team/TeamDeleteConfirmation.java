package com.webaut.project.pages.team;

import com.webaut.project.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeamDeleteConfirmation extends AbstractPage {
    @FindBy(css = "input[class = 'js-confirm full negate']")
    private WebElement deleteTeamForever;

    public void clickDeleteForever(){
        action.click(deleteTeamForever);
    }
}
