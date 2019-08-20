Feature: BaseUIElement

Scenario: click 
	Given "Html5 Page" is opened
	When I Click on "Red Button" 
	Then Alert text equals to "Red button" 
	
Scenario: jsClick 
	Given "Html5 Page" page is opened 
	When Click with JS on "Red Button" 
	Then Alert text equals to "Red button" 
	
Scenario: value 
	Given "Html5 Page" is opened 
	Then "Red Button" text equals to "Big Red Button-Input"
	
Scenario: labelText 
	Given "Html5 Page" is opened 
	Then "Name" label text equals to "Your name:"

@test
Scenario: sendKeys 
	Given "Html5 Page" is opened 
	When I Send keys "simple 1234" to "Name"
	Then "Name" text match to "\w{6} \d{4}"
	
Scenario: check 
	Given "Html5 Page" is opened 
	When Check "Accept Conditions" 
	Then "Accept Conditions" is selected 
	
Scenario: uncheck 
	Given "Html5 Page" is opened 
	When Uncheck "Accept Conditions" 
	Then "Accept Conditions" is deselected 
	
Scenario: clear 
	Given "Html5 Page" is opened
    When Clear "Name"
	When Send keys "simple text" to "Name" 
	Then "Name" text equals to "simple text"
	When I Clear "Name"
	Then "Name" text equals to ""
	
Scenario: input 
	Given "Html5 Page" is opened
    When Clear "Name"
    When Send keys "simple text" to "Name"
	Then "Name" text equals to "simple text"
	When Input "Input text" in "Name" 
	Then "Name" text equals to "Input text"
	
Scenario: placeholder 
	Given "Html5 Page" is opened 
	Then "Name" placeholder equals to "Input name"
	
Scenario: getValue 
	Given "Html5 Page" is opened 
	When Input "simple text" in "Name"
	Then "Name" text equals to "simple text"
	
Scenario: getText 
	Given "Html5 Page" is opened 	
	Then "Blue Button" text equals to "BIG BLUE BUTTON"
	
Scenario: getAttribute
	Given "Html5 Page" is opened 	
	Then "Disabled Name" attribute "id" equals to "disabled-name"
	
Scenario: isEnabled
	Given "Html5 Page" is opened 	
	Then "Name" is enabled
	
Scenario: isDisabled
	Given "Html5 Page" is opened 	
	Then "Disabled Name" is disabled
	
Scenario: isHidden
	Given "Html5 Page" is opened 	
	Then "Logout" is hidden

Scenario: isHidden
	Given "Html5 Page" is opened
	Then "Logout" is not appear

Scenario: isDisplayed
	Given "Html5 Page" is opened 	
	Then "Name" is displayed
	
Scenario: setText 
	Given "Html5 Page" is opened 
	When Input "simple text" in "Name"
	Then "Name" text equals to "simple text"
	When Set text "Input text" in "Name" 
	Then "Name" text equals to "Input text"