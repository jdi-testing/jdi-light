package io.github.epam.html.tests.elements.composite.section;

import com.epam.jdi.light.elements.base.JDIBase;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;
import pseudo.site.dataproviders.section.CustomSectionDataProvider;

import static io.github.epam.html.tests.elements.composite.CompositeUtils.checkInitializedElement;

public class CustomSectionTests extends TestsInit {

    @Test(dataProvider = "customSectionWebElementDataProvider", dataProviderClass = CustomSectionDataProvider.class)
    public void customSectionWebElementTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customSectionListWebElementDataProvider", dataProviderClass = CustomSectionDataProvider.class)
    public void customSectionListWebElementTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customSectionUIElementDataProvider", dataProviderClass = CustomSectionDataProvider.class)
    public void customSectionUIElementTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customSectionButtonDataProvider", dataProviderClass = CustomSectionDataProvider.class)
    public void customSectionButtonTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customSectionWebListDataProvider", dataProviderClass = CustomSectionDataProvider.class)
    public void customSectionWebListTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customSectionListUIElementPublicDataProvider", dataProviderClass = CustomSectionDataProvider.class)
    public void customSectionListUIElementPublicTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customSectionListButtonPublicDataProvider", dataProviderClass = CustomSectionDataProvider.class)
    public void customSectionListButtonPublicTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customSectionUIListQuestionDataProvider", dataProviderClass = CustomSectionDataProvider.class)
    public void customSectionUIListQuestionTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customSectionUIListSomedataDataProvider", dataProviderClass = CustomSectionDataProvider.class)
    public void customSectionUIListSomedataTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customSectionDropDownDataProvider", dataProviderClass = CustomSectionDataProvider.class)
    public void customSectionDropDownTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }
}
