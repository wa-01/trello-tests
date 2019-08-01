package com.webaut.project.pages;

import org.openqa.selenium.By;

public class Boards extends AbstractPage {

    private static final String XPATH_TEAM_LIST_IN_BOARDS ="//h3[text()='%s']/ancestor::div[@class='boards-page-board-section-header']/following-sibling::ul";
    private static final String XPATH_BOARD_LINK ="/li/a[contains(@href,'%s')]";

    public boolean isBoardInTeamList(String boardID,String teamName) {
        String specificTeamList;
        specificTeamList = String.format(XPATH_TEAM_LIST_IN_BOARDS,teamName);
        String specificTeamBoard=specificTeamList.concat(String.format(XPATH_BOARD_LINK,boardID));
        System.out.println(specificTeamBoard);
        return  driver.findElements(By.xpath(specificTeamBoard)).size()==1;

    }
}
