@month
Feature: DateTimeSelector, INPUT TYPE MONTH

  Scenario: Get date value test
    Given I open "Html5 Page"
    Then the "Month Date" text equals to "2018-05"

  Scenario: Get label of input type datetime test
    Given I open "Html5 Page"
    Then the "Month Date" label text equals to "Month of Holidays"

  Scenario: Get attribute "min" of input type datetime test
    Given I open "Html5 Page"
    Then the "Month Date" min equals to "2015-03"

  Scenario: Get attribute "max" of input type datetime test
    Given I open "Html5 Page"
    Then the "Month Date" max equals to "2020-12"

  Scenario: Date validation test
    Given I open "Html5 Page"
    Then the "Month Date" is enabled
    Then the "Month Date" text contains "05"

  Scenario: Label validation test
    Given I open "Html5 Page"
    Then the "Month Date" label text equals to "Month of Holidays"
    Then the "Month Date" label text contains "Holidays"

  Scenario: Date contains text test
    Given I open "Html5 Page"
    Then the "Month Date" text contains "2018"

  Scenario: Set date
    Given I open "Html5 Page"
    Then the "Month Date" text equals to "2018-05"
    When I set date "2018-10" in the "Month Date"
    Then the "Month Date" text equals to "2018-10"

  Scenario: Base validation test
    Given I open "Html5 Page"
    Then the "Month Date" is basically valid
