package com.webaut.project.pages.card;

import com.webaut.project.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CardForm extends AbstractPage {
    private String titleCard;

    private static final String ADD_CARD_LINK = "//h2[text()='%s']/ancestor::div[@class='js-list list-wrapper']/descendant::a[contains(@class, 'js-open-card-composer')]";
    private static final String BOARD_BUTTON = ".boards-page-board-section a[href*='/%s']";
    private static final String TITLE_TEXT = "//span[contains(text(),'%s')]";

    private static final String EDIT_CARD_LINK = "//span[contains(text(),'%s')]/ancestor::a";
    private static final String SAVE_DESCRIPTION = "//input[@value='Save']/ancestor::div[contains(@class,'window-module')]/descendant::h3[text()='Description']";
    private static final String SAVE_COMMENT = "//div[contains(@class,'comment-controls')]/child::input";
    private static final String BADGES = "//span[contains(text(),'%s')]/following-sibling::div[@class='badges']";

    @FindBy(css = "textarea[class='list-card-composer-textarea js-card-title']")
    private WebElement cardTextField;

    @FindBy(css = "input[value='Add Card']")
    private WebElement saveCardButton;

    @FindBy(css = "div[id='board']")
    private WebElement board;

    @FindBy(css = ".js-show-with-desc")
    private WebElement descriptionLink;

    @FindBy(css = ".js-description-draft")
    private WebElement descriptionField;

    @FindBy(css ="textarea[class *='comment-box-input js-new']")
    private WebElement commentField;

    @FindBy(css = "a[class *='js-close-window']")
    private WebElement close;

    @FindBy(css = "a[class*='js-archive-card']")
    private WebElement archiveButton;

    @FindBy(css = "a[class*='js-delete-card']")
    private WebElement deleteButton;

    @FindBy(css = "input[class*='js-confirm']")
    private WebElement confirmDelete;

    public void addCard(String listName, String boardName) {
        action.click(By.cssSelector((String.format(BOARD_BUTTON, boardName))));
        action.click(By.xpath(String.format(ADD_CARD_LINK, listName)));
    }

    public void writeTitle(String title) {
        this.titleCard = title;
        action.setValue(cardTextField, title);
        action.click(saveCardButton);
        action.click(board);
    }

    public boolean isCardVisible(String title) {
        return action.isElementVisible(By.xpath(String.format(TITLE_TEXT, title)));
    }

    public void openCardToEdit(String title) {
        action.click(By.xpath(String.format(EDIT_CARD_LINK, title)));
    }

    public void editCard(String description, String comment) {
        action.clickJS(descriptionLink);
        action.setValue(descriptionField, description);
        action.click(By.xpath(SAVE_DESCRIPTION));
        action.setValue(commentField, comment);
        action.click(By.xpath(SAVE_COMMENT));
        action.click(close);
    }

    public boolean isBadgesVisible() {
        return action.isElementVisible(By.xpath(String.format(BADGES, this.titleCard)));
    }

    public void deleteCard() {
        action.click(archiveButton);
        action.click(deleteButton);
        action.click(confirmDelete);
    }
}
