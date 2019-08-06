package com.webaut.project.steps;

import com.webaut.project.pages.HeaderCreateMenu;
import com.webaut.project.pages.Home;
import com.webaut.project.pages.Header;
import com.webaut.project.pages.team.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import static java.lang.Thread.sleep;

public class TeamSteps {
    private Home home;
    private TeamForm teamForm;
    private TeamDetails teamDetails;
    private Header header;
    private HeaderCreateMenu headerCreateMenuHeader;
    private TeamSideBarOption teamSideBarOption;
    private TeamDeleteConfirmation teamDeleteConfirmation;
    private TeamEditForm teamEditForm;

    public TeamSteps (Home home, TeamForm teamForm, TeamDetails teamDetails, Header header,
                      HeaderCreateMenu headerCreateMenuHeader, TeamSideBarOption teamSideBarOption,
                      TeamDeleteConfirmation teamDeleteConfirmation, TeamEditForm teamEditForm){
        this.home = home;
        this.teamForm = teamForm;
        this.teamDetails = teamDetails;
        this.header = header;
        this.headerCreateMenuHeader = headerCreateMenuHeader;
        this.teamSideBarOption = teamSideBarOption;
        this.teamDeleteConfirmation = teamDeleteConfirmation;
        this.teamEditForm = teamEditForm;

    }
    @Given("I Create a {string} Team with {string} from Dashboards")
    public void iCreateTeamFromDashboards(String teamName, String teamDescription) throws InterruptedException {
        home.clickCreateTeam();
        teamForm.setTeamName(teamName);
        teamForm.setTeamDescription(teamDescription);
        teamForm.clickCreate();
    }

    @Then("I validate that {string} Team is loaded")
    public void iValidateTeamIsLoaded(String teamName) throws InterruptedException {
        Assert.assertEquals(teamName, teamDetails.getHeaderTitle());
    }

    @And("I validate that {string} Team is listed in TEAMS section of sidebar")
    public void iValidateTeamIsListedInSidebar(String teamName) throws InterruptedException {
        home = header.clickHomeButton();
        Assert.assertTrue(home.teamIsListedOnSideBar(teamName));
    }

    @When("I Create a {string} Team with {string} from Header")
    public void iCreateTeamFromHeader(String teamName, String teamDescription){
        headerCreateMenuHeader = header.clickAdd();
        headerCreateMenuHeader.clickLinkCreateTeam();
        teamForm.setHeaderInputName(teamName);
        teamForm.setHeaderTeamDescription(teamDescription);
        teamForm.clickHeaderCreateTeam();
    }

    @When("I Delete {string} Team from Home Dashboards - Side Bar")
    public void iDeleteTeamFromHomeDashboardSideBar(String teamName) throws InterruptedException {
        Thread.sleep(1500);
        header.clickHomeButton();
        home.clickListedTeam(teamName);
        teamSideBarOption.clickSettings();
        teamSideBarOption.clickDeleteLink();
        teamDeleteConfirmation.clickDeleteForever();
    }
    @Then("I Validate {string} Team is not listed in Side bar")
    public void iValidateTeamIsRemovedFromSideBar(String teamName) throws InterruptedException {
        Assert.assertFalse(home.teamIsListedOnSideBar(teamName));
    }

    @When("I edit {string} Team updating {string} as Name and {string} as description")
    public void iEditNameAndDescriptionOfTeam(String teamName, String newTeamName, String newDescription)
            throws InterruptedException {
        Thread.sleep(1500);
        teamDetails.clickEditTeamProfile();
        teamEditForm.updateTeamName(newTeamName);
        teamEditForm.updateTeamDescription(newDescription);
        teamEditForm.clickSave();
    }
    @Then("I validate updated Team name is {string}")
    public void iValidateUpdateTeamName(String expectedName) throws InterruptedException {
        Assert.assertEquals(teamDetails.getHeaderTitle(),expectedName);
    }
    @Then("I validate updated Team description is {string}")
    public void iValidateUpdateTeamDescription(String newDescription){
        Assert.assertEquals(teamDetails.getDescription(),newDescription);
    }

    @When ("I edit {string} Team updating {string} as Name and {string} as description canceled")
    public void iEditTeamShortNameAndWebsite(String teamName, String shortName, String website) throws InterruptedException {
        Thread.sleep(1500);
        teamDetails.clickEditTeamProfile();
        teamEditForm.updateTeamShortName(shortName);
        teamEditForm.updateTeamWebsite(website);
        teamEditForm.clickCancel();
    }

    @Then("I validate {string} Team remains {string} as Name and {string} as Description")
    public void iValidateTeamNameAndDescriptonWereNotUpdated(String Name, String teamName, String teamDescription) throws InterruptedException {
        Assert.assertEquals(teamDetails.getHeaderTitle(), teamName);
        Assert.assertEquals(teamDetails.getDescription(), teamDescription);
        teamDetails.clickEditTeamProfile();
        Assert.assertEquals(teamEditForm.getDisplayName(), teamName);
        Assert.assertEquals(teamEditForm.getDescription(), teamDescription);
        teamEditForm.clickCancel();
    }

}
