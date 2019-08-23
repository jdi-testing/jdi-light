Feature: Menu

  Scenario: Select test
    Given I open "Html5 Page"
    When I Check "Accept Conditions"
    When I Select "Contact form" in "Left Menu" menu
    Then the "Contact Form Page" page is opened

  Scenario: Select test
    Given I open "Html5 Page"
    When I Check "Accept Conditions"
    When I Show "Contact form" in "Left Menu" menu
    Then the "Contact form" in "Left Menu" menu is deselected
    When I Select "Contact form" in "Left Menu" menu
    Then the "Contact form" in "Left Menu" menu is selected
    Then the "Contact Form Page" page is opened

  Scenario: Select items test
    Given I open "Html5 Page"
    When I Check "Accept Conditions"
    When I Select "Service;Dates" items in "Left Menu" menu
    Then the "Dates Page" page is opened

  Scenario: Is validation test
    Given I open "Html5 Page"
    When I Check "Accept Conditions"
    Then the "HTML 5" in "Left Menu" menu is selected
