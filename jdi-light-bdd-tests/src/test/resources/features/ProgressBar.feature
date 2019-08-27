@ProgressBar
Feature: ProgressBar

Background:
  Given I should be logged in

Scenario: check progress bar value
  Given I open "Html5 Page" page
  Then the "Progress" attribute "value" equals to "70"

Scenario: check max value of progress bar
  Given I open "Html5 Page" page
  Then the "Progress" attribute "max" equals to "100"

Scenario: progress bar validation
  Given I open "Html5 Page" page
  Then the "Progress" attribute "max" equals to "100"
  And the "Progress" progress volume greater or equal to 10
  And the "Progress" progress volume less or equal to 100
  And the "Progress" attribute "value" equals to "70"
  And the "Progress" is enabled

Scenario: label test
  Given I open "Html5 Page" page
  Then the "Progress" label text equals to "File progress"
  And the "Progress" label text contains "progress"

Scenario: base validation test
  Given I open "Html5 Page" page
  Then the "Progress" is basically valid