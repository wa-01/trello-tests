package com.webaut.project.pages.team;

import com.webaut.project.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeamDetails extends AbstractPage {

    @FindBy(css = ".u-inline")
    private WebElement teamTitle;

    public String getHeaderTitle(){
        String teamsTitle = teamTitle.getText();
        return (teamsTitle);
    }

}
