@checkbox
Feature: Checkbox

  Scenario: Get label text test
    Given I open "Html5 Page"
    When I Check "Accept Conditions"
    Then the "Accept Conditions" label text equals to "Accept terms and conditions"

  Scenario: Check test
    Given I open "Html5 Page"
    When I Check "Accept Conditions"
    When I Check "Accept Conditions"
    Then the "Accept Conditions" is selected

  Scenario: Uncheck test
    Given I open "Html5 Page"
    When I Check "Accept Conditions"
    When I Uncheck "Accept Conditions"
    Then the "Accept Conditions" is deselected

  Scenario: Click test
    Given I open "Html5 Page"
    When I Check "Accept Conditions"
    Then the "Accept Conditions" is selected
    When I Click on "Accept Conditions"
    Then the "Accept Conditions" is deselected

  Scenario: Is validation test
    Given I open "Html5 Page"
    When I Check "Accept Conditions"
    Then the "Accept Conditions" is selected
    When I Click on "Accept Conditions"
    Then the "Accept Conditions" is deselected
    Then the "Accept Conditions" is enabled
    Then the "Accept Conditions" is displayed

  Scenario: Label test
    Given I open "Html5 Page"
    When I Check "Accept Conditions"
    Then the "Accept Conditions" label text equals to "Accept terms and conditions"
    Then the "Accept Conditions" label text contains "terms and conditions"

  Scenario: Assert validation test
    Given I open "Html5 Page"
    When I Check "Accept Conditions"
    Then the "Accept Conditions" is basically valid