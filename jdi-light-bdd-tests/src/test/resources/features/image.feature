Feature: image

Background:
  Given I should be logged in

Scenario: Check image source
  Given I open "Html5 Page"
  Then "Jdi Logo" attribute "src" equals to "https://jdi-testing.github.io/jdi-light/images/jdi-logo.jpg"

  Scenario: Check image alt attribute
    Given I open "Html5 Page"
    Then "Jdi Logo" attribute "alt" equals to "Jdi Logo 2"

  Scenario: Click at image and accept Alert
    Given I open "Html5 Page"
    When Click on "Jdi Logo"
    Then Alert text equals to "JDI Logo"
    And Accept alert

  Scenario: Image validation test
    Given I open "Html5 Page"
    And Refresh webpage
    Then "Jdi Logo" attribute "src" contains "jdi-logo.jpg"
    And "Jdi Logo" attribute "height" contains "100"
    And "Jdi Logo" attribute "width" contains "101"

  Scenario: Do base validation
    Given I open "Html5 Page"
    Then "Jdi Logo" is basically valid
