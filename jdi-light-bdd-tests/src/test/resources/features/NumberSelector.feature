@numberselector
Feature: NumberSelector

  Scenario: Get label text
    Given I open "Html5 Page"
    Then the "Height" label text equals to "Height (metres):"
    Then the "Height" label text contains "Height"
    
  Scenario: Set number 
    Given I open "Html5 Page"
    When I set text "2.1" in "Height"
    Then the "Height" text equals to "2.1"
    
  Scenario: Get minValue
    Given I open "Html5 Page"
    Then the "Height" number selector min is "0.3"
    
  Scenario: Get maxValue
    Given I open "Html5 Page"
    Then the "Height" number selector max is "2.5"
    
  Scenario: Get step
    Given I open "Html5 Page"
    Then the "Height" number selector step is "0.2"
    
  Scenario: Get placeholder
    Given I open "Html5 Page"
    Then the "Height" placeholder equals to "20 cm increments. Range [0.3,2.5]"
    
  Scenario: Validation 
    Given I open "Html5 Page"
    Then the "Height" number selector min is "0.3"
    And the "Height" number selector max is "2.5"
    And the "Height" number selector step is "0.2"
    And the "Height" placeholder contains "20 cm increments"
    And the "Height" number selector value is greater or equal to "0.3"
    And the "Height" number selector value less or equal to "2.5"
    And the "Height" text equals to "2.1"
    And the "Height" is enabled
    
  Scenario: Assert validation
    Given I open "Html5 Page"
    Then the "Height" number selector value is greater than "0.0"
    And the "Height" number selector value less than "3.0"
    And the "Height" text equals to "2.1"
  
  Scenario: Base validation
    Given I open "Html5 Page"
    Then the "Height" is basically valid
  
  