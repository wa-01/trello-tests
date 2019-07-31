package com.webaut.project.steps;

import com.webaut.project.pages.BoardDetails;
import com.webaut.project.pages.BoardForm;
import com.webaut.project.pages.Header;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

import java.util.Map;

public class BoardSteps {

    BoardDetails boardDetails;
    BoardForm boardForm;

    @When("I open the board creation form")
    public void iOpenTheBoardCreationForm() {
        Header header =new Header();
        boardForm=header.clickCreateBoardButton();
    }

    @And("I fill the board form with:")
    public void iFillTheBoardFormWith(Map<String, String> data) {
        BoardForm boardForm = new BoardForm();
        boardDetails=boardForm.createBoard(data);
    }

    @And("I crated an a list into the board with {string} name")
    public void iCratedAnAListIntoTheBoardWithName(String listName) {
        boardForm.addList(listName);
    }
}

