@Date
Feature: DateTimeSelector, INPUT TYPE DATE

  Scenario: Get date value test
    Given I open "Html5 Page"
    Then the "Birth Date" text equals to "1985-06-18"

  Scenario: Get label of input type datetime test
    Given I open "Html5 Page"
    Then the "Birth Date" label text equals to "Birth date"

  Scenario: Get attribute "min" of input type datetime test
    Given I open "Html5 Page"
    Then the "Birth Date" min equals to "1970-01-01"

  Scenario: Get attribute "max" of input type datetime test
    Given I open "Html5 Page"
    Then  the "Birth Date" max equals to "2030-12-31"

  Scenario: Date validation test
    Given I open "Html5 Page"
    Then the "Birth Date" is enabled
    Then the "Birth Date" text equals to "1985-06-18"

  Scenario: Label validation test
    Given I open "Html5 Page"
    Then the "Birth Date" label text equals to "Birth date"
    Then the "Birth Date" label text contains "Birth"

  Scenario: Date contains year test
    Given I open "Html5 Page"
    Then the "Birth Date" text contains "1985"

  Scenario: Set date
    Given I open "Html5 Page"
    Then the "Birth Date" text equals to "1985-06-18"
    When I Set date "2018-11-13" in the "Birth Date"
    Then the "Birth Date" text equals to "2018-11-13"

  Scenario: Base validation test
    Given I open "Html5 Page"
    Then the "Birth Date" is basically valid
