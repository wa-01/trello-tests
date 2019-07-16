Feature: Lists
  Scenario: Add a list in empty board
    Given a board is created
    And I am in empty board
    When I click add a list button
    And I set list name "test"
    Then I see the new list in board