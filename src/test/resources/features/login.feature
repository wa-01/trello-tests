Feature: login
  Scenario: login and start a session

    Given I login as "luiscachi" user with password "Control123"
    Then I verify the user "luiscachi" is in member button