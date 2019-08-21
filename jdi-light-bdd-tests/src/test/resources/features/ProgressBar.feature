Feature: ProgressBar
#Background:
#  I should be logged in
#@BeforeMethod
#public void before() {
#shouldBeLoggedIn();
#html5Page.shouldBeOpened();
#}
#Scenario: check label
#  Given I open "Html5 Page" page
#  Then "Progress" attribute "label
#@Test
#public void getLabelTextTest() {
#assertEquals(progress.labelText(), "File progress");
#}
Scenario: check progress bar value
  Given I open "Html5 Page" page
  Then "Progress" attribute "value" equals to "70"

Scenario: check max value of progress bar
  Given I open "Html5 Page" page
  Then "Progress" attribute "max" equals to "100"

Scenario: progress bar validation
  Given I open "Html5 Page" page
  Then "Progress" attribute "max" equals to "100"
  And "Progress" volume greater or equal to 10
  And "Progress" volume less or equal to 100
  And "Progress" attribute "value" equals to "70"
  And "Progress" is enabled

Scenario: label test
  Given I open "Html5 Page" page
  Then "Progress" text equals to "File progress"
  And "Progress" text contains "progress"

Scenario: base validation test
  Given I open "Html5 Page" page
  Then "Progress" is basically valid