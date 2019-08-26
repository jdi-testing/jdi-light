@TextField
Feature: TextField

  Scenario: sendKeys test
    Given I open "Html5 Page"
    When I Send keys "Lorem" to "Name"
    Then "Name" value equals "Lorem"

  Scenario: setText test
    Given I open "Html5 Page"
    When I Set text "Lorem" in "Name"
    Then "Name" value equals "Lorem"

  Scenario: clear test
    Given I open "Html5 Page"
    And "Name" have "Lorem" value
    When I Clear "Name"
    Then "Name" value equals ""

  Scenario: input test
    Given I open "Html5 Page"
    When I Input "Lorem" in "Name"
    Then "Name" value equals "Lorem"

  Scenario: placeholder test
    Given I open "Html5 Page"
    Then "Name" placeholder equals to "Input name"

  Scenario: getText test
    Given I open "Html5 Page"
    And "Name" have "Lorem" value
    When I get text from "Name"
    Then "Name" text equals to "Lorem"

   Scenario: getValue test
    Given I open "Html5 Page"
    And "Name" have "Lorem" value
    When I get value from "Name"
    Then "Name" value equals to "Lorem"

  Scenario: assertThat validation test
    Given I open "Html5 Page"
    And "Name" have "Lorem" value
    Then "Name" text is "Lorem"

  Scenario: base validation test
    Given I open "Html5 Page"
    Then "Name" is basically valid