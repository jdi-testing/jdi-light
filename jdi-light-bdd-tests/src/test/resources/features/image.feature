Feature: image

Scenario: Check image source
  Given I open "Html5 Page"
  Then source of image "Jdi Logo" is "https://jdi-testing.github.io/jdi-light/images/jdi-logo.jpg"

Scenario: Check image alt attribute
  Given I open "Html5 Page"
  Then image "Jdi Logo" alt attribute is "Jdi Logo 2"

Scenario: Click at image and accept Alert
  Given I open "Html5 Page"
  When click at image "Jdi Logo"
  Then check Alert text is "JDI Logo"
  Then accept Alert

Scenario: Image validation test
  Given I refresh webpage
  Then image source of "Jdi Logo" contains "jdi-logo.jpg"
  And image "Jdi Logo" alt attribute is "Jdi Logo 2"
  And image "Jdi Logo" height is 100
  And image "Jdi Logo" width is 101

Scenario: Check
  Given I open "Html5 Page"
  Then "Jdi Logo" alt is "Jdi Logo 2"

Scenario: Do base validation
  Given I open "Html5 Page"
  Then do "Jdi Logo" base validation



public void baseValidationTest() {
baseValidation(jdiLogo);
}



#click()	click on the image	void
##src()	get value of src attribute	String
##height()	get value of height attribute	String
##width()	get value of width attribute	String
##alt()	get value of alt attribute	String
##is()	method for building assertions	ImageAssert
##assertThat()