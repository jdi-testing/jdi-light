package io.github.epam.html.tests.elements.composite.webpage;

import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;
import pseudo.site.dataproviders.webpages.CustomWebPageUIDataProvider;

import static io.github.epam.html.tests.elements.composite.CompositeUtils.checkInitializedElement;

public class CustomWebPageUITests extends TestsInit {

    @Test(dataProvider = "customWebPageUIWebElementDataProvider", dataProviderClass = CustomWebPageUIDataProvider.class)
    public void customWebPageUIWebElementTest(ICoreElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customWebPageUIListWebElementDataProvider", dataProviderClass = CustomWebPageUIDataProvider.class)
    public void customWebPageUIListWebElementTest(ICoreElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customWebPageUIUIElementDataProvider", dataProviderClass = CustomWebPageUIDataProvider.class)
    public void customWebPageUIUIElementTest(ICoreElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customWebPageUIButtonDataProvider", dataProviderClass = CustomWebPageUIDataProvider.class)
    public void customWebPageUIButtonTest(ICoreElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customWebPageUIWebListDataProvider", dataProviderClass = CustomWebPageUIDataProvider.class)
    public void customWebPageUIWebListTest(ICoreElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customWebPageUIListUIElementPublicDataProvider", dataProviderClass = CustomWebPageUIDataProvider.class)
    public void customWebPageUIListUIElementPublicTest(ICoreElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customWebPageUIListButtonPublicDataProvider", dataProviderClass = CustomWebPageUIDataProvider.class)
    public void customWebPageUIListButtonPublicTest(ICoreElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customWebPageUIUIListQuestionDataProvider", dataProviderClass = CustomWebPageUIDataProvider.class)
    public void customWebPageUIUIListQuestionTest(ICoreElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customWebPageUIUIListSomedataDataProvider", dataProviderClass = CustomWebPageUIDataProvider.class)
    public void customWebPageUIUIListSomedataTest(ICoreElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customWebPageUIDropDownDataProvider", dataProviderClass = CustomWebPageUIDataProvider.class)
    public void customWebPageUIDropDownTest(ICoreElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }
}
