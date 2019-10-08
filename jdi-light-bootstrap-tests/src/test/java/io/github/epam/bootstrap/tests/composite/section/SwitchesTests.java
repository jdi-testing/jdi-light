package io.github.epam.bootstrap.tests.composite.section;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.switches;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by Dmitrii Pavlov on 08.10.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class SwitchesTests extends TestsInit {



    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void isValidationTests() {
        switches.checkbox
                .is()
                .hidden()
                .enabled()
                .core()
                .attr("type", "checkbox")
                .hasClass("custom-control-input")
                .tag(is("input"));
        switches.checkbox.label()
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("custom-control-label")
                .text(is("Toggle this switch element"))
                .tag(is("label"));
        switches.checkboxContainer
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("custom-control custom-switch")
                .tag(is("div"));
    }

    @Test
    public void disabledIsValidationTests() {
        switches.checkboxDisabled
                .is()
                .hidden()
                .disabled()
                .core()
                .attr("type", "checkbox")
                .hasClass("custom-control-input")
                .tag(is("input"));
        switches.checkboxDisabled.label()
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("custom-control-label")
                .text(is("Disabled switch element"))
                .tag(is("label"));
        switches.checkboxDisabledContainer
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("custom-control custom-switch")
                .tag(is("div"));
    }

    @Test
    public void clickableTests() {
        switches.checkboxContainer.check();
        switches.checkbox.is().selected();
        switches.checkboxContainer.check();
        switches.checkbox.is().deselected();
        switches.checkbox.label().click();
        switches.checkbox.is().selected();
        switches.checkbox.label().click();
        switches.checkbox.is().deselected();
    }

    @Test
    public void disabledClickableTests() {
        switches.checkboxDisabledContainer.check();
        switches.checkboxDisabled.is().deselected();
        switches.checkboxDisabled.label().click();
        switches.checkboxDisabled.is().deselected();
    }
}
