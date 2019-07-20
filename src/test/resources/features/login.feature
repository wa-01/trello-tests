Feature: login
  Scenario: login and start a session

    Given I login as "" user with password ""
    Then I verify the user "" is in member button