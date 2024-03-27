package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.angular.elements.enums.CustomColors.BLACK_SEMI_TRANSPARENT;
import static com.epam.jdi.light.angular.elements.enums.CustomColors.PURPLE;
import static com.epam.jdi.light.angular.elements.enums.CustomColors.RED;
import static com.epam.jdi.light.angular.elements.enums.CustomColors.YELLOW;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.radioButtonPage;
import static io.github.com.pages.RadioButtonPage.accentRadioButton;
import static io.github.com.pages.RadioButtonPage.basicRadioGroup;
import static io.github.com.pages.RadioButtonPage.beforePositionRadioGroup;
import static io.github.com.pages.RadioButtonPage.colorRadioGroup;
import static io.github.com.pages.RadioButtonPage.disabledRadioGroup;
import static io.github.com.pages.RadioButtonPage.elementPositionRadioGroup;
import static io.github.com.pages.RadioButtonPage.labelPositionRadioGroup;
import static io.github.com.pages.RadioButtonPage.primaryRadioButton;
import static io.github.com.pages.RadioButtonPage.requiredRadioGroup;
import static io.github.com.pages.RadioButtonPage.warnRadioButton;

public class RadioButtonTests extends TestsInit {
    @BeforeClass
    public void before() {
        radioButtonPage.open();
        waitCondition(() -> radioButtonPage.isOpened());
        radioButtonPage.checkOpened();
    }

    @Test(description = "Test verifies value and the radio-button is checked")
    public void basicRadioButtonsTest() {
        basicRadioGroup.show();
        basicRadioGroup.is().displayed();
        basicRadioGroup.click("2");
        basicRadioGroup.is().checked("2");
        basicRadioGroup.click("1");
        basicRadioGroup.is().checked("1");
        basicRadioGroup.is().notChecked("2");
        basicRadioGroup.radioButtons().get(0).is().checked();
        basicRadioGroup.radioButtons().get(1).is().notChecked();
    }

    @Test(description = "Test verifies that radio-group label in in before/after position")
    public void labelGroupPositionTest() {
        labelPositionRadioGroup.is().groupBeforePosition();
        basicRadioGroup.is().groupAfterPosition();
    }

    @Test(description = "Test verifies that radio-button label in in before/after position")
    public void labelRadioButtonPositionTest() {
        elementPositionRadioGroup.radioButtons().get(0).has().labelBeforePosition();
        basicRadioGroup.radioButtons().get(0).has().labelAfterPosition();
        beforePositionRadioGroup.radioButtons().get(0).has().labelBeforePosition();
        beforePositionRadioGroup.radioButtons().get(1).has().labelBeforePosition();
    }

    @Test(description = "Test verifies radio button label")
    public void radioButtonLabelTest() {
        requiredRadioGroup.radioButtons().get(0).has().label("One");
    }

    @Test(description = "Test verifies that radio-button group is disabled/enabled")
    public void radioGroupDisabledTest() {
        disabledRadioGroup.is().disabled();
        basicRadioGroup.is().enabled();
    }

    @Test(description = "Test verifies that radio-button in group is disabled/enabled")
    public void radioButtonDisabledTest() {
        disabledRadioGroup.radioButtons().get(0).is().disabled();
        basicRadioGroup.radioButtons().get(0).is().enabled();
    }

    @Test(description = "Test verifies that radio-button group is required/not required")
    public void radioGroupRequiredTest() {
        requiredRadioGroup.show();
        requiredRadioGroup.is().displayed().and().required();
        basicRadioGroup.is().notRequired();
    }

    @Test(description = "Test verifies that there is checked radio-button in the group")
    public void getCheckedRadioButtonTest() {
        colorRadioGroup.has().checkedRadioButton();
        requiredRadioGroup.has().noCheckedRadioButton();
    }

    @Test(description = "Check radio buttons colors")
    public void colorButtonsTest() {
        colorRadioGroup.show();
        colorRadioGroup.is().displayed();
        primaryRadioButton.click();
        primaryRadioButton.has().color(PURPLE.getColor());
        accentRadioButton.has().color(BLACK_SEMI_TRANSPARENT.getColor());
        warnRadioButton.click();
        warnRadioButton.has().color(RED.getColor());
        primaryRadioButton.has().color(BLACK_SEMI_TRANSPARENT.getColor());
        accentRadioButton.click();
        accentRadioButton.has().color(YELLOW.getColor());
    }
}
