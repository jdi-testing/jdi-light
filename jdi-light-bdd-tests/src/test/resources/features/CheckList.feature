@checklist
Feature: CheckList

  Background:
    Given I should be logged in
    And I open "Html5 Page"
    And I check element "Hot option" in "Weather" checklist

  Scenario: Check text test:
    Then the "Weather" checklist value is "Hot option"

  Scenario: Check elements test
    When I check elements in "Weather" checklist:
      | Hot option |
      | Cold       |
    Then in "Weather" checklist checked element is "Cold"

  Scenario: Uncheck elements test
    When I check elements in "Weather" checklist:
      | Rainy day |
      | Sunny     |
    And I uncheck in "Weather" checklist elements:
      | Rainy day |
      | Sunny     |
    Then count of selected elements in "Weather" checklist is 2
    Then in the "Weather" checklist checked elements are:
      | Hot option |
      | Cold       |

  Scenario: Select checkbox test
    When I Select fields from "Weather":
    |Cold|
    |Hot option|
    Then in "Weather" checklist checked element is "Cold"

  Scenario: Check element via numbers test
    When I check in "Weather" checklist elements by numbers:
      | 1 |
      | 4 |
    Then in the "Weather" checklist checked elements are:
      | Hot option |
      | Sunny      |

  Scenario: Uncheck element via number test
    When I check all elements in "Weather" checklist
    And I uncheck in "Weather" checklist elements by numbers:
      | 1 |
      | 4 |
    Then in the "Weather" checklist checked elements are:
      | Cold      |
      | Rainy day |

  Scenario: Select checkbox via numbers
    When I select elements in "Weather" checklist by numbers:
      | 1 |
      | 4 |
    Then in "Weather" checklist checked element is "Sunny"

  Scenario: Empty choice test
    When I select nothing in "Weather" checklist and should be exception

  Scenario: Disable element test
    When I Select fields from "Weather":
    |Disabled|
    Then the "Weather" checklist value is "Hot option"

  Scenario: Validation test
    Then checkList "Weather" is basically valid

  Scenario: Uncheck All test
    When I check elements in "Weather" checklist:
      | Rainy day |
      | Sunny     |
    And I uncheck all elements in "Weather" checklist
    Then count of selected elements in "Weather" checklist is 0

  Scenario: Check All test
    When I check all elements in "Weather" checklist
    Then count of selected elements in "Weather" checklist is 4
    And in the "Weather" checklist checked elements are:
      | Hot option |
      | Cold       |
      | Rainy day  |
      | Sunny      |