Feature: image

Background:
  Given I should be login
  And I open "Html5 Page"

Scenario: Check image source
  Then image "Jdi Logo" src is equals to "https://jdi-testing.github.io/jdi-light/images/jdi-logo.jpg"

  Scenario: Check image alt attribute
    Then image "Jdi Logo" alt attribute is equal to "Jdi Logo 2"

  Scenario: Click at image and accept Alert
    When click at image "Jdi Logo"
    Then alert text is equal to "JDI Logo"
    And accept Alert

  Scenario: Image validation test
    Given I refresh webpage
    Then image "Jdi Logo" scr contains "jdi-logo.jpg"
    And image "Jdi Logo" height is equal to 100
    And image "Jdi Logo" width is equal to 101

  Scenario: Do base validation
    Then Base validation of "Jdi Logo"
