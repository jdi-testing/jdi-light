package io.github.epam.html.tests.elements.composite;

import com.epam.jdi.light.elements.base.JDIBase;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;
import pseudo.site.dataproviders.Section.ExtendedObjectUIDataProvider;

import static io.github.epam.html.tests.elements.composite.CompositeUtils.checkInitializedElement;

public class ExtendedObjectUITests extends TestsInit {

    @Test(dataProvider = "extendedObjectUIWebElementDataProvider", dataProviderClass = ExtendedObjectUIDataProvider.class)
    public void extendedObjectUIWebElementTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedObjectUIListWebElementDataProvider", dataProviderClass = ExtendedObjectUIDataProvider.class)
    public void extendedObjectUIListWebElementTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedObjectUIUIElementDataProvider", dataProviderClass = ExtendedObjectUIDataProvider.class)
    public void extendedObjectUIUIElementTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedObjectUIButtonDataProvider", dataProviderClass = ExtendedObjectUIDataProvider.class)
    public void extendedObjectUIButtonTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedObjectUIWebListDataProvider", dataProviderClass = ExtendedObjectUIDataProvider.class)
    public void extendedObjectUIWebListTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedObjectUIListUIElementPublicDataProvider", dataProviderClass = ExtendedObjectUIDataProvider.class)
    public void extendedObjectUIListUIElementPublicTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedObjectUIListButtonPublicDataProvider", dataProviderClass = ExtendedObjectUIDataProvider.class)
    public void extendedObjectUIListButtonPublicTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedObjectUIUIListQuestionDataProvider", dataProviderClass = ExtendedObjectUIDataProvider.class)
    public void extendedObjectUIUIListQuestionTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedObjectUIUIListSomedataDataProvider", dataProviderClass = ExtendedObjectUIDataProvider.class)
    public void extendedObjectUIUIListSomedataTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedObjectUIDropDownDataProvider", dataProviderClass = ExtendedObjectUIDataProvider.class)
    public void extendedObjectUIDropDownTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }
}
