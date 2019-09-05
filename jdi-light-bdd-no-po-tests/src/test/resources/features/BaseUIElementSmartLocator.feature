@basesmartlocator
Feature: BaseUIElementLocator
  Background:
    Given I logged in with name "Roman" and password "Jdi1234"
    And I open page by url "https://jdi-testing.github.io/jdi-light/html5.html"

  Scenario: click element
    When I Click on "Red Button" element
    Then the Alert text equals to "Red button"

  Scenario: jsClick element
    When Click with JS on "Red Button" element
    Then the Alert text equals to "Red button"

  Scenario: value element
    Then the "Red Button" element text equals to "Big Red Button-Input"

  Scenario: labelText
    Then the "Name" element label text equals to "Your name:"

  Scenario: sendKeys element
    When I send keys "simple 1234" to "Name" element
    Then the "Name" element text matches to "\w{6} \d{4}"

  Scenario: check element
    When check "Accept Conditions" element
    Then the "Accept Conditions" element is selected

  Scenario: uncheck element
    When uncheck "Accept Conditions" element
    Then the "Accept Conditions" element is deselected

  Scenario: clear element
    When clear "Name" element
    And send keys "simple text" to "Name" element
    Then the "Name" element text equals to "simple text"
    When I clear "Name" element
    Then the "Name" element text equals to ""

  Scenario: css element
    Then the "Name" element css "font-size" equals to "14px"

  Scenario: input element
    When clear "Name" element
    And send keys "simple text" to "Name" element
    Then the "Name" element text equals to "simple text"
    When input "Input text" in "Name" element
    Then the "Name" element text equals to "Input text"

  Scenario: placeholder element
    Then the "Name" element placeholder equals to "Input name"

  Scenario: getValue element
    When input "simple text" in "Name" element
    Then the "Name" element text equals to "simple text"

  Scenario: getText element
    Then the "Blue Button" element text equals to "BIG BLUE BUTTON"

  Scenario: getAttribute element
    Then the "Disabled Name" element attribute "id" equals to "disabled-name"

  Scenario: isEnabled element
    Then the "Name" element is enabled

  Scenario: isDisabled element
    Then the "Disabled Name" element is disabled

  Scenario: isHidden element
    Then the "Logout" element is hidden

  Scenario: element does not appear
    Then the "Logout" element does not appear

  Scenario: isDisplayed element
    Then the "Name" element is displayed

  Scenario: setText element
    When input "simple text" in "Name" element
    Then the "Name" element text equals to "simple text"
    When set text "Input text" in "Name" element
    Then the "Name" element text equals to "Input text"
#@fail
#  Scenario: select element
#    When select "Pirate" field from "#dress-code" element
#    Then the "#dress-code" element text equals to "Pirate"