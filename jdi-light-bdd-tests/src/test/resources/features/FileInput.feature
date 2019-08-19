Feature: File Input element functionality

  Scenario: Upload file by enabled file input element
    Given I open "Html5 Page"
    Then "Avatar" file input element label text is "Profile picture:"
    And "Avatar" file input element label text contains "picture"
    When I upload file "/src/test/resources/general.xml" by "Avatar" file input element
    Then "Avatar" file input element text is "C:\fakepath\general.xml"
    And "Avatar" file input element text contains "general.xml"
    And "Avatar" file input element value is "C:\fakepath\general.xml"
    And "Avatar" file input element value contains "general.xml"

  Scenario: Upload file by disabled file input element
    Given I open "Html5 Page"
    When I try to upload file "/jdi-light-bdd-tests/src/test/resources/general.xml" by "Disabled File Input" file input element
    Then "Disabled File Input" file input element text is ""
    And "Disabled File Input" file input element value is ""


