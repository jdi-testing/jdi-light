<h1> How to launch HTML Web tests on Android emulator or IOS simulator</h1>  
<h3> Requirements for Android</h3>

Required tools: Android Studio, Appium, Maven.

1. Download <b>chrome driver</b> For more details
   visit: https://github.com/appium/appium/blob/master/docs/en/writing-running-appium/web/chromedriver.md
It is recommended to use the version of <b>chrome driver</b> >= 87. 
The version of Chrome browser in the Android emulator must be the same. Then go to <b>src/test/resources</b> of
module <b>jdi-light-mobile-angular-web-tests</b>.

2. Set following settings in <b>test.properties</b> file: <br>
   <b>driver=android</b>; <br>
   <b>remote.type=appium</b>; <br>
   <b>appium.capabilities.path=android.properties</b>; <br>
   <b>driver.remote.run=true</b>; <br>
   If your version of appium has its own URL (not http://0.0.0.0:4723), specify it in the <b>driver.remote.url</b>
   property.   
2.1. Set following settings in <b>android.properties</b> file:<br>
<b>platformName=Android</b>; <br>
<b>deviceName=emulator-5554</b>; <br>
<b>chromedriverExecutable=emulator-5554</b>; <br>
Here <b>deviceName</b> and <b>platformName</b> must be the same as Desired Capabilities in Inspector Session window was
started from Appium (see future steps).<br>
2.2. Set following settings in <b>chrome.properties file</b>: <br>
<b>w3c=false</b>;

3. Launch Android emulator and wait until home screen is ready.

4. Launch Appium from console or using UI.<br>
   <code>appium -p 4723 --chromedriver-executable /path/to/your/chromedriver</code>
   
5. Wait for Appium server ready and then open new Inspector Session window and set Desired Capabilities as described in
   2.1
   
6. 1 Go to module <b>jdi-light-angular-web-tests</b><br>
   2 Run maven script: <code>mvn clean package -U -DskipTests</code> to make .jar package of tests for future dependency.
   
Note: Before reloading module <b>jdi-light-mobile-angular-web-tests</b> should be reloaded module <b>jdi-light</b>. 

<h3> Requirement for iOS</h3>

Required tools for iOS: Xcode, Appium, Maven.<br>
In general settings absolutely the same as for Android, but you need to use <b>ios.properties</b> instead of <b>android.properties</b> 
and in <b>test.properties</b> change two fields which use android to iOS:

1. Set following settings in <b>test.properties</b> file: <br>
   <b>driver=ios</b>; <br>
   <b>remote.type=appium</b>; <br>
   <b>appium.capabilities.path=ios.properties</b>; <br>
   <b>driver.remote.run=true</b>; 
   
2. Set following settings in <b>ios.properties</b> file:<br>
    <b>platformName=ios</b>; <br>
    <b>automationName=XCUITest</b>;<br>
    <b>platformVersion=14.2</b>;<br>
    <b>deviceName=iPhone 11</b>; <br>
    <b>browserName=Safari</b>; <br>
    
<h3> Debugging and test running. </h3>
    Go to module <b>jdi-light-mobile-angular-web-tests</b>
<h5>Test Run</h5>

Run maven script from the module root:<br>

- <code>mvn clean test site -U -Dtest=TestClassToRunName.java#testMethodToRun</code> <br>
or just execute script: <code>mvn clean test site -U</code><br>

- <code>mvn clean test site -Dsuite.xml.file=src/test/resources/demoRun.xml</code>
<br>(for run tests which is already exist in xml-file; use 'site' for Allure Report) 

<h5> Debug </h5>

Debug from maven run (with breakpoints in IDE) could be performed like example below:<br>
1. Create maven configuration with script: <br>
<code>mvn clean test -Dtest=TestClassToRunName.java#testMethodToRun -U -Dmaven.surefire.debug -DforkCount=0 -DreuseForks=false</code>

2. Run this configuration in IDE using debug mode.

<h3> How to edit source code of tests in src/test and debug classes directly:</h3>
<h5>Dirty way</h5>

1. In <b>pom.xml</b> comment or delete <b>test-jar</b> dependency: <b>jdi-light-angular-tests</b> with  <b>test-jar</b> type
 
2. Go to module <b>jdi-light-angular-tests</b> and copy all from <b>src/test/java</b><br>
<b>But TestsInit.java interface must be excluded</b>

3. Go to module <b>jdi-light-mobile-angulat-web-tests</b> <br>
Note: Do not delete old <b>TestsInit.java</b> interface in <b>src/test/java</b><br>
3.1. But delete all from <b>src/test/java</b> except TestsInit.java

4. Paste all from 2. to <b>src/test/java</b><br> but do not replace <b>TestsInit.java</b>

5. Run tests or debug like described before.

<h3> How to edit source code of tests with no option to debug test classes directly:</h3>
<h5>Clean way</h5>

1. Go to module <b>jdi-light-angular-tests</b>

2. Edit or develop source code of tests in src/test folder

3. When finish - repeat step 6.2 from <b>Requirements for Android</b> section

4. Go to module <b>jdi-light-mobile-angular-web-tests</b> and rerun maven script to apply changes: <code>mvn clean install -U -DskipTests</code></b>
