package io.github.epam.bootstrap.tests.composite.section;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.checkboxesCustom;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.is;

public class CheckboxesCustomTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        checkboxesCustom.hover();
    }

    @Test
    public void isValidationTests() {
        checkboxesCustom.checkbox
                .is()
                .hidden()
                .enabled()
                .core()
                .attr("type", "checkbox")
                .hasClass("custom-control-input");
        checkboxesCustom.checkbox.label()
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("custom-control-label")
                .text(is("Check this custom checkbox"));
    }

    @Test
    public void clickableTests() {
        checkboxesCustom.checkbox.check();
        checkboxesCustom.checkbox.is().selected();
        checkboxesCustom.checkbox.uncheck();
        checkboxesCustom.checkbox.is().deselected();
    }
}
