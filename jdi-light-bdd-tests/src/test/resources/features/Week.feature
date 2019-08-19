Feature: DateTimeSelector, INPUT TYPE WEEK

  Scenario: Get date value test
    Given I open "Html5 Page"
    Then "Autumn Week" value is "2018-W40"

  Scenario: Get label of input type datetime test
    Given I open "Html5 Page"
    Then "Autumn Week" label is "Autumn"

  Scenario: Get attribute "min" and "max" of input type datetime test
    Given I open "Html5 Page"
    Then "Autumn Week" min is "2018-W35"
    And  "Autumn Week" max is "2018-W48"

  Scenario: Date validation test
    Given I open "Html5 Page"
    And "Autumn Week" is enabled
    And "Autumn Week" date is "2018-W40"

  Scenario: Label validation test
    Given I open "Html5 Page"
    Then "Autumn Week" label is "Autumn"
    And "Autumn Week" label ignoring case is "autumn"

  Scenario: Date assertion input type datetime contains year test
    Given I open "Html5 Page"
    Then "Autumn Week" contains "W40" value

  Scenario: Base validation test
    Given I open "Html5 Page"
    Then I make base validation "Autumn Week" element

  Scenario: Set date
    Given I open "Html5 Page"
    Then "Autumn Week" value is "2018-W40"
    Then I set date "2018-W12" in "Autumn Week"
    Then "Autumn Week" value is "2018-W12"





