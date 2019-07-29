package com.webaut.project.pages.team;

import com.webaut.project.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        teamInputName.sendKeys(teamName);
    }

    @FindBy(css = "#org-desc")
    private WebElement teamInputDescription;

    public void setTeamDescription(String description){
        teamInputDescription.sendKeys(description);
    }

    @FindBy(css = "input[class = 'primary wide js-save']")
    private WebElement clickCreate;

    public void clickCreate(){
        clickCreate.click();
    }
}
