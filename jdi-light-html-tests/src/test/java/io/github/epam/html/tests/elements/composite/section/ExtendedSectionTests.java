package io.github.epam.html.tests.elements.composite.section;

import com.epam.jdi.light.elements.base.JDIBase;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;
import pseudo.site.dataproviders.section.ExtendedSectionDataProvider;
import pseudo.site.sections.ExtendedSection;

import static io.github.epam.html.tests.elements.composite.CompositeUtils.checkInitializedElement;
import static pseudo.site.PseudoSite.extendedSection;

public class ExtendedSectionTests extends TestsInit {

    @Test(dataProvider = "extendedSectionWebElementDataProvider", dataProviderClass = ExtendedSectionDataProvider.class)
    public void extendedSectionWebElementTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedSectionListWebElementDataProvider", dataProviderClass = ExtendedSectionDataProvider.class)
    public void extendedSectionListWebElementTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedSectionUIElementDataProvider", dataProviderClass = ExtendedSectionDataProvider.class)
    public void extendedSectionUIElementTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedSectionButtonDataProvider", dataProviderClass = ExtendedSectionDataProvider.class)
    public void extendedSectionButtonTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedSectionWebListDataProvider", dataProviderClass = ExtendedSectionDataProvider.class)
    public void extendedSectionWebListTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedSectionListUIElementPublicDataProvider", dataProviderClass = ExtendedSectionDataProvider.class)
    public void extendedSectionListUIElementPublicTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedSectionListButtonPublicDataProvider", dataProviderClass = ExtendedSectionDataProvider.class)
    public void extendedSectionListButtonPublicTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        ExtendedSection e = extendedSection;
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedSectionUIListQuestionDataProvider", dataProviderClass = ExtendedSectionDataProvider.class)
    public void extendedSectionUIListQuestionTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedSectionUIListSomedataDataProvider", dataProviderClass = ExtendedSectionDataProvider.class)
    public void extendedSectionUIListSomedataTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "extendedSectionDropDownDataProvider", dataProviderClass = ExtendedSectionDataProvider.class)
    public void extendedSectionDropDownTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }
}
