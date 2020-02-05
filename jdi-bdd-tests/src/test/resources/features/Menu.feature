@menu
Feature: Menu
  Background:
    Given I open "Html5 Page"

  Scenario: Select menu item test
    And I select "Contact form" in "Left Menu" menu
    Then the "Contact Form Page" page is opened

  Scenario: Get item list test
    When I select "Contact form" in "Left Menu" menu
    Then the "Contact form" in "Left Menu" menu is selected
    And the "Contact Form Page" page is opened

  Scenario: Select menu items test
    And I select items in "Left Menu" menu:
      | Service |
      | Dates   |
    Then the "Dates Page" page is opened

  Scenario: Check selected item after page load
    Then the "Elements packs" in "Left Menu" menu is selected

  Scenario: Check selected sub-item after page load
    Then the "HTML 5" in "Left Menu" menu is selected
