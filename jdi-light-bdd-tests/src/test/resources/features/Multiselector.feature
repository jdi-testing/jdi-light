@Multiselector
Feature: Multiselector

  Scenario: Select multiselector test
    Given I open "Html5 Page"
    When I select "Ages" with value "Steam"
    Then the "Ages" text equals to "Steam"




#  Scenario: Validate age section
#    Given I open "Html5 Page"
#    Then I check Age multiselector contains next values: Electro, Steam, Metalic, Disabled, Wood

#  Scenario: Validate age section
#    Given I open "Html5 Page"
#    Then I check "Ages" multiselector contains next values:
#    |Electro| Steam| Metalic| Disabled| Wood|

#  Scenario: Validate age section
#    Given I open "Html5 Page"
#    Then I validate Age multiselector
#
#  Scenario: Disable selection check
#    Given I open "Html5 Page"
#    Then I check Disable state in Multiselector and equals to Steam
#
#  Scenario: Single selection check
#    Given I open "Html5 Page"
#    Then I check element can be selected in Multiselector and equals to Steam
#
#  Scenario: Multiple selection check
#    Given I open "Html5 Page"
#    Then I check elements can be selected in Multiselector
#
#  Scenario: Numbers selection check
#    Given I open "Html5 Page"
#    Then I check numbers can be selected in Multiselector 1, 5
#
#  Scenario: Label check
#    Given I open "Html5 Page"
#    Then I check label in Multiselector is equals to Age status: and contains Age
