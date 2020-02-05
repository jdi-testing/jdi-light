@jsonpages
Feature: JsonBasedPage

  Background:
    Given I'm logged in as "Roman" with "Jdi1234" password

  Scenario: json based bootstrap page
    When I open "Bootstrap Page" page
    Then the "Bootstrap Page" page is opened

  Scenario: json based contacts page
    When I open "Contacts Page" page
    Then the "Contacts Page" page is opened