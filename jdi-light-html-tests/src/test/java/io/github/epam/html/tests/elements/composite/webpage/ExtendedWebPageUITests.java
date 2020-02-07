package io.github.epam.html.tests.elements.composite.webpage;

import com.epam.jdi.mobile.elements.interfaces.base.IBaseElement;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;
import pseudo.site.dataproviders.webpages.ExtendedWebPageUIDataProvider;

import static io.github.epam.html.tests.elements.composite.CompositeUtils.checkInitializedElement;

public class ExtendedWebPageUITests implements TestsInit {

    @Test(dataProvider = "extendedWebPageUIWebElementDataProvider", dataProviderClass = ExtendedWebPageUIDataProvider.class)
    public void extendedWebPageUIWebElementTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedWebPageUIListWebElementDataProvider", dataProviderClass = ExtendedWebPageUIDataProvider.class)
    public void extendedWebPageUIListWebElementTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedWebPageUIUIElementDataProvider", dataProviderClass = ExtendedWebPageUIDataProvider.class)
    public void extendedWebPageUIUIElementTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedWebPageUIButtonDataProvider", dataProviderClass = ExtendedWebPageUIDataProvider.class)
    public void extendedWebPageUIButtonTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedWebPageUIWebListDataProvider", dataProviderClass = ExtendedWebPageUIDataProvider.class)
    public void extendedWebPageUIWebListTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedWebPageUIListUIElementPublicDataProvider", dataProviderClass = ExtendedWebPageUIDataProvider.class)
    public void extendedWebPageUIListUIElementPublicTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedWebPageUIListButtonPublicDataProvider", dataProviderClass = ExtendedWebPageUIDataProvider.class)
    public void extendedWebPageUIListButtonPublicTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedWebPageUIUIListQuestionDataProvider", dataProviderClass = ExtendedWebPageUIDataProvider.class)
    public void extendedWebPageUIUIListQuestionTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedWebPageUIUIListSomedataDataProvider", dataProviderClass = ExtendedWebPageUIDataProvider.class)
    public void extendedWebPageUIUIListSomedataTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedWebPageUIDropDownDataProvider", dataProviderClass = ExtendedWebPageUIDataProvider.class)
    public void extendedWebPageUIDropDownTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }
}
