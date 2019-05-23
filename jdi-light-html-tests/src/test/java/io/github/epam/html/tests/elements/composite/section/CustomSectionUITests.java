package io.github.epam.html.tests.elements.composite.section;

import com.epam.jdi.light.elements.base.JDIBase;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;
import pseudo.site.dataproviders.section.CustomSectionUIDataProvider;

import static io.github.epam.html.tests.elements.composite.CompositeUtils.checkInitializedElement;

public class CustomSectionUITests extends TestsInit {

    @Test(dataProvider = "customSectionUIWebElementDataProvider", dataProviderClass = CustomSectionUIDataProvider.class)
    public void customSectionUIWebElementTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customSectionUIListWebElementDataProvider", dataProviderClass = CustomSectionUIDataProvider.class)
    public void customSectionUIListWebElementTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customSectionUIUIElementDataProvider", dataProviderClass = CustomSectionUIDataProvider.class)
    public void customSectionUIUIElementTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customSectionUIButtonDataProvider", dataProviderClass = CustomSectionUIDataProvider.class)
    public void customSectionUIButtonTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customSectionUIWebListDataProvider", dataProviderClass = CustomSectionUIDataProvider.class)
    public void customSectionUIWebListTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customSectionUIListUIElementPublicDataProvider", dataProviderClass = CustomSectionUIDataProvider.class)
    public void customSectionUIListUIElementPublicTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customSectionUIListButtonPublicDataProvider", dataProviderClass = CustomSectionUIDataProvider.class)
    public void customSectionUIListButtonPublicTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customSectionUIUIListQuestionDataProvider", dataProviderClass = CustomSectionUIDataProvider.class)
    public void customSectionUIUIListQuestionTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customSectionUIUIListSomedataDataProvider", dataProviderClass = CustomSectionUIDataProvider.class)
    public void customSectionUIUIListSomedataTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customSectionUIDropDownDataProvider", dataProviderClass = CustomSectionUIDataProvider.class)
    public void customSectionUIDropDownTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }
}
