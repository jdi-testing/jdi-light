package io.github.epam.bootstrap.tests.composite.section.form;

import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.checkboxAndRadioButtonCustomDisabled;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by Dmitrii Pavlov on 08.10.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class CheckboxAndRadioButtonCustomDisabledTests extends TestsInit {

    private String label1 = "Toggle this custom radio";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        checkboxAndRadioButtonCustomDisabled.checkbox.hover();
    }

    @Test
    public void checkboxIsValidationTests() {
        checkboxAndRadioButtonCustomDisabled.checkbox
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("custom-control")
                .hasClass("custom-checkbox")
                .tag(is("div"));
    }

    @Test
    public void radioButtonIsValidationTests() {
        checkboxAndRadioButtonCustomDisabled.radioButton.is()
                .hidden()
                .disabled()
                .core()
                .attr("type", "radio")
                .attr("name", "radioDisabled")
                .hasClass("custom-control-input")
                .tag(Matchers.is("input"));
    }

    @Test
    public void baseInitTest() {
        checkboxAndRadioButtonCustomDisabled.radioButtonContainer.is()
                .size(1);
        checkboxAndRadioButtonCustomDisabled.radioButton.is()
                .deselected();
        checkboxAndRadioButtonCustomDisabled.radio1Label.is()
                .text(is(label1));
    }

    @Test
    public void radioButtonTests() {
        checkboxAndRadioButtonCustomDisabled.radioButtonContainer.select();
        checkboxAndRadioButtonCustomDisabled.radioButton.is()
                .deselected();
        checkboxAndRadioButtonCustomDisabled.radio1Label.click();
        checkboxAndRadioButtonCustomDisabled.radioButton.is()
                .deselected();
    }

    @Test
    public void checkboxTests() {
        checkboxAndRadioButtonCustomDisabled.checkbox.check();
        checkboxAndRadioButtonCustomDisabled.checkbox.is().deselected();
        checkboxAndRadioButtonCustomDisabled.checkbox.click();
        checkboxAndRadioButtonCustomDisabled.checkbox.is().deselected();
    }
}
