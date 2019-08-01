package com.webaut.project.pages.team;

import com.webaut.project.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TeamForm extends AbstractPage {

    @FindBy(css = ".pop-over-header-title")
    private WebElement headerTitle;

    public String getHeaderTitle(){
        String title = headerTitle.getText();
        return (title);
    }
    @FindBy(css = "a[class = 'pop-over-header-close-btn icon-sm icon-close']")
    private WebElement close;

    public void closeTeamForm(){
        close.click();
    }
    @FindBy(css = "#org-display-name")
    private WebElement teamInputName;

    public void setTeamName(String teamName){
        wait.until(ExpectedConditions.visibilityOf(headerTitle));
        action.setValue(teamInputName,teamName);
    }

    @FindBy(css = "#org-desc")
    private WebElement teamInputDescription;

    public void setTeamDescription(String description){
        action.setValue(teamInputDescription,description);
    }

    @FindBy(css = "input[class = 'primary wide js-save']")
    private WebElement clickCreate;

    public void clickCreate(){
        action.click(clickCreate);
    }

    @FindBy(css = "input[data-test-id='header-create-team-name-input']")
    private WebElement headerInputName;

    public void setHeaderInputName (String teamName){
        headerInputName.sendKeys(teamName);
    }

    @FindBy(css = "textarea[name='desc']")
    private WebElement headerInputDescription;

    public void setHeaderTeamDescription(String teamDescription){
        headerInputDescription.sendKeys(teamDescription);
    }
    @FindBy(css = "button[data-test-id='header-create-team-submit-button']")
    private WebElement headerCreateTeamButton;

    public void clickHeaderCreateTeam(){headerCreateTeamButton.click();}
}
