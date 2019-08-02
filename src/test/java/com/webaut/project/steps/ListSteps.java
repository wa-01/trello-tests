package com.webaut.project.steps;

import com.webaut.project.pages.BoardDetails;
import com.webaut.project.pages.Home;
import com.webaut.project.pages.list.ListActions;
import com.webaut.project.pages.list.ListForm;
import com.webaut.project.pages.list.ListFormContent;
import com.webaut.project.pages.list.MoveList;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class ListSteps {
    private BoardDetails boardDetails;
    private ListFormContent listContent;
    private ListActions listActions;
    private ListForm listForm;
    private MoveList moveList;

    public ListSteps(BoardDetails boardDetails, ListFormContent listContent, ListActions listActions, ListForm listForm, MoveList moveList){
        this.boardDetails = boardDetails;
        this.listContent = listContent;
        this.listActions = listActions;
        this.listForm = listForm;
        this.moveList = moveList;
    }

    @And("I click cancel button in list form")
    public void iClickCancelButtonInListForm() {
        listForm.clickCancelButton();
    }
//    @And("a board is created")
//    public void aBoardIsCreated() {
//        //TODO: replace with code to create a board
//        Home homePage = new Home();

//    }

    @When("I click add a list button")
    public void iClickAddAListButton() {
        listForm = boardDetails.clickAddListButton();
    }

    @And("I set the list title")
    public void iSetTheListTitle(Map<String, String> data) {
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

    @When("I click the actions button in the list {string}")
    public void iClickTheActionsButtonInTheList(String listTitle) {
        listActions = listContent.clickListActionsButton(listTitle);
    }

    @And("I select the action list {string}")
    public void iSelectTheActionList(String listAction) {
        //listActions.selectArchiveThisList();
        listActions.selectAction(listAction);
    }

    @Then("I validate the list named {string} is archived")
    public void iValidateTheListNamedIsArchived(String listName) {
        boolean actualResult = boardDetails.isListVisible(listName);
        Assert.assertFalse(actualResult);
    }

    @When("I move {string} to {string} position")
    public void iMoveToPosition(String listSource, String listTarget) {
        listContent.moveList(listSource, listTarget);
    }

    @Then("I validate {string} is before {string}")
    public void iValidateIsBefore(String beforeList, String afterList) {
        Assert.assertTrue(listContent.isListAfter(beforeList, afterList));
    }

    @And("I select the position {string}")
    public void iSelectThePosition(String newPosition) {
        moveList.selectPosition(newPosition);
    }
}
