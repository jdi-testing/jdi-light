@CheckList
Feature: CheckList

  Background:
    Given I should be logged in
    And I open "Html5 Page"
    And I check element "Hot option" in "Weather"

  Scenario: Check text test:
    Then "Weather" Checklist text is "Hot option"

  Scenario: Check elements test
    When I check in "Weather":
      | Hot option |
      | Cold       |
    Then In "Weather" checked element is "Cold"

  Scenario: Uncheck elements test
    When I check in "Weather":
      | Rainy day |
      | Sunny     |
    And I uncheck in "Weather":
      | Rainy day |
      | Sunny     |
    Then Count of selected checkboxes in "Weather" is "2"
    Then In "Weather" checked elements are:
      | Hot option |
      | Cold       |

  Scenario: Select checkbox test
    When I select in "Weather":
      | Cold       |
      | Hot option |
    Then In "Weather" checked element is "Cold"

  Scenario: Check element via enum test
    When I check in "Weather" via enum:
      | Cold  |
      | Rainy |
    Then In "Weather" checked elements are:
      | Cold      |
      | Rainy day |

  Scenario: Uncheck element via enum test
    When I check all in "Weather"
    And I uncheck in "Weather" labels via enum:
      | Hot   |
      | Rainy |
    Then Count of selected checkboxes in "Weather" is "2"
    And In "Weather" checked elements are:
      | Cold  |
      | Sunny |

  Scenario: Select checkbox enum test
    When I select in "Weather" via enum:
      | Cold  |
      | Rainy |
    Then In "Weather" checked elements are:
      | Hot option |
      | Cold       |
      | Rainy day  |

  Scenario: Check element via numbers test
    When I check in "Weather" via numbers:
      | 1 |
      | 4 |
    Then In "Weather" checked elements are:
      | Hot option |
      | Sunny      |

  Scenario: Uncheck element via number test
    When I check all in "Weather"
    And I uncheck in "Weather" via numbers:
      | 1 |
      | 4 |
    Then In "Weather" checked elements are:
      | Cold      |
      | Rainy day |

  Scenario: Select checkbox via numbers
    When I select checkbox in "Weather" via numbers:
      | 1 |
      | 4 |
    Then In "Weather" checked element is "Sunny"

  Scenario: Empty choice test
    When I select nothing in "Weather" should be exception

  Scenario: Disable element test
    When I select element "Disabled" in "Weather"
    Then "Weather" Checklist text is "Hot option"

  Scenario: Validation test
    Then CheckList "Weather" is basically valid

  Scenario: Uncheck All test
    When I check in "Weather" via enum:
      | Rainy |
      | Sunny |
    And I uncheck All in "Weather"
    Then Count of selected checkboxes in "Weather" is "0"

  Scenario: Check All test
    When I check all in "Weather"
    Then Count of selected checkboxes in "Weather" is "4"
    And In "Weather" checked elements are:
      | Hot option |
      | Cold       |
      | Rainy day  |
      | Sunny      |