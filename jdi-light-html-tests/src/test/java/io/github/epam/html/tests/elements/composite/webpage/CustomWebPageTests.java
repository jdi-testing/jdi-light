package io.github.epam.html.tests.elements.composite.webpage;

import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;
import pseudo.site.dataproviders.webpages.CustomWebPageDataProvider;

import static io.github.epam.html.tests.elements.composite.CompositeUtils.checkInitializedElement;

public class CustomWebPageTests extends TestsInit {

    @Test(dataProvider = "customWebPageWebElementDataProvider", dataProviderClass = CustomWebPageDataProvider.class)
    public void customWebPageWebElementTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customWebPageListWebElementDataProvider", dataProviderClass = CustomWebPageDataProvider.class)
    public void customWebPageListWebElementTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customWebPageUIElementDataProvider", dataProviderClass = CustomWebPageDataProvider.class)
    public void customWebPageUIElementTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customWebPageButtonDataProvider", dataProviderClass = CustomWebPageDataProvider.class)
    public void customWebPageButtonTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customWebPageWebListDataProvider", dataProviderClass = CustomWebPageDataProvider.class)
    public void customWebPageWebListTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customWebPageListUIElementPublicDataProvider", dataProviderClass = CustomWebPageDataProvider.class)
    public void customWebPageListUIElementPublicTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customWebPageListButtonPublicDataProvider", dataProviderClass = CustomWebPageDataProvider.class)
    public void customWebPageListButtonPublicTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customWebPageUIListQuestionDataProvider", dataProviderClass = CustomWebPageDataProvider.class)
    public void customWebPageUIListQuestionTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customWebPageUIListSomedataDataProvider", dataProviderClass = CustomWebPageDataProvider.class)
    public void customWebPageUIListSomedataTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customWebPageDropDownDataProvider", dataProviderClass = CustomWebPageDataProvider.class)
    public void customWebPageDropDownTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }
}
