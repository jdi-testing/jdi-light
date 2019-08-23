Feature: TextField

  Scenario: sendKeys test
    Given I open "Html5 Page"
    When I Send keys "Lorem" to "Text Field"
    Then "Text field" value equals "Lorem"

  Scenario: setText test
    Given I open "Html5 Page"
    When I Set text "Lorem" in "Text Field"
    Then "Text field" value equals "Lorem"

  Scenario: clear test
    Given I open "Html5 Page"
    And "Text Field" have "Lorem" value
    When I Clear "Text Field"
    Then "Text field" value equals ""

  Scenario: input test
    Given I open "Html5 Page"
    When I Input "Lorem" in "Text Field"
    Then "Text field" value equals "Lorem"

  Scenario: focus test
    Given I open "Html5 Page"
    When I Focus on "Text Field"
    Then "Text Field" is focused

  Scenario: placeholder test
    Given I open "Html5 Page"
    Then "Text Field" placeholder equals to "Input name"

  Scenario: getText test
    Given I open "Html5 Page"
    And "Text Field" have "Lorem" value
    When I get text from "Text Field"
    Then "Text Field" text equals to "Lorem"

   Scenario: getValue test
    Given I open "Html5 Page"
    And "Text Field" have "Lorem" value
    When I get value from "Text Field"
    Then "Text Field" value equals to "Lorem"

  Scenario: assertThat validation test
    Given I open "Html5 Page"
    And "Text Field" have "Lorem" value
    Then "Text Field" text is "Lorem"

  Scenario: base validation test
    Given I open "Html5 Page"
    Then "Text Field" is basically valid