package com.webaut.project.pages.team;

import com.webaut.project.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TeamEditForm extends AbstractPage {

    @FindBy(css = "input[name='displayName']")
    private WebElement displayName;

    @FindBy(css = "input[name='name']")
    private WebElement shortName;

    @FindBy(css = "input[name='website']")
    private WebElement website;

    @FindBy(css = "textarea[name='desc']")
    private WebElement descriptionTextArea;

    @FindBy(css = "input[class='primary wide js-submit-profile']")
    private WebElement saveButton;

    @FindBy(css = "input[class='js-cancel-edit-profile']")
    private WebElement cancelButton;

    @FindBy(css = "span[class='profile-image-icon icon-lg icon-organization']")
    private WebElement imageIcon;

    @FindBy(css = ".pop-over-header-title")
    private WebElement headerTitle;

    public String getHeaderTitle(){
        String title = headerTitle.getText();
        return (title);
    }

    public void updateTeamName(String teamNewName) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(imageIcon));
        Thread.sleep(1000);
        action.setValue(displayName,teamNewName);
    }

    public void updateTeamShortName(String teamNewShortName) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(imageIcon));
        Thread.sleep(1000);
        action.setValue(shortName,teamNewShortName);
    }

    public void updateTeamWebsite(String teamNewWebsite) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(imageIcon));
        Thread.sleep(1000);
        action.setValue(website,teamNewWebsite);
    }

    public void updateTeamDescription(String teamNewdescription) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(imageIcon));
        Thread.sleep(1000);
        action.setValue(descriptionTextArea,teamNewdescription);
    }

    public void clickSave() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(imageIcon));
        Thread.sleep(1000);
        action.click(saveButton);
    }

    public void clickCancel(){
        wait.until(ExpectedConditions.visibilityOf(imageIcon));
        action.click(cancelButton);
    }

    public String getDisplayName() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(imageIcon));
        Thread.sleep(1000);
        String teamsDisplayName = displayName.getAttribute("value");
        return (teamsDisplayName);
    }

    public String getShortName(){
        String teamsShortName = shortName.getText();
        return (teamsShortName);
    }

    public String getWebsite(){
        String teamsWebsite = website.getText();
        return (teamsWebsite);
    }

    public String getDescription() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(imageIcon));
        Thread.sleep(1000);
        String teamsDescription = descriptionTextArea.getText();
        return (teamsDescription);
    }
}
