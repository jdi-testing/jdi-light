@Label
Feature: Label

  Scenario: Text equals
    Given I open "Html5 Page"
    Then the "Jdi Title" text equals to "JDI TESTING PLATFORM"
    
  Scenario: Text contains
    Given I open "Html5 Page"
    Then the "Jdi Title" text contains "TESTING"
  
  Scenario: Text matches
    Given I open "Html5 Page"
    Then the "Jdi Title" text matches to "\w{3} \w{7} \w{8}"
    
  Scenario: Base validation
    Given I open "Html5 Page"
    Then the "Jdi Title" is basically valid