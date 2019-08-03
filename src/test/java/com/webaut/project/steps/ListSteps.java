package com.webaut.project.steps;

import com.webaut.project.pages.BoardDetails;
import com.webaut.project.pages.list.ListActions;
import com.webaut.project.pages.list.ListCreateForm;
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
    private ListCreateForm listCreateForm;
    private MoveList moveList;

    public ListSteps(BoardDetails boardDetails, ListFormContent listContent, ListActions listActions, ListCreateForm listCreateForm, MoveList moveList){
        this.boardDetails = boardDetails;
        this.listContent = listContent;
        this.listActions = listActions;
        this.listCreateForm = listCreateForm;
        this.moveList = moveList;
    }

    @And("I click cancel button in list form")
    public void iClickCancelButtonInListForm() {
        listCreateForm.clickCancelButton();
    }

    @When("I click add a list button")
    public void iClickAddAListButton() {
        listCreateForm = boardDetails.clickAddListButton();
    }

    @And("I set the list title {string}")
    public void iSetTheListTitle(String listTitle) {
        listCreateForm.addList(listTitle);
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
