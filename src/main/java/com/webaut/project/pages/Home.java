package com.webaut.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home extends AbstractPage {

    //TEAMS Section of Side bar
    //-------------------------------------------------------------------------
    protected static final String TEAM_NAME_ON_DASHBOARDS =
            "//span[@data-test-id='home-team-tab-name' and text () = '%s']";

    protected static final String CREATE_TEAM_BUTTON_DASHBOARDS =
            "button[data-test-id='home-navigation-create-team-button'] [class*='icon']";

    public void clickCreateTeam() {
        action.click(By.cssSelector(CREATE_TEAM_BUTTON_DASHBOARDS));
    }

    public boolean teamIsListedOnSideBar(String teamName){
        return action.isElementVisible(By.xpath(String.format(TEAM_NAME_ON_DASHBOARDS, teamName)));
    }
    public void clickListedTeam(String teamName) {
        action.click(By.xpath(String.format(TEAM_NAME_ON_DASHBOARDS, teamName)));
    }
    //-------------------------------------------------------------------------
}
