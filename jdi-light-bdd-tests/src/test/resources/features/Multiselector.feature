@Multiselector
Feature: Multiselector

  Scenario: Multiselector validation
    Given I open "Html5 Page"
    Then the "Steam" value is selected in "Ages" multiselector
    And the "Ages" multiselector contains "Wood" value
    And the "Ages" multiselector in disabled state has "Disabled" item
    And the "Ages" multiselector in enabled state has not "Disabled" item
    And the "Ages" multiselector in enabled contains next values:
      | Electro | Metalic |

  Scenario: Select value in multiselector
    Given I open "Html5 Page"
    When I select "Ages" with value "Steam"
    Then the "Ages" multiselector text is equals to "Steam"

  Scenario: Validate multiselector list of values
    Given I open "Html5 Page"
    Then the "Ages" multiselector contains next values:
    | Electro | Steam| Metalic | Disabled | Wood |

  Scenario: Multiple selection in multiselector
    Given I open "Html5 Page"
    When I select "Ages" with value "Electro, Metalic"
    Then the "Ages" multiselector text is equals to "Electro, Metalic"

  Scenario: Select values by number in multiselector
    Given I open "Html5 Page"
    When I select 1, 5 numbers in "Ages" multiselector
    Then the "Ages" multiselector text is equals to "Electro, Wood"