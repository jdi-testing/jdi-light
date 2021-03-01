#Instruction
##Requirements for Android
Required tools: Android Studio, Appium, Maven.<br>
1. Download **chrome driver** For more details
   visit: https://github.com/appium/appium/blob/master/docs/en/writing-running-appium/web/chromedriver.md <br>
It is recommended to use the version of **chrome driver** >= 87.
The version of Chrome browser in the Android emulator must be the same. Then go to **src/test/resources** of
module **jdi-light-mobile-bootstrap-web-tests**.
2. Set following settings in **test.properties** file:<br>
```
    driver=android
    remote.type=appium
    appium.capabilities.path=android.properties
    driver.remote.run=true
```
If your version of appium has its own URL (not http://0.0.0.0:4723), specify it in the **driver.remote.url**
property<br>
3. Set following settings in **android.properties** file:<br>
```
    platformName=Android
    deviceName=emulator-5554
    chromedriverExecutable={ABSOLUTE_PATH_TO_CHROMEDRIVER}\\chromedriver.exe
```
Here **deviceName** and **platformName** must be the same as Desired Capabilities in Inspector Session window that was
started from Appium (see future steps). **chromedriverExecutable** should be an absolute path to chromedriver file (version must be equal to the Chrome browser version on your device at least the number before the first dot)<br>
4. Set following settings in **chrome.properties** file: **w3c=false**;
   1. Launch Android emulator and wait until home screen is ready
   1. Launch Appium from console or using UI. For commandline it is just `appium`
   1. Wait for Appium server ready and then open new Inspector Session window and set Desired Capabilities as described in 1.1
5. 1. Go to module **jdi-light-bootstrap-tests**<br>
   1. Run maven script: <code>mvn clean package -U -DskipTests</code> to make .jar package of tests for future dependency.

Note: Before reloading module **jdi-light-mobile-bootstrap-web-tests** should be reloaded module **jdi-light**.
##Requirement for iOS
Required tools for iOS: Xcode, Appium, Maven.<br>
In general settings absolutely the same as for Android but you need to use **ios.properties** instead of **android.properties** 
and in **test.properties** change two fields which use android to ios:
1. Set following settings in **test.properties** file: <br>
```   
   driver=ios 
   remote.type=appium 
   appium.capabilities.path=ios.properties
   driver.remote.run=true
```   
2. Set following settings in **ios.properties** file:<br>
``` 
    platformName=ios
    automationName=XCUITest
    platformVersion=14.2
    deviceName=iPhone 11
    browserName=Safari
```    
##Debugging and test running. 
Go to module **jdi-light-mobile-bootstrap-web-tests**
###Test Run
Run maven script from the module root:<br>
- `mvn clean test site -U -Dtest=TestClassToRunName.java#testMethodToRun` <br>
or just execute script: `mvn clean test site -U`<br>
- `mvn clean test site -Dsuite.xml.file=src/test/resources/demoRun.xml` <br>
for tests which is already exist in xml-file; use 'site' for Allure Report
###Debug
Debug from maven run (with breakpoints in IDE) could be performed like example below:<br>
1. Create maven configuration with script: <br>
`mvn clean test -Dtest=TestClassToRunName.java#testMethodToRun -U -Dmaven.surefire.debug -DforkCount=0 -DreuseForks=false`
2. Run this configuration in IDE using debug mode.
## How to edit source code of tests in src/test and debug classes directly:
###Dirty way
1. In **pom.xml** comment or delete **test-jar** dependency: **jdi-light-bootstrap-tests** with  **test-jar** type
2. Go to module **jdi-light-bootstrap-tests** and copy all from **src/test/java**<br>
**But TestsInit.java interface must be excluded**
3. Go to module **jdi-light-mobile-html-web-tests** <br>
Note: Do not delete old TestsInit.java interface in src/test/java<br>
    1. But delete all from **src/test/java** except **TestsInit.java**
4. Paste all from 2. to **src/test/java**<br> but do not replace **TestsInit.java**
5. Run tests or debug like described before.
##How to edit source code of tests with no option to debug test classes directly:</h3>
###Clean way
1. Go to module **jdi-light-bootstrap-tests**
2. Edit or develop source code of tests in src/test folder
3. When finish - repeat step 6.2 from **Requirements for Android**> section
4. Go to module **jdi-light-mobile-bootstrap-web-tests** and rerun maven script to apply changes:<br>
   `mvn clean install -U -DskipTests`