Feature: Login

  Scenario: Verify the user is logged successfully
    Given I login as "owner"
    Then I verify the user "owner" is in member button

  Scenario: Verify an invalid user is not logged
    Given I login as "no_password"
    Then I verify invalid password message is displayed "Invalid password"
    And I verify the url is login page


  Scenario: Verify in not logged with empty credentials
    Given I login as "empty_credential"
    Then I verify invalid password message is displayed "Missing email"
    And I verify the url is login page

  Scenario: Verify an invalid password credential is not logged
    Given I login as "invalid_pw"
    Then I verify invalid password message is displayed "Invalid password"
    And I verify the url is login page

  Scenario: Verify is not logged when the email field is empty
    Given I login as "no_email"
    Then I verify invalid password message is displayed "Missing email"
    And I verify the url is login page

