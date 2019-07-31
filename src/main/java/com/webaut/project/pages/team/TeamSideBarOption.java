package com.webaut.project.pages.team;

import com.webaut.project.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TeamSideBarOption extends AbstractPage {

    @FindBy(xpath = "//span[text() = 'Settings']")
    private WebElement teamSettings;

    @FindBy(xpath = "//span[text() = 'Cards']")
    private WebElement teamCards;

    @FindBy(css = ".u-inline")
    private WebElement teamNameAsTitle;

    @FindBy(css = ".quiet-button")
    private WebElement deleteTeamLink;

    public void clickSettings(){
        wait.until(ExpectedConditions.visibilityOf(teamCards));
        action.click(teamSettings);
    }

    public void clickDeleteLink(){
        wait.until(ExpectedConditions.visibilityOf(teamNameAsTitle));
        action.click(deleteTeamLink);
    }
}
