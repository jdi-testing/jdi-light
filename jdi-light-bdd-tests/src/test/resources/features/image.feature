Feature: image

Background:
  Given I should be login

Scenario: Check image source
  Given I open "Html5 Page"
  Then source of image "Jdi Logo" is "https://jdi-testing.github.io/jdi-light/images/jdi-logo.jpg"

  Scenario: Check image alt attribute
    Given I open "Html5 Page"
    Then image "Jdi Logo" alt attribute is "Jdi Logo 2"

  Scenario: Click at image and accept Alert
    Given I open "Html5 Page"
    When click at image "Jdi Logo"
    Then check Alert text is "JDI Logo"
    And accept Alert

  Scenario: Image validation test
    Given I open "Html5 Page"
    And I refresh webpage
    Then image source of "Jdi Logo" contains "jdi-logo.jpg"
    And image "Jdi Logo" alt attribute is "Jdi Logo 2"
    And image "Jdi Logo" height is 100
    And image "Jdi Logo" width is 101

  Scenario: Check image alt
    Given I open "Html5 Page"
    Then "Jdi Logo" alt is "Jdi Logo 2"

  Scenario: Do base validation
    Given I open "Html5 Page"
    Then Base validation of "Jdi Logo"
