# Contributing to JDI Light

## Step 1: Clone the Repository 

First, you'll need to clone the repository to your local machine. You can do this with the following command: git clone https://github.com/jdi-testing/jdi-light.git

## Step 2: Navigate to the Project Directory 

Next, navigate to the project directory: cd jdi-light

## Step 3: Understand the Properties Files 
The JDI Light project uses *.properties files to configure various aspects of the project. These files are located in the src/test/resources directory. For example, the chrome.properties file is used to configure the Chrome driver, and the ff.properties file is used to configure the Firefox driver.

The test.properties file is a general configuration file that contains various settings for the tests, such as the base URL for the tests, the driver to use, and other settings. Make sure to understand and update these files as necessary for your specific setup.

for example to run tests in non-headless mode you need configure both common.properties and test.properties:

common.properties just comment:
``` bash
 #arguments=--headless
```
test.properties set up:
``` bash
headless=false
``` 
<span style="color:red">**see ➡️ [following](https://jdi-docs.github.io/jdi-light/?java#1-quick-start) to find more about a configuration**</span> 

## Step 4: Build the Project 

Check your java version - you need atleast 11 java to run it 
**(check /jdi-light/.github/workflows/main.yml - to find all compatible versions)**
``` bash
java --version
```

The JDI Light project uses Maven to build the project. You can build the project with the following command: 
``` bash
mvn -ntp install -DskipTests -Dsource.skip -Dmaven.source.skip -Dmaven.javadoc.skip=true 
```
This command tells Maven to build the project, skipping tests, source file generation, and JavaDoc generation.

**If you encountering errors on this step:**
- make sure that you have access to https://repo.maven.apache.org/maven2/ (for example you may have some 
other default repo in your .m2/settings.xml)
- make sure that you using a correct java version supported by Jdi-light by using **java --version** (if not - install a correct one and set it as a default before runnign a project)
- look closely at console logs - it is always can help to find a solution

## Step 5: Run Tests via command line

To run tests you can use few following examples:
- run all tests from jdi-light-angular-tests folder
``` bash
 mvn verify -ntp -Ddriver=chrome -pl com.epam.jdi:jdi-light-angular-tests
```  
- run all tests from jdi-light-angular-tests folder with some additional options
``` bash 
mvn verify -ntp -Ddriver=chrome -Dchrome.capabilities.path=jdi-light-angular-tests/src/test/resources/chrome.properties -Dff.capabilities.path=jdi-light-angular-tests/src/test/resources/ff.properties -pl com.epam.jdi:jdi-light-angular-tests --fail-at-end
```
- run a specific test, you can use the mvn verify command with the -Dtest parameter followed by the name of the test class. For example, if the test class is GridListTests, you can run it like this: 
``` bash 
mvn verify -ntp -Ddriver=chrome -Dchrome.capabilities.path=jdi-light-angular-tests/src/test/resources/chrome.properties -Dff.capabilities.path=jdi-light-angular-tests/src/test/resources/ff.properties -Dtest=io.github.epam.angular.tests.elements.complex.GridListTests -pl com.epam.jdi:jdi-light-angular-tests --fail-at-end 
```

## Step 5.5: Run tests in IDE 
After you have built a project on a step 4 you may accually run tests straight from IDE (vscode or intellij IDEA) by clicking on a green triangle near a test class


## Step 6: Make Your Changes Now you're ready to start contributing! 
Make your changes to the codebase, making sure to follow any coding standards or guidelines defined by the project.

## Step 7: Submit a Pull Request 
Once you've made your changes, you can submit a pull request to have your changes reviewed and potentially merged into the main codebase.