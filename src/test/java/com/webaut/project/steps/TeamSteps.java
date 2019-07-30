package com.webaut.project.steps;

import com.webaut.project.pages.HeaderCreateMenu;
import com.webaut.project.pages.Home;
import com.webaut.project.pages.Header;
import com.webaut.project.pages.team.TeamDeleteConfirmation;
import com.webaut.project.pages.team.TeamDetails;
import com.webaut.project.pages.team.TeamForm;
import com.webaut.project.pages.team.TeamSideBarOption;
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

    public TeamSteps (Home home, TeamForm teamForm, TeamDetails teamDetails, Header header, HeaderCreateMenu headerCreateMenuHeader, TeamSideBarOption teamSideBarOption, TeamDeleteConfirmation teamDeleteConfirmation){
        this.home = home;
        this.teamForm = teamForm;
        this.teamDetails = teamDetails;
        this.header =header;
        this.headerCreateMenuHeader = headerCreateMenuHeader;
        this.teamSideBarOption = teamSideBarOption;
        this.teamDeleteConfirmation = teamDeleteConfirmation;

    }
    @Given("I Create a {string} Team with {string} from Dashboards")
    public void iCreateTeamFromDashboards(String teamName, String teamDescription) {
        home.clickCreateTeam();
        teamForm.setTeamName(teamName);
        teamForm.setTeamDescription(teamDescription);
        teamForm.clickCreate();
    }

    @Then("I validate that {string} Team is loaded")
    public void iValidateTeamIsLoaded(String teamName){
        Assert.assertEquals(teamName, teamDetails.getHeaderTitle());
    }

    @And("I validate that {string} Team is listed in TEAMS section of sidebar")
    public void iValidateTeamIsListedInSidebar(String teamName){
        header.clickHomeButton();
        Assert.assertTrue(home.teamIsListedOnSideBar(teamName));
    }

    @When("I Create a {string} Team with {string} from Header")
    public void iCreateTeamFromHeader(String teamName, String teamDescription){
        header.clickAdd();
        headerCreateMenuHeader.clickLinkCreateTeam();
        teamForm.setHeaderInputName(teamName);
        teamForm.setHeaderTeamDescription(teamDescription);
        teamForm.clickHeaderCreateTeam();
    }

    @When("I Delete {string} Team from Home Dashboards - Side Bar")
    public void iDeleteTeamFromHomeDashboardSideBar(String teamName) throws InterruptedException {
        home.clickListedTeam(teamName);
        sleep(500);
        teamSideBarOption.clickSettings();
        sleep(500);
        teamSideBarOption.clickDeleteLink();
        sleep(500);
        teamDeleteConfirmation.clickDeleteForever();
    }
    @Then("I Validate {string} Team is not listed in Side bar")
    public void iValidateTeamIsRemovedFromSideBar(String teamName){
        Assert.assertFalse(home.teamIsListedOnSideBar(teamName));
    }
}
