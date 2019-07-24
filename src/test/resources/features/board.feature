Feature: Trello board
  Background:
    Given I login as "brosas1" user with password "Control123."

  Scenario: Create a board
    When I open the board creation form.
    And I fill the board form with:
      | Title   | MyBoardTest |
      | account | account1    |
      | privacy | public      |
    Then I validate that board "MyBoardTest" is in Boards page