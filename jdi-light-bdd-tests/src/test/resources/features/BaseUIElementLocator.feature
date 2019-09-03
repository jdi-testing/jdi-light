@baselocator
Feature: BaseUIElement

  Scenario: click element
    Given I open "Html5 Page"
    When I Click on "[value*='Red Button']" element
    Then the Alert text equals to "Red button"

  Scenario: jsClick element
    Given I open "Html5 Page"
    When Click with JS on "[value*='Red Button']" element
    Then the Alert text equals to "Red button"

  Scenario: value element
    Given I open "Html5 Page"
    Then the "[value*='Red Button']" element text equals to "Big Red Button-Input"

  Scenario: sendKeys
    Given I open "Html5 Page"
    When I send keys "simple 1234" to "input[id='name'][placeholder='Input name']" element
    Then the "input[id='name'][placeholder='Input name']" element text matches to "\w{6} \d{4}"

  Scenario: check
    Given I open "Html5 Page"
    When check "#accept-conditions" element
    Then the "#accept-conditions" element is selected