package io.github.epam.html.tests.elements.composite;

import com.epam.jdi.light.elements.base.JDIBase;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;
import pseudo.site.dataproviders.Section.SomeObjectUIDataProvider;

import static io.github.epam.html.tests.elements.composite.CompositeUtils.checkInitializedElement;

public class SomeObjectUITests extends TestsInit {

    @Test(dataProvider = "someObjectUIWebElementDataProvider", dataProviderClass = SomeObjectUIDataProvider.class)
    public void someObjectUIWebElementTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "someObjectUIListWebElementDataProvider", dataProviderClass = SomeObjectUIDataProvider.class)
    public void someObjectUIListWebElementTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "someObjectUIUIElementDataProvider", dataProviderClass = SomeObjectUIDataProvider.class)
    public void someObjectUIUIElementTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "someObjectUIButtonDataProvider", dataProviderClass = SomeObjectUIDataProvider.class)
    public void someObjectUIButtonTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "someObjectUIWebListDataProvider", dataProviderClass = SomeObjectUIDataProvider.class)
    public void someObjectUIWebListTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "someObjectUIListUIElementPublicDataProvider", dataProviderClass = SomeObjectUIDataProvider.class)
    public void someObjectUIListUIElementPublicTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "someObjectUIListButtonPublicDataProvider", dataProviderClass = SomeObjectUIDataProvider.class)
    public void someObjectUIListButtonPublicTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "someObjectUIUIListQuestionDataProvider", dataProviderClass = SomeObjectUIDataProvider.class)
    public void someObjectUIUIListQuestionTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "someObjectUIUIListSomedataDataProvider", dataProviderClass = SomeObjectUIDataProvider.class)
    public void someObjectUIUIListSomedataTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "someObjectUIDropDownDataProvider", dataProviderClass = SomeObjectUIDataProvider.class)
    public void someObjectUIDropDownTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }
}
