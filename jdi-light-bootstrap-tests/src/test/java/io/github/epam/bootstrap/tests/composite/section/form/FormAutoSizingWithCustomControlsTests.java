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
import static org.testng.Assert.assertEquals;

public class FormAutoSizingWithCustomControlsTests extends TestsInit {

    private String checkboxText = "Remember my preference";
    private String defaultSelectMenuText = "Choose...";
    private String colCustomControlParameter = "col-auto my-1";

    @DataProvider
    public Object[][] selectMenuValuesFormAutoSizingTest() {
        return new Object[][]{
                {1, "Choose...", "Choose..."},
                {2, "One", "1"},
                {3, "Two", "2"},
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
        baseValidation(formAutoSizingWithCustomControls.selectMenu);
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
        formAutoSizingWithCustomControls.colParameterCheckbox
                .is()
                .core()
                .hasClass(colCustomControlParameter);
        formAutoSizingWithCustomControls.selectMenu
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("custom-select mr-sm-2")
                .tag(is("select"));
        formAutoSizingWithCustomControls.selectMenu.selectedOptionsSelectMenu
                .is()
                .text(defaultSelectMenuText);
        formAutoSizingWithCustomControls.colParameterSelectMenu
                .is()
                .core()
                .hasClass(colCustomControlParameter);
        formAutoSizingWithCustomControls.colParameterButton
                .is()
                .core()
                .hasClass(colCustomControlParameter);
    }

    @Test
    public void separateElementsCheckboxTests() {
        formAutoSizingWithCustomControls.checkboxContainer.check();
        formAutoSizingWithCustomControls.checkbox.is().selected();
        formAutoSizingWithCustomControls.submit.click();
        validateAlerts();
        formAutoSizingWithCustomControls.checkboxContainer.check();
        formAutoSizingWithCustomControls.checkbox.is().deselected();
        formAutoSizingWithCustomControls.submit.click();
        validateAlerts();
        formAutoSizingWithCustomControls.checkbox.label().click();
        formAutoSizingWithCustomControls.checkbox.is().selected();
        formAutoSizingWithCustomControls.submit.click();
        validateAlerts();
        formAutoSizingWithCustomControls.checkbox.label().click();
        formAutoSizingWithCustomControls.checkbox.is().deselected();
        formAutoSizingWithCustomControls.submit.click();
        validateAlerts();
    }

    @Test(dataProvider = "selectMenuValuesFormAutoSizingTest")
    public void separateElementsSelectMenuTestsWithDataProvider(int i, String optionText, String attrValue) {
        formAutoSizingWithCustomControls.selectMenu.optionsSelectMenu.get(i).is().text(optionText);
        formAutoSizingWithCustomControls.selectMenu.optionsSelectMenu.get(i).assertThat().attr("value", attrValue);
    }

    @Test
    public void separateElementsSelectMenuClickTest() {
        formAutoSizingWithCustomControls.selectMenu.optionsSelectMenu.get(1).click();
        assertEquals(formAutoSizingWithCustomControls.selectMenu.getValue(), "Choose...");
        formAutoSizingWithCustomControls.submit.click();
        validateAlerts();

        formAutoSizingWithCustomControls.selectMenu.optionsSelectMenu.get(2).click();
        assertEquals(formAutoSizingWithCustomControls.selectMenu.getValue(), "One");
        formAutoSizingWithCustomControls.submit.click();
        validateAlerts();

        formAutoSizingWithCustomControls.selectMenu.optionsSelectMenu.get(3).click();
        assertEquals(formAutoSizingWithCustomControls.selectMenu.getValue(), "Two");
        formAutoSizingWithCustomControls.submit.click();
        validateAlerts();

        formAutoSizingWithCustomControls.selectMenu.optionsSelectMenu.get(4).click();
        assertEquals(formAutoSizingWithCustomControls.selectMenu.getValue(), "Three");
        formAutoSizingWithCustomControls.submit.click();
        validateAlerts();
    }

    private void validateAlerts() {
        validateAlert(is("Submit button clicked."));
    }
}
