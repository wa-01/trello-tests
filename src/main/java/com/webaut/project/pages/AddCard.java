package com.webaut.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddCard extends AbstractPage {

    private static final String ADD_CARD_LINK = "//h2[text()='%s']/ancestor::div[@class='js-list list-wrapper']/descendant::a[contains(@class, 'js-open-card-composer')]";
    private static final String BOARD_BUTTON = ".boards-page-board-section a[href*='/%s']";
    private static final String TITLE_TEXT = "//span[contains(text(),'%s')]";

    @FindBy(css = "textarea[class='list-card-composer-textarea js-card-title']")
    private WebElement cardTextField;

    @FindBy(css = "input[value='Add Card']")
    private WebElement saveCardButton;

    @FindBy(css = "div[id='board']")
    private WebElement board;

    public void addTitleCard(String listName, String title, String boardName) {
        action.click(By.cssSelector((String.format(BOARD_BUTTON, boardName))));
        action.click(By.xpath(String.format(ADD_CARD_LINK, listName)));
        action.setValue(cardTextField, title);
        action.click(saveCardButton);
        action.click(board);
    }

    public boolean isCardVisible(String title) {
        return action.isElementVisible(By.xpath(String.format(TITLE_TEXT, title)));
    }
}
