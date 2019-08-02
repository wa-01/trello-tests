package com.webaut.project.steps;

import com.webaut.project.core.Environment;
import com.webaut.project.pages.Header;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.testng.Assert;

public class HeaderStep {

    Header header;

    public HeaderStep(Header header) {
        this.header = header;
    }

    @Then("I verify the user {string} is in member button")
    public void iVerifyTheUserIsInMemberButton(String userName) {
        String name = Environment.getInstance().getValue(String.format("$['credentials']['%s']['username']", userName));
        Assert.assertTrue(header.userNameIsOnButton(name), "user name founds");
    }

    @And("I go to home page")
    public void iGoToHomePage() {
        header.clickHomeButton();
    }

    @And("I click in member button")
    public void iClickInMemberButton() {
        header.clickMemberButton();
    }

    @And("I go to home from team page")
    public void iGoToHomeFromTeamPage() {
        header.goToHomeFromTeam();
    }
}

