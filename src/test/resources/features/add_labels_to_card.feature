Feature: Cards

  Background:
    Given I login as "owner"
    And I open the board creation form
    And I fill the board form with:
      | title   | testboard   |
      | team    | No team     |
      | privacy | Private     |
      | image   | blue        |
    And I crated an a list into the board with "list 1" name
    And I go to home page
    When I click add card button into a list called "list 1" of the board called "testboard"
    And I write a title "this is a title test" for this card
    And I should see my created card in the list with the title "this is a title test"

  Scenario: Add Labels to Card
    And I click on the card with title "this is a title test"
    And I choose "green" and "blue" labels
    Then I should be able to see the labels in the card into the list