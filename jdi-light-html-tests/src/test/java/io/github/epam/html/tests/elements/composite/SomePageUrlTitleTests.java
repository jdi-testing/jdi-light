package io.github.epam.html.tests.elements.composite;

import com.epam.jdi.light.elements.base.JDIBase;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;
import pseudo.site.dataproviders.Section.SomePageUrlTitleDataProvider;

import static io.github.epam.html.tests.elements.composite.CompositeUtils.checkInitializedElement;

public class SomePageUrlTitleTests extends TestsInit {

    @Test(dataProvider = "somePageUrlTitleWebElementDataProvider", dataProviderClass = SomePageUrlTitleDataProvider.class)
    public void somePageUrlTitleWebElementTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "somePageUrlTitleListWebElementDataProvider", dataProviderClass = SomePageUrlTitleDataProvider.class)
    public void somePageUrlTitleListWebElementTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "somePageUrlTitleUIElementDataProvider", dataProviderClass = SomePageUrlTitleDataProvider.class)
    public void somePageUrlTitleUIElementTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "somePageUrlTitleButtonDataProvider", dataProviderClass = SomePageUrlTitleDataProvider.class)
    public void somePageUrlTitleButtonTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "somePageUrlTitleWebListDataProvider", dataProviderClass = SomePageUrlTitleDataProvider.class)
    public void somePageUrlTitleWebListTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "somePageUrlTitleListUIElementPublicDataProvider", dataProviderClass = SomePageUrlTitleDataProvider.class)
    public void somePageUrlTitleListUIElementPublicTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "somePageUrlTitleListButtonPublicDataProvider", dataProviderClass = SomePageUrlTitleDataProvider.class)
    public void somePageUrlTitleListButtonPublicTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "somePageUrlTitleUIListQuestionDataProvider", dataProviderClass = SomePageUrlTitleDataProvider.class)
    public void somePageUrlTitleUIListQuestionTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "somePageUrlTitleUIListSomedataDataProvider", dataProviderClass = SomePageUrlTitleDataProvider.class)
    public void somePageUrlTitleUIListSomedataTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "somePageUrlTitleDropDownDataProvider", dataProviderClass = SomePageUrlTitleDataProvider.class)
    public void somePageUrlTitleDropDownTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }
}
