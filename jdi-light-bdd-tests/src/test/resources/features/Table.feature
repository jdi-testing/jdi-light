Feature: Checkbox
@table
  Scenario: Get label text test
    Given I open "Users Page"
    Then the "Users Table" table columns count equals "4"
    And the "Users Table" table rows count equals "6"
    And the "Users Table" table header has items:
      | Number      |
      | Type        |
      | User        |
      | Description |