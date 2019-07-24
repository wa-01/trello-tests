Feature: Trello board
  Background:
    Given I login as "brayanrosas1" user with password "Control123."

  Scenario: Create a board
    When I open the board creation form
    And I fill the board form with:
      | title   | MyBoardTest |
      | team    | No team     |
      | privacy | Private     |
      | image   | blue        |
    Then I validate that board "MyBoardTest" is in Boards page
