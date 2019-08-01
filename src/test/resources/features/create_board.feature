Feature: Trello board
  Background:
    Given I login as "owner"

  Scenario: Create a board
    When I open the board creation form
    And I fill the board form with:
      | title   | MyBoardTestZZZ |
      | team    | No team     |
      | privacy | Private     |
      | image   | red       |
    And I capture the board ID
    Then I validate that board "MyBoardTestZZZ" is in its boards details page
    And I validate that board "MyBoardTestZZZ" is in boards details page at "Recent Boards" list
    And I validate that board "MyBoardTestZZZ" is in boards page at "Recently Viewed" list
    And I validate that board "MyBoardTestZZZ" is in boards page at the team list "Personal Boards"
    And I validate that board "MyBoardTestZ" is in home page at "Recently Viewed" list