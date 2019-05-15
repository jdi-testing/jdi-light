package io.github.epam.html.tests.elements.composite;

import com.epam.jdi.light.elements.base.JDIBase;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;
import pseudo.site.dataproviders.Section.SomePageDataProvider;

import static io.github.epam.html.tests.elements.composite.CompositeUtils.checkInitializedElement;

public class SomePageTests extends TestsInit {

    @Test(dataProvider = "somePageWebElementDataProvider", dataProviderClass = SomePageDataProvider.class)
    public void somePageWebElementTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "somePageListWebElementDataProvider", dataProviderClass = SomePageDataProvider.class)
    public void somePageListWebElementTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "somePageUIElementDataProvider", dataProviderClass = SomePageDataProvider.class)
    public void somePageUIElementTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "somePageButtonDataProvider", dataProviderClass = SomePageDataProvider.class)
    public void somePageButtonTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "somePageWebListDataProvider", dataProviderClass = SomePageDataProvider.class)
    public void somePageWebListTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "somePageListUIElementPublicDataProvider", dataProviderClass = SomePageDataProvider.class)
    public void somePageListUIElementPublicTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "somePageListButtonPublicDataProvider", dataProviderClass = SomePageDataProvider.class)
    public void somePageListButtonPublicTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "somePageUIListQuestionDataProvider", dataProviderClass = SomePageDataProvider.class)
    public void somePageUIListQuestionTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "somePageUIListSomedataDataProvider", dataProviderClass = SomePageDataProvider.class)
    public void somePageUIListSomedataTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "somePageDropDownDataProvider", dataProviderClass = SomePageDataProvider.class)
    public void somePageDropDownTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }
}
