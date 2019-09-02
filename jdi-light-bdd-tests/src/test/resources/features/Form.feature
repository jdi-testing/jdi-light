@Form
Feature: Form
  
  Scenario: fillContactForm
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
    
  Scenario: fillContactFormCustom
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
    

    
  