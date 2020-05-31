@menu
Feature: Menu
  Background:
    Given I open "Html5 Page"

#  Scenario: Select test
#    When I check "Accept Conditions"
#    And I select "Contact form" in "Left Menu" menu
#    Then the "Contact Form Page" page is opened
#
#  Scenario: Get list test
#    When I check "Accept Conditions"
#    When I select "Contact form" in "Left Menu" menu
#    Then the "Contact form" in "Left Menu" menu is selected
#    And the "Contact Form Page" page is opened
#
#  Scenario: Select items test
#    When I check "Accept Conditions"
#    And I select items in "Left Menu" menu:
#      | Service |
#      | Dates   |
#    Then the "Dates Page" page is opened
#
#  Scenario: Is validation test
#    When I check "Accept Conditions"
#    Then the "HTML 5" in "Left Menu" menu is selected
#
  Scenario: Check selected item after page load
    Then the "Elements packs" in "Left Menu" menu is selected

#  Scenario: Check selected sub-item after page load
#    Then the "HTML 5" in "Left Menu" menu is selected