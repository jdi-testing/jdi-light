@text
Feature: Text

  Scenario: Get text test
    Given I open "Html5 Page"
    Then the "Jdi Text" text equals to "Powerful Framework for UI Tests Automation. Suitable for any UI project: Web(Html5, Angular, React...), Mobile(Android IOs), Desktop(Win app) etc."

  Scenario: Text validation test
    Given I open "Html5 Page"
    Then the "Jdi Text" is enabled
    Then the "Jdi Text" is displayed
    Then the "Jdi Text" text contains "Powerful Framework for UI"
    Then the "Jdi Text" text matches to ".+"
    Then the "Jdi Text" css "font-size" equals to "14px"
    Then the "Jdi Text" css "font-family" contains "Source Sans Pro"
    Then the "Jdi Text" css "font-family" matches to "(.*)sans-serif"

  Scenario: Base validation test
    Given I open "Html5 Page"
    Then the "Jdi Text" is basically valid





