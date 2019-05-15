package io.github.epam.html.tests.elements.composite;

import com.epam.jdi.light.elements.base.JDIBase;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;
import pseudo.site.dataproviders.Section.ExtendedObjectDataProvider;

import static io.github.epam.html.tests.elements.composite.CompositeUtils.checkInitializedElement;

public class ExtendedObjectTests extends TestsInit {

    @Test(dataProvider = "extendedObjectWebElementDataProvider", dataProviderClass = ExtendedObjectDataProvider.class)
    public void extendedObjectWebElementTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedObjectListWebElementDataProvider", dataProviderClass = ExtendedObjectDataProvider.class)
    public void extendedObjectListWebElementTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedObjectUIElementDataProvider", dataProviderClass = ExtendedObjectDataProvider.class)
    public void extendedObjectUIElementTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedObjectButtonDataProvider", dataProviderClass = ExtendedObjectDataProvider.class)
    public void extendedObjectButtonTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedObjectWebListDataProvider", dataProviderClass = ExtendedObjectDataProvider.class)
    public void extendedObjectWebListTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedObjectListUIElementPublicDataProvider", dataProviderClass = ExtendedObjectDataProvider.class)
    public void extendedObjectListUIElementPublicTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedObjectListButtonPublicDataProvider", dataProviderClass = ExtendedObjectDataProvider.class)
    public void extendedObjectListButtonPublicTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedObjectUIListQuestionDataProvider", dataProviderClass = ExtendedObjectDataProvider.class)
    public void extendedObjectUIListQuestionTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedObjectUIListSomedataDataProvider", dataProviderClass = ExtendedObjectDataProvider.class)
    public void extendedObjectUIListSomedataTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedObjectDropDownDataProvider", dataProviderClass = ExtendedObjectDataProvider.class)
    public void extendedObjectDropDownTest(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }
}
