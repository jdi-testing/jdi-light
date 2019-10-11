@form
Feature: Form

  Scenario: fill Contact Form from json
    Given I open "Contact Form Page"
    When submit form "Contact Form" with "Roman Contacts"
    Then the form "Contact Form" data equals to "Roman Contacts"
  
  Scenario: fill Contact Form
    Given I open "Contact Form Page"
    When submit form "Contact Form" with data:
      |name|Roman|
      |lastName|Iovlev|
      |position|ChiefQA|
      |passportNumber|654321|
      |passportSeria|1234|
      |description|JDI - awesome UI automation tool|
      |acceptConditions|true|
      |gender|Female|
      |religion|Other|
    Then the form "Contact Form" data equals to:
      |name|Roman|
      |lastName|Iovlev|
      |position|ChiefQA|
      |passportNumber|654321|
      |passportSeria|1234|
      |description|JDI - awesome UI automation tool|
      |acceptConditions|true|
      |gender|Female|
      |religion|Other|
    
  Scenario: fill Contact Form Custom
    Given I open "Contact Form Page"
    When fill form "Contact Form" with data:
      |name|Roman|
      |lastName|Iovlev|
      |position|ChiefQA|
      |passportNumber|654321|
      |passportSeria|1234|
      |description|JDI - awesome UI automation tool|
      |acceptConditions|true|
      |gender|Female|
      |religion|Other|
    And submit form
    Then the form "Contact Form" data equals to:
      |name|Roman|
      |lastName|Iovlev|
      |position|ChiefQA|
      |passportNumber|654321|
      |passportSeria|1234|
      |description|JDI - awesome UI automation tool|
      |acceptConditions|true|
      |gender|Female|
      |religion|Other|
    
  Scenario: is displayed
    Given I open "Contact Form Page"
    Then the "Contact Form" is displayed
    

    
  