@form
Feature: Form

  Background:
    Given I logged in with name "Roman" and password "Jdi1234"
    And I open page by url "https://jdi-testing.github.io/jdi-light/contacts.html"

  Scenario: fill Contact Form from json
    When fill form "Contact Form" with "Roman Contacts"
     And I click on "Submit Button" element
    Then the form "Contact Form" data equals to "Roman Contacts"

  Scenario: fill Contact Form Custom
    When fill form "Contact Form" with data:
      | Name              | Roman |
      | Last Name         | Iovlev |
      | Position          | ChiefQA |
      | Passport Number   | 654321 |
      | Passport Seria    | 1234 |
      | Description       | JDI - awesome UI automation tool |
      | Gender            | Female |
      | Religion          | Other |
    And I click on "Submit Button" element
    Then the form "Contact Form" data equals to:
      | Name              | Roman |
      | Last Name         | Iovlev |
      | Position          | ChiefQA |
      | Passport Number   | 654321 |
      | Passport Seria    | 1234 |
      | Description       | JDI - awesome UI automation tool |
      | Gender            | Female |
      | Religion          | Other |