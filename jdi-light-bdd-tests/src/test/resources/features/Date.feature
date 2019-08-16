Feature: DateTimeSelector, INPUT TYPE DATE

Scenario: input type date test
  Given I see "partyTime" input type date on the page
  Given I see year "1985-06-18" in input type date
  And label is "Birth date" in input type date
  And I get min attribute "1970-01-01" in input type date
  And I get max attribute "2030-12-31" in input type date
  And I validate year "1985-06-18" in input type date
  And I find date label by "Birth date" or "Birth" in input type date
  And I check that year is "1985" in input type date
  Then I set year "2018-11-13" in input type date




