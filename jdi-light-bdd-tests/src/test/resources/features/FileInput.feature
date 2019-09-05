@fileinput
Feature: File Input element functionality

  Scenario: Label text of file input element
    Given I open "Html5 Page"
    Then the "Avatar" label text equals to "Profile picture:"
    Then the "Avatar" label text contains "picture"

  Scenario: Basic validation
    Given I open "Html5 Page"
    Then the "Avatar" is basically valid

  Scenario: Attribute of file input element
    Given I open "Html5 Page"
    Then the "Avatar" attribute "id" equals to "avatar"

  Scenario: Upload file by enabled file input element
    Given I open "Html5 Page"
    When I upload file "/src/test/resources/steps_list" by "Avatar" file input element
    Then the "Avatar" text equals to "C:\fakepath\steps_list"
    And the "Avatar" text contains "steps_list"

  Scenario: Disabled file input element
    Given I open "Html5 Page"
    Then the "Disabled File Input" is disabled

  Scenario: Upload file by disabled file input element
    Given I open "Html5 Page"
    When I try to upload file "/jdi-light-bdd-tests/src/test/resources/general.xml" by "Disabled File Input" file input element
    Then the "Disabled File Input" text equals to ""

