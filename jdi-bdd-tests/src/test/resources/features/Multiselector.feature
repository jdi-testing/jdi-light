@Multiselector
Feature: Multiselector
  Background:
    Given I open "Html5 Page"

  Scenario: Multiselector validation
    Then the "Ages" selected value is "Steam"
    And the "Ages" values has item "Wood"
    And  the "Ages" has disabled item "Disabled"
    And the "Ages" has no enabled item "Disabled"
    And the "Ages" has enabled items:
      | Electro | Metalic |

  Scenario: Select value in multiselector
    When I check value "Steam" in the "Ages"
    Then the "Ages" selected value is "Steam"

  Scenario: Validate multiselector list of values
    Then the "Ages" contains items:
    | Electro | Steam| Metalic | Disabled | Wood |

  Scenario: Multiple selection in multiselector
    When I check in the "Multi Dropdown" values:
      | Electro | Metalic |
    Then the "Multi Dropdown" selected values:
      | Electro | Metalic |

  Scenario: Select values by number in multiselector
    When I check in the "Multi Dropdown" values by number:
      | 1 | 5 |
    Then the "Multi Dropdown" selected values:
      | Electro | Wood |