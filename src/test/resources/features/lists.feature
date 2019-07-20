Feature: Lists
  Scenario: Add a list in empty board
    Given I login as "joseccb" user with password "Control123"
    And a board is created
    #And I am in empty board
    When I click add a list button
    And I set the list title
      | title    | Myt First List |
    Then I validate the new list is "Myt First List"
    #TODO: additional validations

  Scenario: Edit a list
    Given I login as "joseccb" user with password "Control123"
    And a board is created
    And I click add a list button
    And I set the list title
      | title    | Myt First List |
    When I click the list name "Myt First List"
    And I set a new list title "Edited list"
    Then I validate the new title is "Edited list"
    #TODO: additional validations

  Scenario: Archive a List
    Given I login as "joseccb" user with password "Control123"
    And a board is created
    And I click add a list button
    And I set the list title
      | title    | Myt First List |
    When I click the list actions button
    And I select Archive This List
    Then I validate the list named "Myt First List" is archived
    #TODO: refactor ListActions and board's method isListElementVisible
    #TODO: Add validations

  Scenario: Move a List
    Given I login as "joseccb" user with password "Control123"
    And a board is created
    And I click add a list button
    And I set the list title
      | title    | My List1 |
    And I click add a list button
    And I set the list title
      | title    | My List2 |
    When I move "My List1" to "My List2"
    Then I validate "My List1" is in new position