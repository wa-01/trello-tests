package com.webaut.project.pages;

import com.webaut.project.pages.list.ListCreateForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BoardDetails extends AbstractPage{

    private static final String RECENT_BOARDS_lINK_LIST = "//span[text()='%s']/../../following-sibling::div//a[contains(@href,'%s')]";


    @FindBy(css = ".open-add-list.js-open-add-list>span")
    private WebElement addListButton;

    @FindBy(css = "button[data-test-id = 'header-boards-menu-button'")
    private WebElement boardMenuButton;


    @FindBy(xpath = "//a[contains(@class,\"js-open-more\")]")
    private WebElement moreLink;

    @FindBy(xpath = "//input[@id=\"id-short-url\"]")
    private WebElement boardURL;

    @FindBy(xpath = "//div[contains(@class,\"board-header-btn-name\")]/span")
    private WebElement boardName;

    @FindBy(css = "a[class *='js-show-sidebar']")
    private WebElement showMenuLink;

    @FindBy(css = "a[class *='js-close-board']")
    private WebElement closeBoardLink;

    @FindBy(css = "input[class *='js-confirm']")
    private WebElement confirmInput;

    @FindBy(css = "a[class *='js-delete']")
    private WebElement deleteBoardLInk;

    @FindBy(css = "div[class='board-menu-container']")
    private WebElement boardMenuContainer;

    private String LIST_TITLE = "//h2[text()='%s']/parent::div";

    public String getCurrentBoardID() {
        action.isElementPresent(By.xpath("//a[contains(@class,\"js-open-more\")]"));
        action.click(moreLink);
        String[] boardPartsURL = boardURL.getAttribute("value").split("/");
        return boardPartsURL[boardPartsURL.length-1];
    }

    public String getBoardName() {
        return boardName.getText();
    }

    public String isBoardInRecentBoardsList(String listName,String boardID) {
        if(listName.equals("No team"))  listName = "Personal Boards";
        String boardLink = String.format(RECENT_BOARDS_lINK_LIST,listName, boardID);
       return driver.findElement(By.xpath(boardLink)).getAttribute("title");
    }

    public void expandBoardsList() {
        action.click(boardMenuButton);
    }

    public void openBoardMenu() {
        if(!boardMenuContainer.isDisplayed())
            action.click(showMenuLink);
    }

    public void expandMoreMenu() {
        action.isElementPresent(By.xpath("//a[contains(@class,\"js-open-more\")]"));
        action.click(moreLink);
    }

    public void closeBoard() {
        action.click(closeBoardLink);
        action.click(confirmInput);
    }

    public void deleteBoard() {
        action.click(deleteBoardLInk);
        action.click(confirmInput);

    }
    public ListCreateForm clickAddListButton() {
        action.click(addListButton);
        return new ListCreateForm();
    }

    public boolean isListVisible(String listName) {
        return action.isElementInvisible(By.xpath(String.format(LIST_TITLE, listName)));
    }
}
