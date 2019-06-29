package io.github.epam.html.tests.elements.composite.section;

import com.epam.jdi.light.elements.base.IBaseElement;
import com.epam.jdi.light.elements.base.JDIBase;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;
import pseudo.site.dataproviders.section.ExtendedSectionDataProvider;
import pseudo.site.section.ExtendedSection;

import static io.github.epam.html.tests.elements.composite.CompositeUtils.checkInitializedElement;
import static pseudo.site.PseudoSite.extendedSection;

public class ExtendedSectionTests extends TestsInit {

    @Test(dataProvider = "extendedSectionWebElementDataProvider", dataProviderClass = ExtendedSectionDataProvider.class)
    public void extendedSectionWebElementTest(IBaseElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedSectionListWebElementDataProvider", dataProviderClass = ExtendedSectionDataProvider.class)
    public void extendedSectionListWebElementTest(IBaseElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedSectionUIElementDataProvider", dataProviderClass = ExtendedSectionDataProvider.class)
    public void extendedSectionUIElementTest(IBaseElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedSectionButtonDataProvider", dataProviderClass = ExtendedSectionDataProvider.class)
    public void extendedSectionButtonTest(IBaseElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedSectionWebListDataProvider", dataProviderClass = ExtendedSectionDataProvider.class)
    public void extendedSectionWebListTest(IBaseElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedSectionListUIElementPublicDataProvider", dataProviderClass = ExtendedSectionDataProvider.class)
    public void extendedSectionListUIElementPublicTest(IBaseElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedSectionListButtonPublicDataProvider", dataProviderClass = ExtendedSectionDataProvider.class)
    public void extendedSectionListButtonPublicTest(IBaseElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        ExtendedSection e = extendedSection;
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedSectionUIListQuestionDataProvider", dataProviderClass = ExtendedSectionDataProvider.class)
    public void extendedSectionUIListQuestionTest(IBaseElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedSectionUIListSomedataDataProvider", dataProviderClass = ExtendedSectionDataProvider.class)
    public void extendedSectionUIListSomedataTest(IBaseElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedSectionDropDownDataProvider", dataProviderClass = ExtendedSectionDataProvider.class)
    public void extendedSectionDropDownTest(IBaseElement htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }
}
