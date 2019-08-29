@textarea
Feature: Textarea

  Scenario: Text equivalence test
    Given I open "Html5 Page"
    When I Clear "Text Area"
    And I Set text "This is draft `!@#$%ˆ*()_+˜@[№;:?-=]{}'/|<>" in "Text Area"
    And I Set text "Hello, I'm TextArea! `!@#$%ˆ*()_+˜@[№;:?-=]{}'/|<>" in "Text Area"
    Then the "Text Area" text equals to "Hello, I'm TextArea! `!@#$%ˆ*()_+˜@[№;:?-=]{}'/|<>"

  Scenario: Text contains test
    Given I open "Html5 Page"
    When I Clear "Text Area"
    And I Set text "Text in TextArea, containing jedi power `!@#$%ˆ*()_+˜@[№;:?-=]{}'/|<>" in "Text Area"
    Then the "Text Area" text contains "jedi power `!@#$%ˆ*()_+˜@[№;:?-=]{}'/|<>"

  Scenario: Text matches test
    Given I open "Html5 Page"
    When I Clear "Text Area"
    And I Set text "Text in TextArea, containing jedi power" in "Text Area"
    Then the "Text Area" text matches to ".*jedi power"

  Scenario: Send keys test
    Given I open "Html5 Page"
    When I Clear "Text Area"
    When I Send keys "first" to "Text Area"
    And I Send keys " second `!@#$%ˆ*()_+˜@[№;:?-=]{}'/|<>" to "Text Area"
    Then the "Text Area" text equals to "first second `!@#$%ˆ*()_+˜@[№;:?-=]{}'/|<>"

  Scenario: Input text test
    Given I open "Html5 Page"
    When Clear "Text Area"
    When Send keys "Draft text" to "Text Area"
    Then the "Text Area" text equals to "Draft text"
    When Input "Final text `!@#$%ˆ*()_+˜@[№;:?-=]{}'/|<>" in "Text Area"
    Then the "Text Area" text equals to "Final text `!@#$%ˆ*()_+˜@[№;:?-=]{}'/|<>"

  Scenario: Get lines test
    Given I open "Html5 Page"
    When Input in the "Text Area" lines
      | test 111 11 1 |
      | test2         |
      | test 3        |
    Then Lines in the "Text Area" are equal
      | test 111 11 1 |
      | test2         |
      | test 3        |

  Scenario: Clear test
    Given I open "Html5 Page"
    When Clear "Text Area"
    When Send keys "simple text" to "Text Area"
    Then the "Text Area" text equals to "simple text"
    When I Clear "Text Area"
    Then the "Text Area" text equals to ""

  Scenario: Add new line test
    Given I open "Html5 Page"
    When I Clear "Text Area"
    When I Input in the "Text Area" line "line1"
    And I Input in the "Text Area" line ""
    And I Input in the "Text Area" line "line2"
    Then Lines in the "Text Area" are equal
      | line1 |
      |       |
      | line2 |

  Scenario: Label text test
    Given I open "Html5 Page"
    Then the "Text Area" label text equals to "Text example:"
    Then the "Text Area" label text contains "example"

  Scenario: Count rows test
    Given I open "Html5 Page"
    Then The "Text Area" rows count equals "3"

  Scenario: Count cols test
    Given I open "Html5 Page"
    Then The "Text Area" columns count equals "33"

  Scenario: Minimal lenght test
    Given I open "Html5 Page"
    Then The "Text Area" minimal length equals "10"

  Scenario: Maximal lenght test
    Given I open "Html5 Page"
    Then The "Text Area" maximal length equals "200"

  Scenario: Basic validation test
    Given I open "Html5 Page"
    Then the "Text Area" is basically valid
