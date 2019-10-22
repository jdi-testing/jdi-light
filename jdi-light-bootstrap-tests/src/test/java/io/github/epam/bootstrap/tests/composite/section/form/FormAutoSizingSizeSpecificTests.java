package io.github.epam.bootstrap.tests.composite.section.form;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.Alerts.validateAlert;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.formAutoSizingSizeSpecific;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;

public class FormAutoSizingSizeSpecificTests extends TestsInit {
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
        baseValidation(formAutoSizingSizeSpecific.name);
        baseValidation(formAutoSizingSizeSpecific.email);
        baseValidation(formAutoSizingSizeSpecific.rememberMeCheckbox);
        baseValidation(formAutoSizingSizeSpecific.submit);
    }

    @Test
    public void isValidationTests() {
        formAutoSizingSizeSpecific.name
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("form-control")
                .attr("type", "text")
                .attr("placeholder", placeholderNameText)
                .tag(is("input"))
                .text("");
        formAutoSizingSizeSpecific.name.label()
                .is()
                .displayed()
                .enabled()
                .core()
                .value(labelNameText);
        formAutoSizingSizeSpecific.atSign
                .is()
                .enabled()
                .core()
                .hasClass("input-group-text")
                .text("@");
        formAutoSizingSizeSpecific.email
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("form-control")
                .attr("type", "text")
                .attr("placeholder", placeholderEmailText)
                .tag(is("input"))
                .text("");
        formAutoSizingSizeSpecific.email.label()
                .is()
                .displayed()
                .enabled()
                .core()
                .value(labelEmailText);
        formAutoSizingSizeSpecific.rememberMeCheckbox
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("form-check-input")
                .attr("type", "checkbox")
                .tag(is("input"))
                .deselected();
        formAutoSizingSizeSpecific.rememberMeCheckbox.label()
                .is()
                .displayed()
                .enabled()
                .core()
                .value(labelCheckboxText);
    }

    @Test(dataProvider = "optionFormAutoSizingTest")
    public void fillingNameAndEmailWithDataProviderTest(String name, String email, String checkboxState) {
        formAutoSizingSizeSpecific.name
                .sendKeys(name);
        formAutoSizingSizeSpecific.email
                .sendKeys(email);
        formAutoSizingSizeSpecific.rememberMeCheckbox
                .setValue(checkboxState);
        formAutoSizingSizeSpecific.submit.click();
        validateAlerts();
        formAutoSizingSizeSpecific.name
                .is()
                .text(name);
        formAutoSizingSizeSpecific.email
                .is()
                .text(email);
        formAutoSizingSizeSpecific.rememberMeCheckbox
                .check(checkboxState);
    }

    @Test
    public void separateElementFillingNameTest() {
        formAutoSizingSizeSpecific.name
                .sendKeys("Veronika");
        formAutoSizingSizeSpecific.submit.click();
        validateAlerts();
        formAutoSizingSizeSpecific.name
                .is()
                .text("Veronika");
    }

    @Test
    public void separateElementFillingEmailTest() {
        formAutoSizingSizeSpecific.email
                .sendKeys("gmail.com");
        formAutoSizingSizeSpecific.submit.click();
        validateAlerts();
        formAutoSizingSizeSpecific.email
                .is()
                .text("gmail.com");
    }

    @Test
    public void separateElementCheckboxTest() {
        formAutoSizingSizeSpecific.rememberMeCheckbox
                .check();
        formAutoSizingSizeSpecific.submit.click();
        validateAlerts();
        formAutoSizingSizeSpecific.rememberMeCheckbox
                .isSelected();
    }

    private void validateAlerts() {
        validateAlert(is("Submit button clicked."));
    }
}
