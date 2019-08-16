Feature: DateTimeSelector, INPUT TYPE DATETIME-LOCAL

Scenario: input type datetime test
  Given I see "Party Time" input type datetime on the page
  Then I see date "2018-06-12T19:30" in "Party Time"
  And label of DateTimeSelector is "Date/time:" in "Party Time"
  And I get attribute with name min "2018-05-07T00:00" in "Party Time"
  And I get attribute with name max "2018-06-14T00:00" in "Party Time"
  Then I validate date "2018-06-12t19:30" in "Party Time"
  And I find label by "Date/time:" or "date/time:" in "Party Time"
  And I check that date is "2018" in "Party Time"
  Then I set date "2017-05-10T00:00" in "Party Time"




