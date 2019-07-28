package com.webaut.project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends AbstractPage {

    @FindBy(css = "input[id = user]")
    private WebElement userNameTextField;

    @FindBy(css = "input[id = password]")
    private WebElement userPasswordTextField;

    @FindBy(css = ".button.button-green")
    private WebElement logginButton;

    @FindBy(css = "#error > .error-message")
    private WebElement errorMessage;

    public Login() {
        driver.get("https://trello.com/login");
    }

    public Header loginTrello(String userName, String password) {
        action.setValue(userNameTextField, userName);
        action.setValue(userPasswordTextField, password);
        action.click(logginButton);
        return new Header();
    }

    public String verifyInvalidPasswordMessageIsDisplayed() {
        return action.getText(errorMessage);
    }

    public boolean UrlIsLoginPAge() {
        return driver.getCurrentUrl().endsWith("login");
    }
}
