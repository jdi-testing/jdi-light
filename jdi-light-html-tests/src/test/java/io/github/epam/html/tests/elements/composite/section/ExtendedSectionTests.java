package io.github.epam.html.tests.elements.composite.section;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.elements.interfaces.complex.IsCombobox;
import com.epam.jdi.light.ui.html.elements.complex.DataListOptions;
import io.github.com.StaticSite;
import io.github.epam.TestsInit;
import io.github.epam.test.data.sections.ExtendedSectionDataProvider;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pseudo.site.PseudoSite;
import pseudo.site.section.ExtendedSection;

import static com.epam.jdi.light.elements.init.InitActions.INTERFACES;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static io.github.epam.html.tests.elements.composite.CompositeUtils.checkInitializedElement;
import static pseudo.site.PseudoSite.extendedSection;

public class ExtendedSectionTests implements TestsInit {

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        INTERFACES.update(IsCombobox.class, DataListOptions.class);
        initSite(PseudoSite.class);
        logger.toLog("Run Tests with Pseudo site");
    }

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
        ExtendedSection e = extendedSection;
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
