Designing a UI element for a test automation framework like JDI-Light involves several steps to ensure the element is reusable, robust, and integrates well with the existing framework:

### 1: Identify the Element
- **<span style="color:red;">Main question:</span>** Imagine, that you have this element in your project site, what should be testable for it? How would you implement it, what kind of functionality you always looking for?
- **Research:** Understand the UI component you want to design. For a material UI design, you might be looking at elements like buttons, cards, dialogs, sliders, etc. Use the JDI-Light, Bootstrap or Material Design guidelines as a reference.
    - [JDI-Light](https://jdi-docs.github.io/jdi-light/?java#theory)
    - [Bootstrap](https://getbootstrap.com/docs/5.3/components/) 
    - [Material 2](https://m2.material.io/components?platform=web)
    - [Material 3](https://m3.material.io/components?platform=web)

- **Requirement Analysis:** Determine the functionalities and states this element can have. For instance, a button may have different states like hover, disabled, or pressed. For this step it is also good to use Material Design guidelines referencesd above.

### 2: Define the Interface
- **List Properties:** Decide on the properties your element should expose. For a button, properties could include text, color, size, and state.
- **Define Methods:** Outline the actions you can perform with the element, e.g., click, getText, isEnabled.
- **Consider Events:** Think about what events the element should respond to, e.g., onClick, onFocus.
- **Examples:** Good example you can see in [interface IsText](https://github.com/jdi-testing/jdi-light/blob/master/jdi-light-selenium3/src/main/java/com/epam/jdi/light/elements/interfaces/common/IsText.java) More examples you can [see here](https://github.com/jdi-testing/jdi-light/tree/master/jdi-light-selenium3/src/main/java/com/epam/jdi/light/elements/interfaces/base) eg. (Interfaces introduces all abovementioned approches):
    - HasCheck
    - HasClick
    - HasLabel
    - HasPlaceholder
    - HasUIList
    - HasValue
    - IClickable etc.


### 3: Consider Inheritance and Abstraction
- **Base Classes:** Look for any existing elements in JDI-Light that are similar and can act as base classes. This helps in reusing code and keeping the design DRY (Don't Repeat Yourself).
Good candidates for base classes - members of [following folder](https://github.com/jdi-testing/jdi-light/tree/master/jdi-light-html/src/main/java/com/epam/jdi/light/ui/html/elements/common) eg.:
    - Button
    - Checkbox
    - Image
    - Icon etc.
    
- **Abstract Elements:** If needed, design an abstract class that holds common properties and methods for a category of elements. For example, all form controls might share certain behaviors.
Examples for abstraction - look at the similarity of different elements and incorporate them in to an abstract class, have a look on a [Progress bar implementation](https://github.com/jdi-testing/jdi-light/blob/master/jdi-light-material-ui/src/main/java/com/epam/jdi/light/material/elements/feedback/progress/Progress.java). Following is more good candidates for abstraction: 
    - Table 
    - Bar
    - List


### 4: Incorporate Element Locators
- **Locators:** Define how the element will be located in the DOM. Choose the most stable locators to ensure reliable tests.
- **Methods for Locators:** Decide how the element can change its locators if needed, to make the custom element flexible and reusable in different contexts.
- **NB** ***When using XPath locators***, it's essential to be mindful of their scope within the DOM. By default, an XPath expression is evaluated in the context of the entire document, which can lead to selecting unintended elements if the DOM contains multiple elements that match the given expression. To constrain the search to just the descendants of a specific root element, always start the XPath with a period (.) to indicate the current context. 

### 5: Design for extensibility
- Consider how the element can be customized or extended. Users of your framework might need to adjust the default behavior or appearance.
- Mockups and Prototypes (please have a look inside detailes)<details> 
        **Make visual design:** Draw a visual representation of the element to understand how it should look and behave. Use prototyping platforms like Figma, Sketch, or InVision.
        **Create prototype:** Define example scenarios where the UI element would be used, what the expected user input and system responses would be. This can include common and edge case scenarios. Write detailed UI specifications that describe the functionality, appearance, and behavior of the element. These should include dimensions, color schemes, typographic details, and states (e.g., hover, disabled).
    </details>

### 6: Document the Design
- **Documentation:** Write clear documentation outlining how the element is supposed to work and how it should be used within the JDI-Light framework.
- **Examples:** Provide examples of usage including variations of the element if applicable.
- **Javadoc** Write all documentation related to an element in a form of Javadoc inside an element class.
- **Task for frontend** Express all abowementioned actions (in 6 and 7 steps) in a form of a task for a frontend developer in order to adjust testsite - to get element you designed on it.
- **@JDIAction** Always use this annotation to explane actions as following:
    - '{name}' - the name of the element on which the method is called. 
    - {0}, {1}, ... - method parameters. 
    - If the parameter type is Matcher, then do not use quotes and do not use is/has: *@JDIAction("Check that '{name}' text {0}")*
    - Get-method -> *@JDIAction("Get ...")* 
    - Set-method -> *@JDIAction("Set '{name}' text area as '{0}'") *
    - Boolean method -> *@JDIAction("Get if '{name}' text area is empty")*
    - Asserts -> *@JDIAction(value = "Assert that '{name}' text is {0}", isAssert = true)*


### 7: Plan for Testing
- **Testing Strategy:** Determine how you will test the custom element within the JDI-Light framework.
- **Test Cases:** Outline test cases to cover all functionalities and states of the element. Keep in mind that you need to represent all features of your element.


### Notes:
- Make sure that locators you using in a framework is not implementation-specific. You must use locators which will not change on a different web-site implementation. If you are unable to present your element w/o usage implementation-specific locator - create a custom element inside a test project and use it in test.
- If you are implementing an element that may contain any kind of elements - just implement it as a container and then in a test project make custom elements - to show how to work with it.
- Consider naming conventions that match the JDI-Light framework to maintain coherence and reduce the learning curve for users of your custom library. Have a look on already implemented [classes](https://github.com/jdi-testing/jdi-light/blob/add_documentation_element_design/jdi-light-material-ui/src/main/java/com/epam/jdi/light/material/elements/displaydata/Badge.java) and [tests](https://github.com/jdi-testing/jdi-light/blob/add_documentation_element_design/jdi-light-material-ui-tests/src/test/java/io/github/epam/material/tests/displaydata/BadgeTests.java) Project has checkstyle enabled you may have a look on [rules](https://github.com/jdi-testing/jdi-light/blob/add_documentation_element_design/config/checkstyle/checkstyle.xml).<details>
    - **Do note use UIElement when you can use typed one** (like UIElement button)
    - **Use meaningful and descriptive names**: The method name should clearly state what the method does. For example, a method that checks if a container is fixed could be named `isFixed()`.
    - **Start boolean methods with is, has, can, or similar**: If a method returns a boolean, it's often a good idea to start the name with `is`, `has`, `can`, or similar to make it clear that the method returns a boolean. For example, `isFixed()`, `hasTitle()`.
    - **Use verbs for methods that perform actions**: If a method performs an action, it's often a good idea to start the name with a verb. For example, `scrollDown()`.
    - **Keep it short**: While descriptive names are good, overly long names can make the code harder to read. Try to keep the method names concise.
</details>