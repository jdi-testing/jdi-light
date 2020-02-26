How to launch web tests on Android emulator  

0) Upload chrome driver 
For more details visit: https://github.com/appium/appium/blob/master/docs/en/writing-running-appium/web/chromedriver.md
1) Set following settings in test.properties file  
driver=appium
remote.type=appium  
driver.remote.url=http://0.0.0.0:4723/wd/hub (or your own url)  
Set @JSite("https://jdi-testing.github.io/jdi-mobile-web/") in StaticSite.class (This will fixed in future)
2) Launch Android emulator (e.g. Pixel 3 API 29) and wait until home screen is ready
2) Launch Appium client  
appium -p 4723 --chromedriver-executable /path/to/your/chromedriver  

<br>
NOTE: This is experimental feature and work only for Android emulators. Functionality may change drastically.

