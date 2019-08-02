Feature: Trello board

  Background:
    Given I login as "owner"
    And I Create a "DeletedTeam" Team with "This is a test team that will be deleted " from Header
    And I go to home from team page
    And I open the board creation form
    And I fill the board form with:
      | title   | BoardTestDelete  |
      | team    | DeletedTeam    |
      | privacy | Private     |
      | image   | red       |
    And I capture the board ID

  Scenario: Delete Board
    When I close the board with boardID
    And I delete the board with boardID
    Then I validate that the message "Board not found" is displayed