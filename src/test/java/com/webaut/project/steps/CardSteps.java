package com.webaut.project.steps;

import com.webaut.project.pages.card.CardForm;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CardSteps {

    private CardForm cardForm;

    public CardSteps(CardForm cardForm) {
        this.cardForm = cardForm;
    }

    @When("I click add card button into a list called {string} of the board called {string}")
    public void iClickAddCardButtonIntoAListCalledOfTheBoardCalled(String listName, String boardName) {
        this.cardForm.addCard(listName, boardName);
    }

    @And("I write a title {string} for this card")
    public void iWriteATitleForThisCard(String title) {
        this.cardForm.writeTitle(title);
    }

    @Then("I should see my created card in the list with the title {string}")
    public void iShouldSeeMyCreatedCardInTheListWithTheTitle(String title) {
        boolean actual = this.cardForm.isCardVisible(title);
        assertTrue(actual);
    }

    @When("I click on the card with title {string}")
    public void iClickOnTheCardWithTitle(String title) {
        this.cardForm.openCardToEdit(title);
    }

    @And("I enter {string} description and {string} comment")
    public void iEnterDescriptionAndComment(String description, String comment) {
        this.cardForm.editCard(description, comment);
    }

    @Then("I should be able to see the badges")
    public void iShouldBeAbleToSeeTheBadges() {
        this.cardForm.isBadgesVisible();
    }

    @And("I delete the card")
    public void iDeleteTheCard() {
        this.cardForm.deleteCard();
    }

    @Then("I should not be able to see the deleted card with the title {string} in the column")
    public void iShouldNotBeAbleToSeeTheDeletedCardWithTheTitleInTheColumn(String title) {
        boolean actual = this.cardForm.isCardVisible(title);
        assertFalse(actual);
    }

    @And("I choose {string} and {string} labels")
    public void iChooseAndLabels(String color1, String color2) {
        this.cardForm.addLabels(color1, color2);
    }

    @Then("I should be able to see the labels in the card into the list")
    public void iShouldBeAbleToSeeTheLabelsInTheCardIntoTheList() {
        boolean actual = this.cardForm.isLabelsVisible();
        assertTrue(actual);
    }
}
