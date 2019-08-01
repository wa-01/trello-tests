package com.webaut.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BoardDetails extends AbstractPage{

    private static final String RECENT_BOARDS_lINK_LIST = "(//span[text()='Recent Boards']/ancestor::div/following-sibling::div//a[contains(@href,'%s')])[1]";


    @FindBy(css = ".open-add-list.js-open-add-list>span")
    private WebElement addListbutton;

    @FindBy(css = "button[data-test-id = 'header-boards-menu-button'")
    private WebElement boardMenuButton;


    @FindBy(xpath = "//a[contains(@class,\"js-open-more\")]")
    private WebElement moreLink;

    @FindBy(xpath = "//input[@id=\"id-short-url\"]")
    private WebElement boardURL;

    @FindBy(xpath = "//div[contains(@class,\"board-header-btn-name\")]/span")
    private WebElement boardName;



    public String getCurrentBoardID() {
        action.click(moreLink);
        String[] boardPartsURL = boardURL.getAttribute("value").split("/");
        return boardPartsURL[boardPartsURL.length-1];
    }

    public String getBoardName() {
        return boardName.getText();
    }

    public String isBoardInRecentBoardsList(String boardID) {
        String boardLink = String.format(RECENT_BOARDS_lINK_LIST, boardID);
        System.out.println(driver.findElement(By.xpath(boardLink)).getAttribute("title"));
       return driver.findElement(By.xpath(boardLink)).getAttribute("title");
    }

    public void expandBoardsList() {
        action.click(boardMenuButton);

    }
}
