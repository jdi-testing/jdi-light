@datalist
Feature: Datalist

  Background:
    Given I should be logged in
    And I open "Html5 Page"
    And I focus on "Ice Cream"
    When select value "Coconut" in "Ice Cream"

  Scenario: Get datalist value test
    Then the "Ice Cream" selected value is "Coconut"