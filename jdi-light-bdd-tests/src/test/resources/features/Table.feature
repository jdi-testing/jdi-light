@table
Feature: Table

  Scenario: Get label text test
    Given I open "Users Page"
    Then the "Users Table" table columns count equals "4"
    And the "Users Table" table rows count equals "6"
    And the "Users Table" table header has items:
      | Number      |
      | Type        |
      | User        |
      | Description |

  Scenario: Preview test
    Given I open "Users Page"
    Then the "Users Table" table preview equals values:
      | NumberTypeUserDescription                                     |
      | 1AdminUserManagerRomanWolverineVip                            |
      | 2AdminUserManagerSergeyIvanSpiderManVip                       |
      | 3AdminUserManagerVladzimirPunisherVip                         |
      | 4AdminUserManagerHelenBennettCaptainAmericasomedescriptionVip |
      | 5AdminUserManagerYoshiTannamuriCyclopesomedescriptionVip      |
      | 6AdminUserManagerGiovanniRovelliHulksomedescriptionVip        |

  Scenario: Common matchers test
    Given I open "Users Page"
    Then the "Users Table" table has size "6"
    And the "Users Table" table has size greater than "3"
    And the "Users Table" table has size less or equal to "6"
    And the "Users Table" table is not empty

  Scenario: Row matcher test
    Given I open "Users Page"
    Then the "Users Table" table has row that contains value "Ivan" in column "User"

  Scenario: Rows all test
    Given I open "Users Page"
    Then the "Users Table" table all rows contain value "Vip" in column "Description"

  Scenario: No rows test
    Given I open "Users Page"
    Then the "Users Table" table has no rows which contain value "Vip" in column "Description"

  Scenario: At least test
    Given I open "Users Page"
    Then the "Users Table" table has at least "3" rows which contain value " " in column "User"

  Scenario: Exact matcher test
    Given I open "Users Page"
    Then the "Users Table" table has exact "2" rows which contain value "R" in column "User"

  Scenario: Raw data exact matcher test
    Given I open "Users Page"
    Then the "Users Table" table has exact "1" rows which have value "Roman" in column "User"

  Scenario: Line by index test
    Given I open "Simple Page"
    Then the cell in row "1" in column "3" of the table "Simple Table" is deselected
    Then the cell in row "2" in column "2" of the table "Simple Table" is deselected
    When I click the cell in row "1" in column "3" of the table "Simple Table"
    Then the cell in row "1" in column "3" of the table "Simple Table" is selected
    Then the cell in row "2" in column "2" of the table "Simple Table" is deselected
    When I click the cell in row "2" in column "2" of the table "Simple Table"
    Then the cell in row "1" in column "3" of the table "Simple Table" is deselected
    Then the cell in row "2" in column "2" of the table "Simple Table" is selected