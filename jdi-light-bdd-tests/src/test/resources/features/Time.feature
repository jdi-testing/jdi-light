@time
Feature: DateTimeSelector, INPUT TYPE TIME

  Scenario: Get date value test
    Given I open "Html5 Page"
    Then the "Booking Time" text equals to "11:00"

  Scenario: Get label of input type datetime test
    Given I open "Html5 Page"
    Then the "Booking Time" label text equals to "Booking Time:"

  Scenario: Get attribute "min" of input type datetime test
    Given I open "Html5 Page"
    Then the "Booking Time" min equals to "9:00"

  Scenario: Get attribute "max" of input type datetime test
    Given I open "Html5 Page"
    Then the "Booking Time" max equals to "18:00"

  Scenario: Date validation test
    Given I open "Html5 Page"
    Then the "Booking Time" is enabled
    Then the "Booking Time" text equals to "11:00"

  Scenario: Label validation test
    Given I open "Html5 Page"
    Then the "Booking Time" label text equals to "Booking Time:"
    Then the "Booking Time" label text contains "Booking"

  Scenario: Date contains text test
    Given I open "Html5 Page"
    Then the "Booking Time" text contains "11"

  Scenario: Set date
    Given I open "Html5 Page"
    Then the "Booking Time" text equals to "11:00"
    Then I set date "05:00" in the "Booking Time"
    Then the "Booking Time" text equals to "05:00"

  Scenario: Base validation test
    Given I open "Html5 Page"
    Then  the "Booking Time" is basically valid





