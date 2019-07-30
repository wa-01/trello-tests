package com.webaut.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Create extends AbstractPage {

    @FindBy(css = "button[data-test-id='header-create-board-button']")
    private WebElement linkCreateBoard;

    @FindBy(css = "button[data-test-id='header-create-team-button']")
    private WebElement linkCreateTeam;

    @FindBy(css = "button[data-test-id='header-create-business-team-button']")
    private WebElement linkCreateBusinessTeam;

    public void clickLinkCreateBoard() {
        action.click(linkCreateBoard);
    }
    public void clickLinkCreateTeam() {
        action.click(linkCreateTeam);
    }
    public void clickLinkCreateBusinessTeam() {
        action.click(linkCreateBusinessTeam);
    }

}
