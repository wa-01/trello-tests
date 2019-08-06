package com.webaut.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractPage {

    private static final String MEMBER_BUTTON = "//button[contains(@title,\"%s\")]";
    private static final String XPATH_BOARD_LINK_IN_TEAM ="//span[text()='%s']/../../following-sibling::div//a[contains(@href,'%s')]";

    @FindBy(css = "button[data-steps-id = 'header-member-menu-button']")
    private WebElement memberButton;

    @FindBy(css = "span[name=\"house\"]")
    private WebElement homeButton;

    @FindBy(css = "button[data-test-id=\"header-create-menu-button\"]")
    private WebElement createMenuButton;

    @FindBy(css = "button[data-test-id=\"header-create-board-button\"]")
    private WebElement createBoardButton;

    @FindBy(css = "span[name= 'add']")
    private WebElement addButton;

    @FindBy(css = "a[data-test-id='home-link']")
    private WebElement homeLink;

    @FindBy(css = "button[data-test-id=\"header-boards-menu-button\"]")
    private WebElement boardMenuButton;

    public Boolean userNameIsOnButton(String userName) {
        return action.isElementVisible(By.xpath(String.format(MEMBER_BUTTON, userName)));
    }

    public MemberPopoverMenu clickMemberButton() {
        action.click(memberButton);
        return new MemberPopoverMenu();
    }

    public Home clickHomeButton() {
        action.click(homeButton);
        action.click(homeButton);
        return new Home();
    }

    public BoardForm clickCreateBoardButton() {
        action.click(createMenuButton);
        action.click(createBoardButton);
        return new BoardForm();
    }

    public HeaderCreateMenu clickAdd(){
        action.click(addButton);
        return new HeaderCreateMenu();
    }

    public void goToHomeFromTeam() {

        driver.get("https://trello.com/");
        action.click(homeLink);
    }

    public BoardDetails goToBoardDetailsFromBoardMenu(String boardTeam,String boardID){
        if(boardTeam.equals("No team")) boardTeam = "Personal Boards";
        String specificBoardLink = String.format(XPATH_BOARD_LINK_IN_TEAM,boardTeam,boardID);
        action.click(boardMenuButton);
        action.click(By.xpath(specificBoardLink));
        return new BoardDetails();
    }

    public String isBoardInRecentBoardsList(String boardTeam,String boardID) {
        if(boardTeam.equals("No team")) boardTeam = "Personal Boards";
        String boardLink = String.format(XPATH_BOARD_LINK_IN_TEAM, boardTeam,boardID);
        System.out.println(driver.findElement(By.xpath(boardLink)).getAttribute("title"));
        return driver.findElement(By.xpath(boardLink)).getAttribute("title");
    }

}
