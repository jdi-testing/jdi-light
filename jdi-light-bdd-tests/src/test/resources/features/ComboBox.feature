@Combobox
Feature: Combobox

  Background:
    Given I should be logged in
    And I open "Html5 Page"
    When Select "Coconut" field from "Ice Cream"

  Scenario: Get combobox value test
    Then the "Ice Cream" selected value is "Coconut"

  Scenario: Select combobox value test
    When Select "Chocolate" field from "Ice Cream"
    Then the "Ice Cream" selected value is "Chocolate"

  Scenario: Select num combobox value test
    When Select value 5 in "Ice Cream"
    Then the "Ice Cream" selected value is "Vanilla"

  Scenario: Selected combobox value test
    Then the "Ice Cream" selected value is "Coconut"

  Scenario: Combobox label test
    Then the "Ice Cream" label text equals to "Choose your lovely icecream"
    And the "Ice Cream" label text contains "lovely icecream"

  Scenario: Combobox is validation test
    Then the "Ice Cream" is enabled
    And the "Ice Cream" text equals to "Coconut"
    When Select "Vanilla" field from "Ice Cream"
    Then the "Ice Cream" text contains "Van"

  Scenario: Assert validation test
    Then the "Ice Cream" text equals to "Coconut"

  Scenario: Base validation test
    Then the "Ice Cream" is basically valid