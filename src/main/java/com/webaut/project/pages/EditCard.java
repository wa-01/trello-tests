package com.webaut.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditCard extends AbstractPage{

    private static final String EDIT_CARD_LINK = "//span[contains(text(),'%s')]/ancestor::a";
    // private static final String SAVE_COMMENT = "//input[@value='Save']/ancestor::div[contains(@class,'window-module')]/descendant::h3[text()='Add Comment']";
    private static final String SAVE_DESCRIPTION = "//input[@value='Save']/ancestor::div[contains(@class,'window-module')]/descendant::h3[text()='Description']";
    private static final String SAVE_COMMENT = "//div[contains(@class,'comment-controls')]/child::input";

    /* @FindBy(css = "a[class *='description-fake-text-area']")
    private WebElement descriptionLink; */

    @FindBy(css = "a[class *='js-show-with-desc']")
    private WebElement descriptionLink;

    @FindBy(css = "textarea[class *='description card-description']")
    private WebElement descriptionField;

    @FindBy(css ="textarea[class *='comment-box-input js-new']")
    private WebElement commentField;

    @FindBy(css = "a[class *='js-close-window']")
    private WebElement close;

    public void editCard(String title, String description, String comment) {
        action.click(By.xpath(String.format(EDIT_CARD_LINK, title)));
        action.click(descriptionLink);
        action.setValue(descriptionField, description);
        action.click(By.xpath(SAVE_DESCRIPTION));

        action.setValue(commentField, comment);
        action.click(By.xpath(SAVE_COMMENT));
        action.click(close);
    }
}
