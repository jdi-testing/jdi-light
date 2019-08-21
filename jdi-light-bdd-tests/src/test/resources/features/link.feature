Feature: link

  Scenario: Link text equivalence test
    Given I open "Html5 Page"
    Then "Github Link" text equals to "Github JDI"

  Scenario: Link text equivalence ignoring case test
    Given I open "Html5 Page"
    Then "Github Link" text ignoring case equals to "Github jdi"

  Scenario: Link reference equivalence test
    Given I open "Html5 Page"
    Then "Github Link" reference equals to "https://github.com/jdi-testing"

  Scenario: Link reference likeness test
    Given I open "Html5 Page"
    Then "Github Link" reference contains "github"

  Scenario: Link URL path test
    Given I open "Html5 Page"
    Then "Github Link" link URL path equals to "/jdi-testing"

  Scenario: Link alt text equivalence test
    Given I open "Html5 Page"
    Then "Github Link" alt text equals to "Github JDI Link"

  Scenario: Link alt text matching to RegExp
    Given I open "Html5 Page"
    Then "Github Link" alt text match to "Git.* JE*DI Link"

  Scenario: Link alt text likeness test
    Given I open "Html5 Page"
    Then "Github Link" alt text contains "JDI"

  Scenario: Click link test
    Given I open "Html5 Page"
    When Click on "Github Link"
    Then Current URL is "https://github.com/jdi-testing"

  Scenario: Link activity validation test
    Given I open "Html5 Page"
    Then "Github Link" is enabled

  Scenario: Base link validation test
    Given I open "Html5 Page"
    Then "Github Link" is basically valid
