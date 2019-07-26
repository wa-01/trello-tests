package com.webaut.project.steps;

import com.webaut.project.pages.Header;
import cucumber.api.java.en.Then;
import org.testng.Assert;

public class HeaderStep {

    @Then("I verify the user {string} is in member button")
    public void iVerifyTheUserIsInMemberButton(String userName) {
        Header header= new Header();
        Assert.assertTrue(header.userNameIsOnButton(userName), "user name founds");

    }

}

