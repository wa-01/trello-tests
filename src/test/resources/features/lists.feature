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