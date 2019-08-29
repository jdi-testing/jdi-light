@alert
Feature: Alert

  Scenario: alert text equals
    Given I open "Html5 Page"
    When Click on "Red Button"
    And Accept alert
    And Click on "Red Button"
    Then the Alert text equals to "Red button"

  Scenario: alert text contains
    Given I open "Html5 Page"
    When Click on "Red Button"
    And Dismiss alert
    And Click on "Red Button"
    Then the Alert text contains "Red b"

  Scenario: alert text matches
    Given I open "Html5 Page"
    When Click on "Red Button"
    Then the Alert text matches to "\w{3} \w{6}"
    