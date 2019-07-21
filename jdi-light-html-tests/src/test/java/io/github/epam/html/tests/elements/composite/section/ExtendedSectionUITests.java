package io.github.epam.html.tests.elements.composite.section;

import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.interfaces.IBaseElement;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;
import pseudo.site.dataproviders.section.ExtendedSectionUIDataProvider;

import static io.github.epam.html.tests.elements.composite.CompositeUtils.checkInitializedElement;

public class ExtendedSectionUITests extends TestsInit {

    @Test(dataProvider = "extendedSectionUIWebElementDataProvider", dataProviderClass = ExtendedSectionUIDataProvider.class)
    public void extendedSectionUIWebElementTest(IBaseElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedSectionUIListWebElementDataProvider", dataProviderClass = ExtendedSectionUIDataProvider.class)
    public void extendedSectionUIListWebElementTest(IBaseElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedSectionUIUIElementDataProvider", dataProviderClass = ExtendedSectionUIDataProvider.class)
    public void extendedSectionUIUIElementTest(IBaseElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedSectionUIButtonDataProvider", dataProviderClass = ExtendedSectionUIDataProvider.class)
    public void extendedSectionUIButtonTest(IBaseElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedSectionUIWebListDataProvider", dataProviderClass = ExtendedSectionUIDataProvider.class)
    public void extendedSectionUIWebListTest(IBaseElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedSectionUIListUIElementPublicDataProvider", dataProviderClass = ExtendedSectionUIDataProvider.class)
    public void extendedSectionUIListUIElementPublicTest(IBaseElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedSectionUIListButtonPublicDataProvider", dataProviderClass = ExtendedSectionUIDataProvider.class)
    public void extendedSectionUIListButtonPublicTest(IBaseElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedSectionUIUIListQuestionDataProvider", dataProviderClass = ExtendedSectionUIDataProvider.class)
    public void extendedSectionUIUIListQuestionTest(IBaseElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedSectionUIUIListSomedataDataProvider", dataProviderClass = ExtendedSectionUIDataProvider.class)
    public void extendedSectionUIUIListSomedataTest(IBaseElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedSectionUIDropDownDataProvider", dataProviderClass = ExtendedSectionUIDataProvider.class)
    public void extendedSectionUIDropDownTest(IBaseElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }
}
