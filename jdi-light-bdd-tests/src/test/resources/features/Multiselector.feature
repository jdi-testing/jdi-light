@Multiselector
Feature: Multiselector

  Scenario: Select value in multiselector
    Given I open "Html5 Page"
    When I select "Ages" with value "Steam"
    Then I check the "Ages" multiselector text is equals to "Steam"

  Scenario: Validate multiselector list of values
    Given I open "Html5 Page"
    Then I check the "Ages" multiselector contains next values:
    |Electro| Steam| Metalic| Disabled| Wood|

  Scenario: Multiple selection in multiselector
    Given I open "Html5 Page"
    When I select "Ages" with value "Electro, Metalic"
    Then I check the "Ages" multiselector text is equals to "Electro, Metalic"

  Scenario: Select values by number in multiselector
    Given I open "Html5 Page"
    When I select 1, 5 numbers in "Ages" multiselector
    Then I check the "Ages" multiselector text is equals to "Electro, Wood"