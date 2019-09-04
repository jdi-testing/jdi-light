@baselocator
Feature: BaseUIElementLocator

  Scenario: click element
    Given I logged in with name "Roman" and password "Jdi1234"
    And I open page by url "https://jdi-testing.github.io/jdi-light/html5.html"
    When I Click on "[value*='Red Button']" element
    Then the Alert text equals to "Red button"

  Scenario: jsClick element
    And I open page by url "https://jdi-testing.github.io/jdi-light/html5.html"
    When Click with JS on "[value*='Red Button']" element
    Then the Alert text equals to "Red button"

  Scenario: value element
    And I open page by url "https://jdi-testing.github.io/jdi-light/html5.html"
    Then the "[value*='Red Button']" element text equals to "Big Red Button-Input"

  Scenario: sendKeys element
    And I open page by url "https://jdi-testing.github.io/jdi-light/html5.html"
    When I send keys "simple 1234" to "#name[placeholder='Input name']" element
    Then the "#name[placeholder='Input name']" element text matches to "\w{6} \d{4}"

  Scenario: check element
    And I open page by url "https://jdi-testing.github.io/jdi-light/html5.html"
    When check "#accept-conditions" element
    Then the "#accept-conditions" element is selected

  Scenario: uncheck element
    And I open page by url "https://jdi-testing.github.io/jdi-light/html5.html"
    When uncheck "#accept-conditions" element
    Then the "#accept-conditions" element is deselected

  Scenario: clear element
    And I open page by url "https://jdi-testing.github.io/jdi-light/html5.html"
    When clear "#name[placeholder='Input name']" element
    When send keys "simple text" to "#name[placeholder='Input name']" element
    Then the "#name[placeholder='Input name']" element text equals to "simple text"
    When I clear "#name[placeholder='Input name']" element
    Then the "#name[placeholder='Input name']" element text equals to ""

  Scenario: css element
    And I open page by url "https://jdi-testing.github.io/jdi-light/html5.html"
    Then the "#name[placeholder='Input name']" element css "font-size" equals to "14px"

  Scenario: input element
    And I open page by url "https://jdi-testing.github.io/jdi-light/html5.html"
    When clear "#name[placeholder='Input name']" element
    When send keys "simple text" to "#name[placeholder='Input name']" element
    Then the "#name[placeholder='Input name']" element text equals to "simple text"
    When input "Input text" in "#name[placeholder='Input name']" element
    Then the "#name[placeholder='Input name']" element text equals to "Input text"

  Scenario: placeholder element
    And I open page by url "https://jdi-testing.github.io/jdi-light/html5.html"
    Then the "#name[placeholder='Input name']" element placeholder equals to "Input name"

  Scenario: getValue element
    And I open page by url "https://jdi-testing.github.io/jdi-light/html5.html"
    When input "simple text" in "#name[placeholder='Input name']" element
    Then the "#name[placeholder='Input name']" element text equals to "simple text"

  Scenario: getText element
    And I open page by url "https://jdi-testing.github.io/jdi-light/html5.html"
    Then the "#blue-button" element text equals to "BIG BLUE BUTTON"

  Scenario: getAttribute element
    And I open page by url "https://jdi-testing.github.io/jdi-light/html5.html"
    Then the "#disabled-name" element attribute "id" equals to "disabled-name"

  Scenario: isEnabled element
    And I open page by url "https://jdi-testing.github.io/jdi-light/html5.html"
    Then the "#name[placeholder='Input name']" element is enabled

  Scenario: isDisabled element
    And I open page by url "https://jdi-testing.github.io/jdi-light/html5.html"
    Then the "#disabled-name" element is disabled

  Scenario: isHidden element
    And I open page by url "https://jdi-testing.github.io/jdi-light/html5.html"
    Then the ".fa-sign-out" element is hidden

  Scenario: element does not appear
    And I open page by url "https://jdi-testing.github.io/jdi-light/html5.html"
    Then the ".fa-sign-out" element does not appear

  Scenario: isDisplayed element
    And I open page by url "https://jdi-testing.github.io/jdi-light/html5.html"
    Then the "#name[placeholder='Input name']" element is displayed

  Scenario: setText element
    And I open page by url "https://jdi-testing.github.io/jdi-light/html5.html"
    When input "simple text" in "#name[placeholder='Input name']" element
    Then the "#name[placeholder='Input name']" element text equals to "simple text"
    When set text "Input text" in "#name[placeholder='Input name']" element
    Then the "#name[placeholder='Input name']" element text equals to "Input text"
#@fail
#  Scenario: select element
#    And I open page by url "https://jdi-testing.github.io/jdi-light/html5.html"
#    When select "Pirate" field from "#dress-code" element
#    Then the "#dress-code" element text equals to "Pirate"