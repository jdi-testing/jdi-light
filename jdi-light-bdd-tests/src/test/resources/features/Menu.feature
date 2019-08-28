@menu
Feature: Menu

  Scenario: Select test
    Given I open "Html5 Page"
    When I Check "Accept Conditions"
    And I select "Contact form" in "Left Menu" menu
    Then the "Contact Form Page" page is opened

  Scenario: Get list test
    Given I open "Html5 Page"
    When I Check "Accept Conditions"
    And I show "Contact form" in "Left Menu" menu
    Then the "Contact form" in "Left Menu" menu is deselected
    When I select "Contact form" in "Left Menu" menu
    Then the "Contact form" in "Left Menu" menu is selected
    And the "Contact Form Page" page is opened

  Scenario: Select items test
    Given I open "Html5 Page"
    When I Check "Accept Conditions"
    And I select items in "Left Menu" menu:
      | Service |
      | Dates   |
    Then the "Dates Page" page is opened

  Scenario: Is validation test
    Given I open "Html5 Page"
    When I Check "Accept Conditions"
    Then the "HTML 5" in "Left Menu" menu is selected
