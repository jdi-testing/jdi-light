@locators
Feature: TestsWithLocators
  Background:
    Given Page with url "https://jdi-testing.github.io/jdi-light/html5.html" opened

  Scenario: click element
    When I click on "[value*='Red Button']"
    Then the Alert text equals to "Red button"

  Scenario: jsClick element
    When click with JS on "[value*='Red Button']"
    Then the Alert text equals to "Red button"

  Scenario: value element
    Then the "[value*='Red Button']" text equals to "Big Red Button-Input"

  Scenario: labelText
    Then the "#your-name" label text equals to "Your name:"

  Scenario: input element
    When I input "simple 1234" in "#your-name"
    Then the "#your-name" text matches to "\w{6} \d{4}"

  Scenario: check element
    When check "#accept-conditions"
    Then the "#accept-conditions" is selected

  Scenario: uncheck element
    When uncheck "#accept-conditions"
    Then the "#accept-conditions" is deselected

  Scenario: clear element
    When I input "simple text" in "#your-name"
    Then the "#your-name" text equals to "simple text"
    When I clear "#your-name"
    Then the "#your-name" text equals to ""

  Scenario: css element
    Then the "#your-name" css "font-size" equals to "14px"

  Scenario: placeholder element
    Then the "#your-name" placeholder equals to "Input name"

  Scenario: getValue element
    When input "simple text" in "#your-name"
    Then the "#your-name" text equals to "simple text"

  Scenario: getText element
    Then the "#blue-button" text equals to "BIG BLUE BUTTON"

  Scenario: getAttribute element
    Then the "#disabled-name" attribute "id" equals to "disabled-name"

  Scenario: isEnabled element
    Then the "#your-name" is enabled

  Scenario: isDisabled element
    Then the "#disabled-name" is disabled

  Scenario: isHidden element
    Then the ".logout" is hidden

  Scenario: element does not appear
    Then the ".logout" does not appear

  Scenario: isDisplayed element
    Then the "#your-name" is displayed

  Scenario: setText element
    When input "simple text" in "#your-name"
    Then the "#your-name" text equals to "simple text"
    When set text "Input text" in "#your-name"
    Then the "#your-name" text equals to "Input text"
