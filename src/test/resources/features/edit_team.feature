Feature: Edit Team
  Background:
    Given I login as "owner"
    And I Create a "XXXGPa" Team with "Description" from Dashboards

  Scenario: Edit Team Name and Description From Home Dashboards - Side Bar
    When I edit "XXXGPa" Team updating "NewName" as Name and "New Description" as description
    Then I validate updated Team name is "NewName"
    And I validate updated Team description is "New Description"
    And I Delete "NewName" Team from Home Dashboards - Side Bar