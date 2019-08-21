Feature: DateTimeSelector, INPUT TYPE WEEK

  Scenario: Get date value test
    Given I open "Html5 Page"
    Then "Autumn Week" text equals to "2018-W40"

  Scenario: Get label of input type datetime test
    Given I open "Html5 Page"
    Then "Autumn Week" label text equals to "Autumn"

  Scenario: Get attribute "min" and "max" of input type datetime test
    Given I open "Html5 Page"
    Then "Autumn Week" attribute min equals to "2018-W35"
    And  "Autumn Week" attribute max equals to "2018-W48"

  Scenario: Date validation test
    Given I open "Html5 Page"
    And "Autumn Week" is enabled
    And "Autumn Week" text equals to "2018-W40"

  Scenario: Label validation test
    Given I open "Html5 Page"
    Then "Autumn Week" label text equals to "Autumn"

  Scenario: Date contains text test
    Given I open "Html5 Page"
    Then "Autumn Week" text contains "W40"

  Scenario: Set date
    Given I open "Html5 Page"
    Then "Autumn Week" text equals to "2018-W40"
    Then I Set date "2018-W12" in "Autumn Week"
    Then "Autumn Week" text equals to "2018-W12"

  Scenario: Base validation test
    Given I open "Html5 Page"
    Then "Autumn Week" is basically valid





