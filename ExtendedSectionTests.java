package io.github.epam.html.tests.elements.composite.section;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;
import pseudo.site.dataproviders.section.ExtendedSectionDataProvider;
import pseudo.site.section.ExtendedSection;

import static io.github.epam.html.tests.elements.composite.CompositeUtils.checkInitializedElement;

public class ExtendedSectionTests extends TestsInit {

    @Test(dataProvider = "extendedSectionWebElementDataProvider", dataProviderClass = ExtendedSectionDataProvider.class)
    public void extendedSectionWebElementTest(ICoreElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedSectionListWebElementDataProvider", dataProviderClass = ExtendedSectionDataProvider.class)
    public void extendedSectionListWebElementTest(ICoreElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedSectionUIElementDataProvider", dataProviderClass = ExtendedSectionDataProvider.class)
    public void extendedSectionUIElementTest(ICoreElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedSectionButtonDataProvider", dataProviderClass = ExtendedSectionDataProvider.class)
    public void extendedSectionButtonTest(ICoreElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedSectionWebListDataProvider", dataProviderClass = ExtendedSectionDataProvider.class)
    public void extendedSectionWebListTest(ICoreElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedSectionListUIElementPublicDataProvider", dataProviderClass = ExtendedSectionDataProvider.class)
    public void extendedSectionListUIElementPublicTest(ICoreElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedSectionListButtonPublicDataProvider", dataProviderClass = ExtendedSectionDataProvider.class)
    public void extendedSectionListButtonPublicTest(ICoreElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedSectionUIListQuestionDataProvider", dataProviderClass = ExtendedSectionDataProvider.class)
    public void extendedSectionUIListQuestionTest(ICoreElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedSectionUIListSomedataDataProvider", dataProviderClass = ExtendedSectionDataProvider.class)
    public void extendedSectionUIListSomedataTest(ICoreElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedSectionDropDownDataProvider", dataProviderClass = ExtendedSectionDataProvider.class)
    public void extendedSectionDropDownTest(ICoreElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }
}
