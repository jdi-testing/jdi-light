package io.github.epam.angular.tests.elements.common;

import com.epam.jdi.light.angular.elements.enums.AngularColors;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.angular.elements.enums.CheckBoxModes.AFTER;
import static com.epam.jdi.light.angular.elements.enums.CheckBoxModes.BEFORE;
import static com.jdiai.tools.Timer.waitCondition;

import static io.github.com.StaticSite.checkBoxPage;
import static io.github.com.pages.CheckBoxPage.accentColorCheckbox;
import static io.github.com.pages.CheckBoxPage.basicCheckbox;
import static io.github.com.pages.CheckBoxPage.disabledCheckbox;
import static io.github.com.pages.CheckBoxPage.indeterminateCheckbox;
import static io.github.com.pages.CheckBoxPage.modeRadioGroup;
import static io.github.com.pages.CheckBoxPage.primaryColorCheckbox;
import static io.github.com.pages.CheckBoxPage.requiredCheckbox;
import static io.github.com.pages.CheckBoxPage.requiredCheckboxText;
import static io.github.com.pages.CheckBoxPage.resultCheckbox;
import static io.github.com.pages.CheckBoxPage.warnColorCheckbox;

public class CheckboxTests extends TestsInit {
    @BeforeClass(alwaysRun = true)
    public void before() {
        checkBoxPage.open();
        waitCondition((()  -> checkBoxPage.isOpened()));
        checkBoxPage.checkOpened();
    }

    @Test(description = "Test verifies label value of checkbox")
    public void checkLabelValue() {
        basicCheckbox.label().has().value("Check me!");
        resultCheckbox.label().has().value("I'm a checkbox");
    }

    @Test(description = "Test verifies initial checkbox state")
    public void basicCheckboxValidation() {
        basicCheckbox.show();
        basicCheckbox.is().displayed().and().enabled().and().deselected();
    }

    @Test(description = "Test verifies checkbox selection state")
    public void checkBasicCheckbox() {
        basicCheckbox.check();
        basicCheckbox.is().selected();
    }

    @Test(description = "Test verifies checkbox feature: indeterminate")
    public void indeterminateCheckBoxTest() {
        indeterminateCheckbox.show();
        indeterminateCheckbox.check();
        resultCheckbox.is().indeterminate();
        indeterminateCheckbox.uncheck();
        resultCheckbox.is().notIndeterminate();
    }

    @Test(description = "Test verifies checkbox disabled state")
    public void disabledOptionCheckBoxTest() {
        disabledCheckbox.check();
        resultCheckbox.is().disabled();
        disabledCheckbox.uncheck();
        resultCheckbox.is().enabled();
    }

    @Test(description = "Test verifies checkbox align positions")
    public void alignPositionsCheckboxTest() {
        modeRadioGroup.click(BEFORE.getMode());
        resultCheckbox.is().alignedBefore();
        modeRadioGroup.click(AFTER.getMode());
        resultCheckbox.is().alignedAfter();
    }

    @Test(description = "Test verifies checkbox feature: required option")
    public void isRequiredCheckboxTest() {
        requiredCheckbox.show();
        requiredCheckbox.is().isRequired();
        requiredCheckboxText.has().text("Checkbox should be checked!");
        requiredCheckbox.check();
        requiredCheckboxText.is().notVisible();
        resultCheckbox.is().isNotRequired();
    }

    @Test(description = "Verifies checkbox colors")
    public void colorCheckBoxTest() {
        //Check color for checkboxes with attribute 'color'
        primaryColorCheckbox.has().color(AngularColors.PRIMARY.getColor());
        accentColorCheckbox.has().color(AngularColors.ACCENT.getColor());
        warnColorCheckbox.has().color(AngularColors.WARN.getColor());
        //Check color for checkbox without attribute 'color'
        requiredCheckbox.has().color(AngularColors.ACCENT.getColor());
    }

}
