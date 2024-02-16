JDI Light (Java Development Integration Light) is a testing framework designed to streamline the UI testing process for Java applications. It amalgamates best development practices and design patterns to create stable and easily maintainable tests. 
### **Core Concepts of JDI Light:**

- **Page Object Model (POM):** JDI Light leverages the Page Object Model pattern to separate test code and scenarios from the web page structure. Each web page is represented as a Java class. All the web elements on the page are defined as variables in the class, and all the possible user interactions are defined as methods.

- **Typed Elements:** Web page elements are represented as specialized objects (e.g., Button, TextField) in the framework, simplifying interactions and enhancing test readability. JDI-Light provides a set of predefined classes for different types of UI elements. These classes encapsulate the logic for interacting with the UI elements, making the tests more readable and maintainable.

- **Annotation Support:** Maximizing the use of annotations for defining page elements and their interactions, JDI Light reduces boilerplate code and simplifies test writing. Here are some key annotations used in JDI-Light:


    1. **@JDIAction:** This annotation is used to describe the action performed by a method. It is used for logging and reporting purposes.

        **TBD**



- **Smart-Wait Mechanisms:** The framework provides built-in wait mechanisms (e.g., page load waits, element presence waits), minimizing the need for manual wait configuration and enhancing test stability.

- **Integration with Test Data:** JDI Light allows for the use of external data sources (like JSON, Excel files) for test parameterization, simplifying test data management and reuse across different test cases.

- **Element Actions:** Predefined actions can be easily invoked in tests for elements, such as clicks, filling out forms, selections from drop-downs, etc., making tests more intuitive. 

- **Assertions:** JDI Light has its assertion library, providing clearer and more informative error messages. It also provides built-in validations for web elements, helping testers to ensure that the UI elements meet certain conditions before performing actions on them.

- **Logging and Reporting:** Advanced logging mechanisms and detailed test reports generation are supported, including integration with tools like Allure for in-depth test documentation.

- **Extensibility and Customization:** Various settings for driver factory customization, element initialization, and other built-in mechanisms are available, making JDI Light a flexible tool adaptable to diverse project requirements.

### **Key Features:**

- **Smart Locators:** By using smart locators, JDI Light can automatically generate locators based on field names when annotations are used, speeding up the test development process by reducing the amount of required code.

- **Cross-Browser and Cross-Platform Testing:** Supports testing across different browsers and mobile testing through Appium integration, facilitating cross-platform compatibility checks for web applications.

- **Rich Assertions and Validations:** Built-in validations for web elements help ensure UI elements meet certain conditions before actions are performed, supported by a fluent and intuitive assertion syntax.
