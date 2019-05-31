package io.github.epam.html.tests.elements.composite.webpage;

import com.epam.jdi.light.elements.base.JDIBase;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;
import pseudo.site.dataproviders.webpage.ExtendedWebPageUIDataProvider;

import static io.github.epam.html.tests.elements.composite.CompositeUtils.checkInitializedElement;

public class ExtendedWebPageUITests extends TestsInit {

    @Test(dataProvider = "extendedWebPageUIWebElementDataProvider", dataProviderClass = ExtendedWebPageUIDataProvider.class)
    public void extendedWebPageUIWebElementTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedWebPageUIListWebElementDataProvider", dataProviderClass = ExtendedWebPageUIDataProvider.class)
    public void extendedWebPageUIListWebElementTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedWebPageUIUIElementDataProvider", dataProviderClass = ExtendedWebPageUIDataProvider.class)
    public void extendedWebPageUIUIElementTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedWebPageUIButtonDataProvider", dataProviderClass = ExtendedWebPageUIDataProvider.class)
    public void extendedWebPageUIButtonTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedWebPageUIWebListDataProvider", dataProviderClass = ExtendedWebPageUIDataProvider.class)
    public void extendedWebPageUIWebListTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedWebPageUIListUIElementPublicDataProvider", dataProviderClass = ExtendedWebPageUIDataProvider.class)
    public void extendedWebPageUIListUIElementPublicTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedWebPageUIListButtonPublicDataProvider", dataProviderClass = ExtendedWebPageUIDataProvider.class)
    public void extendedWebPageUIListButtonPublicTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedWebPageUIUIListQuestionDataProvider", dataProviderClass = ExtendedWebPageUIDataProvider.class)
    public void extendedWebPageUIUIListQuestionTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedWebPageUIUIListSomedataDataProvider", dataProviderClass = ExtendedWebPageUIDataProvider.class)
    public void extendedWebPageUIUIListSomedataTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedWebPageUIDropDownDataProvider", dataProviderClass = ExtendedWebPageUIDataProvider.class)
    public void extendedWebPageUIDropDownTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }
}
