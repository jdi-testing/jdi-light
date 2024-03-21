package io.github.epam.angular.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.angular.elements.enums.CustomColors.BLACK_SEMI_TRANSPARENT;
import static com.epam.jdi.light.angular.elements.enums.CustomColors.PURPLE;
import static com.epam.jdi.light.angular.elements.enums.CustomColors.RED;
import static com.epam.jdi.light.angular.elements.enums.CustomColors.YELLOW;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.checkBoxPage;
import static io.github.com.enums.CheckBoxAlignPosition.AFTER;
import static io.github.com.enums.CheckBoxAlignPosition.BEFORE;
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
    public void checkLabelValueTest() {
        basicCheckbox.label().has().value("Check me!");
        resultCheckbox.label().has().value("I'm a checkbox");
    }

    @Test(description = "Test verifies initial checkbox state and selection")
    public void basicCheckboxValidationTest() {
        basicCheckbox.show();
        basicCheckbox.is().displayed().and().enabled().and().notSelected();
        basicCheckbox.check();
        basicCheckbox.is().selected();
        basicCheckbox.uncheck();
    }

    @Test(description = "Test verifies checkbox feature: indeterminate")
    public void indeterminateCheckBoxTest() {
        indeterminateCheckbox.show();
        indeterminateCheckbox.check();
        resultCheckbox.is().indeterminate();
        indeterminateCheckbox.uncheck();
        basicCheckbox.is().notIndeterminate();
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
        modeRadioGroup.click(BEFORE.getAlignPosition());
        resultCheckbox.is().alignedBefore();
        modeRadioGroup.click(AFTER.getAlignPosition());
        resultCheckbox.is().alignedAfter();
    }

    @Test(description = "Test verifies checkbox feature: required option")
    public void isRequiredCheckboxTest() {
        requiredCheckbox.show();
        requiredCheckbox.uncheck();
        requiredCheckbox.is().required();
        requiredCheckboxText.has().text("Checkbox should be checked!");
        requiredCheckbox.check();
        requiredCheckboxText.is().notVisible();
        requiredCheckbox.uncheck();
        basicCheckbox.is().notRequired();
        warnColorCheckbox.is().notRequired();
    }

    @Test(description = "Verifies checkbox colors as Angular colors")
    public void angularColorCheckBoxTest() {
        //Check color for checkboxes with attribute 'color'
        primaryColorCheckbox.uncheck();
        primaryColorCheckbox.has().color(BLACK_SEMI_TRANSPARENT.getColor());
        primaryColorCheckbox.check();
        primaryColorCheckbox.has().color(PURPLE.getColor());
        accentColorCheckbox.check();
        accentColorCheckbox.has().color(YELLOW.getColor());
        warnColorCheckbox.check();
        warnColorCheckbox.has().color(RED.getColor());
        //Check color for checkbox without attribute 'color'
        requiredCheckbox.check();
        requiredCheckbox.has().color(YELLOW.getColor());
    }

}
