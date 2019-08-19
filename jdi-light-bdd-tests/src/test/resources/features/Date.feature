Feature: DateTimeSelector, INPUT TYPE DATE

  Scenario: Get date value test
    Given I open "Html5 Page"
    Then "Birth Date" value is "1985-06-18"

  Scenario: Get label of input type datetime test
    Given I open "Html5 Page"
    Then "Birth Date" label is "Birth date"

  Scenario: Get attribute "min" and "max" of input type datetime test
    Given I open "Html5 Page"
    Then "Birth Date" min is "1970-01-01"
    And  "Birth Date" max is "2030-12-31"

  Scenario: Date validation test
    Given I open "Html5 Page"
    And "Birth Date" is enabled
    And "Birth Date" date is "1985-06-18"

  Scenario: Label validation test
    Given I open "Html5 Page"
    Then "Birth Date" label is "Birth date"
    And "Birth Date" label contains "Birth"

  Scenario: Date assertion input type datetime contains year test
    Given I open "Html5 Page"
    Then "Birth Date" contains "1985" value

  Scenario: Base validation test
    Given I open "Html5 Page"
    Then I make base validation "Birth Date" element

  Scenario: Set date
    Given I open "Html5 Page"
    Then "Birth Date" value is "1985-06-18"
    Then I set date "2018-11-13" in "Birth Date"
    Then "Birth Date" value is "2018-11-13"





