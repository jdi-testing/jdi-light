package io.github.epam.html.tests.elements.composite.webpage;

import com.epam.jdi.light.elements.base.JDIBase;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;
import pseudo.site.dataproviders.webpage.CustomWebPageDataProvider;

import static io.github.epam.html.tests.elements.composite.CompositeUtils.checkInitializedElement;

public class CustomWebPageTests extends TestsInit {

    @Test(dataProvider = "customWebPageWebElementDataProvider", dataProviderClass = CustomWebPageDataProvider.class)
    public void customWebPageWebElementTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customWebPageListWebElementDataProvider", dataProviderClass = CustomWebPageDataProvider.class)
    public void customWebPageListWebElementTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customWebPageUIElementDataProvider", dataProviderClass = CustomWebPageDataProvider.class)
    public void customWebPageUIElementTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customWebPageButtonDataProvider", dataProviderClass = CustomWebPageDataProvider.class)
    public void customWebPageButtonTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customWebPageWebListDataProvider", dataProviderClass = CustomWebPageDataProvider.class)
    public void customWebPageWebListTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customWebPageListUIElementPublicDataProvider", dataProviderClass = CustomWebPageDataProvider.class)
    public void customWebPageListUIElementPublicTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customWebPageListButtonPublicDataProvider", dataProviderClass = CustomWebPageDataProvider.class)
    public void customWebPageListButtonPublicTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customWebPageUIListQuestionDataProvider", dataProviderClass = CustomWebPageDataProvider.class)
    public void customWebPageUIListQuestionTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customWebPageUIListSomedataDataProvider", dataProviderClass = CustomWebPageDataProvider.class)
    public void customWebPageUIListSomedataTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customWebPageDropDownDataProvider", dataProviderClass = CustomWebPageDataProvider.class)
    public void customWebPageDropDownTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }
}
