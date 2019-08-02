Feature: Create Team
  Background:
    Given I login as "owner"

  Scenario: Create Team From Dashboards
    When I Create a "XXXGP" Team with "Description" from Dashboards
    Then I validate that "XXXGP" Team is loaded
    And I validate that "XXXGP" Team is listed in TEAMS section of sidebar
    And I Delete "XXXGP" Team from Home Dashboards - Side Bar

  Scenario: Create Team From Header + Button
    When I Create a "GPXXX" Team with "Description" from Header
    Then I validate that "GPXXX" Team is loaded
    And I validate that "GPXXX" Team is listed in TEAMS section of sidebar
    And I Delete "GPXXX" Team from Home Dashboards - Side Bar
