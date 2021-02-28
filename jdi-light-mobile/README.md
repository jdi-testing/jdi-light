#How to launch web tests on Android emulator  

1. Download **chrome driver**. 
For more details visit: https://github.com/appium/appium/blob/master/docs/en/writing-running-appium/web/chromedriver.md <br/> 
It is recommended to use the version of **chrome driver** >= 87. 
The version of Chrome browser in the Android emulator must be the same.

1. Set following settings in **test.properties** file: <br/>
**driver=android (or ios)**; <br/>
**remote.type=appium**; <br/>
If your version of appium has its own URL (not http://0.0.0.0:4723), specify it in the **driver.remote.url** property

1. Launch Android or iOS emulator and wait until home screen is ready

1. Launch Appium client  
`appium -p 4723 --chromedriver-executable /path/to/your/chromedriver`

1. Run the tests  

**Note:** This is experimental feature. Functionality may change drastically.

**Note:** Before reloading module **jdi-light-mobile** should be reloaded module **jdi-light**. 