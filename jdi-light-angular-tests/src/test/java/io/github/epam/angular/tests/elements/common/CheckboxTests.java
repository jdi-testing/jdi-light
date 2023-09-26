package io.github.epam.angular.tests.elements.common;

import com.epam.jdi.light.angular.elements.enums.AngularColors;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;

import static io.github.com.StaticSite.checkBoxPage;
import static io.github.com.pages.CheckBoxPage.accentColorCheckbox;
import static io.github.com.pages.CheckBoxPage.alignAfterRadioButton;
import static io.github.com.pages.CheckBoxPage.alignBeforeRadioButton;
import static io.github.com.pages.CheckBoxPage.ariaLabelCheckbox;
import static io.github.com.pages.CheckBoxPage.basicCheckbox;
import static io.github.com.pages.CheckBoxPage.disableRippleCheckbox;
import static io.github.com.pages.CheckBoxPage.disabledCheckbox;
import static io.github.com.pages.CheckBoxPage.indeterminateCheckbox;
import static io.github.com.pages.CheckBoxPage.primaryColorCheckbox;
import static io.github.com.pages.CheckBoxPage.requiredCheckbox;
import static io.github.com.pages.CheckBoxPage.resultCheckbox;
import static io.github.com.pages.CheckBoxPage.warnColorCheckbox;

public class CheckboxTests extends TestsInit {
    @BeforeMethod(alwaysRun = true)
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
    public void indeterminateTest() {
        indeterminateCheckbox.show();
        indeterminateCheckbox.check();
        resultCheckbox.is().indeterminate();
    }

    @Test(description = "Test verifies checkbox disabled state")
    public void disabledOption() {
        disabledCheckbox.check();
        resultCheckbox.is().disabled();
    }

    @Test(description = "Test verifies checkbox align positions")
    public void configurableCheckboxTest() {
        alignBeforeRadioButton.click();
        resultCheckbox.is().alignedBefore();
        alignAfterRadioButton.click();
        resultCheckbox.is().alignedAfter();
    }

    @Test(description = "Test verifies that checkbox has no ripple effect")
    public void noRippleEffect() {
        disabledCheckbox.show();
        disableRippleCheckbox.is().noRippleEffect();
    }

    @Test(description = "Test verifies checkbox aria-label")
    public void ariaLabel() {
        ariaLabelCheckbox.show();
        String ARIALABEL = "First checkbox";
        ariaLabelCheckbox.is().hasAriaLabel(ARIALABEL);
    }

    @Test(description = "Test verifies checkbox feature: required option")
    public void isRequired() {
        requiredCheckbox.show();
        resultCheckbox.is().isRequired();
    }

    @Test(description = "Verifies checkbox colors")
    public void colorButtonsTest() {
        primaryColorCheckbox.is().color(AngularColors.PRIMARY.getColor());
        accentColorCheckbox.is().color(AngularColors.ACCENT.getColor());
        warnColorCheckbox.is().color(AngularColors.WARN.getColor());
    }

}
