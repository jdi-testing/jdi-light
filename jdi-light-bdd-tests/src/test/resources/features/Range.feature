@Range
Feature: Range
  
Background: 
  Given I should be logged in
  And I open "Html5 Page" page
  And install "Volume" value to 90
  
Scenario: Check label text
  Then "Volume" label text equals to "Volume"

Scenario: Validate value test
  Then "Disabled Range" attribute "value" equals to "50"

Scenario: Validate minimum value
  Then  "Volume" attribute "min" equals to "10"

Scenario: Validate maximum value
  Then  "Volume" attribute "max" equals to "100"

Scenario: Validate step value
  Then "Volume" attribute "step" equals to "5"

Scenario: Change Volume value
  When install "Volume" value to 5
  Then "Volume" attribute "value" equals to "10"

Scenario: Validation Volume element test
  Then "Volume" is enabled
  And "Volume" attribute "min" equals to "10"
  And "Volume" attribute "max" equals to "100"
  And "Volume" attribute "step" equals to "5"
  And "Volume" attribute "value" greater or equal to 10
  And "Volume" attribute "value" less or equal to 100
  And "Volume" attribute "value" equals to "90"

Scenario: Label Test
  Then "Volume" label text equals to "Volume"
  Then "Volume" label text contains "lume"

Scenario: Validation Test
  And "Volume" attribute "value" greater or equal to 0
  And "Volume" attribute "value" less or equal to 200
  Then "Disabled Range" attribute "value" equals to "50"

Scenario: Base validation
  Then "Volume" is basically valid