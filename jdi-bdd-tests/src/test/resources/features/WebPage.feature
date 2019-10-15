@webpage
Feature: Checking Basic WebPage Actions

  Background:
    Given I open "Home Page" page
    And I open url "https://jdi-testing.github.io/jdi-light/superpage.html"

  Scenario: check URL
    Then the current page url is "https://jdi-testing.github.io/jdi-light/superpage.html"

  Scenario: check page title
    Then the current page title is "Superpage"

  Scenario: scroll to bottom test
    When I scroll to the bottom of the page
    Then the bottom of the page is reached

  Scenario: scroll to top test
    When I scroll to the top of the page
    Then the top of the page is reached

  Scenario: scroll down and up test
    When I scroll "30" px down
    And I scroll "20" px up
    Then the page is scrolled "10" px down

  Scenario: scroll right and left test
    When I scroll "10" px right
    And I scroll "5" px left
    Then the page is scrolled "5" px right

  Scenario: zoom test
    When I zoom in "2" times
    Then the page is zoomed "2" times

  Scenario: go back test
    When I go back
    Then the current page title is "Home Page"

  Scenario: go forward test
    When I go forward
    Then the current page title is "Superpage"

  Scenario: page refresh test
    When refresh webpage
    Then the current page title is "Superpage"