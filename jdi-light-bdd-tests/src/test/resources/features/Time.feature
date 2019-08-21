Feature: DateTimeSelector, INPUT TYPE TIME

  Scenario: Get date value test
    Given I open "Html5 Page"
    Then "Booking Time" text equals to "11:00"

  Scenario: Get label of input type datetime test
    Given I open "Html5 Page"
    Then "Booking Time" label text equals to "Booking Time:"

  Scenario: Get attribute "min" of input type datetime test
    Given I open "Html5 Page"
    Then "Booking Time" min equals to "9:00"

  Scenario: Get attribute "max" of input type datetime test
    Given I open "Html5 Page"
    Then  "Booking Time" max equals to "18:00"

  Scenario: Date validation test
    Given I open "Html5 Page"
    Then "Booking Time" is enabled
    And "Booking Time" text equals to "11:00"

  Scenario: Label validation test
    Given I open "Html5 Page"
    Then "Booking Time" label text equals to "Booking Time:"
    And "Booking Time" label text contains "Booking"

  Scenario: Date contains text test
    Given I open "Html5 Page"
    Then "Booking Time" text contains "11"

  Scenario: Set date
    Given I open "Html5 Page"
    Then "Booking Time" text equals to "11:00"
    Then I Set date "05:00" in "Booking Time"
    Then "Booking Time" text equals to "05:00"

  Scenario: Base validation test
    Given I open "Html5 Page"
    Then  "Booking Time" is basically valid





