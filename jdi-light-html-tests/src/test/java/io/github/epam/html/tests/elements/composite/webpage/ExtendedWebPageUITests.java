package io.github.epam.html.tests.elements.composite.webpage;

import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;
import pseudo.site.dataproviders.webpages.ExtendedWebPageUIDataProvider;

import static io.github.epam.html.tests.elements.composite.CompositeUtils.checkInitializedElement;

public class ExtendedWebPageUITests extends TestsInit {

    @Test(dataProvider = "extendedWebPageUIWebElementDataProvider", dataProviderClass = ExtendedWebPageUIDataProvider.class)
    public void extendedWebPageUIWebElementTest(ICoreElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedWebPageUIListWebElementDataProvider", dataProviderClass = ExtendedWebPageUIDataProvider.class)
    public void extendedWebPageUIListWebElementTest(ICoreElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedWebPageUIUIElementDataProvider", dataProviderClass = ExtendedWebPageUIDataProvider.class)
    public void extendedWebPageUIUIElementTest(ICoreElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedWebPageUIButtonDataProvider", dataProviderClass = ExtendedWebPageUIDataProvider.class)
    public void extendedWebPageUIButtonTest(ICoreElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedWebPageUIWebListDataProvider", dataProviderClass = ExtendedWebPageUIDataProvider.class)
    public void extendedWebPageUIWebListTest(ICoreElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedWebPageUIListUIElementPublicDataProvider", dataProviderClass = ExtendedWebPageUIDataProvider.class)
    public void extendedWebPageUIListUIElementPublicTest(ICoreElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedWebPageUIListButtonPublicDataProvider", dataProviderClass = ExtendedWebPageUIDataProvider.class)
    public void extendedWebPageUIListButtonPublicTest(ICoreElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedWebPageUIUIListQuestionDataProvider", dataProviderClass = ExtendedWebPageUIDataProvider.class)
    public void extendedWebPageUIUIListQuestionTest(ICoreElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedWebPageUIUIListSomedataDataProvider", dataProviderClass = ExtendedWebPageUIDataProvider.class)
    public void extendedWebPageUIUIListSomedataTest(ICoreElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedWebPageUIDropDownDataProvider", dataProviderClass = ExtendedWebPageUIDataProvider.class)
    public void extendedWebPageUIDropDownTest(ICoreElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }
}
