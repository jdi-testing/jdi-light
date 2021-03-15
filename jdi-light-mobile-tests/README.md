#How to launch web tests on Android emulator  

Stable environment: Java 8, Maven 3.6.3, Jdi 1.2.21, TestNG 6.14.3, Aspectj 1.9.6, Appium 1.18.3, Android 10 <br>

1. Download **chrome driver** 
For more details visit: https://github.com/appium/appium/blob/master/docs/en/writing-running-appium/web/chromedriver.md
It is recommended to use the version of **chrome driver** >= 87. 
The version of Chrome browser in the Android emulator must be the same.

2. Set following settings in **test.properties** file:
**driver=android**; <br>
**remote.type=appium**; <br>
If your version of appium has its own URL (not http://0.0.0.0:4723), specify it in the **driver.remote.url** property
3. Launch Android emulator and wait until home screen is ready
4. Launch Appium client  
`appium -p 4723 --chromedriver-executable /path/to/your/chromedriver` <br>
Note: Before module reloading **jdi-light-mobile-tests** should be module reloaded **jdi-light**.
#How to launch iOS native apps tests example</h1>
Example tests work properly only on macOS computers and iOS 13.4 iPhone simulators<br>
**Required tools:** macOS 10.15, Xcode 11.5, iOS Simulator 13.4, Appium 1.17.0
1. Set following settings in **test.properties** file: <br>
   **driver=ios** <br>
   **remote.type=appium** <br>
   If your version of appium has its own URL (not http://0.0.0.0:4723), specify it in the **driver.remote.url** property
2. Set following settings in **ios.properties** file: <br>
   **platformVersion=13.4** <br>
   **deviceName=iPhone 11 (or your preferred iPhone)**
3. Launch Appium client
4. Open iOS Simulator device
5. Run tests from JDI Light Mobile tests directory:<br>
`mvn clean test -Dsuite.xml.file=src/test/resources/iosApps.xml`
#How to launch Android native apps tests example
**Required tools:** OS Android 10.0, device emulator Pixel XL, Appium 1.18.3
1. Set the following settings in **test.properties** file: 
**driver=android** <br>
**remote.type=appium** <br>
If your version of Appium has its own URL (not http://0.0.0.0:4723), specify it in the **driver.remote.url** property
2. Set the following settings in **android.properties** file:
**platformName=Android** <br>
**deviceName=emulator-5554 (the name of your emulated device)**
3. Launch Appium client
4. Open Android device emulator
5. Run tests from JDI Light Mobile tests directory:<br>
**Directory android10NonApplicationTests**<br>
`mvn clean test site -Dsuite.xml.file=src/test/resources/androidApps.xml` <br>
**System test also available for Android 11. There are in package SystemAndroid11Tests**
#How to launch Android Espresso tests example</h1>
**Required tools:** OS Android 11.0, device emulator Pixel 3a, Appium 1.18.3
1. Set following settings in **test.properties file**: <br>
```   
   driver=android
   remote.type=appium
```
If your version of appium has its own URL (not http://0.0.0.0:4723), specify it in the **driver.remote.url** property
2. Set following settings in **android.properties** file: <br>
```
   platformName=Android
   deviceName=emulator-5554 #the name of your emulated device
   autoLaunch=true
   appPackage=io.appium.android.apis
   appActivity=ApiDemos
   automationName=Espresso
   forceEspressoRebuild=true
   fullReset=true
   app=<<path_to_jdi-light-mobile-tests_project>>/src/main/resources/ApiDemosEspresso-debug.apk** 
```
**<<path_to_jdi-light-mobile-tests_project>>** - is absolute path to **jdi-light-mobile-tests** module
3. Launch Appium client
4. Open Android device emulator
5. Run tests from JDI Light Mobile tests directory:<br>
   `mvn clean test -Dsuite.xml.file=src/test/resources/androidAppsEspresso.xml`
   