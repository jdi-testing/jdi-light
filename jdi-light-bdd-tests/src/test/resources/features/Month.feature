Feature: DateTimeSelector, INPUT TYPE MONTH

  Scenario: Get date value test
    Given I open "Html5 Page"
    Then "Month Date" value is "2018-05"

  Scenario: Get label of input type datetime test
    Given I open "Html5 Page"
    Then "Month Date" label is "Month of Holidays"

  Scenario: Get attribute "min" and "max" of input type datetime test
    Given I open "Html5 Page"
    Then "Month Date" min is "2015-03"
    And  "Month Date" max is "2020-12"

  Scenario: Date validation test
    Given I open "Html5 Page"
    And "Month Date" is enabled
    And "Month Date" contains "05" value

  Scenario: Label validation test
    Given I open "Html5 Page"
    Then "Month Date" label contains "Holidays"
    And "Month Date" label ignoring case is "month of holidays"

  Scenario: Date assertion input type datetime contains year test
    Given I open "Html5 Page"
    Then "Month Date" contains "2018" value

  Scenario: Base validation test
    Given I open "Html5 Page"
    Then I make base validation "Month Date" element

  Scenario: Set date
    Given I open "Html5 Page"
    Then "Month Date" value is "2018-05"
    Then I set date "2018-10" in "Month Date"
    Then "Month Date" value is "2018-10"




