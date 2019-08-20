Feature: File Input element functionality

  Scenario: Upload file by enabled file input element
    Given I open "Html5 Page"
    Then Assert that "Avatar" file input element label equals to "Profile picture:"
    And Assert that "Avatar" file input element label contains "picture"
    When I upload file "/src/test/resources/general.xml" by "Avatar" file input element
    Then Assert that "Avatar" file input element text equals to "C:\fakepath\general.xml"
    And Assert that "Avatar" file input element text contains "general.xml"
    And Assert that "Avatar" file input element value equals to "C:\fakepath\general.xml"
    And Assert that "Avatar" file input element value contains "general.xml"

  Scenario: Upload file by disabled file input element
    Given I open "Html5 Page"
    When I try to upload file "/jdi-light-bdd-tests/src/test/resources/general.xml" by "Disabled File Input" file input element
    Then Assert that "Disabled File Input" file input element text equals to ""
    And Assert that "Disabled File Input" file input element value equals to ""


