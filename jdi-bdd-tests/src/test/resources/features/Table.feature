@table
Feature: Table

  Scenario: Get label text test
    Given I open "Users Page"
    Then the "Users Table" has "4" columns
    And the "Users Table" has "6" rows
    And the "Users Table" header is:
      | Number      |
      | Type        |
      | User        |
      | Description |

  Scenario: Preview test
    Given I open "Users Page"
    Then the "Users Table" table preview is:
      | NumberTypeUserDescription                                     |
      | 1AdminUserManagerRomanWolverineVip                            |
      | 2AdminUserManagerSergeyIvanSpiderManVip                       |
      | 3AdminUserManagerVladzimirPunisherVip                         |
      | 4AdminUserManagerHelenBennettCaptainAmericasomedescriptionVip |
      | 5AdminUserManagerYoshiTannamuriCyclopesomedescriptionVip      |
      | 6AdminUserManagerGiovanniRovelliHulksomedescriptionVip        |

  Scenario: Common matchers test
    Given I open "Users Page"
    Then the "Users Table" has "6" rows
    And the "Users Table" has at least "3" rows
    And the "Users Table" has not more than "6" rows
    And the "Users Table" table is not empty

  Scenario: Row matcher test
    Given I open "Users Page"
    Then the "Users Table" has row with "Ivan" in column "User"

  Scenario: Rows all test
    Given I open "Users Page"
    Then all rows of the "Users Table" contains "Vip" in column "Description"

  Scenario: No rows test
    Given I open "Users Page"
    Then the "Users Table" has no rows which has "Vip" in column "Description"

  Scenario: At least test
    Given I open "Users Page"
    Then the "Users Table" has at least "3" rows which contains " " in column "User"

  Scenario: Exact matcher test
    Given I open "Users Page"
    Then the "Users Table" has exact "2" rows which contains "R" in column "User"

  Scenario: Raw data exact matcher test
    Given I open "Users Page"
    Then the "Users Table" has exact "1" rows with "Roman" in column "User"

  Scenario: Line by index test
    Given I open "Simple Page"
    Then the cell (1,3) in the "Simple Table" is deselected
    And the cell (2,2) in the "Simple Table" is deselected
    When I click the cell (1,3) in the "Simple Table"
    Then the cell (1,3) in the "Simple Table" is selected
    And the cell (2,2) in the "Simple Table" is deselected
    When I click the cell (2,2) in the "Simple Table"
    Then the cell (2,2) in the "Simple Table" is selected
    And the cell (1,3) in the "Simple Table" is deselected