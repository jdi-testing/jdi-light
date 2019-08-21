Feature: ColorPicker

  Scenario: Color picker get color test
    Given I open "Html5 Page"
    And "Color Picker" was set to "#ffd7a6" color
    Then "Color Picker" have "#ffd7a6" color

  Scenario: Color picker set color test
    Given I open "Html5 Page"
    When I set "Color Picker" to "#ffd7a6" color
    Then "Color Picker" have "#ffd7a6" color

  Scenario: Color picker is() validation test
    Given I open "Html5 Page"
    And "Color Picker" was set to "#ffd7a6" color
    Then is validation for "Color Picker" is successful with color "#ffd7a6"

  Scenario: Color picker label assertion test
    Given I open "Html5 Page"
    Then "Color Picker" label has "Select a color" text

  Scenario: Color picker assertThat validation test
    Given I open "Html5 Page"
    And "Color Picker" was set to "#ffd7a6" color
    Then "Color Picker" has "#ffd7a6" color

  Scenario: baseValidation
    Given I open "Html5 Page"
    Then "Color Picker" is basically valid