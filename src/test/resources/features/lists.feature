Feature: Lists
  Background: User is in Board
    Given I login as "joseccb" user with password "Control123"
    And a board is created

  Scenario: Add a list in empty board
    #And I am in empty board
    When I click add a list button
    And I set the list title
      | title    | My First List |
    Then I validate the new list is "My First List"
    #TODO: additional validations

  Scenario: Edit a list
    Given I click add a list button
    And I set the list title
      | title    | My First List |
    When I click the list name "My First List"
    And I set a new list title "Edited list"
    Then I validate the new title is "Edited list"
    #TODO: additional validations

  Scenario: Archive a List
    Given I click add a list button
    And I set the list title
      | title    | My First List |
    When I click the actions button in the list "My First List"
    And I select the action list "Archive This List"
    Then I validate the list named "My First List" is archived
    #TODO: refactor ListActions and board's method isListElementVisible
    #TODO: Add validations

  Scenario: Move a List
    Given I click add a list button
    And I set the list title
      | title    | My List1 |
    And I set the list title
      | title    | My List2 |
    When I click the actions button in the list "My List1"
    And I select the action list "Move List"
    And I select the position "2"
    Then I validate "My List2" is before "My List1"