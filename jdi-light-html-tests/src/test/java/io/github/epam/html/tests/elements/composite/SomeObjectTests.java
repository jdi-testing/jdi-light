package io.github.epam.html.tests.elements.composite;

import com.epam.jdi.light.elements.base.JDIBase;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;
import pseudo.site.dataproviders.Section.SomeObjectDataProvider;

import static io.github.epam.html.tests.elements.composite.CompositeUtils.checkInitializedElement;

public class SomeObjectTests extends TestsInit {

    @Test(dataProvider = "someObjectWebElementDataProvider", dataProviderClass = SomeObjectDataProvider.class)
    public void someObjectWebElementTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "someObjectListWebElementDataProvider", dataProviderClass = SomeObjectDataProvider.class)
    public void someObjectListWebElementTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "someObjectUIElementDataProvider", dataProviderClass = SomeObjectDataProvider.class)
    public void someObjectUIElementTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "someObjectButtonDataProvider", dataProviderClass = SomeObjectDataProvider.class)
    public void someObjectButtonTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "someObjectWebListDataProvider", dataProviderClass = SomeObjectDataProvider.class)
    public void someObjectWebListTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "someObjectListUIElementPublicDataProvider", dataProviderClass = SomeObjectDataProvider.class)
    public void someObjectListUIElementPublicTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "someObjectListButtonPublicDataProvider", dataProviderClass = SomeObjectDataProvider.class)
    public void someObjectListButtonPublicTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "someObjectUIListQuestionDataProvider", dataProviderClass = SomeObjectDataProvider.class)
    public void someObjectUIListQuestionTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "someObjectUIListSomedataDataProvider", dataProviderClass = SomeObjectDataProvider.class)
    public void someObjectUIListSomedataTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "someObjectDropDownDataProvider", dataProviderClass = SomeObjectDataProvider.class)
    public void someObjectDropDownTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }
}
