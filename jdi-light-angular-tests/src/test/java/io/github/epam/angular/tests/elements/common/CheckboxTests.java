package io.github.epam.angular.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.checkboxSection;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class CheckboxTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void basicCheckboxTest() {
        checkboxSection.basicCheckbox.isDisplayed();
        checkboxSection.basicCheckbox.check();
        checkboxSection.basicCheckbox.isSelected();
        checkboxSection.basicCheckbox.uncheck();
        checkboxSection.basicCheckbox.is().deselected();
    }

    @Test
    public void configurableCheckboxTest() {
        checkboxSection.configurableCheckedCheckbox.show();
        checkboxSection.configurableCheckedCheckbox.check();
        checkboxSection.configurableResultCheckbox.isSelected();
        checkboxSection.configurableCheckedCheckbox.uncheck();
        checkboxSection.configurableResultCheckbox.is().deselected();

        checkboxSection.configurableIndeterminateCheckbox.check();
        checkboxSection.configurableResultCheckbox.has().cssClass("mat-checkbox-indeterminate");

        checkboxSection.configurableCheckboxAlignBeforeRadioButton.click();
        checkboxSection.configurableResultCheckbox.has().cssClass("mat-checkbox-label-before");

        checkboxSection.configurableCheckboxAlignAfterRadioButton.click();
        checkboxSection.configurableResultCheckbox.has().cssClass("mat-checkbox-label-after");

        checkboxSection.configurableDisabledCheckbox.click();
        checkboxSection.configurableResultCheckbox.is().disabled();
    }
}
