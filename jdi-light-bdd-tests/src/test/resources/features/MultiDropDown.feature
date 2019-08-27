@MultiDropDown
Feature: MultiDropDown

  Scenario: Select test
    Given I open "Html5 Page"
    When I check in the "Multi Dropdown" values:
    | Electro | Metalic |
    Then the "Multi Dropdown" selected values:
    | Electro | Metalic |
    When I check in the "Multi Dropdown" values by number:
      | 1 | 5 |
    Then the "Multi Dropdown" selected values:
      | Electro | Wood |
    When I check in the "Multi Dropdown" values by enum:
      | Wood  | Steam |
    Then the "Multi Dropdown" selected values:
      | Steam | Wood |


  Scenario: Get label text tests
    Given I open "Html5 Page"
    Then the "Multi Dropdown" label text equals to "Multi dropdown:"
    Then the "Multi Dropdown" label text contains "dropdown:"
    Then the "Multi Dropdown" label text matches to "(.*)dropdown:"

  Scenario: Get css tests
    Given I open "Html5 Page"
    Then the "Multi Dropdown" css "font-size" equals to "14px"
    Then the "Multi Dropdown" css "font-family" contains "Source Sans Pro"
    Then the "Multi Dropdown" css "font-family" matches to "(.*)sans-serif"