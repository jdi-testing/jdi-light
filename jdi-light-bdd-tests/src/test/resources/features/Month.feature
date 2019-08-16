Feature: DateTimeSelector, INPUT TYPE MONTH

Scenario: input type month test
  Given I see input type week on the page
  Given I see date in input type week "2018-05"
  And label of input type week is "Month of Holidays"
  And I get min attribute of input type week "2015-03"
  And I get max attribute of input type week "2020-12"
  And I validate date "-05" in input type week
  And I find label by "Holidays" or "month of holidays" for input type week
  And I check that date is "05" in input type week
  Then I set date "2018-10" in input type week




