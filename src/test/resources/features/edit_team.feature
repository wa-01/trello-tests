Feature: Edit Team
  Background:
    Given I login as "owner"
    And I Create a "XXXGPa" Team with "Description" from Dashboards

  Scenario: Edit Team Name and Description From Home Dashboards - Side Bar
    When I edit "XXXGPa" Team updating "NewName" as Name and "New Description" as description
    Then I validate updated Team name is "NewName"
    And I validate updated Team description is "New Description"
    And I Delete "NewName" Team from Home Dashboards - Side Bar

  Scenario: Edit Team Name and Description can be Canceled From Home Dashboards - Side Bar
    When I edit "XXXGPa" Team updating "New Name" as Name and "New Website" as description canceled
    Then I validate "XXXGPa" Team remains "XXXGPa" as Name and "Description" as Description
    And I Delete "XXXGPa" Team from Home Dashboards - Side Bar