package com.webaut.project.pages.team;

import com.webaut.project.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TeamDeleteConfirmation extends AbstractPage {
    @FindBy(css = "input[class = 'js-confirm full negate']")
    private WebElement deleteTeamForever;

    @FindBy(css = ".pop-over-header-title")
    private WebElement deleteTeamTitleHeader;


    public void clickDeleteForever(){
        wait.until(ExpectedConditions.visibilityOf(deleteTeamTitleHeader));
        action.click(deleteTeamForever);
    }
}
