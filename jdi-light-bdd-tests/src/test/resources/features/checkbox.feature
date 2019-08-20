Feature: Checkbox

  Scenario: Get Label Text Test
    Given I open "Html5 Page"
    When Check "Accept Conditions" checkbox
    Then "Accept Conditions" checkbox label text equals to "Accept terms and conditions"

  Scenario: Check Test
    Given I open "Html5 Page"
    When Check "Accept Conditions" checkbox
    When Check "Accept Conditions" checkbox
    Then "Accept Conditions" checkbox is selected

  Scenario: Uncheck Test
    Given I open "Html5 Page"
    When Check "Accept Conditions" checkbox
    When Uncheck "Accept Conditions" checkbox
    Then "Accept Conditions" checkbox is deselected

  Scenario: Click Test
    Given I open "Html5 Page"
    When Check "Accept Conditions" checkbox
    Then "Accept Conditions" checkbox is selected
    When Click "Accept Conditions" checkbox
    Then "Accept Conditions" checkbox is deselected

  Scenario: Is Validation Test
#    TODO (Waiting for common methods enabled() and displayed() in BDD branch)

  Scenario: Label Test
    Given I open "Html5 Page"
    When Check "Accept Conditions" checkbox
    Then "Accept Conditions" checkbox label text equals to "Accept terms and conditions"
    Then "Accept Conditions" checkbox label text contains "terms and conditions"
    Then "Accept Conditions" checkbox label text equals to "accept terms and conditions" ignoring case

#  The same as part of the Click Test
#  Scenario: Assert Validation Test
#    Given I open "Html5 Page"
#    When Check "Accept Conditions" checkbox
#    Then "Accept Conditions" checkbox is selected