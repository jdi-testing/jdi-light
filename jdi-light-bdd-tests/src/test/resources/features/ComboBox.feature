@Combobox
Feature: Combobox

  Background:
    Given I should be logged in
    And I open "Html5 Page"
    When Select "Coconut" in combobox "Ice Cream"

  Scenario: Get combobox value test
    Then "Coconut" is selected in combobox "Ice Cream"

  Scenario: Select combobox value test
    When Select "Chocolate" in combobox "Ice Cream"
    Then "Chocolate" is selected in combobox "Ice Cream"

  Scenario: Select enum combobox value test
    When  Select ice cream "Strawberry" in combobox "Ice Cream"
    Then "Strawberry" is selected in combobox "Ice Cream"

  Scenario: Select num combobox value test
    When Select value 5 in combobox "Ice Cream"
    Then "Vanilla" is selected in combobox "Ice Cream"

  Scenario: Selected combobox value test
    Then "Coconut" is selected in combobox "Ice Cream"

  Scenario: Combobox label test
    Then "Ice Cream" label text equals to "Choose your lovely icecream"
    And "Ice Cream" label text contains "lovely icecream"

  Scenario: Combobox is validation test
    Then "Ice Cream" is enabled
    And "Ice Cream" text equals to "Coconut"
    When Select "Vanilla" in combobox "Ice Cream"
    Then "Ice Cream" text contains "Van"

  Scenario: Assert validation test
    Then "Ice Cream" text equals to "Coconut"

  Scenario: Base validation test
    Then "Ice Cream" is basically valid