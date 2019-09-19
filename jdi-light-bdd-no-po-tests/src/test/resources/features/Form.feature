@form
Feature: Form

  Background:
    Given I'm on "Contacts Page" page

  Scenario: fill Contact Form from json
    When I fill form "Contact Form" with "Roman Contacts"
     And click on "Submit Button"
    Then the form "Contact Form" data equals to "Roman Contacts"

  Scenario: fill Contact Form from table
    When I fill form "Contact Form" with data:
      | Name              | Roman |
      | Last Name         | Iovlev |
      | Position          | ChiefQA |
      | Passport Number   | 654321 |
      | Passport Seria    | 1234 |
      | Description       | JDI - awesome UI automation tool |
      | Gender            | Female |
      | Religion          | Other |
    And click on "Submit Button"
    Then the form "Contact Form" data equals to:
      | Name              | Roman |
      | Last Name         | Iovlev |
      | Position          | ChiefQA |
      | Passport Number   | 654321 |
      | Passport Seria    | 1234 |
      | Description       | JDI - awesome UI automation tool |
      | Gender            | Female |
      | Religion          | Other |