package com.webaut.project.pages.team;

import com.webaut.project.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TeamDetails extends AbstractPage {

    @FindBy(xpath = "//h1[@class = 'u-inline']")
    private WebElement teamTitle;

    @FindBy(css = "a[class= 'button-link tabbed-pane-header-details-edit js-edit-profile']")
    private WebElement editTeamProfile;

    @FindBy(xpath ="//div[@class='tabbed-pane-header-details-content markeddown']//p")
    private WebElement teamDescription;

    @FindBy(css = "span[class= 'profile-image-icon icon-lg icon-organization']")
    private WebElement img;

    public String getHeaderTitle() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(img));
        Thread.sleep(600);
        String teamsName = action.getText(teamTitle);
        return (teamsName);
    }
    public void clickEditTeamProfile() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(teamTitle));
        Thread.sleep(600);
        action.click(editTeamProfile);
    }

    public String getDescription(){
        wait.until(ExpectedConditions.visibilityOf(img));
        String teamsDescription = teamDescription.getText();
        return (teamsDescription);
    }
}
