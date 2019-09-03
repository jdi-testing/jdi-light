@combobox
Feature: Combobox

Background:
  Given I should be logged in
  And I open "Html5 Page"
  When select "Coconut" field from "Ice Cream"

Scenario: Get combobox value test
  Then the "Ice Cream" combobox selected value is "Coconut"

Scenario: select combobox value test
  When select "Chocolate" field from "Ice Cream"
  Then the "Ice Cream" combobox selected value is "Chocolate"

Scenario: select num combobox value test
  When select index 5 in "Ice Cream"
  Then the "Ice Cream" combobox selected value is "Vanilla"

Scenario: Selected combobox value test
  Then the "Ice Cream" combobox selected value is "Coconut"

Scenario: Combobox label test
  Then the "Ice Cream" label text equals to "Choose your lovely icecream"
  And the "Ice Cream" label text contains "lovely icecream"

Scenario: Combobox is validation test
  Then the "Ice Cream" is enabled
  And the "Ice Cream" text equals to "Coconut"
  When select "Vanilla" field from "Ice Cream"
  Then the "Ice Cream" text contains "Van"

Scenario: Assert validation test
  Then the "Ice Cream" text equals to "Coconut"

Scenario: Base validation test
  Then the "Ice Cream" is basically valid

Scenario: Send keys test
  When select "Chocolate" field from "Ice Cream"
  When I send keys "Test" to "Ice Cream"
  Then the "Ice Cream" text equals to "ChocolateTest"

Scenario: Input test
  When I input "New text" in "Ice Cream"
  Then the "Ice Cream" text equals to "New text"

Scenario: Clear text
  When I clear "Ice Cream"
  Then the "Ice Cream" text equals to ""

Scenario: Check placeholder
  Then the "Ice Cream" placeholder equals to "Ice cream"
  Then the "Ice Cream" placeholder contains "cream"
  And the "Ice Cream" placeholder matches to "(.*)cream"

Scenario: Focus
  When I focus on "Ice Cream"