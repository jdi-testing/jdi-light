Feature: BaseUIElement 

Scenario: click 
	Given I open "Html5 Page" 
	When Click on "Red Button" BaseUIElement 
	Then Alert text equals "Red button" 
	
Scenario: jsClick 
	Given I open "Html5 Page" 
	When jsClick on "Red Button" BaseUIElement 
	Then Alert text equals "Red button" 
	
Scenario: valueText 
	Given I open "Html5 Page" 
	Then BaseUIElement "Red Button" valueText equals "Big Red Button-Input" 
	
Scenario: labelText 
	Given I open "Html5 Page" 
	Then BaseUIElement "Name" labelText equals "Your name:" 
	
Scenario: sendKeys 
	Given I open "Html5 Page" 
	When Send keys "simple text" to "Name" BaseUIElement 
	Then BaseUIElement "Name" valueText equals "simple text" 
	
Scenario: check 
	Given I open "Html5 Page" 
	When Check "Accept Conditions" BaseUIElement 
	Then BaseUIElement "Accept Conditions" isSelected 
	
Scenario: uncheck 
	Given I open "Html5 Page" 
	When Uncheck "Accept Conditions" BaseUIElement 
	Then BaseUIElement "Accept Conditions" isDeselected 
	
Scenario: clear 
	Given I open "Html5 Page" 
	When Send keys "simple text" to "Name" BaseUIElement 
	Then BaseUIElement "Name" valueText equals "simple text" 
	When Clear "Name" BaseUIElement 
	Then BaseUIElement "Name" valueText equals "" 
	
Scenario: input 
	Given I open "Html5 Page" 
	When Send keys "simple text" to "Name" BaseUIElement 
	Then BaseUIElement "Name" valueText equals "simple text" 
	When Input "Input text" in "Name" BaseUIElement 
	Then BaseUIElement "Name" valueText equals "Input text" 
	
Scenario: select 
	Given I open "Html5 Page" 
	When Select "Casual" from "Dress Code" BaseUIElement 
	Then BaseUIElement "Dress Code" valueText equals "casual" 
	When Select "Pirate" from "Dress Code" BaseUIElement 
	Then BaseUIElement "Dress Code" valueText equals "pirate" 
	
Scenario: placeholder 
	Given I open "Html5 Page" 
	Then BaseUIElement "Name" placeholder equals "Input name"
	
Scenario: getValue 
	Given I open "Html5 Page" 
	When Send keys "simple text" to "Name" BaseUIElement 
	Then BaseUIElement "Name" value equals "simple text" 
	

	
	
