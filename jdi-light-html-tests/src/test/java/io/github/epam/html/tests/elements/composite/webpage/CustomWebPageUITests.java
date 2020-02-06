package io.github.epam.html.tests.elements.composite.webpage;

import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;
import pseudo.site.dataproviders.webpages.CustomWebPageUIDataProvider;

import static io.github.epam.html.tests.elements.composite.CompositeUtils.checkInitializedElement;

public class CustomWebPageUITests implements TestsInit {

    @Test(dataProvider = "customWebPageUIWebElementDataProvider", dataProviderClass = CustomWebPageUIDataProvider.class)
    public void customWebPageUIWebElementTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customWebPageUIListWebElementDataProvider", dataProviderClass = CustomWebPageUIDataProvider.class)
    public void customWebPageUIListWebElementTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customWebPageUIUIElementDataProvider", dataProviderClass = CustomWebPageUIDataProvider.class)
    public void customWebPageUIUIElementTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customWebPageUIButtonDataProvider", dataProviderClass = CustomWebPageUIDataProvider.class)
    public void customWebPageUIButtonTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customWebPageUIWebListDataProvider", dataProviderClass = CustomWebPageUIDataProvider.class)
    public void customWebPageUIWebListTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customWebPageUIListUIElementPublicDataProvider", dataProviderClass = CustomWebPageUIDataProvider.class)
    public void customWebPageUIListUIElementPublicTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customWebPageUIListButtonPublicDataProvider", dataProviderClass = CustomWebPageUIDataProvider.class)
    public void customWebPageUIListButtonPublicTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customWebPageUIUIListQuestionDataProvider", dataProviderClass = CustomWebPageUIDataProvider.class)
    public void customWebPageUIUIListQuestionTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customWebPageUIUIListSomedataDataProvider", dataProviderClass = CustomWebPageUIDataProvider.class)
    public void customWebPageUIUIListSomedataTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customWebPageUIDropDownDataProvider", dataProviderClass = CustomWebPageUIDataProvider.class)
    public void customWebPageUIDropDownTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }
}
