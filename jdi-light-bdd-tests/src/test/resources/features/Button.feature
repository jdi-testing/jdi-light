@button
Feature: button

  Scenario:
    Given I open "Html5 Page" page
    Then the "Red Button" text equals to "Big Red Button-Input"


  Scenario: Click and alert
    Given I open "Html5 Page" page
    When Click on "Red Button"
    Then the Alert text equals to "Red button"
    When Click on "Blue Button"
    Then the Alert text equals to "Blue button"

  Scenario: Validation
    Given I open "Html5 Page" page
    Then the "Red Button" is displayed
    And the "Red Button" is enabled
    And the "Red Button" text equals to "Big Red Button-Input"
    And the "Red Button" text contains "Red Button"
    And the "Red Button" css "font-size" equals to "14px"
    And the "Red Button" attribute "type" equals to "button"
    And the "Blue Button" text contains "BLUE BUTTON"
    And the "Disabled Button" is disabled

  Scenario: Basic validation
    Given I open "Html5 Page" page
    Then the "Red Button" is basically valid