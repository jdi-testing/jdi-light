Feature: File Input element functionality

  Scenario: Label text of file input element
    Given I open "Html5 Page"
    Then "Avatar" label text equals to "Profile picture:"
    Then "Avatar" label text contains "picture"

  Scenario: Basic validation
    Given I open "Html5 Page"
    Then "Avatar" is basically valid

  Scenario: Attribute of file input element
    Given I open "Html5 Page"
    Then "Avatar" attribute "id" equals to "avatar"

  Scenario: Upload file by enabled file input element
    Given I open "Html5 Page"
    When I upload file "/src/test/resources/general.xml" by "Avatar" file input element
    Then "Avatar" text equals to "C:\fakepath\general.xml"
    And "Avatar" text contains "general.xml"

  Scenario: Disabled file input element
    Given I open "Html5 Page"
    Then "Disabled File Input" is disabled

  Scenario: Upload file by disabled file input element
    Given I open "Html5 Page"
    When I try to upload file "/jdi-light-bdd-tests/src/test/resources/general.xml" by "Disabled File Input" file input element
    Then "Disabled File Input" text equals to ""

