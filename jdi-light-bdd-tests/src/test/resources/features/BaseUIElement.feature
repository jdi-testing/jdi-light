Feature: BaseUIElement

Scenario: click 
	Given I open "Html5 Page" 
	When Click on "Red Button" 
	Then Alert text equals to "Red button" 
	
Scenario: jsClick 
	Given I open "Html5 Page" 
	When jsClick on "Red Button" 
	Then Alert text equals to "Red button" 
	
Scenario: value text 
	Given I open "Html5 Page" 
	Then "Red Button" value text equals to "Big Red Button-Input" 
	
Scenario: labelText 
	Given I open "Html5 Page" 
	Then "Name" label text equals to "Your name:" 
	
Scenario: sendKeys 
	Given I open "Html5 Page" 
	When Send keys "simple text" to "Name" 
	Then "Name" value text equals to "simple text" 
	
Scenario: check 
	Given I open "Html5 Page" 
	When Check "Accept Conditions" 
	Then "Accept Conditions" is selected 
	
Scenario: uncheck 
	Given I open "Html5 Page" 
	When Uncheck "Accept Conditions" 
	Then "Accept Conditions" is deselected 
	
Scenario: clear 
	Given I open "Html5 Page" 
	When Send keys "simple text" to "Name" 
	Then "Name" value text equals to "simple text" 
	When Clear "Name" 
	Then "Name" value text equals to "" 
	
Scenario: input 
	Given I open "Html5 Page" 
	When Send keys "simple text" to "Name" 
	Then "Name" value text equals to "simple text" 
	When Input "Input text" in "Name" 
	Then "Name" value text equals to "Input text" 
	
Scenario: select 
	Given I open "Html5 Page" 
	When Select "Casual" field from "Dress Code" 
	Then "Dress Code" value text equals to "casual" 
	When Select "Pirate" field from "Dress Code" 
	Then "Dress Code" value text equals to "pirate" 
	
Scenario: multiselect 
	Given I open "Html5 Page" 
	When Select "Steam;Wood" fields from "Ages" 
	Then "Ages" value equals to "Steam;Wood"
	
Scenario: placeholder 
	Given I open "Html5 Page" 
	Then "Name" placeholder equals to "Input name"
	
Scenario: getValue 
	Given I open "Html5 Page" 
	When Send keys "simple text" to "Name" 
	Then "Name" value equals to "simple text" 
	
Scenario: innerText 
	Given I open "Html5 Page" 	
	Then "Blue Button" inner text equals to "BIG BLUE BUTTON"
	
Scenario: get text 
	Given I open "Html5 Page" 	
	Then "Blue Button" text equals to "BIG BLUE BUTTON"
	
Scenario: getAttribute
	Given I open "Html5 Page" 	
	Then "Disabled Name" attribute "id" equals to "disabled-name"
	
Scenario: isEnabled
	Given I open "Html5 Page" 	
	Then "Name" is enabled
	
Scenario: isDisabled
	Given I open "Html5 Page" 	
	Then "Disabled Name" is disabled
	
Scenario: isHidden
	Given I open "Html5 Page" 	
	Then "Logout" is hidden
	
Scenario: isDisplayed
	Given I open "Html5 Page" 	
	Then "Name" is displayed
	
Scenario: setText 
	Given I open "Html5 Page" 
	When Send keys "simple text" to "Name" 
	Then "Name" value text equals to "simple text" 
	When Set text "Input text" in "Name" 
	Then "Name" value text equals to "Input text" 
	
Scenario: rightClick 
	Given I open "Html5 Page" 
	When Right click on "Right Click Button" 
	Then Alert text equals to "Right Click" 
	
Scenario: doubleClick 
	Given I open "Html5 Page" 
	When Double click on "Double Click Button" 
	Then Alert text equals to "Double Click" 

	


	

	
	
