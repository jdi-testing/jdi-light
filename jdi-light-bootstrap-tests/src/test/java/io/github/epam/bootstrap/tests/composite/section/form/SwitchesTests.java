package io.github.epam.bootstrap.tests.composite.section.form;

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
        switches.checkbox.label()
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("custom-control-label")
                .text(is("Toggle this switch element"))
                .tag(is("label"));
        switches.checkbox
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("custom-control")
                .hasClass("custom-switch")
                .tag(is("div"));
    }

    @Test
    public void disabledIsValidationTests() {
        switches.checkboxDisabled.label()
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("custom-control-label")
                .text(is("Disabled switch element"))
                .tag(is("label"));
        switches.checkboxDisabled
                .is()
                .displayed()
                .disabled()
                .core()
                .hasClass("custom-control")
                .hasClass("custom-switch")
                .tag(is("div"));
    }

    @Test
    public void clickableTests() {
        switches.checkbox.check();
        switches.checkbox.is().selected();
        switches.checkbox.uncheck();
        switches.checkbox.is().deselected();
        switches.checkbox.label().click();
        switches.checkbox.is().selected();
        switches.checkbox.label().click();
        switches.checkbox.is().deselected();
    }

    @Test
    public void disabledClickableTests() {
        switches.checkboxDisabled.check();
        switches.checkboxDisabled.is().deselected();
        switches.checkboxDisabled.label().click();
        switches.checkboxDisabled.is().deselected();
    }
}
