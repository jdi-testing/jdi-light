@DropDown
Feature: DropDown

  Scenario: Selected Test
    Given I open "Html5 Page"
    When I select "Pirate" field from "Dress Code"
    Then the "Pirate" in "Dress Code" is selected

    # https://github.com/jdi-testing/jdi-light/issues/1747
#  Scenario: Default drop-down state Test
#    Given I open "Html5 Page"
#    Then the "Dress Code" dropdown is closed
#
#  Scenario: Open and close drop-down Test
#    Given I open "Html5 Page"
#    When I expand "Dress Code" dropdown
#    Then the "Dress Code" dropdown is expanded
#    And I close "Dress Code" dropdown
#    Then the "Dress Code" dropdown is closed

  Scenario: Default drop-down state Test another page
    Given I open "Metal And Colors Page"
    Then the "Colors" dropdown is closed
    Then the "Metals" dropdown is closed
    Then the "Metals2" dropdown is closed

  Scenario: Open and close Colors drop-down Test
    Given I open "Metal And Colors Page"
    When I expand "Colors" dropdown
    And the "Colors" dropdown is expanded
    And I close "Colors" dropdown
    Then the "Colors" dropdown is closed

  Scenario: Open and close Metals drop-down Test
    Given I open "Metal And Colors Page"
    When I expand "Metals" dropdown
    And the "Metals" dropdown is expanded
    And I close "Metals" dropdown
    Then the "Metals" dropdown is closed

  Scenario: Open and close Metals2 drop-down Test
    Given I open "Metal And Colors Page"
    When I expand "Metals2" dropdown
    And the "Metals2" dropdown is expanded
    And I close "Metals2" dropdown
    Then the "Metals2" dropdown is closed