package io.github.epam.html.tests.elements.composite.webpage;

import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;
import pseudo.site.dataproviders.webpages.ExtendedWebPageDataProvider;

import static io.github.epam.html.tests.elements.composite.CompositeUtils.checkInitializedElement;

public class ExtendedWebPageTests extends TestsInit {

    @Test(dataProvider = "extendedWebPageWebElementDataProvider", dataProviderClass = ExtendedWebPageDataProvider.class)
    public void extendedWebPageWebElementTest(ICoreElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedWebPageListWebElementDataProvider", dataProviderClass = ExtendedWebPageDataProvider.class)
    public void extendedWebPageListWebElementTest(ICoreElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedWebPageUIElementDataProvider", dataProviderClass = ExtendedWebPageDataProvider.class)
    public void extendedWebPageUIElementTest(ICoreElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedWebPageButtonDataProvider", dataProviderClass = ExtendedWebPageDataProvider.class)
    public void extendedWebPageButtonTest(ICoreElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedWebPageWebListDataProvider", dataProviderClass = ExtendedWebPageDataProvider.class)
    public void extendedWebPageWebListTest(ICoreElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedWebPageListUIElementPublicDataProvider", dataProviderClass = ExtendedWebPageDataProvider.class)
    public void extendedWebPageListUIElementPublicTest(ICoreElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedWebPageListButtonPublicDataProvider", dataProviderClass = ExtendedWebPageDataProvider.class)
    public void extendedWebPageListButtonPublicTest(ICoreElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedWebPageUIListQuestionDataProvider", dataProviderClass = ExtendedWebPageDataProvider.class)
    public void extendedWebPageUIListQuestionTest(ICoreElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedWebPageUIListSomedataDataProvider", dataProviderClass = ExtendedWebPageDataProvider.class)
    public void extendedWebPageUIListSomedataTest(ICoreElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedWebPageDropDownDataProvider", dataProviderClass = ExtendedWebPageDataProvider.class)
    public void extendedWebPageDropDownTest(ICoreElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }
}
