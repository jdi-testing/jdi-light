@Week
Feature: DateTimeSelector, INPUT TYPE WEEK

  Scenario: Get date value test
    Given I open "Html5 Page"
    Then the "Autumn Week" text equals to "2018-W40"

  Scenario: Get label of input type datetime test
    Given I open "Html5 Page"
    Then the "Autumn Week" label text equals to "Autumn"

  Scenario: Get attribute "min" of input type datetime test
    Given I open "Html5 Page"
    Then "Autumn Week" min equals to "2018-W35"

  Scenario: Get attribute "max" of input type datetime test
    Given I open "Html5 Page"
    Then  "Autumn Week" max equals to "2018-W48"

  Scenario: Date validation test
    Given I open "Html5 Page"
    Then the "Autumn Week" is enabled
    And the "Autumn Week" text equals to "2018-W40"

  Scenario: Label validation test
    Given I open "Html5 Page"
    Then the "Autumn Week" label text equals to "Autumn"

  Scenario: Date contains text test
    Given I open "Html5 Page"
    Then the "Autumn Week" text contains "W40"

  Scenario: Set date
    Given I open "Html5 Page"
    Then the "Autumn Week" text equals to "2018-W40"
    When I Set date "2018-W12" in "Autumn Week"
    Then the "Autumn Week" text equals to "2018-W12"

  Scenario: Base validation test
    Given I open "Html5 Page"
    Then the "Autumn Week" is basically valid





