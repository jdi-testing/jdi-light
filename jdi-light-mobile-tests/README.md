How to launch web tests on Android emulator  

0) Download chrome driver 
For more details visit: https://github.com/appium/appium/blob/master/docs/en/writing-running-appium/web/chromedriver.md
It is recommended to use the version of chromedriver > 75. 
The version of Chrome browser in the Android emulator must be the same.
1) Set following settings in test.properties file: <br>
<b>driver=android</b>; <br>
<b>remote.type=appium</b>; <br>
If your version of appium has its own URL (not http://0.0.0.0:4723), specify it in the <b>driver.remote.url</b> property  

3) Launch Android emulator and wait until home screen is ready
4) Launch Appium client  
appium -p 4723 --chromedriver-executable /path/to/your/chromedriver  

<br>
NOTE: This is experimental feature. Functionality may change drastically.

<br><br>
<h1>How to launch iOS native apps tests example</h1>
<i>Example tests work properly only on macOS computers and iOS 13.4 iPhone simulators</i>
<br>
<b>Required tools:</b> macOS 10.15, Xcode 11.5, iOS Simulator 13.4, Appium 1.17.0

0) Set following settings in test.properties file: <br>
   <b>driver=ios</b> <br>
   <b>remote.type=appium</b> <br>
   If your version of appium has its own URL (not http://0.0.0.0:4723), specify it in the <b>driver.remote.url</b> property
1) Set following settings in ios.properties file: <br>
   <b>platformVersion=13.4</b> <br>
   <b>deviceName=iPhone 11 (or your preferred iPhone)</b>
2) Launch Appium client
3) Open iOS Simulator device
4) Run tests from JDI Light Mobile tests directory:<br>
<code>mvn clean test -Dsuite.xml.file=src/test/resources/iosApps.xml</code>
