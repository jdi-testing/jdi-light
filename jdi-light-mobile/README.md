<h1>How to launch web tests on Android emulator</h1>  

1. Download <b>chrome driver</b>. 
For more details visit: https://github.com/appium/appium/blob/master/docs/en/writing-running-appium/web/chromedriver.md <br>
It is recommended to use the version of <b>chrome driver</b> >= 87. 
The version of Chrome browser in the Android emulator must be the same.

2. Set following settings in <b>test.properties</b> file: <br>
<b>driver=android (or ios)</b>; <br>
<b>remote.type=appium</b>; <br>
If your version of appium has its own URL (not http://0.0.0.0:4723), specify it in the <b>driver.remote.url</b> property

3. Launch Android or iOS emulator and wait until home screen is ready

4. Launch Appium client  
<code>appium -p 4723 --chromedriver-executable /path/to/your/chromedriver</code>

5. Run the tests  

Note: This is experimental feature. Functionality may change drastically.

Note: Before reloading module <b>jdi-light-mobile</b> should be reloaded module <b>jdi-light</b>. 