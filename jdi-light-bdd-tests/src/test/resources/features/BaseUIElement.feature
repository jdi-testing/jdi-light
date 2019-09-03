@base
Feature: BaseUIElement

  Scenario: click 
	Given I open "Html5 Page"
	When I click on "Red Button" 
	Then the Alert text equals to "Red button"
	
  Scenario: jsclick 
	Given I open "Html5 Page"
	When click with JS on "Red Button" 
	Then the Alert text equals to "Red button"
	
  Scenario: value 
	Given I open "Html5 Page" 
	Then the "Red Button" text equals to "Big Red Button-Input"
	
  Scenario: labelText 
	Given I open "Html5 Page" 
	Then the "Name" label text equals to "Your name:"

  Scenario: sendKeys 
	Given I open "Html5 Page" 
	When I send keys "simple 1234" to "Name"
	Then the "Name" text matches to "\w{6} \d{4}"
	
  Scenario: check 
	Given I open "Html5 Page" 
	When check "Accept Conditions" 
	Then the "Accept Conditions" is selected 
	
  Scenario: uncheck 
	Given I open "Html5 Page" 
	When uncheck "Accept Conditions" 
	Then the "Accept Conditions" is deselected 
	
  Scenario: clear 
	Given I open "Html5 Page"
    When clear "Name"
	When send keys "simple text" to "Name" 
	Then the "Name" text equals to "simple text"
	When I clear "Name"
	Then the "Name" text equals to ""

  Scenario: css
	Given I open "Html5 Page"
	Then the "Name" css "font-size" equals to "14px"

  Scenario: input 
	Given I open "Html5 Page"
    When clear "Name"
    When send keys "simple text" to "Name"
	Then the "Name" text equals to "simple text"
	When input "Input text" in "Name" 
	Then the "Name" text equals to "Input text"
	
  Scenario: placeholder 
	Given I open "Html5 Page" 
	Then the "Name" placeholder equals to "Input name"
	
  Scenario: getValue 
	Given I open "Html5 Page" 
	When input "simple text" in "Name"
	Then the "Name" text equals to "simple text"
	
  Scenario: getText 
	Given I open "Html5 Page" 	
	Then the "Blue Button" text equals to "BIG BLUE BUTTON"
	
  Scenario: getAttribute
	Given I open "Html5 Page" 	
	Then the "Disabled Name" attribute "id" equals to "disabled-name"
	
  Scenario: isEnabled
	Given I open "Html5 Page" 	
	Then the "Name" is enabled
	
  Scenario: isDisabled
	Given I open "Html5 Page" 	
	Then the "Disabled Name" is disabled
	
  Scenario: isHidden
	Given I open "Html5 Page" 	
	Then the "Logout" is hidden

  Scenario: isHidden
	Given I open "Html5 Page"
	Then the "Logout" does not appear

  Scenario: isDisplayed
	Given I open "Html5 Page" 	
	Then the "Name" is displayed
	
  Scenario: setText 
	Given I open "Html5 Page" 
	When input "simple text" in "Name"
	Then the "Name" text equals to "simple text"
	When set text "Input text" in "Name" 
	Then the "Name" text equals to "Input text"

  Scenario: select
    Given I open "Html5 Page"
    When select "Pirate" field from "Dress Code"
    Then the "Dress Code" text equals to "Pirate"