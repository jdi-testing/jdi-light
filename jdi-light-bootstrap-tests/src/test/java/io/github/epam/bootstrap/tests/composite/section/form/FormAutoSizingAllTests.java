package io.github.epam.bootstrap.tests.composite.section.form;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.Alerts.validateAlert;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.formAutoSizingAll;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;

public class FormAutoSizingAllTests extends TestsInit {
    private String email = "delnot@gmail.com";
    private String placeholderText = "Jane Doe";
    private String radio = "option2";
    private String accept = "true";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void isValidationTests() {
        formAutoSizingAll.name
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("form-control mb-2")
                .attr("type", "text")
                .attr("placeholder", placeholderText)
                .tag(is("input"));
        formAutoSizingAll.name.label()
                .is()
                .displayed()
                .enabled()
                .core()
                .value("Name");
        formAutoSizingAll.email
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("form-control")
                .attr("type", "text")
                .attr("placeholder", "Username")
                .tag(is("input"));
        formAutoSizingAll.email.label()
                .is()
                .displayed()
                .enabled()
                .core()
                .value("Username");
        formAutoSizingAll.rememberMeCheckbox
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("form-check-input")
                .attr("type", "checkbox")
                .tag(is("input"));
        formAutoSizingAll.rememberMeCheckbox.label()
                .is()
                .displayed()
                .enabled()
                .core()
                .value("Remember me");
    }

    @Test
    public void fillingFormTest() {
        formAutoSizingAll.name
                .sendKeys("Veronika");
        formAutoSizingAll.email
                .sendKeys("ver.revjakina");
        formAutoSizingAll.rememberMeCheckbox
                .check();

        formAutoSizingAll.name
                .is()
                .text("Veronika");
        formAutoSizingAll.email
                .is()
                .text("ver.revjakina");
        formAutoSizingAll.rememberMeCheckbox
                .isSelected();
        formAutoSizingAll.submit.click();
        //validateAlerts();

    }


    private void validateAlerts() {
        validateAlert(is("Submit button clicked."));
        validateAlert(is("Form submitted successfully"));
    }
}
