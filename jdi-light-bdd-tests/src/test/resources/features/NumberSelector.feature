@NumberSelector
Feature: NumberSelector

  Scenario: Get label text
    Given I open "Html5 Page"
    Then "Height" label text equals to "Height (metres):"
    Then "Height" label text contains "Height"
    
  Scenario: Set number 
    Given I open "Html5 Page"
    When I Set number "2.1" in "Height" number selector
    Then "Height" text equals to "2.1"
    
  Scenario: Get minValue
    Given I open "Html5 Page"
    Then "Height" number selector min is "0.3"
    
  Scenario: Get maxValue
    Given I open "Html5 Page"
    Then "Height" number selector max is "2.5"
    
  Scenario: Get step
    Given I open "Html5 Page"
    Then "Height" number selector step is "0.2"
    
  Scenario: Get placeholder
    Given I open "Html5 Page"
    Then "Height" placeholder equals to "20 cm increments. Range [0.3,2.5]"
    
  Scenario: Validation 
    Given I open "Html5 Page"
    Then "Height" number selector min is "0.3"
    And "Height" number selector max is "2.5"
    And "Height" number selector step is "0.2"
    And "Height" placeholder contains "20 cm increments"
    And "Height" number selector value is greater or equal to "0.3"
    And "Height" number selector value less or equal to "2.5"
    And "Height" text equals to "2.1"
    And "Height" is enabled
    
  Scenario: Assert validation
    Given I open "Html5 Page"
    Then "Height" number selector value is greater than "0.0"
    And "Height" number selector value less than "3.0"
    And "Height" text equals to "2.1"
  
  Scenario: Base validation
    Given I open "Html5 Page"
    Then "Height" is basically valid
  
  