@Image
Feature: Image

Background:
  Given I should be logged in

Scenario: Check image source
  Given I open "Html5 Page"
  Then the "Jdi Logo" attribute "src" equals to "https://jdi-testing.github.io/jdi-light/images/jdi-logo.jpg"

  Scenario: Check image alt attribute
    Given I open "Html5 Page"
    Then the "Jdi Logo" attribute "alt" equals to "Jdi Logo 2"

@fail
  Scenario: Click at image and accept Alert
    Given I open "Html5 Page"
    When Click on "Jdi Logo"
    Then Alert text equals to "JDI Logo"

  Scenario: Image validation test
    Given I open "Html5 Page"
    And Refresh webpage
    Then the "Jdi Logo" attribute "src" contains "jdi-logo.jpg"
    And the "Jdi Logo" attribute "height" contains "100"
    And the "Jdi Logo" attribute "width" contains "101"

  Scenario: Do base validation
    Given I open "Html5 Page"
    Then the "Jdi Logo" is basically valid
