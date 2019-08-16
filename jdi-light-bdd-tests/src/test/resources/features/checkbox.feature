Feature: Checkbox

  Scenario: Set and get checkbox values
    Given I open "Contact Form Page"

    When Set "Passport" checkbox to "true"
    Then "Passport" checkbox is "1"

    When Set "Passport" checkbox to "0"
    Then "Passport" checkbox is "false"

    And "Accept Conditions" checkbox is "0"

    When Set "Accept Conditions" checkbox to "1"
    Then "Accept Conditions" checkbox is "1"
