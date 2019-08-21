Feature: ColorPicker

  Scenario: Color picker get color test
    Given I open "Html5 Page"
    And "Color Picker" was set to "#ffd7a6" color
    Then "Color Picker" color equals to "#ffd7a6"

  Scenario: Color picker set color test
    Given I open "Html5 Page"
    When I set "Color Picker" to "#ffd7a6" color
    Then "Color Picker" color equals to "#ffd7a6"

  Scenario: Color picker is() validation test
    Given I open "Html5 Page"
    And "Color Picker" was set to "#ffd7a6" color
    Then is validation for "Color Picker" is successful for color "#ffd7a6"

  Scenario: Color picker label assertion test
    Given I open "Html5 Page"
    Then "Color Picker" label text equals to "Select a color"

  Scenario: Color picker assertThat validation test
    Given I open "Html5 Page"
    And "Color Picker" was set to "#ffd7a6" color
    Then assertThat for "Color Picker" is successful for color "#ffd7a6"

  Scenario: baseValidation
    Given I open "Html5 Page"
    Then "Color Picker" is basically valid