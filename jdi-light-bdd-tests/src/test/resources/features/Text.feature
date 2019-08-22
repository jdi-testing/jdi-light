@Text
Feature: Text

  Scenario: Get text test
    Given I open "Html5 Page"
    Then "Jdi Text" text equals to "Powerful Framework for UI Tests Automation. Suitable for any UI project: Web(Html5, Angular, React...), Mobile(Android IOs), Desktop(Win app) etc."

  Scenario: Text validation test
    Given I open "Html5 Page"
    Then "Jdi Text" is enabled
    Then "Jdi Text" text contains "Powerful Framework for UI"

  Scenario: Base validation test
    Given I open "Html5 Page"
    Then "Jdi Text" is basically valid



