# Visual testing

## Major conclusions:
* Functional testing can miss a lot of things without Visual testing
* You can spend to much time for failing tests maintenance without screenshots of failed test cases
* But just visual testing is not enough to validate functional requirements like correct workflow, sort order, business values.
</br>
**Main Conclusion: in order to get best results it is necessary combine both approaches that allows you to test application from functional and visual sides**</br>

## About test project
Test project contains two types of tests:</br>
* Traditional (TraditionalTests.java)
* Visual (VisualTests.java); You can setup eyes in VisualTestsInit.java. 
Note: **Don't forget to setup your APPLITOOLS_API_KEY in environment variables**</br>
</br>
Using IntelliJIdea: you can run tests </br>
1. With right click on it and select "Run" </br>
2. With right click and "Run" on testng xml (see details below)</br>
3. Using maven "clean install" (or with additional parameteres, see details below)</br>

## Run with testng xml
Project contains 3 testng xml files: **traditional.xml, visual.xml, all.xml**, that allows you to run specific tests or all tests in project</br>
You can select file, right click on it and "Run" tests in this suite</br>

## Run with maven
In order to **run tests against V1 environment** set property "environment" in pom.xml to "V1"</br>
In order to **run tests against V2 environment** set property "environment" in pom.xml to "V2"</br>
Also in pom.xml property "testSuite" you can specify test suite you would like to run using values: **traditional, visual, all**</br>
And of course you can run tests using maven console using properties</br>
</br>
This order to run tests recommended to verify test project results:</br>
**clean install -DtestSuite=traditional -Denvironment=V1** - First time you should run traditional tests against environment V1</br>
(optional) **clean install -DtestSuite=traditional -Denvironment=V1** - Second run against same environment to be sure that tests still passed and baselines passed</br>
**clean install -DtestSuite=traditional -Denvironment=V2** - Third time, tests against environment V2 and identify issues</br>
You can observe test run results in console log or using allure report. In order to do it just place folder with "allure-results" in "target folder" and run Plugins>allure>allure:serve in maven panel or start local allure server using console</br>
See visual images comparison based on Selenium TakesScreenshot for canvas tests in \src\test\.logs\screens folder</br>
</br>
**clean install -DtestSuite=visual -Denvironment=V1** - First time, run visual tests with Applitools eyes against environment V1</br>
(optional) **clean install -DtestSuite=visual -Denvironment=V1** - Second run against same environment to be sure that tests still passed and baselines passed</br>
**clean install -DtestSuite=visual -Denvironment=V2** - Third run tests against environment V2 and identify issues</br>
Visual testing results you can also see in Allure report or in Applitools web application using your APPLITOOLS_API_KEY.</br>

# Tests

## Login Page UI Elements Test
For test is good to have visual validation because the requirement is "everything **looks** OK". With Standard approach you can check that all elements are on the page and has correct values, but:
1. This is only one string of visual test and dozens for Traditional
2. In case of multiple errors it is hard to get all errors on page, especially if some elements missed.
3. You can't verify elements positions (will not fail in case of some misplacements)

## Data-Driven Test
If requirement just check login functionality this can be done with traditional approach with ease, especially for failed login messagges validation, but if you would like also to verify that no visual errors appear after your actions (like wrong message background or font color or broken layout) you can't avoid adding visual vhecks.

## Table Sort Test
The functional requirement for this case better to check with Traditional approach. Because just visual validation without strings content analyzes will fail with any data changes in table.</br>
From other hand because table has a lot of visual components like icons, badges and colors you can't avoid visual testing as well.</br>
The solution is to combine both approaches. Validate data in table with traditional approach and each row with visual validation.</br>
The complex thing here that you need to validate rows image not comparing to baseline but with its view before sorting. </br>

## Canvas Chart Test
Of cource this case is only for Visual testing while you have no access to canveas data. This is the same if you would like to validate some icon or image (for example photo) on the page.

## Dynamic Content Test
It think this test is mostly for Traditional testing because advertisement content can be anything and you can just validate that you have place for it. Even no image can be a correct behaviour because advertisement service sends nothing. </br>
In addition this can be validated with http request to service and validation that response has expected amount of advertisements.

# JDI Light links
JDI Light framework used for this Exercise is Selenium based framework that operates with UI elements and helps to resuce amount of code for tests in 2-3 times compare to traditional approaches with tag-like elements and provide additional stability for you tests</br>
See more details at official [Github of the project](https://github.com/jdi-testing/jdi-light) and in our [documentation](https://jdi-docs.github.io/jdi-light/?java)</br>
For fast start you can go through [tutorial](https://jdi-docs.github.io/jdi-light/?java#tutorial) </br>
</br>
More links: </br>
Documentation: https://jdi-docs.github.io/jdi-light/?java - different types of documentation from introduction and tutorial to technical methods documentation </br>
Introduction + fast start example: https://jdi-docs.github.io/jdi-light/?java#introduction </br>
Tutorial: https://jdi-docs.github.io/jdi-light/?java#tutorial - helps to get main ideas on practice </br>
Tutorial repo:  https://github.com/jdi-tutorials </br>
Project templates: https://github.com/jdi-templates - for fast projects start </br>
Examples: https://github.com/jdi-examples </br>
How to use [UI Elements examples](https://github.com/jdi-testing/jdi-light/tree/master/jdi-light-html-tests/src/test/java/io/github/epam/html/tests/elements) </br>
Increase test [performance examples](https://github.com/jdi-testing/jdi-light/tree/master/jdi-performance) </br>
