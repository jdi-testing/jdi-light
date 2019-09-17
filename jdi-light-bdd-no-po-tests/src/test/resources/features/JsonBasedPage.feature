@jsonpages
Feature: JsonBasedPage
  Background:
    Given I logged in with name "Roman" and password "Jdi1234"

  Scenario: json based bootstrap page
    When I open "Bootstrap Page" page
    Then the "Bootstrap Page" page is opened

  Scenario: json based contacts page
    When I open "Contacts Page" page
    Then the "Contacts Page" page is opened