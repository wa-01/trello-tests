package com.webaut.project.pages.team;

import com.webaut.project.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeamSideBarOption extends AbstractPage {

    @FindBy(xpath = "//span[text() = 'Settings']")
    private WebElement teamSettings;

    public void clickSettings(){
        action.click(teamSettings);
    }

    @FindBy(css = ".quiet-button")
    private WebElement deleteTeamLink;

    public void clickDeleteLink(){
        action.click(deleteTeamLink);
    }
}
