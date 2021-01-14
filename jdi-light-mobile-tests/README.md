<h1>How to launch web tests on Android emulator</h1>  

Stable environment: Java 8, Maven 3.6.3, Jdi 1.2.21, TestNG 6.14.3, Aspectj 1.9.6, Appium 1.18.3, Android 10 <br>

1. Download <b>chrome driver</b> 
For more details visit: https://github.com/appium/appium/blob/master/docs/en/writing-running-appium/web/chromedriver.md
It is recommended to use the version of <b>chrome driver</b> >= 87. 
The version of Chrome browser in the Android emulator must be the same.

2. Set following settings in <b>test.properties</b> file:
<b>driver=android</b>; <br>
<b>remote.type=appium</b>; <br>
If your version of appium has its own URL (not http://0.0.0.0:4723), specify it in the <b>driver.remote.url</b> property
  
3. Launch Android emulator and wait until home screen is ready

4. Launch Appium client  
<code>appium -p 4723 --chromedriver-executable /path/to/your/chromedriver</code>

Note: Before module reloading <b>jdi-light-mobile-tests</b> should be module reloaded <b>jdi-light</b>.   

<h1>How to launch iOS native apps tests example</h1>
Example tests work properly only on macOS computers and iOS 13.4 iPhone simulators<br>
<b>Required tools:</b> macOS 10.15, Xcode 11.5, iOS Simulator 13.4, Appium 1.17.0

1. Set following settings in <b>test.properties</b> file: <br>
   <b>driver=ios</b> <br>
   <b>remote.type=appium</b> <br>
   If your version of appium has its own URL (not http://0.0.0.0:4723), specify it in the <b>driver.remote.url</b> property
   
2. Set following settings in <b>ios.properties</b> file: <br>
   <b>platformVersion=13.4</b> <br>
   <b>deviceName=iPhone 11 (or your preferred iPhone)</b>
   
3. Launch Appium client

4. Open iOS Simulator device

5. Run tests from JDI Light Mobile tests directory:<br>
<code>mvn clean test -Dsuite.xml.file=src/test/resources/iosApps.xml</code>

<h1>How to launch Android native apps tests example</h1>
<b>Required tools:</b> OS Android 10.0, device emulator Pixel XL, Appium 1.18.3<br>

1. Set the following settings in <b>test.properties</b> file: 
<b>driver=android</b> <br>
<b>remote.type=appium</b> <br>
If your version of Appium has its own URL (not http://0.0.0.0:4723), specify it in the <b>driver.remote.url</b> property

2. Set the following settings in <b>android.properties</b> file:
<b>platformName=Android</b> <br>
<b>deviceName=emulator-5554 (the name of your emulated device)</b>

3. Launch Appium client

4. Open Android device emulator

5. Run tests from JDI Light Mobile tests directory:<br>
<b>Directory SystemAndroid10Tests</b><br>
<code>mvn clean test</code>
  
<b>System test also available for Android 11. There are in package SystemAndroid11Tests</b><br>  

<h1>How to launch Android Espresso tests example</h1>
<b>Required tools:</b> OS Android 11.0, device emulator Pixel 3a, Appium 1.18.3

1. Set following settings in <b>test.properties file</b>: <br>
   <b>driver=android</b> <br>
   <b>remote.type=appium</b> <br>
   If your version of appium has its own URL (not http://0.0.0.0:4723), specify it in the <b>driver.remote.url</b> property
   
2. Set following settings in <b>android.properties</b> file: <br>
   <b>platformName=Android</b> <br>
   <b>deviceName=emulator-5554 (the name of your emulated device)</b> <br>
   <b>autoLaunch=true</b> <br>
   <b>appPackage=io.appium.android.apis</b> <br>
   <b>appActivity=ApiDemos</b> <br>
   <b>automationName=Espresso</b> <br>
   <b>forceEspressoRebuild=true</b> <br>
   <b>fullReset=true</b> <br>
   <b>app=<<path_to_jdi-light-mobile-tests_project>>/src/main/resources/ApiDemosEspresso-debug.apk</b> 
   (where <b><<path_to_jdi-light-mobile-tests_project>></b> - absolute path to <b>jdi-light-mobile-tests</b> module)
   
3. Launch Appium client

4. Open Android device emulator

5. Run tests from JDI Light Mobile tests directory:<br>
   <code>mvn clean test -Dsuite.xml.file=src/test/resources/androidAppsEspresso.xml</code>