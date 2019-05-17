package io.github.epam.html.tests.elements.composite.section;

import com.epam.jdi.light.elements.base.JDIBase;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;
import pseudo.site.dataproviders.section.SomeSectionUIDataProvider;

import static io.github.epam.html.tests.elements.composite.CompositeUtils.checkInitializedElement;

public class SomeSectionUITests extends TestsInit {

    @Test(dataProvider = "someSectionUIWebElementDataProvider", dataProviderClass = SomeSectionUIDataProvider.class)
    public void someSectionUIWebElementTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "someSectionUIListWebElementDataProvider", dataProviderClass = SomeSectionUIDataProvider.class)
    public void someSectionUIListWebElementTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "someSectionUIUIElementDataProvider", dataProviderClass = SomeSectionUIDataProvider.class)
    public void someSectionUIUIElementTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "someSectionUIButtonDataProvider", dataProviderClass = SomeSectionUIDataProvider.class)
    public void someSectionUIButtonTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "someSectionUIWebListDataProvider", dataProviderClass = SomeSectionUIDataProvider.class)
    public void someSectionUIWebListTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "someSectionUIListUIElementPublicDataProvider", dataProviderClass = SomeSectionUIDataProvider.class)
    public void someSectionUIListUIElementPublicTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "someSectionUIListButtonPublicDataProvider", dataProviderClass = SomeSectionUIDataProvider.class)
    public void someSectionUIListButtonPublicTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "someSectionUIUIListQuestionDataProvider", dataProviderClass = SomeSectionUIDataProvider.class)
    public void someSectionUIUIListQuestionTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "someSectionUIUIListSomedataDataProvider", dataProviderClass = SomeSectionUIDataProvider.class)
    public void someSectionUIUIListSomedataTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "someSectionUIDropDownDataProvider", dataProviderClass = SomeSectionUIDataProvider.class)
    public void someSectionUIDropDownTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }
}
