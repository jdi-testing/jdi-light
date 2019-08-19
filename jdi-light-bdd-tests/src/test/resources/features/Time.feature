Feature: DateTimeSelector, INPUT TYPE TIME

  Scenario: Get date value test
    Given I open "Html5 Page"
    Then "Booking Time" value is "11:00"

  Scenario: Get label of input type datetime test
    Given I open "Html5 Page"
    Then "Booking Time" label is "Booking Time:"

  Scenario: Get attribute "min" and "max" of input type datetime test
    Given I open "Html5 Page"
    Then "Booking Time" min is "9:00"
    And  "Booking Time" max is "18:00"

  Scenario: Date validation test with ignoring case test
    Given I open "Html5 Page"
    And "Booking Time" is enabled
    And "Booking Time" date is "11:00"

  Scenario: Label validation test
    Given I open "Html5 Page"
    Then "Booking Time" label is "Booking Time:"
    And "Booking Time" label ignoring case is "booking Time:"

  Scenario: Date assertion input type datetime contains year test
    Given I open "Html5 Page"
    Then "Booking Time" contains "11" value

  Scenario: Base validation test
    Given I open "Html5 Page"
    Then I make base validation "Booking Time" input

  Scenario: Set date
    Given I open "Html5 Page"
    Then "Booking Time" value is "11:00"
    Then I set date "05:00" in "Booking Time"
    Then "Booking Time" value is "05:00"





