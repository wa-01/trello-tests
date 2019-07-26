package com.webaut.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractPage {

    private static final String MEMBER_BUTTON = "button[title*=\"%s\"]";

    @FindBy(css = "button[data-steps-id = 'header-member-menu-button']")
    private WebElement memberButton;

    @FindBy(css = "span[name = 'house']")
    private WebElement homeButton;

    @FindBy(css = "button[data-steps-id='header-create-menu-button']")
    private WebElement createMenuButton;

    @FindBy(css = "button[data-steps-id='header-create-board-button']")
    private WebElement createBoardButton;

    public Boolean userNameIsOnButton(String userName) {
        return action.isElementVisible(By.cssSelector(String.format(MEMBER_BUTTON, userName)));
    }

    public MemberPopoverMenu clickMemberButton() {
        action.click(memberButton);
        return new MemberPopoverMenu();
    }

    public HomePage clickHomeButton() {
        action.click(homeButton);
        return new HomePage();
    }

    public BoardForm clickCreateBoardButton() {
        action.click(createMenuButton);
        action.click(createBoardButton);
        return new BoardForm();
    }
}
