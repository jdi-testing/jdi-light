## Applitools Eyes

### What Eyes can
Applitools SDKs works with JDI and simply takes screenshots of the page, element, region or an iframe and uploads them along with DOM snapshots to Applitools Eyes server. 
After Applitools AI compares them with previous test executions' screenshots (aka Baselines - a unique combination of five parameters: the OS, Viewport Size, Browser, Application name, Test name), 
highlight diffs and allows to reviewer to make a final decision if there is a bug or not. 
Very simple!

### How to prepare Eyes
1) Create a free Applitools account on official Applitools site
2) Get the Applitools API-key from Applitools account and set it to the environment variable:
Mac: export APPLITOOLS_API_KEY='YOUR_API_KEY'
Windows: set APPLITOOLS_API_KEY='YOUR_API_KEY'
3) Have Java v10 or higher installed (recommended by Applitools)
4) (Optionally) Install IDE (IntelliJ or Eclipse)
5) (Optionally) Install ChromeDriver on your machine and make sure it's is in the PATH
(Detailed instruction is available on official Applitools site)
 
### How to cook Eyes with JDI
To integrate Applitools Eyes with tests module need following:
1) Add Maven dependency on jdi-light-applitools module to tests module pom.xml
2) Uncomment if exists (or add in case of absence) the following settings to tests module test.properties file:
application.name - the name of tests module, string
eyes.enabled - indicates is Eyes features enabled or not, boolean. Options: true / false (true or false)
eyes.check - Eyes checking (taking screen pics) options. Options: new page, on test start, after assertion, after jdi assertion, with processed element (can be combined)
Detaily about Eyes checking options provided by JDI:
new page - Eyes takes screenshot of entire window view after new page opened
on test start - Eyes takes screenshot of entire window view on test start (works only if JEyesTestNGListener engaged, see 3 item)
after assertion - Eyes takes screenshot of entire window view after every test assertion (works only if JEyesTestNGListener engaged, see 3 item)
after jdi assertion - Eyes takes screenshot of entire window view after those test assertion that use jdiAssert method inside
with processed element - if specified, in addition to the entire screen, Eyes also take screenshot of the last processed web element (all cases above covered)
All eyes.check this options work only if eyes.enabled set to "true"
3) (Optionally) Add listener JEyesTestNGListener to main test class list of TestNG listeners (example: @Listeners({TestNGListener.class, JEyesTestNGListener.class}))
Go! Rn tests module tests and view full Eyes checks results in created Applitools account :)

## Useful Links
Applitools official site: https://applitools.com
Selenium + Java Eyes tutorial: https://applitools.com/tutorials/selenium-java.html
Applitools account registration: https://applitools.com/users/register

## Contacts:
Mail: roman.iovlev.jdi@gmail.com
Skype: roman.iovlev
