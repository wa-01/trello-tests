package com.webaut.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Home extends AbstractPage {

    //TEAMS Section of Side bar
    //-------------------------------------------------------------------------
    protected static final String TEAM_NAME_ON_DASHBOARDS =
            "//span[@data-test-id='home-team-tab-name' and text () = '%s']";

    protected static final String CREATE_TEAM_BUTTON_DASHBOARDS =
            "button[data-test-id='home-navigation-create-team-button'] [class*='icon']";

    @FindBy(xpath = "//div[text()='teams']")
    private WebElement teamLabelOnSideBar;

    public void clickCreateTeam() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(teamLabelOnSideBar));
        Thread.sleep(600);
        action.click(By.cssSelector(CREATE_TEAM_BUTTON_DASHBOARDS));
    }

    public boolean teamIsListedOnSideBar(String teamName) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(teamLabelOnSideBar));
        Thread.sleep(600);
        return action.isElementVisible(By.xpath(String.format(TEAM_NAME_ON_DASHBOARDS, teamName)));
    }
    public void clickListedTeam(String teamName) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(teamLabelOnSideBar));
        Thread.sleep(600);
        action.click(By.xpath(String.format(TEAM_NAME_ON_DASHBOARDS, teamName)));
    }
    //-------------------------------------------------------------------------
}
