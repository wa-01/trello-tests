package com.webaut.project.steps;

import com.webaut.project.pages.BoardArchiveMenu;
import com.webaut.project.pages.BoardDetails;
import com.webaut.project.pages.BoardMenu;
import com.webaut.project.pages.BoardMoreMenu;
import com.webaut.project.pages.list.ListActions;
import com.webaut.project.pages.list.ListCreateForm;
import com.webaut.project.pages.list.ListFormContent;
import com.webaut.project.pages.list.MoveList;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ListSteps {
    private BoardDetails boardDetails;
    private ListFormContent listContent;
    private ListActions listActions;
    private ListCreateForm listCreateForm;
    private MoveList moveList;
    private BoardMenu boardMenu;
    private BoardMoreMenu boardMoreMenu;
    private BoardArchiveMenu boardArchiveMenu;

    public ListSteps(BoardDetails boardDetails, ListFormContent listContent, ListActions listActions,
                     ListCreateForm listCreateForm, MoveList moveList, BoardMenu boardMenu){
        this.boardDetails = boardDetails;
        this.listContent = listContent;
        this.listActions = listActions;
        this.listCreateForm = listCreateForm;
        this.moveList = moveList;
        this.boardMenu = boardMenu;
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

    @Then("I validate the list {string} is displayed")
    public void iValidateTheListIsDisplayed(String listTitle) {
        String actualLisTitle = listContent.getListTitle();
        Assert.assertEquals(actualLisTitle, listTitle);
    }

    @When("I click the list name {string}")
    public void iClickTheListName(String listTitle) {
        listContent.clickListTitle(listTitle);
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

    @Then("I validate the list named {string} is archived")
    public void iValidateTheListNamedIsArchived(String listName) {
        boolean actualResult = boardDetails.isListVisible(listName);
        Assert.assertFalse(actualResult);
    }

    @And("I select the action list {string}")
    public void iSelectTheActionList(String listAction) throws InterruptedException {
        listActions.selectAction(listAction);
    }

    @And("I select the position {string}")
    public void iSelectThePosition(String newPosition) {
        moveList.selectPosition(newPosition);
    }

    @Then("I validate {string} is before {string}")
    public void iValidateIsBefore(String beforeList, String afterList) {
        Assert.assertTrue(listContent.isListAfter(beforeList, afterList));
    }

    @And("I click More in right sidebar menu")
    public void iClickMoreInRightSidebarMenu() {
        boardMoreMenu = boardMenu.clickMore();
    }

    @And("I click Archived Items")
    public void iClickArchivedItems() {
        boardArchiveMenu = boardMoreMenu.clickArchivedItems();
    }

    @And("I type {string} in search field")
    public void iTypeInSearchField(String searchText) {
        boardArchiveMenu.setTextSearch(searchText);
    }

    @And("I click Switch to lists button")
    public void iClickSwitchToListsButton() {
        boardArchiveMenu.clickSwitchToLists();
    }

    @And("I validate the {string} is displayed in the search results")
    public void iValidateTheIsDisplayedInTheSearchResults(String listName) {
        Assert.assertTrue(boardArchiveMenu.isElementInResults(listName));
    }

    @And("I validate the position {string} is displayed")
    public void iValidateThePositionIsDisplayed(String position) {
        Assert.assertEquals(position, moveList.getPositionDisplayed());
    }

    @And("I click position")
    public void iClickPosition() {
        moveList.clickPosition();
    }

    @And("I validate the position {string} is marked as current")
    public void iValidateThePositionIsMarkedAsCurrent(String position) {
        Assert.assertTrue(moveList.getCurrentPosition().contains(position));
    }
}
