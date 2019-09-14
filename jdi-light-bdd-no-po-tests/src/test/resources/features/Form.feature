@form
Feature: Form

  Background:
    Given I logged in with name "Roman" and password "Jdi1234"
    And I open page by url "https://jdi-testing.github.io/jdi-light/contacts.html"

  Scenario: fill Contact Form from json
    When submit form "Contact Form" with "Roman Contacts"
    Then the form "Contact Form" data equals to "Roman Contacts"
  
  Scenario: fill Contact Form
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
    

    
  