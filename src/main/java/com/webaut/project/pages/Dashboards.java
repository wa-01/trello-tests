package com.webaut.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboards extends AbstractPage {
    //TEAMS Section of Side bar
    //-------------------------------------------------------------------------
    @FindBy(css = "button[data-test-id='home-navigation-create-team-button']")
    private WebElement buttonCreateTeam;

    public void clickCreateTeam() {
        action.click(buttonCreateTeam);
    }

    //@FindBy(xpath = "//span[@data-test-id='home-team-tab-name' and text () = '%s']")
    //private WebElement teamListed;

    public Boolean teamIsListedOnSideBar(String teamName){
        return action.isElementVisible(By.xpath(String.format("//span[@data-test-id='home-team-tab-name' and text () = '%s']", teamName)));
    }

    //-------------------------------------------------------------------------
}
