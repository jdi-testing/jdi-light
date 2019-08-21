Feature: link

  Scenario: Link text equivalence test
    Given I open "Html5 Page"
    Then "Github Link" text equals to "Github JDI"

  Scenario: Link text likeness ignoring case test
    Given I open "Html5 Page"
    Then "Github Link" text contains "Github"

  Scenario: Link reference equivalence test
    Given I open "Html5 Page"
    Then "Github Link" reference equals to "https://github.com/jdi-testing"

  Scenario: Link reference likeness test
    Given I open "Html5 Page"
    Then "Github Link" reference contains "github"

  Scenario: Link alternative text equivalence test
    Given I open "Html5 Page"
    Then "Github Link" alternative text equals to "Github JDI Link"

  Scenario: Link alternative text matching to RegExp
    Given I open "Html5 Page"
    Then "Github Link" alternative text match to "Git.* JE*DI Link"

  Scenario: Link alternative text likeness test
    Given I open "Html5 Page"
    Then "Github Link" alternative text contains "JDI"

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
