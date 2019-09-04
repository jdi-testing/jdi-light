@baselocator
Feature: BaseUIElementLocator

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

  Scenario: sendKeys element
    Given I open "Html5 Page"
    When I send keys "simple 1234" to "input[id='name'][placeholder='Input name']" element
    Then the "input[id='name'][placeholder='Input name']" element text matches to "\w{6} \d{4}"

  Scenario: check element
    Given I open "Html5 Page"
    When check "#accept-conditions" element
    Then the "#accept-conditions" element is selected

  Scenario: uncheck element
    Given I open "Html5 Page"
    When uncheck "#accept-conditions" element
    Then the "#accept-conditions" element is deselected

  Scenario: clear element
    Given I open "Html5 Page"
    When clear "input[id='name'][placeholder='Input name']" element
    When send keys "simple text" to "input[id='name'][placeholder='Input name']" element
    Then the "input[id='name'][placeholder='Input name']" element text equals to "simple text"
    When I clear "input[id='name'][placeholder='Input name']" element
    Then the "input[id='name'][placeholder='Input name']" element text equals to ""

  Scenario: css element
    Given I open "Html5 Page"
    Then the "input[id='name'][placeholder='Input name']" element css "font-size" equals to "14px"

  Scenario: input element
    Given I open "Html5 Page"
    When clear "input[id='name'][placeholder='Input name']" element
    When send keys "simple text" to "input[id='name'][placeholder='Input name']" element
    Then the "input[id='name'][placeholder='Input name']" element text equals to "simple text"
    When input "Input text" in "input[id='name'][placeholder='Input name']" element
    Then the "input[id='name'][placeholder='Input name']" element text equals to "Input text"

  Scenario: placeholder element
    Given I open "Html5 Page"
    Then the "input[id='name'][placeholder='Input name']" element placeholder equals to "Input name"

  Scenario: getValue element
    Given I open "Html5 Page"
    When input "simple text" in "input[id='name'][placeholder='Input name']" element
    Then the "input[id='name'][placeholder='Input name']" element text equals to "simple text"

  Scenario: getText element
    Given I open "Html5 Page"
    Then the "#blue-button" element text equals to "BIG BLUE BUTTON"

  Scenario: getAttribute element
    Given I open "Html5 Page"
    Then the "#disabled-name" element attribute "id" equals to "disabled-name"

  Scenario: isEnabled element
    Given I open "Html5 Page"
    Then the "input[id='name'][placeholder='Input name']" element is enabled

  Scenario: isDisabled element
    Given I open "Html5 Page"
    Then the "#disabled-name" element is disabled

  Scenario: isHidden element
    Given I open "Html5 Page"
    Then the ".fa-sign-out" element is hidden

  Scenario: element does not appear
    Given I open "Html5 Page"
    Then the ".fa-sign-out" element does not appear

  Scenario: isDisplayed element
    Given I open "Html5 Page"
    Then the "input[id='name'][placeholder='Input name']" element is displayed

  Scenario: setText element
    Given I open "Html5 Page"
    When input "simple text" in "input[id='name'][placeholder='Input name']" element
    Then the "input[id='name'][placeholder='Input name']" element text equals to "simple text"
    When set text "Input text" in "input[id='name'][placeholder='Input name']" element
    Then the "input[id='name'][placeholder='Input name']" element text equals to "Input text"
#@fail
#  Scenario: select element
#    Given I open "Html5 Page"
#    When select "Pirate" field from "#dress-code" element
#    Then the "Dress Code" text equals to "Pirate"