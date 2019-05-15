package io.github.epam.html.tests.elements.composite;

import com.epam.jdi.light.elements.base.JDIBase;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;
import pseudo.site.dataproviders.Section.SomePageUrlDataProvider;

import static io.github.epam.html.tests.elements.composite.CompositeUtils.checkInitializedElement;

public class SomePageUrlTests extends TestsInit {

    @Test(dataProvider = "somePageUrlWebElementDataProvider", dataProviderClass = SomePageUrlDataProvider.class)
    public void somePageUrlWebElementTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "somePageUrlListWebElementDataProvider", dataProviderClass = SomePageUrlDataProvider.class)
    public void somePageUrlListWebElementTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "somePageUrlUIElementDataProvider", dataProviderClass = SomePageUrlDataProvider.class)
    public void somePageUrlUIElementTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "somePageUrlButtonDataProvider", dataProviderClass = SomePageUrlDataProvider.class)
    public void somePageUrlButtonTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "somePageUrlWebListDataProvider", dataProviderClass = SomePageUrlDataProvider.class)
    public void somePageUrlWebListTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "somePageUrlListUIElementPublicDataProvider", dataProviderClass = SomePageUrlDataProvider.class)
    public void somePageUrlListUIElementPublicTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "somePageUrlListButtonPublicDataProvider", dataProviderClass = SomePageUrlDataProvider.class)
    public void somePageUrlListButtonPublicTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "somePageUrlUIListQuestionDataProvider", dataProviderClass = SomePageUrlDataProvider.class)
    public void somePageUrlUIListQuestionTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "somePageUrlUIListSomedataDataProvider", dataProviderClass = SomePageUrlDataProvider.class)
    public void somePageUrlUIListSomedataTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "somePageUrlDropDownDataProvider", dataProviderClass = SomePageUrlDataProvider.class)
    public void somePageUrlDropDownTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }
}
