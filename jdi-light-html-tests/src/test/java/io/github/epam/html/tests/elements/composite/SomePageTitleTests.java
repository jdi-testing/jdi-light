package io.github.epam.html.tests.elements.composite;

import com.epam.jdi.light.elements.base.JDIBase;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;
import pseudo.site.dataproviders.Section.SomePageTitleDataProvider;

import static io.github.epam.html.tests.elements.composite.CompositeUtils.checkInitializedElement;

public class SomePageTitleTests extends TestsInit {

    @Test(dataProvider = "somePageTitleWebElementDataProvider", dataProviderClass = SomePageTitleDataProvider.class)
    public void somePageTitleWebElementTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "somePageTitleListWebElementDataProvider", dataProviderClass = SomePageTitleDataProvider.class)
    public void somePageTitleListWebElementTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "somePageTitleUIElementDataProvider", dataProviderClass = SomePageTitleDataProvider.class)
    public void somePageTitleUIElementTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "somePageTitleButtonDataProvider", dataProviderClass = SomePageTitleDataProvider.class)
    public void somePageTitleButtonTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "somePageTitleWebListDataProvider", dataProviderClass = SomePageTitleDataProvider.class)
    public void somePageTitleWebListTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "somePageTitleListUIElementPublicDataProvider", dataProviderClass = SomePageTitleDataProvider.class)
    public void somePageTitleListUIElementPublicTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "somePageTitleListButtonPublicDataProvider", dataProviderClass = SomePageTitleDataProvider.class)
    public void somePageTitleListButtonPublicTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "somePageTitleUIListQuestionDataProvider", dataProviderClass = SomePageTitleDataProvider.class)
    public void somePageTitleUIListQuestionTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "somePageTitleUIListSomedataDataProvider", dataProviderClass = SomePageTitleDataProvider.class)
    public void somePageTitleUIListSomedataTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "somePageTitleDropDownDataProvider", dataProviderClass = SomePageTitleDataProvider.class)
    public void somePageTitleDropDownTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }
}
