@alert
Feature: Alert

  Scenario: alert text equals
    Given I open "Html5 Page"
    When click on "Red Button"
    And accept alert
    And click on "Red Button"
    Then the Alert text equals to "Red button"

  Scenario: alert text contains
    Given I open "Html5 Page"
    When click on "Red Button"
    And dismiss alert
    And click on "Red Button"
    Then the Alert text contains "Red b"

  Scenario: alert text matches
    Given I open "Html5 Page"
    When click on "Red Button"
    Then the Alert text matches to "\w{3} \w{6}"
    