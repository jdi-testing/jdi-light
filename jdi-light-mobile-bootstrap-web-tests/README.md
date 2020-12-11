<h1> How to launch HTMl Web tests on Android emulator</h1>  

Required tools: Android Studio, Appium, Maven.

0) Download chrome driver For more details
   visit: https://github.com/appium/appium/blob/master/docs/en/writing-running-appium/web/chromedriver.md

The version of Chrome browser in the Android emulator must be the same. Then go to <b>src/test/resources</b> of
module <b>jdi-light-mobile-bootstrap-web-tests</b>.

1) Set following settings in test.properties file: <br>
   <b>driver=android</b>; <br>
   <b>remote.type=appium</b>; <br>
   <b>appium.capabilities.path=android.properties</b>; <br>
   <b>driver.remote.run=true</b>; <br>
   If your version of appium has its own URL (not http://0.0.0.0:4723), specify it in the <b>driver.remote.url</b>
   property

1.1) Set following settings in android.properties file:<br>
<b>platformName=Android</b>; <br>
<b>deviceName=emulator-5554</b>; <br>
<b>chromedriverExecutable=emulator-5554</b>; <br>
Here <b>deviceName</b> and <b>platformName</b> must be the same as Desired Capabilities in Inspector Session window was
started from Appium (see future steps).

1.2) Set following settings in chrome.properties file: <br>
<b>w3c=false</b>;

3) Launch Android emulator and wait until home screen is ready.
4) Launch Appium from console or using UI.<br>
   appium -p 4723 --chromedriver-executable /path/to/your/chromedriver
5) Wait for Appium server ready and then open new Inspector Session window and set Desired Capabilities as described in
   1.1
   <br>

6)
    1. Go to module <b>jdi-light-bootstrap-tests</b>
    2. Run maven script: <b>mvn clean package -U -DskipTests</b> to make .jar package of tests for future dependency.

<h3> Debugging and test running. </h3>
    Go to module <b>jdi-light-mobile-bootstrap-web-tests</b>

<h5>Test Run</h5>

1. Run maven script from the module root:<br>
   <b>mvn clean test site -U -Dtest=TestClassToRunName.java#testMethodToRun</b> <br>
   or just execute script: <b>mvn clean test site -U</b><br>

   <h5> Debug </h5>
    Debug from maven run (with breakpoints in IDE) could be performed like example below:<br>
   1. Create maven configuration with script: <b><br>
mvn clean test -Dtest=TestClassToRunName.java#testMethodToRun -U -Dmaven.surefire.debug -DforkCount=0 -DreuseForks=false </b><br>
   2. Run this configuration in IDE using debug mode. 

   <h3> How to edit source code of tests in src/test and debug classes directly:</h3>
<h4>Dirty way</h4>
1. In <b>pom.xml</b> comment or delete <b>test-jar</b> dependency: <b>jdi-light-bootstrap-tests</b> with  <b>test-jar</b> type<br> 
2. Go to module jdi-light-bootstrap-tests and copy all from <b>src/test/java</b><br>
<b>But TestsInit.java interface must be excluded</b><br>
3. Go to module jdi-light-mobile-html-web-tests <br>
Note: Do not delete old TestsInit.java interface in src/test/java<br>
3.1 But delete all from src/test/java except TestsInit.java<br>

4. Paste all from 2. to <b>src/test/java</b><br> but do not replace TestsInit.java<br>

5. Run tests or debug like described before.

<h3> How to edit source code of tests with no option to debug test classes directly:</h3>
<h4>Clean way</h4>
 1. Go to module <b>jdi-light-bootstrap-tests</b><br>
 2. Edit or develop source code of tests in src/test folder<br>
3. When finish - repeat step 6) ii." <br>
4. Go to module <b>jdi-light-mobile-bootstrap-web-tests</b> and rerun maven script to apply changes: <b>mvn clean install -U -DskipTests</b></b>
