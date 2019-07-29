package com.webaut.project.steps;

import com.webaut.project.pages.Dashboards;
import com.webaut.project.pages.Header;
import com.webaut.project.pages.team.TeamDetails;
import com.webaut.project.pages.team.TeamForm;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.testng.Assert;

public class TeamSteps {
    private Dashboards dashboards;
    private TeamForm teamForm;
    private TeamDetails teamDetails;
    private Header header;

    public TeamSteps (Dashboards dashboards, TeamForm teamForm, TeamDetails teamDetails, Header header){
        this.dashboards = dashboards;
        this.teamForm = teamForm;
        this.teamDetails = teamDetails;
        this.header =header;

    }
    @Given("I Create a {string} Team with {string} from Dashboards")
    public void iCreateTeamFromDashboards(String teamName, String teamDescription) {
        dashboards.clickCreateTeam();
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
        Assert.assertTrue(dashboards.teamIsListedOnSideBar(teamName));
    }
}
