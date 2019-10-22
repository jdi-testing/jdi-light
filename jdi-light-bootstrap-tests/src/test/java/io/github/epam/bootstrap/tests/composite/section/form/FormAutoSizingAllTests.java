package io.github.epam.bootstrap.tests.composite.section.form;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.Alerts.validateAlert;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.formAutoSizingAll;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;

public class FormAutoSizingAllTests extends TestsInit {

    private String placeholderNameText = "Jane Doe";
    private String placeholderEmailText = "Username";
    private String labelNameText = "Name";
    private String labelEmailText = "Username";
    private String labelCheckboxText = "Remember me";

    @DataProvider
    public Object[][] optionFormAutoSizingTest() {
        return new Object[][]{
                {"Veronika", "gmail.com", "true"},
                {"Ivan", "mail.ru", "false"},
                {"Fedor", "epam.com", "true"}
        };
    }

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        bsPage.refresh();
    }

    @Test
    public void baseValidationTest() {
        baseValidation(formAutoSizingAll.name);
        baseValidation(formAutoSizingAll.email);
        baseValidation(formAutoSizingAll.rememberMeCheckbox);
        baseValidation(formAutoSizingAll.submit);
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
                .attr("placeholder", placeholderNameText)
                .tag(is("input"))
                .text("");
        formAutoSizingAll.name.label()
                .is()
                .displayed()
                .enabled()
                .core()
                .value(labelNameText);
        formAutoSizingAll.atSign
                .is()
                .enabled()
                .core()
                .hasClass("input-group-text")
                .text("@");
        formAutoSizingAll.colParameter
                .is()
                .core()
                .hasClass("col-auto");
        formAutoSizingAll.email
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("form-control")
                .attr("type", "text")
                .attr("placeholder", placeholderEmailText)
                .tag(is("input"))
                .text("");
        formAutoSizingAll.email.label()
                .is()
                .displayed()
                .enabled()
                .core()
                .value(labelEmailText);
        formAutoSizingAll.rememberMeCheckbox
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("form-check-input")
                .attr("type", "checkbox")
                .tag(is("input"))
                .deselected();
        formAutoSizingAll.rememberMeCheckbox.label()
                .is()
                .displayed()
                .enabled()
                .core()
                .value(labelCheckboxText);
    }

    @Test(dataProvider = "optionFormAutoSizingTest")
    public void fillingNameAndEmailWithDataProviderTest(String name, String email, String checkboxState) {
        formAutoSizingAll.name
                .sendKeys(name);
        formAutoSizingAll.email
                .sendKeys(email);
        formAutoSizingAll.rememberMeCheckbox
                .setValue(checkboxState);
        formAutoSizingAll.submit.click();
        validateAlerts();
        formAutoSizingAll.name
                .is()
                .text(name);
        formAutoSizingAll.email
                .is()
                .text(email);
        formAutoSizingAll.rememberMeCheckbox
                .check(checkboxState);
    }

    @Test
    public void separateElementFillingNameTest() {
        formAutoSizingAll.name
                .sendKeys("Veronika");
        formAutoSizingAll.submit.click();
        validateAlerts();
        formAutoSizingAll.name
                .is()
                .text("Veronika");
    }

    @Test
    public void separateElementFillingEmailTest() {
        formAutoSizingAll.email
                .sendKeys("gmail.com");
        formAutoSizingAll.submit.click();
        validateAlerts();
        formAutoSizingAll.email
                .is()
                .text("gmail.com");
    }

    @Test
    public void separateElementCheckboxTest() {
        formAutoSizingAll.rememberMeCheckbox
                .check();
        formAutoSizingAll.submit.click();
        validateAlerts();
        formAutoSizingAll.rememberMeCheckbox
                .isSelected();
    }

    private void validateAlerts() {
        validateAlert(is("Submit button clicked."));
    }
}
