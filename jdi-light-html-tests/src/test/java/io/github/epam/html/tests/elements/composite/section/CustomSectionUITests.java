package io.github.epam.html.tests.elements.composite.section;

import com.epam.jdi.light.elements.base.IBaseElement;
import com.epam.jdi.light.elements.base.JDIBase;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;
import pseudo.site.dataproviders.section.CustomSectionUIDataProvider;

import static io.github.epam.html.tests.elements.composite.CompositeUtils.checkInitializedElement;

public class CustomSectionUITests extends TestsInit {

    @Test(dataProvider = "customSectionUIWebElementDataProvider", dataProviderClass = CustomSectionUIDataProvider.class)
    public void customSectionUIWebElementTest(IBaseElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customSectionUIListWebElementDataProvider", dataProviderClass = CustomSectionUIDataProvider.class)
    public void customSectionUIListWebElementTest(IBaseElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customSectionUIUIElementDataProvider", dataProviderClass = CustomSectionUIDataProvider.class)
    public void customSectionUIUIElementTest(IBaseElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customSectionUIButtonDataProvider", dataProviderClass = CustomSectionUIDataProvider.class)
    public void customSectionUIButtonTest(IBaseElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customSectionUIWebListDataProvider", dataProviderClass = CustomSectionUIDataProvider.class)
    public void customSectionUIWebListTest(IBaseElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customSectionUIListUIElementPublicDataProvider", dataProviderClass = CustomSectionUIDataProvider.class)
    public void customSectionUIListUIElementPublicTest(IBaseElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customSectionUIListButtonPublicDataProvider", dataProviderClass = CustomSectionUIDataProvider.class)
    public void customSectionUIListButtonPublicTest(IBaseElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customSectionUIUIListQuestionDataProvider", dataProviderClass = CustomSectionUIDataProvider.class)
    public void customSectionUIUIListQuestionTest(IBaseElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customSectionUIUIListSomedataDataProvider", dataProviderClass = CustomSectionUIDataProvider.class)
    public void customSectionUIUIListSomedataTest(IBaseElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customSectionUIDropDownDataProvider", dataProviderClass = CustomSectionUIDataProvider.class)
    public void customSectionUIDropDownTest(IBaseElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }
}
