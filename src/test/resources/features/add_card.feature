Feature: Cards

  Background:
    Given I login as "owner"
    And I open the board creation form
    And I fill the board form with:
      | title   | myboardtest |
      | team    | No team     |
      | privacy | Private     |
      | image   | blue        |
    And I crated an a list into the board with "list 1" name
    And I go to home page

  Scenario: Add card
    When I click add card button into a list called "list 1" of the board called "myboardtest"
    And I write a title "This is a title test" for this card
    Then I should see my created card in the list with the title "This is a title test"
