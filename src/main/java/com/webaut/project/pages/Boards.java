package com.webaut.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Boards extends AbstractPage {

    private static final String XPATH_TEAM_LIST_IN_BOARDS ="//h3[text()='%s']/ancestor::div[@class='boards-page-board-section-header']/following-sibling::ul/li/a[contains(@href,'%s')]";
    private static final String XPATH_BOARD_GENERIC_LINK ="//li/a[contains(@href,'%s')]";

    @FindBy(css = "a[contains(@href,'%s')]")
    private WebElement memberButton;

    public boolean isBoardInTeamList(String teamName,String boardID) {
        if(teamName.equals("No team"))  teamName = "Personal Boards";
        String specificTeamBoard=String.format(XPATH_TEAM_LIST_IN_BOARDS,teamName,boardID);
        return  driver.findElements(By.xpath(specificTeamBoard)).size()==1;
    }

    public BoardDetails goToBoardDetails(String boardID) {
        String boardLink = String.format(XPATH_BOARD_GENERIC_LINK,boardID);
        action.click(By.xpath(boardLink));
        return new BoardDetails();
    }
}
