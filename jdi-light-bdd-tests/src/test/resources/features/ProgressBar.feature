Feature: ProgressBar
Background:
 # I should be login
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
#  And "Progress" attribute "volume" greater or equal to "10"
#  And "Progress" attribute "volume" less or equal to "100"
  And "Progress" attribute "value" equals to "70"
  And "Progress" is enabled
#@Test
#public void isValidationTest() {
#progress.assertThat().maxVolume(is(100));
#progress.is().volume(greaterThanOrEqualTo(10));
#progress.is().volume(lessThanOrEqualTo(100));
#progress.assertThat().volume(is(70));
#progress.is().enabled();
#}

Scenario: label test
  Given I open "Html5 Page" page
  Then "Progress" text equals to "File progress"
  And "Progress" text contains "progress"
#@Test
#public void labelTest() {
#assertEquals(progress.label().getText(), "File progress");
#progress.label().is().text(containsString("progress"));
#progress.label().assertThat().text(equalToIgnoringCase("file progress"));
#}

Scenario: base validation test
  Given I open "Html5 Page" page
  Then "Progress" is basically valid

}
