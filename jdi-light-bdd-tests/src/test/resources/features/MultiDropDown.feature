@MultiDropDown

Feature: MultiDropDown

  Scenario: Check one value test
    Given I open "Html5 Page"
    When I check value "Steam" in the "Multi Dropdown"
    Then the "Multi Dropdown" selected value is "Steam"

  Scenario: Assert validation test
    Given I open "Html5 Page"
    Then the "Multi Dropdown" contains items:
      | Disabled | Wood | Steam | Electro | Metalic |

  Scenario: Check disabled element value
    When I Select "Disabled" field from "Multi Dropdown"
    Then the "Multi Dropdown" selected value is "Steam"

  Scenario: Validation test
    Given I open "Html5 Page"
    Then the "Multi Dropdown" selected value is "Steam"
    And the "Multi Dropdown" values has item "Wood"
    And  the "Multi Dropdown" has disabled item "Disabled"
    And the "Multi Dropdown" has not enabled item "Disabled"
    And the "Multi Dropdown" has enabled items:
      | Electro | Metalic |

  Scenario: Check  values test
    When I check in the "Multi Dropdown" values:
      | Electro | Metalic |
    Then the "Multi Dropdown" selected values:
      | Electro | Metalic |

  Scenario: Check values by number test
    When I check in the "Multi Dropdown" values by number:
      | 1 | 5 |
    Then the "Multi Dropdown" selected values:
      | Electro | Wood |

  Scenario: Get label text tests
    Given I open "Html5 Page"
    Then the "Multi Dropdown" label text equals to "Multi dropdown:"
    And the "Multi Dropdown" label text contains "dropdown:"
    And the "Multi Dropdown" label text matches to "(.*)dropdown:"

  Scenario: Get css tests
    Given I open "Html5 Page"
    Then the "Multi Dropdown" css "font-size" equals to "14px"
    And the "Multi Dropdown" css "font-family" contains "Source Sans Pro"
    And the "Multi Dropdown" css "font-family" matches to "(.*)sans-serif"

  Scenario: Base validation test
    Given I open "Html5 Page"
    Then the "Multi Dropdown" is basically valid