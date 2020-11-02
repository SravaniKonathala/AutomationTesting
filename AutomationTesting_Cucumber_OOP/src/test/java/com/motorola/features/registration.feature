Feature: Test the New User Registration and Login Functionality

  Background:
    Given I launch the browser "chrome"
    And I Open this URL  "http://automationpractice.com/index.php"
    When I Click on the 'Sign in' button.

  @registration
  Scenario Outline: Automate User Registration Process
    And I Enter email address in the 'CREATE AN ACCOUNT' section for "<user>".
    And I Click on Create an Account button.
    And I Enter Personal Information, Address, and Contact info for "<user>".
    And I Click on the Register button.
    Then I Validate that the user is created.
    And I quit the browser.
    Examples:
      | user   |
      | happe|

    @invalidUser
    Scenario Outline: Verify invalid email address error.

      When I Enter invalid "<email>" address in the email box and click enter.
      Then I Validate that an error message is displaying saying "Invalid email address."
      And I quit the browser.

      Examples:
        | email        |
        |abc@gmail     |
        |xyz@gmail     |

  @emptyRegistration
  Scenario Outline: Verify error messages for mandatory fields.

    When I Enter a valid "<email>" address and click on Create an Account button.
    And  I Leave the mandatory fields (marked with *) blank and click the Register button.
    Then I Verify that "<errorMessage>" has been displayed only for the mandatory fields.
    And I quit the browser.
    Examples:
      | email            |errorMessage            |
      |sravani@gmail.com |   There are 8 errors   |

  @invalidDataRegistration
  Scenario Outline:
    When I Enter a valid "<email>" address and click on Create an Account button.
    And I Enter incorrect values in fields like enter numbers in first name "<firstName>" and last name "<lastName>", alphabets in Mobile no "<MobileNo>", invalid Zip postal code "<zipcode>" , "<address>", "<city>"and click on the 'Register' button.
    Then I Verify that error messages for respective fields are displaying.
    And I quit the browser.
    Examples:
      | email             |firstName|lastName |MobileNo|zipcode|address|city|
      | sravani@gmail.com |123456   |456789   |asbdgcc |ig11nh |#######|london|