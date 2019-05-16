package io.github.epam.html.tests.elements.composite.section;

import com.epam.jdi.light.elements.base.JDIBase;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;
import pseudo.site.dataproviders.Section.SomeSectionDataProvider;

import static io.github.epam.html.tests.elements.composite.CompositeUtils.checkInitializedElement;

public class SomeSectionSectionTests extends TestsInit {

    @Test(dataProvider = "someSectionWebElementDataProvider", dataProviderClass = SomeSectionDataProvider.class)
    public void someSectionWebElementTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "someSectionListWebElementDataProvider", dataProviderClass = SomeSectionDataProvider.class)
    public void someSectionListWebElementTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "someSectionUIElementDataProvider", dataProviderClass = SomeSectionDataProvider.class)
    public void someSectionUIElementTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "someSectionButtonDataProvider", dataProviderClass = SomeSectionDataProvider.class)
    public void someSectionButtonTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "someSectionWebListDataProvider", dataProviderClass = SomeSectionDataProvider.class)
    public void someSectionWebListTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "someSectionListUIElementPublicDataProvider", dataProviderClass = SomeSectionDataProvider.class)
    public void someSectionListUIElementPublicTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "someSectionListButtonPublicDataProvider", dataProviderClass = SomeSectionDataProvider.class)
    public void someSectionListButtonPublicTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "someSectionUIListQuestionDataProvider", dataProviderClass = SomeSectionDataProvider.class)
    public void someSectionUIListQuestionTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "someSectionUIListSomedataDataProvider", dataProviderClass = SomeSectionDataProvider.class)
    public void someSectionUIListSomedataTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "someSectionDropDownDataProvider", dataProviderClass = SomeSectionDataProvider.class)
    public void someSectionDropDownTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }
}
