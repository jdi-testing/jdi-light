Feature: FileInput

  Scenario: Upload file by enabled file input element
    Given I open "Html5 Page"
    Then "Avatar" file input element label text equals "Profile picture:"
    And "Avatar" file input element label text contains "picture"
    When I upload file "/jdi-light-bdd-tests/src/test/resources/general.xml" by "Avatar" file input element
    Then "Avatar" file input element text equals "general.xml"

  Scenario: Upload file by disabled file input element
    Given I open "Html5 Page"
#  When I upload file "/jdi-light-bdd-tests/src/test/resources/general.xml" by "Disabled File Input" file input element
#  Then "Disabled File Input" file input element has text ""


