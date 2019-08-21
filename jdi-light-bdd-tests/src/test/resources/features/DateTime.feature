Feature: DateTimeSelector, INPUT TYPE DATETIME-LOCAL

  Scenario: Get date value test
    Given I open "Html5 Page"
    Then "Party Time" text equals to "2018-06-12T19:30"

  Scenario: Get label of input type datetime test
    Given I open "Html5 Page"
    Then "Party Time" label text equals to "Date/time:"

  Scenario: Get attribute "min" of input type datetime test
    Given I open "Html5 Page"
    Then "Party Time" attribute min equals to "2018-05-07T00:00"
    Then "Party Time" attribute max equals to "2018-06-14T00:00"

  Scenario: Get attribute "max" of input type datetime test
    Given I open "Html5 Page"
    Then  "Party Time" attribute max equals to "2018-06-14T00:00"

  Scenario: Date validation test
    Given I open "Html5 Page"
    And "Party Time" is enabled
    And "Party Time" text equals to "2018-06-12T19:30"

  Scenario: Label validation test
    Given I open "Html5 Page"
    Then "Party Time" label text equals to "Date/time:"
    And "Party Time" label text contains "time:"

  Scenario: Date contains text test
    Given I open "Html5 Page"
    Then "Party Time" text contains "2018"

  Scenario: Set date
    Given I open "Html5 Page"
    And "Party Time" text equals to "2018-06-12T19:30"
    Then I Set date "2017-05-10T00:00" in "Party Time"

  Scenario: Base validation test
    Given I open "Html5 Page"
    Then "Party Time" is basically valid

