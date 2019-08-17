package io.github.epam.html.tests.elements.composite.webpage;

import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;
import pseudo.site.dataproviders.webpages.CustomWebPageDataProvider;

import static io.github.epam.html.tests.elements.composite.CompositeUtils.checkInitializedElement;

public class CustomWebPageTests extends TestsInit {

    @Test(dataProvider = "customWebPageWebElementDataProvider", dataProviderClass = CustomWebPageDataProvider.class)
    public void customWebPageWebElementTest(ICoreElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customWebPageListWebElementDataProvider", dataProviderClass = CustomWebPageDataProvider.class)
    public void customWebPageListWebElementTest(ICoreElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customWebPageUIElementDataProvider", dataProviderClass = CustomWebPageDataProvider.class)
    public void customWebPageUIElementTest(ICoreElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customWebPageButtonDataProvider", dataProviderClass = CustomWebPageDataProvider.class)
    public void customWebPageButtonTest(ICoreElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customWebPageWebListDataProvider", dataProviderClass = CustomWebPageDataProvider.class)
    public void customWebPageWebListTest(ICoreElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customWebPageListUIElementPublicDataProvider", dataProviderClass = CustomWebPageDataProvider.class)
    public void customWebPageListUIElementPublicTest(ICoreElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customWebPageListButtonPublicDataProvider", dataProviderClass = CustomWebPageDataProvider.class)
    public void customWebPageListButtonPublicTest(ICoreElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customWebPageUIListQuestionDataProvider", dataProviderClass = CustomWebPageDataProvider.class)
    public void customWebPageUIListQuestionTest(ICoreElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customWebPageUIListSomedataDataProvider", dataProviderClass = CustomWebPageDataProvider.class)
    public void customWebPageUIListSomedataTest(ICoreElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customWebPageDropDownDataProvider", dataProviderClass = CustomWebPageDataProvider.class)
    public void customWebPageDropDownTest(ICoreElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }
}
