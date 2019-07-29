Feature: Team
  Background:
    Given I login as "owner"

  Scenario: Create Team From Dashboards
    When I Create a "XXXGP" Team with "Description" from Dashboards
    Then I validate that "XXXGP" Team is loaded
    And I validate that "XXXGP" Team is listed in TEAMS section of sidebar