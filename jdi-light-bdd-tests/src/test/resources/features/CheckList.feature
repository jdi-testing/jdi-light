@checklist
Feature: CheckList

  Background:
    Given I should be logged in
    And I open "Html5 Page"
    And I check element "Hot option" in "Weather" checklist

  Scenario: Check text test:
    Then The "Weather" checklist value is "Hot option"

  Scenario: Check elements test
    When I check elements in "Weather" checklist:
      | Hot option |
      | Cold       |
    Then In "Weather" checklist checked element is "Cold"

  Scenario: Uncheck elements test
    When I check elements in "Weather" checklist:
      | Rainy day |
      | Sunny     |
    And I uncheck in "Weather" checklist elements:
      | Rainy day |
      | Sunny     |
    Then Count of selected elements in "Weather" checklist is 2
    Then In the "Weather" checklist checked elements are:
      | Hot option |
      | Cold       |

  Scenario: Select checkbox test
    When I Select "Cold;Hot option" fields from "Weather"
    Then In "Weather" checklist checked element is "Cold"

  Scenario: Check element via enum test
    When I check in "Weather" checklist elements by enum:
      | Cold  |
      | Rainy |
    Then In the "Weather" checklist checked elements are:
      | Cold      |
      | Rainy day |

  Scenario: Uncheck element via enum test
    When I check all elements in "Weather" checklist
    And I uncheck in "Weather" checklist elements by enum:
      | Hot   |
      | Rainy |
    Then Count of selected elements in "Weather" checklist is 2
    And In the "Weather" checklist checked elements are:
      | Cold  |
      | Sunny |

  Scenario: Select checkbox enum test
    When I select in "Weather" checklist elements by enum:
      | Cold  |
      | Rainy |
    Then In the "Weather" checklist checked elements are:
      | Hot option |
      | Cold       |
      | Rainy day  |

  Scenario: Check element via numbers test
    When I check in "Weather" checklist elements by numbers:
      | 1 |
      | 4 |
    Then In the "Weather" checklist checked elements are:
      | Hot option |
      | Sunny      |

  Scenario: Uncheck element via number test
    When I check all elements in "Weather" checklist
    And I uncheck in "Weather" checklist elements by numbers:
      | 1 |
      | 4 |
    Then In the "Weather" checklist checked elements are:
      | Cold      |
      | Rainy day |

  Scenario: Select checkbox via numbers
    When I select elements in "Weather" checklist by numbers:
      | 1 |
      | 4 |
    Then In "Weather" checklist checked element is "Sunny"

  Scenario: Empty choice test
    When I select nothing in "Weather" checklist and should be exception

  Scenario: Disable element test
    When I Select "Disabled" fields from "Weather"
    Then The "Weather" checklist value is "Hot option"

  Scenario: Validation test
    Then CheckList "Weather" is basically valid

  Scenario: Uncheck All test
    When I check in "Weather" checklist elements by enum:
      | Rainy |
      | Sunny |
    And I uncheck all elements in "Weather" checklist
    Then Count of selected elements in "Weather" checklist is 0

  Scenario: Check All test
    When I check all elements in "Weather" checklist
    Then Count of selected elements in "Weather" checklist is 4
    And In the "Weather" checklist checked elements are:
      | Hot option |
      | Cold       |
      | Rainy day  |
      | Sunny      |