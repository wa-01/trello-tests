Feature: Login

  Scenario: Verify the user is logged successfully
    Given I login as "owner"
    Then I verify the user "owner" is in member button

  Scenario Outline: Verify an invalid user is not logged
    Given I login as "<user>"
    Then I verify invalid password message is displayed "<message>"
    And I verify the url is login page
    Examples:
      | user             | message          |
      | no_password      | Invalid password |
      | empty_credential | Missing email    |
      | invalid_pw       | Invalid password |
      | no_email         | Missing email    |

