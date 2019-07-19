package com.webaut.project;

import com.webaut.project.pages.Board;
import com.webaut.project.pages.Home;
import com.webaut.project.pages.ListForm;
import com.webaut.project.pages.ListFormContent;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class ListSteps {
    private ListFormContent listContent = new ListFormContent();
    @And("a board is created")
    public void aBoardIsCreated() {
        //TODO: replace with code to create a board
        Home homePage = new Home();
    }

    @When("I click add a list button")
    public void iClickAddAListButton() {
        Board board = new Board();
        ListForm listForm = board.clickAddListButton();
    }

    @And("I set the list title")
    public void iSetTheListTitle(Map<String, String> data) {
        ListForm listForm = new ListForm();
        listForm.addList(data);
    }

    @Then("I validate the new list is {string}")
    public void iValidateTheNewListIs(String listTitle) {
        String actualLisTitle = listContent.getListTitle();
        Assert.assertEquals(actualLisTitle, listTitle);
    }

    @When("I click the list name {string}")
    public void iClickTheListName(String listTitle) {
        listContent.clickEditListButton(listTitle);
    }

    @And("I set a new list title {string}")
    public void iSetANewListTitle(String newListTitle) {
        listContent.setListTitle(newListTitle);
    }

    @Then("I validate the new title is {string}")
    public void iValidateTheNewTitleIs(String newTitle) {
        String actualTitle = listContent.getListTitle();
        Assert.assertEquals(newTitle, actualTitle);
    }
}
