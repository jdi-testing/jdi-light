<h1>How to launch HTML Web tests on Android emulator or iOS simulator</h1>
<h3> Requirements for Android</h3>
Required tools for Android: Android Studio, Appium, Maven.<br>

1. Download chrome driver For more details
   visit: https://github.com/appium/appium/blob/master/docs/en/writing-running-appium/web/chromedriver.md <br>
The version of Chrome browser in the Android emulator must be the same. Then go to <b>src/test/resources</b> of
module <b>jdi-light-mobile-html-web-tests</b>.<br>
2. Set following settings in test.properties file: <br>
   <b>driver=android</b>; <br>
   <b>remote.type=appium</b>; <br>
   <b>appium.capabilities.path=android.properties</b>; <br>
   <b>driver.remote.run=true</b>; <br>
   If your version of appium has its own URL (not http://0.0.0.0:4723), specify it in the <b>driver.remote.url</b>
   property<br>
2.1. Set following settings in android.properties file:<br>
<b>platformName=Android</b>; <br>
<b>deviceName=emulator-5554</b>; <br>
<b>chromedriverExecutable=emulator-5554</b>; <br>
Here <b>deviceName</b> and <b>platformName</b> must be the same as Desired Capabilities in Inspector Session window was
started from Appium (see future steps).<br>
2.2. Set following settings in chrome.properties file: <br>
<b>w3c=false</b>;<br>
3. Launch Android emulator and wait until home screen is ready.<br>
4. Launch Appium from console or using UI.<br>
   <code>appium -p 4723 --chromedriver-executable /path/to/your/chromedriver</code><br>
5. Wait for Appium server ready and then open new Inspector Session window and set Desired Capabilities as described in
   1.1<br>
6. 1 Go to module <b>jdi-light-html-tests</b><br>
   2 Run maven script: <code>mvn clean package -U -DskipTests</code> to make .jar package of tests for future dependency.

<h3> Requirement for iOS</h3>
Required tools for Ios: Xcode, Appium, Maven.<br>
In general settings absolutely the same as for Android but you need to use ios.properties instead of android.properties 
and in test.properties change two fields which use android to iOS:

1. Set following settings in test.properties file: <br>
   <b>driver=ios</b>; <br>
   <b>remote.type=appium</b>; <br>
   <b>appium.capabilities.path=ios.properties</b>; <br>
   <b>driver.remote.run=true</b>; <br>
2. Set following settings in ios.properties file:<br>
    <b>platformName=ios</b>; <br>
    <b>automationName=XCUITest</b>;<br>
    <b>platformVersion=14.2</b>;<br>
    <b>deviceName=iPhone 11</b>; <br>
    <b>browserName=Safari</b>; <br>
    
    
<h3> Debugging and test running for iOS and Android</h3>
    Go to module <b>jdi-light-mobile-html-web-tests</b>

<h5>Test Run</h5>

Run maven script from the module root:
   - <code>mvn clean test site -U -Dtest=TestClassToRunName.java#testMethodToRun</code> <br>
   or just execute script: <b>mvn clean test site -U</b><br>
   - <code>mvn clean test site -Dsuite.xml.file=src/test/resources/demoRun.xml</code> 
    <br>(for run tests which is already exist in xml-file; use 'site' for Allure Report) 
     
<h5> Debug </h5>
Debug from maven run (with breakpoints in IDE) could be performed like example below:<br>

1. Create maven configuration with script:<br>
<code>mvn clean test -Dtest=TestClassToRunName.java#testMethodToRun -U -Dmaven.surefire.debug -DforkCount=0 -DreuseForks=false</code><br>
2. Run this configuration in IDE using debug mode.

<h3> How to edit source code of tests in src/test and debug classes directly:</h3>
<h5>Dirty way</h5>

1. In <b>pom.xml</b> comment or delete <b>test-jar</b> dependency: <b>jdi-light-html-tests</b> with  <b>test-jar</b> type<br> 
2. Go to module <b>jdi-light-html-tests</b> and copy all from <b>src/test/java</b><br>
<b>But TestsInit.java interface must be excluded</b><br>
3. Go to module jdi-light-mobile-html-web-tests <br>
Note: Do not delete old TestsInit.java interface in src/test/java<br>
3.1. But delete all from src/test/java except TestsInit.java<br>
4. Paste all from 2. to <b>src/test/java</b>, but do not replace TestsInit.java<br>
5. Run tests or debug like described before

<h3> How to edit source code of tests with no option to debug test classes directly:</h3>
<h5>Clean way</h5>

1. Go to module <b>jdi-light-html-tests</b><br>
2. Edit or develop source code of tests in src/test folder<br>
3. When finish - repeat step 6.2.<br>
4. Go to module <b>jdi-light-mobile-html-web-tests</b> and rerun maven script to apply changes: <code>mvn clean install -U -DskipTests</code>
