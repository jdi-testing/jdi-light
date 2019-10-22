package io.github.epam.bootstrap.tests.composite.section.form;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.Alerts.validateAlert;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.formAutoSizingWithCustomControls;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;

public class FormAutoSizingWithCustomControls extends TestsInit {

    private String checkboxText="Remember my preference";

    @DataProvider
    public Object[][] selectorValuesFormAutoSizingTest() {
        return new Object[][]{
                {1, "Choose...",""},
                {2, "One","1"},
                {3, "Two","2"},
                {4, "Three", "3"},
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
        baseValidation(formAutoSizingWithCustomControls.checkbox);
        baseValidation(formAutoSizingWithCustomControls.selector);
    }

    @Test
    public void isValidationTests() {
        formAutoSizingWithCustomControls.checkbox
                .is()
                .disappear()
                .enabled()
                .core()
                .attr("type", "checkbox")
                .hasClass("custom-control-input")
                .tag(is("input"));
        formAutoSizingWithCustomControls.checkbox.label()
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("custom-control-label")
                .text(is(checkboxText))
                .tag(is("label"));
        formAutoSizingWithCustomControls.checkboxContainer
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("custom-control custom-checkbox mr-sm-2")
                .tag(is("div"));
    }

    @Test
    public void separateElementsCheckboxTests() {
        formAutoSizingWithCustomControls.checkboxContainer.check();
        formAutoSizingWithCustomControls.submit.click();
        formAutoSizingWithCustomControls.checkbox.is().selected();
        validateAlerts();
        formAutoSizingWithCustomControls.checkboxContainer.check();
        formAutoSizingWithCustomControls.submit.click();
        formAutoSizingWithCustomControls.checkbox.is().deselected();
        validateAlerts();
        formAutoSizingWithCustomControls.checkbox.label().click();
        formAutoSizingWithCustomControls.submit.click();
        formAutoSizingWithCustomControls.checkbox.is().selected();
        validateAlerts();
        formAutoSizingWithCustomControls.checkbox.label().click();
        formAutoSizingWithCustomControls.submit.click();
        formAutoSizingWithCustomControls.checkbox.is().deselected();
        validateAlerts();
    }

    @Test(dataProvider = "selectorValuesFormAutoSizingTest")
    public void separateElementsCheckboxTests(int i,String optionText,String attrValue) {
        formAutoSizingWithCustomControls.selector.select(i);
        formAutoSizingWithCustomControls.selector.selected().equals(optionText);
        formAutoSizingWithCustomControls.selector.selected().toCharArray();

        formAutoSizingWithCustomControls.submit.click();
        formAutoSizingWithCustomControls.checkbox.is().selected();
        validateAlerts();
        formAutoSizingWithCustomControls.checkboxContainer.check();
        formAutoSizingWithCustomControls.submit.click();
        formAutoSizingWithCustomControls.checkbox.is().deselected();
        validateAlerts();
        formAutoSizingWithCustomControls.checkbox.label().click();
        formAutoSizingWithCustomControls.submit.click();
        formAutoSizingWithCustomControls.checkbox.is().selected();
        validateAlerts();
        formAutoSizingWithCustomControls.checkbox.label().click();
        formAutoSizingWithCustomControls.submit.click();
        formAutoSizingWithCustomControls.checkbox.is().deselected();
        validateAlerts();
    }

    private void validateAlerts() {
        validateAlert(is("Submit button clicked."));
    }
}
