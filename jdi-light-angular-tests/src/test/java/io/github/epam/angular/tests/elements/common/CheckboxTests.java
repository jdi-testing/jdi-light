package io.github.epam.angular.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.CheckboxSection.*;
import static io.github.epam.angular.tests.elements.BaseValidationsUtils.baseValidation;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class CheckboxTests extends TestsInit {
    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.open();
        disabledCheckbox.show();
    }

    @Test
    public void checkLabelValue() {
        basicCheckbox.label().has().value("Check me!");
        resultCheckbox.label().has().value("I'm a checkbox");
    }

    @Test
    public void basicCheckboxValidation() {
        basicCheckbox.is().displayed().and().enabled().and().deselected();
    }

    @Test
    public void checkBasicCheckbox() {
        basicCheckbox.check();
        basicCheckbox.is().selected();
    }

    @Test
    public void baseValidationTest() {
        baseValidation(basicCheckbox);
    }

    @Test
    public void indeterminateTest() {
        indeterminateCheckbox.click();
        resultCheckbox.is().indeterminate();
    }

    @Test
    public void disabledOption() {
        disabledCheckbox.click();
        resultCheckbox.is().disabled();
    }

    @Test
    public void configurableCheckboxTest() {
        indeterminateCheckbox.check();
        alignBeforeRadioButton.click();
        resultCheckbox.is().indeterminate().and().cssClass("mat-checkbox-label-before");
    }
}
