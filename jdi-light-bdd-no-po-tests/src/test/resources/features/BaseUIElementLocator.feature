@baselocator
Feature: BaseUIElementLocator
  Background:
    Given I logged in with name "Roman" and password "Jdi1234"
    And I open page by url "https://jdi-testing.github.io/jdi-light/html5.html"

  Scenario: click element
    When I Click on "[value*='Red Button']" element
    Then the Alert text equals to "Red button"

  Scenario: jsClick element
    When Click with JS on "[value*='Red Button']" element
    Then the Alert text equals to "Red button"

  Scenario: value element
    Then the "[value*='Red Button']" element text equals to "Big Red Button-Input"

  Scenario: sendKeys element
    When I send keys "simple 1234" to "#name[placeholder='Input name']" element
    Then the "#name[placeholder='Input name']" element text matches to "\w{6} \d{4}"

  Scenario: check element
    When check "#accept-conditions" element
    Then the "#accept-conditions" element is selected

  Scenario: uncheck element
    When uncheck "#accept-conditions" element
    Then the "#accept-conditions" element is deselected

  Scenario: clear element
    When clear "#name[placeholder='Input name']" element
    And send keys "simple text" to "#name[placeholder='Input name']" element
    Then the "#name[placeholder='Input name']" element text equals to "simple text"
    When I clear "#name[placeholder='Input name']" element
    Then the "#name[placeholder='Input name']" element text equals to ""

  Scenario: css element
    Then the "#name[placeholder='Input name']" element css "font-size" equals to "14px"

  Scenario: input element
    When clear "#name[placeholder='Input name']" element
    And send keys "simple text" to "#name[placeholder='Input name']" element
    Then the "#name[placeholder='Input name']" element text equals to "simple text"
    When input "Input text" in "#name[placeholder='Input name']" element
    Then the "#name[placeholder='Input name']" element text equals to "Input text"

  Scenario: placeholder element
    Then the "#name[placeholder='Input name']" element placeholder equals to "Input name"

  Scenario: getValue element
    When input "simple text" in "#name[placeholder='Input name']" element
    Then the "#name[placeholder='Input name']" element text equals to "simple text"

  Scenario: getText element
    Then the "#blue-button" element text equals to "BIG BLUE BUTTON"

  Scenario: getAttribute element
    Then the "#disabled-name" element attribute "id" equals to "disabled-name"

  Scenario: isEnabled element
    Then the "#name[placeholder='Input name']" element is enabled

  Scenario: isDisabled element
    Then the "#disabled-name" element is disabled

  Scenario: isHidden element
    Then the ".fa-sign-out" element is hidden

  Scenario: element does not appear
    Then the ".fa-sign-out" element does not appear

  Scenario: isDisplayed element
    Then the "#name[placeholder='Input name']" element is displayed

  Scenario: setText element
    When input "simple text" in "#name[placeholder='Input name']" element
    Then the "#name[placeholder='Input name']" element text equals to "simple text"
    When set text "Input text" in "#name[placeholder='Input name']" element
    Then the "#name[placeholder='Input name']" element text equals to "Input text"
#@fail
#  Scenario: select element
#    When select "Pirate" field from "#dress-code" element
#    Then the "#dress-code" element text equals to "Pirate"