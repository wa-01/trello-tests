Feature: Trello board
  Background:
    Given I login as "owner"

  Scenario: Create a board
    When I open the board creation form
    And I fill the board form with:
      | title   | MyBoardTest5 |
      | team    | Test     |
      | privacy | Private     |
      | image   | blue      |
    And I capture the board ID
    Then I validate that board "MyBoardTest5" is in its boards details page
    And I validate that board "MyBoardTest5" is in boards details page at "Recent Boards" list
    And I validate that board "MyBoardTest5" is in boards page at "Recently Viewed" list
    And I validate that board "MyBoardTest5" is in boards page at the team list "Test"
    And I validate that board "MyBoardTest5" is in home page at "Recently Viewed" list
    And I go to the Board details from Board Menu with: boardID and the "Test" team
    And I close the board with boardID
    And I delete the board with boardID
    And I validate that the message "Board not found" is displayed