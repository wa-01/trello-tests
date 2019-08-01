Feature: Delete Team
  Background:
    Given I login as "owner"
    And I Create a "XXXGPe" Team with "Description" from Dashboards
    And I go to home from team page
    
  Scenario: Delete Team From Home Dashboards - Side Bar
    When I Delete "XXXGPe" Team from Home Dashboards - Side Bar
    Then I Validate "XXXGPe" Team is not listed in Side bar

