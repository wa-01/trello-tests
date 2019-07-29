Feature: Cards

  Background:
    Given I login as "owner"
    When I click add card button into a list called "List 1" of the board called "testboard"
    And I write a title "This is a title test" for this card
    And I should see my created card in the list with the title "This is a title test"

  Scenario: Add Labels to Card
    And I click on the card with title "This is a title test"
    And I choose "green" and "blue" labels
    Then I should be able to see the labels in the card into the list