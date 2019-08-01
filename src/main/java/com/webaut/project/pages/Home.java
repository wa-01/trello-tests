package com.webaut.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home extends AbstractPage {

    protected static final String TEAM_NAME_ON_DASHBOARDS =
            "//span[@data-test-id='home-team-tab-name' and text () = '%s']";

    protected static final String CREATE_TEAM_BUTTON_DASHBOARDS =
            "button[data-test-id='home-navigation-create-team-button'] [class*='icon']";

    protected static final String RECENTLY_BOARDS_LIST = " //div[text()='Recently Viewed']/../following-sibling::div[contains(@href,'%s')]";



    public void clickCreateTeam() {
        action.click(By.cssSelector(CREATE_TEAM_BUTTON_DASHBOARDS));
    }

    public boolean teamIsListedOnSideBar(String teamName){
        return action.isElementVisible(By.xpath(String.format(TEAM_NAME_ON_DASHBOARDS, teamName)));
    }
    public void clickListedTeam(String teamName) {
        action.click(By.xpath(String.format(TEAM_NAME_ON_DASHBOARDS, teamName)));
    }


    public boolean isBoardInRecentlyList(String currentBoardID) {
        String specificBoard= String.format(RECENTLY_BOARDS_LIST,currentBoardID);
        return driver.findElements(By.xpath(specificBoard)).size()==1;
    }
}
