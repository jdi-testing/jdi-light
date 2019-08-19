Feature: link

  Scenario: Link text test
    Given I open "Html5 Page"
    Then "Github Link" text is "Github JDI"

  Scenario: Link value test
    Given I open "Html5 Page"
    Then "Github Link" value is "Github JDI"

  Scenario: Link ref test
    Given I open "Html5 Page"
    Then "Github Link" ref is "https://github.com/jdi-testing"

  Scenario: Link url path test
    Given I open "Html5 Page"
    Then "Github Link" url path is "/jdi-testing"

  Scenario: Link alt test
    Given I open "Html5 Page"
    Then "Github Link" alt is "Github JDI Link"

  Scenario: Click link test
    Given I open "Html5 Page"
    When I click on "Github Link"
    Then Current URL is "https://github.com/jdi-testing"

  Scenario: LinkAssert is() text validation test
    Given I open "Html5 Page"
    Then Link text is "Github JDI"
    And Link text ignoring case is "Github jdi"

  Scenario: LinkAssert is() activity validation test
    Given I open "Html5 Page"
    Then Link is enabled

  Scenario: LinkAssert is() alt validation test
    Given I open "Html5 Page"
    Then Link alt contains "JDI"

  Scenario: LinkAssert is() ref validation test
    Given I open "Html5 Page"
    Then Link ref contains "github"

  Scenario: LinkAssert assertThat() text validation test
    Given I open "Html5 Page"
    Then Link asserts that link text is "Github JDI"

  Scenario: Base link validation test
    Given I open "Html5 Page"
    Then "Github Link" is basically valid
