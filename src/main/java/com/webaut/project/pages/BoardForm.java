package com.webaut.project.pages;

import com.webaut.project.core.ui.ISteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BoardForm extends AbstractPage{

    private static final String SELECTOR_OPTIONS_XPATH = "//div[@role='dialog']/descendant::li//span[text()='%s']";
    private static final String BACKGROUND_COLOR_XPATH = "//li/button[contains(@style,'background') and @title='%s']";

    @FindBy(css = "#layer-manager-overlay")
    private WebElement boardForm;

    @FindBy(css = "input[data-test-id=\"header-create-board-title-input\"]")
    private WebElement inputBoardTitle;

    //@FindBy(xpath = "//div[@id='layer-manager-overlay']/descendant::div/button/span[text()='No team']/following-sibling::span")
    @FindBy(xpath = "(//button/span[@name=\"down\"])[1]")
    private WebElement teamSelector;

    @FindBy(xpath = "(//button/span[@name=\"down\"])[2]")
    private WebElement privacySelector;

    @FindBy(css = "button[data-test-id=\"header-create-board-submit-button\"]")
    private WebElement createBoardButton;

    //@FindBy(css = ".list-name-input")
    @FindBy(xpath = "//input[@class='list-name-input']")
    private WebElement listNameInput;

    @FindBy(css = ".primary.mod-list-add-button.js-save-edit")
    private WebElement addListButton;



    public BoardDetails createBoard(Map<String, String> data) {
        setBoardFields(data);
        action.click(createBoardButton);
        return new BoardDetails();

    }

    private void setBoardFields(Map<String, String> data) {
        Map<String, ISteps> strategyMap = new HashMap<>();
        strategyMap.put("title", () -> action.setValue(inputBoardTitle, data.get("title")));
        strategyMap.put("team", () -> selectTeam(data.get("team")));
        strategyMap.put("privacy", () -> selectPrivacy(data.get("privacy")));
        strategyMap.put("image", () -> selectBackgroundAvailableImage(data.get("image")));
        Set<String> keys = data.keySet();
        for (String key : keys) {
            strategyMap.get(key).execute();
        }
    }

    private void selectBackgroundAvailableImage(String image) {
        String optionBackgroudColor = String.format(BACKGROUND_COLOR_XPATH,image);
        action.click(By.xpath(optionBackgroudColor));
    }

    private void selectPrivacy(String expectedPrivacy) {
        action.click(privacySelector);
        String optionPrivacyLocator=String.format(SELECTOR_OPTIONS_XPATH, expectedPrivacy);
        action.click(By.xpath(optionPrivacyLocator));
    }

    private void selectTeam(String expectedTeam) {
        action.click(teamSelector);
        String optionTeamLocator = String.format(SELECTOR_OPTIONS_XPATH, expectedTeam);
        action.click(By.xpath(optionTeamLocator));
    }

    public void addList(String ListName) {
        action.setValue(listNameInput, ListName);
        action.click(addListButton);
    }
}

