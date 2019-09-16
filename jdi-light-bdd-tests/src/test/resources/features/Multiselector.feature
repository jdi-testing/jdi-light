@Multiselector
Feature: Multiselector

  Scenario: Multiselector validation
    Given I open "Html5 Page"
    Then the "Ages" selected value is "Steam"
    And the "Ages" values has item "Wood"
    And  the "Ages" has disabled item "Disabled"
    And the "Ages" has no enabled item "Disabled"
    And the "Ages" has enabled items:
      | Electro | Metalic |

  Scenario: Select value in multiselector
    Given I open "Html5 Page"
    When I check value "Steam" in the "Ages"
    Then the "Ages" selected value is "Steam"

  Scenario: Validate multiselector list of values
    Given I open "Html5 Page"
    Then the "Ages" contains items:
    | Electro | Steam| Metalic | Disabled | Wood |

  Scenario: Multiple selection in multiselector
    When I check in the "Multi Dropdown" values:
      | Electro | Metalic |
    Then the "Multi Dropdown" selected values:
      | Electro | Metalic |

  Scenario: Select values by number in multiselector
    Given I open "Html5 Page"
    When I check in the "Multi Dropdown" values by number:
      | 1 | 5 |
    Then the "Multi Dropdown" selected values:
      | Electro | Wood |