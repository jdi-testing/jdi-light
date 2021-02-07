@DropDown
Feature: DropDown

  Scenario: Selected Test
    Given I open "Html5 Page"
    When I select "Pirate" field from "Dress Code"
    Then the "Pirate" in "Dress Code" is selected