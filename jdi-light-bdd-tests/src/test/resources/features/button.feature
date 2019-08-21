Feature: button


  Scenario:
    Given I open "Html5 Page" page
    Then "Red Button" text equals to "Big Red Button-Input"


  Scenario: Click and alert
    Given I open "Html5 Page" page
    When Click on "Red Button"
    Then Alert text equals to "Red button"
    When Accept alert
    When Click on "Blue Button"
    Then Alert text equals to "Blue button"

  Scenario: Validation
    Given I open "Html5 Page" page
    Then "Red Button" is displayed
    And "Red Button" is enabled
    And "Red Button" text equals to "Big Red Button-Input"
    And "Red Button" text contains "Red Button"
    And "Red Button" css "font-size" equals to "14px"
    And "Red Button" attribute "type" equals to "button"
    And "Blue Button" text contains "BLUE BUTTON"
    And "Disabled Button" text contains "DISABLED BUTTON"
    And "Disabled Button Input" text contains "Disabled Button"
    And "Disabled Button" is disabled

  Scenario:Basic validation
    Given I open "Html5 Page" page
    Then "Red Button" is basically valid

  Scenario: Suspend button
    Given I open "Html5 Page" page
    Then "Suspend Button" is enabled

  Scenario: Vanish button
    Given I open "Html5 Page" page
    Then "Ghost Button" is not appear

























