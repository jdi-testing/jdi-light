How to launch web tests on Android emulator  

0) Download chrome driver 
For more details visit: https://github.com/appium/appium/blob/master/docs/en/writing-running-appium/web/chromedriver.md
It is recommended to use the version of chromedriver > 75. 
The version of Chrome browser in the Android emulator must be the same.
1) Set following settings in test.properties file:  
driver=appium;
remote.type=appium;  
appium.capabilities.path=android.properties (or ios.properties if needed);
If your version of appium has its own URL, specify it in the driver.remote.url property  
Set @JSite("https://jdi-testing.github.io/jdi-mobile-web/") in StaticSite.class (This will be fixed in future)
2) Launch Android emulator (e.g. Pixel 3 API 29) and wait until home screen is ready
2) Launch Appium client  
appium -p 4723 --chromedriver-executable /path/to/your/chromedriver  

<br>
NOTE: This is experimental feature and work only for Android emulators. Functionality may change drastically.

