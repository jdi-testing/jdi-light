@text
Feature: Text

  Scenario: Get text test
    Given I open "Html5 Page"
    Then the "Jdi Text" text equals to "Powerful Framework for UI Tests Automation. Suitable for any UI project: Web(Html5, Angular, React...), Mobile(Android IOs), Desktop(Win app) etc."

  Scenario: Text validation test
    Given I open "Html5 Page"
    Then the "Jdi Text" is enabled
      And the "Jdi Text" is displayed
      And the "Jdi Text" text contains "Powerful Framework for UI"
      And the "Jdi Text" text matches to ".+"
      And the "Jdi Text" css "font-size" equals to "14px"
      And the "Jdi Text" css "font-family" contains "Source Sans Pro"
      And the "Jdi Text" css "font-family" matches to "(.*)sans-serif"
