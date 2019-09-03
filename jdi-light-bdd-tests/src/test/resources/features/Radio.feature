@radio
Feature: Radio

  Scenario: Select
    Given I open "Html5 Page" page
    And I Select "Blue" field from "Html5 Page.Colors"
    Then the "Html5 Page.Colors" text equals to "Blue"
    When I select the radio button with "1" index from "Html5 Page.Colors"
    Then the "Html5 Page.Colors" text equals to "Red"

  Scenario: Consist of
    Given I open "Html5 Page" page
    Then the "Html5 Page.Colors" consists of next values:
      | Red | Green | Blue | Yellow |

  Scenario: Validate
    Given I open "Html5 Page" page
    And I Select "Blue" field from "Html5 Page.Colors"
    Then the "Html5 Page.Colors" text equals to "Blue"
    And the "Html5 Page.Colors" contains "Yellow" radio button
    And the "Html5 Page.Colors" contains "Yellow" disabled radio button
    And the "Html5 Page.Colors" does not contain "Yellow" enabled radio button
    And the "Html5 Page.Colors" contains next enabled values:
      | Green | Blue |