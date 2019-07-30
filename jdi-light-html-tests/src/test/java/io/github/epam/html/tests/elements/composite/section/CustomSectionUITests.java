package io.github.epam.html.tests.elements.composite.section;

import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.interfaces.ICoreElement;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;
import pseudo.site.dataproviders.section.CustomSectionUIDataProvider;

import static io.github.epam.html.tests.elements.composite.CompositeUtils.checkInitializedElement;

public class CustomSectionUITests extends TestsInit {

    @Test(dataProvider = "customSectionUIWebElementDataProvider", dataProviderClass = CustomSectionUIDataProvider.class)
    public void customSectionUIWebElementTest(ICoreElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customSectionUIListWebElementDataProvider", dataProviderClass = CustomSectionUIDataProvider.class)
    public void customSectionUIListWebElementTest(ICoreElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customSectionUIUIElementDataProvider", dataProviderClass = CustomSectionUIDataProvider.class)
    public void customSectionUIUIElementTest(ICoreElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customSectionUIButtonDataProvider", dataProviderClass = CustomSectionUIDataProvider.class)
    public void customSectionUIButtonTest(ICoreElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customSectionUIWebListDataProvider", dataProviderClass = CustomSectionUIDataProvider.class)
    public void customSectionUIWebListTest(ICoreElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customSectionUIListUIElementPublicDataProvider", dataProviderClass = CustomSectionUIDataProvider.class)
    public void customSectionUIListUIElementPublicTest(ICoreElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customSectionUIListButtonPublicDataProvider", dataProviderClass = CustomSectionUIDataProvider.class)
    public void customSectionUIListButtonPublicTest(ICoreElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customSectionUIUIListQuestionDataProvider", dataProviderClass = CustomSectionUIDataProvider.class)
    public void customSectionUIUIListQuestionTest(ICoreElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customSectionUIUIListSomedataDataProvider", dataProviderClass = CustomSectionUIDataProvider.class)
    public void customSectionUIUIListSomedataTest(ICoreElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customSectionUIDropDownDataProvider", dataProviderClass = CustomSectionUIDataProvider.class)
    public void customSectionUIDropDownTest(ICoreElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }
}
