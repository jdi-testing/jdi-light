package io.github.epam.bootstrap.tests.composite.section;

import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.checkboxAndRadioButtonCustomDisabled;
import static io.github.com.pages.BootstrapPage.checkboxesCustom;
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
        checkboxesCustom.hover();
    }

    @Test
    public void checkboxIsValidationTests() {
        checkboxAndRadioButtonCustomDisabled.checkbox
                .is()
                .disappear()
                .disabled()
                .core()
                .attr("type", "checkbox")
                .hasClass("custom-control-input")
                .tag(is("input"));
        checkboxAndRadioButtonCustomDisabled.checkbox.label()
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("custom-control-label")
                .text(is("Check this custom checkbox"))
                .tag(is("label"));
        checkboxAndRadioButtonCustomDisabled.checkboxContainer
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("custom-control custom-checkbox")
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
        checkboxAndRadioButtonCustomDisabled.checkboxContainer.check();
        checkboxAndRadioButtonCustomDisabled.checkbox.is().deselected();
        checkboxAndRadioButtonCustomDisabled.checkbox.label().click();
        checkboxAndRadioButtonCustomDisabled.checkbox.is().deselected();
    }
}
