Feature: DateTimeSelector, INPUT TYPE DATETIME-LOCAL

Scenario: Get date value test
  Given I open "Html5 Page"
  Then "Party Time" value is "2018-06-12T19:30"

Scenario: Get label of input type datetime test
  Given I open "Html5 Page"
  Then "Party Time" label is "Date/time:"

Scenario: Get attribute "min" and "max" of input type datetime test
  Given I open "Html5 Page"
  Then "Party Time" min is "2018-05-07T00:00"
  And  "Party Time" max is "2018-06-14T00:00"

Scenario: Date validation test with ignoring case test
  Given I open "Html5 Page"
  And "Party Time" is enabled
  And "Party Time" date is "2018-06-12t19:30"

Scenario: Label validation test
  Given I open "Html5 Page"
  Then "Party Time" label is "Date/time:"
  And "Party Time" label ignoring case is "date/time:"

Scenario: Date assertion input type datetime contains year test
  Given I open "Html5 Page"
  Then "Party Time" contains "2018" value

Scenario: Base validation test
  Given I open "Html5 Page"
  Then I make base validation "Party Time" input

Scenario: Set date
  Given I open "Html5 Page"
  And "Party Time" value is "2018-06-12T19:30"
  Then I set date "2017-05-10T00:00" in "Party Time"

