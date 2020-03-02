How to launch web tests on Android emulator  

0) Download chrome driver 
For more details visit: https://github.com/appium/appium/blob/master/docs/en/writing-running-appium/web/chromedriver.md
It is recommended to use the version of chromedriver > 75. 
The version of Chrome browser in the Android emulator must be the same.
1) Set following settings in test.properties file: <br>
<b>driver=android (or ios)</b>; <br>
<b>remote.type=appium</b>; <br>
If your version of appium has its own URL (not http://0.0.0.0:4723), specify it in the <b>driver.remote.url</b> property  

2) Launch Android emulator (e.g. Pixel 3 API 29) and wait until home screen is ready
2) Launch Appium client  
appium -p 4723 --chromedriver-executable /path/to/your/chromedriver  

<br>
NOTE: This is experimental feature. Functionality may change drastically.

