package com.webaut.project.steps;

import com.webaut.project.pages.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.Map;

public class BoardSteps {

    private Header header;
    private BoardDetails boardDetails;
    private BoardForm boardForm;
    private String currentBoardID;
    private Boards boards;
    private Home home;

    public BoardSteps(Header header, BoardDetails boardDetails, BoardForm boardForm, Boards boards, Home home) {
        this.header = header;
        this.boardDetails = boardDetails;
        this.boardForm = boardForm;
        this.boards = boards;
        this.home = home;
    }

    @When("I open the board creation form")
    public void iOpenTheBoardCreationForm() {
        boardForm=header.clickCreateBoardButton();
    }

    @And("I fill the board form with:")
    public void iFillTheBoardFormWith(Map<String, String> data) {
        boardDetails=boardForm.createBoard(data);
    }

    @And("I crated an a list into the board with {string} name")
    public void iCratedAnAListIntoTheBoardWithName(String listName) {
        boardForm.addList(listName);
    }

    @And("I capture the board ID")
    public void iCaptureTheBoardID() {
        currentBoardID=boardDetails.getCurrentBoardID();
        System.out.println(currentBoardID);
    }

    @Then("I validate that board {string} is in its boards details page")
    public void iValidateThatBoardIsInBoardsPage(String boardName) {
        Assert.assertEquals(boardDetails.getBoardName(),boardName);
    }

    @And("I validate that board {string} is in boards details page at {string} list")
    public void iValidateThatBoardIsInBoardsDetailsPageAtList(String expectedBoardName, String listName) {
        boardDetails.expandBoardsList();
        Assert.assertEquals(header.isBoardInRecentBoardsList(listName,currentBoardID),expectedBoardName);
    }

    @And("I validate that board {string} is in boards page at {string} list")
    public void iValidateThatBoardIsInBoardsPageAtList(String boardName, String teamName) {
        header.clickHomeButton();
        Assert.assertTrue(boards.isBoardInTeamList(currentBoardID,teamName));
    }

    @And("I validate that board {string} is in boards page at the team list {string}")
    public void iValidateThatBoardIsInBoardsPageAtTheTeamList(String arg0, String teamName) {

        Assert.assertTrue(boards.isBoardInTeamList(currentBoardID,teamName));
    }

    @And("I validate that board {string} is in home page at {string} list")
    public void iValidateThatBoardIsInHomePageAtList(String arg0, String arg1) {
        header.goToHomeFromTeam();
        Assert.assertTrue(home.isBoardInRecentlyList(currentBoardID));
    }

    @And("I close the board with boardID")
    public void iCloseTheBoardWithBoardID() {
        boardDetails.openBoardMenu();
        boardDetails.expandMoreMenu();
        boardDetails.closeBoard();
    }

    @And("I delete the board with boardID")
    public void iDeleteTheBoardWithBoardID() {
        boardDetails.deleteBoard();
    }

    @And("I go to the Board details from Board Menu with: boardID and the {string} team")
    public void iGoToBoardDetailsFromBoardsMenu(String boarTeam) {
        header.goToBoardDetailsFromBoardMenu(boarTeam,currentBoardID);
    }

    @Then("I validate that the message {string} is displayed")
    public void iValidateThatTheMessageIsDisplayed(String message) {

        Assert.assertTrue(boardDetails.isBoardDeletingMessageDisplayed(message));
    }
}

