package io.github.epam.html.tests.elements.composite.section;

import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import io.github.epam.TestsInit;
import io.github.epam.test.data.sections.CustomSectionDataProvider;
import org.testng.annotations.Test;

import static io.github.epam.html.tests.elements.composite.CompositeUtils.*;

public class CustomSectionTests implements TestsInit {

    @Test(dataProvider = "customSectionWebElementDataProvider", dataProviderClass = CustomSectionDataProvider.class)
    public void customSectionWebElementTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customSectionListWebElementDataProvider", dataProviderClass = CustomSectionDataProvider.class)
    public void customSectionListWebElementTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customSectionUIElementDataProvider", dataProviderClass = CustomSectionDataProvider.class)
    public void customSectionUIElementTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customSectionButtonDataProvider", dataProviderClass = CustomSectionDataProvider.class)
    public void customSectionButtonTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customSectionWebListDataProvider", dataProviderClass = CustomSectionDataProvider.class)
    public void customSectionWebListTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customSectionListUIElementPublicDataProvider", dataProviderClass = CustomSectionDataProvider.class)
    public void customSectionListUIElementPublicTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customSectionListButtonPublicDataProvider", dataProviderClass = CustomSectionDataProvider.class)
    public void customSectionListButtonPublicTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customSectionUIListQuestionDataProvider", dataProviderClass = CustomSectionDataProvider.class)
    public void customSectionUIListQuestionTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customSectionUIListSomedataDataProvider", dataProviderClass = CustomSectionDataProvider.class)
    public void customSectionUIListSomedataTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "customSectionDropDownDataProvider", dataProviderClass = CustomSectionDataProvider.class)
    public void customSectionDropDownTest(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }
}
