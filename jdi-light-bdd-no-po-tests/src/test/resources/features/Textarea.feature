@textarea
Feature: Textarea

  Scenario: Text equivalence test
    Given I open "Html5 Page"
    When I clear "Text Area"
    And I set text "This is draft `!@#$%ˆ*()_+˜@[№;:?-=]{}'/|<>" in "Text Area"
    And I set text "Hello, I'm TextArea! `!@#$%ˆ*()_+˜@[№;:?-=]{}'/|<>" in "Text Area"
    Then the "Text Area" text equals to "Hello, I'm TextArea! `!@#$%ˆ*()_+˜@[№;:?-=]{}'/|<>"

  Scenario: Text contains test
    Given I open "Html5 Page"
    When I clear "Text Area"
    And I set text "Text in TextArea, containing jedi power `!@#$%ˆ*()_+˜@[№;:?-=]{}'/|<>" in "Text Area"
    Then the "Text Area" text contains "jedi power `!@#$%ˆ*()_+˜@[№;:?-=]{}'/|<>"

  Scenario: Text matches test
    Given I open "Html5 Page"
    When I clear "Text Area"
    And I set text "Text in TextArea, containing jedi power" in "Text Area"
    Then the "Text Area" text matches to ".*jedi power"

  Scenario: Send keys test
    Given I open "Html5 Page"
    When I clear "Text Area"
    When I send keys "first" to "Text Area"
    And I send keys " second `!@#$%ˆ*()_+˜@[№;:?-=]{}'/|<>" to "Text Area"
    Then the "Text Area" text equals to "first second `!@#$%ˆ*()_+˜@[№;:?-=]{}'/|<>"

  Scenario: Input text test
    Given I open "Html5 Page"
    When clear "Text Area"
    When send keys "Draft text" to "Text Area"
    Then the "Text Area" text equals to "Draft text"
    When input "Final text `!@#$%ˆ*()_+˜@[№;:?-=]{}'/|<>" in "Text Area"
    Then the "Text Area" text equals to "Final text `!@#$%ˆ*()_+˜@[№;:?-=]{}'/|<>"

  Scenario: Get lines test
    Given I open "Html5 Page"
    When input in the "Text Area" lines
      | test 111 11 1 |
      | test2         |
      | test 3        |
    Then the lines in the "Text Area" are equal
      | test 111 11 1 |
      | test2         |
      | test 3        |

  Scenario: Clear test
    Given I open "Html5 Page"
    When clear "Text Area"
    When send keys "simple text" to "Text Area"
    Then the "Text Area" text equals to "simple text"
    When I clear "Text Area"
    Then the "Text Area" text equals to ""

  Scenario: Add new line test
    Given I open "Html5 Page"
    When I clear "Text Area"
    When I input in the "Text Area" line "line1"
    And I input in the "Text Area" line ""
    And I input in the "Text Area" line "line2"
    Then the lines in the "Text Area" are equal
      | line1 |
      |       |
      | line2 |

  Scenario: Label text test
    Given I open "Html5 Page"
    Then the "Text Area" label text equals to "Text example:"
    Then the "Text Area" label text contains "example"

  Scenario: Count rows test
    Given I open "Html5 Page"
    Then the "Text Area" rows count equals "3"

  Scenario: Count cols test
    Given I open "Html5 Page"
    Then the "Text Area" columns count equals "33"

  Scenario: Minimal lenght test
    Given I open "Html5 Page"
    Then the "Text Area" minimal length equals "10"

  Scenario: Maximal lenght test
    Given I open "Html5 Page"
    Then the "Text Area" maximal length equals "200"

  Scenario: Basic validation test
    Given I open "Html5 Page"
    Then the "Text Area" is basically valid
