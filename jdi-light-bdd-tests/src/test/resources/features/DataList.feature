@datalist
Feature: Datalist

  Background:
    Given I should be logged in
    And I open "Html5 Page"
    When select "Coconut" field from "Ice Cream"

  Scenario: Get datalist value test
    Then the "Ice Cream" datalist selected value is "Coconut"