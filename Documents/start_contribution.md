# Contributing to JDI Light

## 1: Setting Up the Repository for Contribution
If you already have write access to the repository or do not need to create a personal fork for contribution, you can directly clone the repository to your local machine: 
``` bash
git clone https://github.com/jdi-testing/jdi-light.git
```
If you don't have write access, then first fork the repository to your own GitHub account by clicking the "Fork" button on the repository page. This creates a personal copy of the repository where you can make changes without affecting the original project. Next, clone your forked repository to your local machine using the command:

``` bash
git clone https://github.com/YOUR_USERNAME/jdi-light.git
```

Replace YOUR_USERNAME with your GitHub username. This step prepares your local development environment for making contributions.

Insead cloning repo in a terminal you can do that by opening a project from IDE here an examples for different IDEs:

- IntelliJ IDEA:
    - If you see the Welcome screen, click on "Get from VCS".
    - If you have already opened a project, select "File" > "New" > "Project from Version Control..." from the main menu.
- Visual Studio Code:
    - If you see the Welcome screen, click on "Clone Git repository".
    - If you have already opened a project, press ctr+shift+G or select Source control in a left menu and push "Clone repository"


## 2: Understand the project structure 

Core methods and classes are resides in a jdi-light/jdi-light-core folder

Project contains multiple folders like:
- **.github/workflows** - in this folder you can find github actions description triggers on merging branches.
- Core methods and classes are resides in a **jdi-light/jdi-light-core** folder
- **jdi-light-XXXX** - Contains the JDI Light specific module targets specific kind of testing or element base. You can see dependencies betveen modules in pom.xml for each module.
- **jdi-light-XXXX-tests** - Holds tests for the abovementioned specific module. 
- **jdi-light-XXXX-tests/src/test/resources** - holds variouce property files for example, the chrome.properties file is used to configure the Chrome driver, and the ff.properties file is used to configure the Firefox driver. 

### Browser and test settings

The test.properties file is a general configuration file that contains various settings for the tests, such as the base URL for the tests, the driver to use, and other settings. Make sure to understand and update these files as necessary for your specific setup.
- test.properties - with this file you can fine tune a framework for your needs eg:

> driver — we can specify the driver used to run our tests. Common options include chrome, firefox, ie; we can also just put ${driver} here and read the driver name from the command line.
driver.version — by default, JDI Light will download the latest version of a driver for us, but if we need a specific version we can put it here (in which case the framework will find and download exactly this version). <span style="color:darkblue">➡️ **[see to find more about a configuration following](https://jdi-docs.github.io/jdi-light/?java#configuration)**</span> 

- chrome.properties also have some specific parametres to run browser:
``` bash
#arguments=--ignore-certificate-errors --start-maximized --incognito
#enableVNC=true
```

**NOTE: by default browser shall be set in headless mode - in order to run ptoperly on CI!** However for the local usage you may set it in a non-headless mode, you just need configure both common.properties and test.properties:
- common.properties just comment:
``` bash
 #arguments=--headless
```
- test.properties set up:
``` bash
headless=false
``` 


## 3: Build the Project 

Check your java version - you need atleast 11 java to run it 
NOTE: current jdi-light version is not support Java greater than 21 yet, due to AspectJ usage.
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

## 4: Run Tests via command line

To run tests you can use few following examples:
- run all tests from jdi-light-angular-tests folder
``` bash
 mvn verify -ntp -Ddriver=chrome -pl com.epam.jdi:jdi-light-angular-tests
```  
- run all tests from jdi-light-angular-tests folder with some additional options
``` bash 
mvn verify -ntp -Ddriver=firefox -Dff.capabilities.path=jdi-light-vuetify-tests/src/test/resources/ff.properties -pl com.epam.jdi:jdi-light-vuetify-tests --fail-at-end
```
- run a specific test, you can use the mvn verify command with the -Dtest parameter followed by the name of the test class. For example, if the test class is GridListTests, you can run it like this: 
``` bash 
mvn verify -ntp -Ddriver=chrome -Dtest=io.github.epam.vuetify.tests.composite.FormsTests -pl com.epam.jdi:jdi-light-vuetify-tests --fail-at-end
```

## 5: Run tests in IDE 
After you have built a project on a step 3 you may accually run tests straight from IDE (vscode or intellij IDEA) by clicking on a green triangle near a test class


## 6: Make Your Changes Now you're ready to start contributing! 
Make your changes to the codebase, making sure to follow any coding standards or guidelines defined by the project.

## 7: Contribution flow

 - Create a new branch using 
 ``` bash 
 git checkout -b <branch-name>
 ```
 Replace \<branch-name> with a descriptive name for your branch. Use references to a task.

- Make your changes in the new branch. Ensure that your code adheres to the project's coding standards and guidelines.

- Stage your changes using 
``` bash 
git add <staging-files>
``` 

- Commit your changes using 
``` bash 
git commit -m "<commit-message>"
``` 
 Replace \<commit-message> with a descriptive message about the changes you made. A good commit message is concise, uses the imperative mood, and describes what was done and why.

- Push your changes to the remote repository using 
``` bash 
git push origin <branch-name>
``` 

- Go to the GitHub page of your forked repository and click on "Pull request".
Choose the branch you just pushed from the "compare" dropdown.
Review your changes and then click on "Create pull request".

- After creating a pull request, the Github Actions pipeline will automatically run to check your changes.
You can see the status of the [Actions pipeline](https://github.com/jdi-testing/jdi-light/actions) on the GitHub page of your pull request. If the job fails, click on the job link to see what went wrong and fix the issues. <span style="color:green">**Please make sure that PR pipeline is green**</span>