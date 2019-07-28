Feature: Cards

  Background:
    Given I login as "owner"

  Scenario: Add card
    When I click add card button into a list called "List 1" of the board called "testboard"
    And I write a title "This is a title test" for this card
    Then I should see my created card in the list with the title "This is a title test"
