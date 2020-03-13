package io.github.epam.html.tests.elements.composite.webpage;

import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;
import pseudo.site.dataproviders.webpages.ExtendedWebPageDataProvider;

import static io.github.epam.html.tests.elements.composite.CompositeUtils.*;

public class ExtendedWebPageTests implements TestsInit {

    @Test(dataProvider = "extendedWebPageWebElementDataProvider", dataProviderClass = ExtendedWebPageDataProvider.class)
    public void extendedWebPageWebElementTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedWebPageListWebElementDataProvider", dataProviderClass = ExtendedWebPageDataProvider.class)
    public void extendedWebPageListWebElementTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedWebPageUIElementDataProvider", dataProviderClass = ExtendedWebPageDataProvider.class)
    public void extendedWebPageUIElementTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedWebPageButtonDataProvider", dataProviderClass = ExtendedWebPageDataProvider.class)
    public void extendedWebPageButtonTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedWebPageWebListDataProvider", dataProviderClass = ExtendedWebPageDataProvider.class)
    public void extendedWebPageWebListTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedWebPageListUIElementPublicDataProvider", dataProviderClass = ExtendedWebPageDataProvider.class)
    public void extendedWebPageListUIElementPublicTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedWebPageListButtonPublicDataProvider", dataProviderClass = ExtendedWebPageDataProvider.class)
    public void extendedWebPageListButtonPublicTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedWebPageUIListQuestionDataProvider", dataProviderClass = ExtendedWebPageDataProvider.class)
    public void extendedWebPageUIListQuestionTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedWebPageUIListSomedataDataProvider", dataProviderClass = ExtendedWebPageDataProvider.class)
    public void extendedWebPageUIListSomedataTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedWebPageDropDownDataProvider", dataProviderClass = ExtendedWebPageDataProvider.class)
    public void extendedWebPageDropDownTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }
}
