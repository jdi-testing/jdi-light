@link
Feature: Link

  Scenario: Link text equivalence test
    Given I open "Html5 Page"
    Then the "Github Link" text equals to "Github JDI"

  Scenario: Link text contains test
    Given I open "Html5 Page"
    Then the "Github Link" text contains "Github"

  Scenario: Link reference equivalence test
    Given I open "Html5 Page"
    Then the "Github Link" reference equals to "https://github.com/jdi-testing"

  Scenario: Link reference contains test
    Given I open "Html5 Page"
    Then the "Github Link" reference contains "github"

  Scenario: Link alt text equivalence test
    Given I open "Html5 Page"
    Then the "Github Link" alt text equals to "Github JDI Link"

  Scenario: Link alt text matching to RegExp
    Given I open "Html5 Page"
    Then the "Github Link" alt text match to "Git.* JE*DI Link"

  Scenario: Link alt text contains test
    Given I open "Html5 Page"
    Then the "Github Link" alt text contains "JDI"

  Scenario: Click link test
    Given I open "Html5 Page"
    When click on "Github Link"
    Then the current page URL is "https://github.com/jdi-testing"

  Scenario: Link activity validation test
    Given I open "Html5 Page"
    Then the "Github Link" is enabled

  Scenario: Basic link validation test
    Given I open "Html5 Page"
    Then the "Github Link" is basically valid
