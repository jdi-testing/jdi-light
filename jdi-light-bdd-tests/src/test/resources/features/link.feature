Feature: link

  Scenario: Get link text test
    Given I open "Home Page"
    Then "Github Link" text is "JDI GITHUB"

  Scenario: Get link value test
    Given I open "Home Page"
    Then "Github Link" value is "JDI GITHUB"

  Scenario: Get link ref test
    Given I open "Home Page"
    Then "Github Link" ref is "https://github.com/epam/JDI"

  Scenario: Get link url path test
    Given I open "Home Page"
    Then "Github Link" url path is "/epam/JDI"

  Scenario: Get link alt test
    Given I open "Home Page"
    Then "Github Link" alt is ""

  Scenario: Click link test
    Given I open "Home Page"
    When I click on "Github Link"
    Then Current URL is "https://github.com/epam/JDI"

  Scenario: Link assertion text validation test
    Given I open "Home Page"
    Then Link text is "JDI GITHUB"
    And Link text ignoring case is "jdi GITHUB"

  Scenario: Link assertion activity validation test
    Given I open "Home Page"
    Then Link is enabled

  Scenario: Link assertion alt validation test
    Given I open "Home Page"
    Then Link alt contains ""

  Scenario: Link assertion ref validation test
    Given I open "Home Page"
    Then Link ref contains "github"

  Scenario: Link assertion assertion text validation test
    Given I open "Home Page"
    Then Link asserts that link text is "JDI GITHUB"

  Scenario: Base link validation test
    Given I open "Home Page"
    Then Base validation of "Github Link"

#  Scenario: Get link text test
#    Given I open "Html5 Page"
#    Then "Github Link" text is "Github JDI"
#
#  Scenario: Get link value test
#    Given I open "Html5 Page"
#    Then "Github Link" value is "Github JDI"
#
#  Scenario: Get link ref test
#    Given I open "Html5 Page"
#    Then "Github Link" ref is "https://github.com/jdi-testing"
#
#  Scenario: Get link url path test
#    Given I open "Html5 Page"
#    Then "Github Link" url path is "/jdi-testing"
#
#  Scenario: Get link alt test
#    Given I open "Html5 Page"
#    Then "Github Link" alt is "Github JDI Link"
#
#  Scenario: Click link test
#    Given I open "Html5 Page"
#    When I click on "Github Link"
#    Then Current URL is "https://github.com/jdi-testing"
#
#  Scenario: Link assertion text validation test
#    Given I open "Html5 Page"
#    Then Link text is "Github JDI"
#    And Link text ignoring case is "Github jdi"
#
#  Scenario: Link assertion activity validation test
#    Given I open "Html5 Page"
#    Then Link is enabled
#
#  Scenario: Link assertion alt validation test
#    Given I open "Html5 Page"
#    Then Link alt contains "JDI"
#
#  Scenario: Link assertion ref validation test
#    Given I open "Html5 Page"
#    Then Link ref contains "github"
#
#  Scenario: Link assertion assertion text validation test
#    Given I open "Html5 Page"
#    Then Link asserts that link text is "Github JDI"
#
#  Scenario: Base link validation test
#    Given I open "Html5 Page"
#    Then Base validation of "Github Link"

