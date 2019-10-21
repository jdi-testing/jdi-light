package io.github.epam.bootstrap.tests.composite.section.form;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.formDisabled;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.is;

public class FormDisabledTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void isValidationTests() {
        formDisabled.formContainer
                .is()
                .displayed()
                .disabled()
                .core()
                .hasAttr("disabled");
        formDisabled.textField
                .is()
                .displayed()
                .disabled()
                .core()
                .hasClass("form-control")
                .attr("placeholder", "Disabled input")
                .tag(is("input"));
        formDisabled.textField.label()
                .is()
                .displayed()
                .enabled()
                .core()
                .text(is("Disabled input"));
        formDisabled.selector
                .is()
                .selected("Disabled select")
                .displayed()
                .disabled()
                .core()
                .hasClass("form-control");
        formDisabled.selector.label()
                .is()
                .displayed()
                .enabled()
                .core()
                .text(is("Disabled select menu"));
        formDisabled.checkbox
                .is()
                .displayed()
                .disabled()
                .deselected()
                .core()
                .hasClass("form-check-input")
                .attr("type", "checkbox")
                .tag(is("input"));
        formDisabled.checkbox.label()
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("form-check-label")
                .text(is("Can't check this"));
        formDisabled.submit
                .is()
                .disabled()
                .displayed()
                .core()
                .value("Submit")
                .hasClass("btn btn-primary")
                .attr("type", "submit");
    }
}
