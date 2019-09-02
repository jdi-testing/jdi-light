@WebPage
Feature: Checking Basic WebPage Actions

  Background:
    Given I should be logged in
    And I open "Contact Form Page"

  Scenario: check URL
    Then Current page URL is "https://jdi-testing.github.io/jdi-light/contacts.html"

  Scenario: check page title
    And Current page Title is "Contact Form"
    And the "Contact Form Page" is opened

  Scenario: scroll to bottom test
    When I scroll to the bottom of the page
    Then the bottom of the page is reached

  Scenario: scroll to top test
    When I scroll to the top of the page
    Then the top of the page is reached

  Scenario: scroll down test
    When I scroll "30" px down
    Then the page is scrolled "30" px down

  Scenario: scroll up test
    When I scroll "20" px up
    Then the page is scrolled "20" px up

  Scenario: scroll right test
    When I scroll "10" px right
    Then the page is scrolled "10" px right

  Scenario: scroll left test
    When I scroll "5" px left
    Then the page is scrolled "5" px left

  Scenario: zoom test
    When I zoom in
    Then the page is zoomed

  Scenario: go back test
    When I go back
    Then Current page Title is "Home Page"

  Scenario: go forward test
    When I go forward
    Then Current page Title is "Contact Form"

  Scenario: page refresh test
    When Refresh webpage
    Then Current page Title is "Contact Form"