Feature: Cards

  Background:
    Given I login as "owner"
    And I open the board creation form
    And I fill the board form with:
      | title   | boardtest   |
      | team    | No team     |
      | privacy | Private     |
      | image   | blue        |
    And I crated an a list into the board with "list 1" name
    And I go to home page
    When I click add card button into a list called "list 1" of the board called "boardtest"
    And I write a title "This is a title test" for this card
    And I should see my created card in the list with the title "This is a title test"

  Scenario: Edit Card
    And I click on the card with title "This is a title test"
    And I enter "This is a description test" description and "This is a comment test" comment
    Then I should be able to see the badges
