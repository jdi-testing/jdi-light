@textfield
Feature: TextField

  Scenario: sendKeys test
    Given I open "Html5 Page"
    When I send keys "Lorem" to "Your Name"
    Then the "Your Name" text equals to "Lorem"

  Scenario: setText test
    Given I open "Html5 Page"
    When I set text "Lorem" in "Your Name"
    Then the "Your Name" text equals to "Lorem"

  Scenario: clear test
    Given I open "Html5 Page"
    And I set text "Lorem" in "Your Name"
    When I clear "Your Name"
    Then the "Your Name" text equals to ""

  Scenario: input test
    Given I open "Html5 Page"
    When I input "Lorem" in "Your Name"
    Then the "Your Name" text equals to "Lorem"

  Scenario: placeholder test
    Given I open "Html5 Page"
    Then the "Your Name" placeholder equals to "Input name"

  Scenario: getText test
    Given I open "Html5 Page"
    And I set text "Lorem" in "Your Name"
    Then the "Your Name" text equals to "Lorem"
