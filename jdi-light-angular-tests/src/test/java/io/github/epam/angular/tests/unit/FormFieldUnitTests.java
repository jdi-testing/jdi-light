package io.github.epam.angular.tests.unit;

import io.github.epam.*;
import org.testng.annotations.*;

import static io.github.com.StaticSite.*;
import static io.github.com.pages.AngularPage.*;
import static io.github.epam.site.steps.States.*;
import static org.testng.Assert.*;

public class FormFieldUnitTests extends TestsInit {
    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void getInputsTest() {
        assertEquals(formFieldsSection.simpleFormField.getInputs().size(), 1);
        assertEquals(formFieldsSection.formFieldWithLabel.getInputs().size(), 2);
        assertEquals(formFieldsSection.formFieldValidation.getInputs().size(), 1);
        assertEquals(formFieldsSection.formFieldHints.getInputs().size(), 1);
    }

    @Test
    public void getTextAreasTest() {
        assertEquals(formFieldsSection.simpleFormField.getTextAreas().size(), 1);
    }

    @Test
    public void getDropdownsTest() {
        assertEquals(formFieldsSection.simpleFormField.getDropdowns().size(), 1);
        assertEquals(formFieldsSection.formFieldWithLabel.getDropdowns().size(), 1);
        assertEquals(formFieldsSection.formFieldHints.getDropdowns().size(), 1);
    }

    @Test
    public void setInputsTest() {
        formFieldsSection.simpleFormField.input(1, "Fancy test input");
        assertEquals(formFieldsSection.simpleFormField.inputText(1), "Fancy test input");
        formFieldsSection.simpleFormField.clearInput(1);
        assertEquals(formFieldsSection.simpleFormField.inputText(1), "");
    }

    @Test
    public void setTextAreaTest() {
        formFieldsSection.simpleFormField.setTextArea(1, "Fancy text area value");
        assertEquals(formFieldsSection.simpleFormField.textAreaText(1), "Fancy text area value");
        formFieldsSection.simpleFormField.clearTextArea(1);
        assertEquals(formFieldsSection.simpleFormField.textAreaText(1), "");
    }

    @Test
    public void setDropdownTest() {
        formFieldsSection.formFieldThemes.select(1, "Warn");
        assertEquals(formFieldsSection.formFieldThemes.getDropdownValue(1), "Warn");
    }

    @Test
    public void setValuesTest() {
        formFieldsSection.simpleFormField.set(1, "Fancy input value");
        assertEquals(formFieldsSection.simpleFormField.value(1), "Fancy input value");
        formFieldsSection.simpleFormField.set(2, "Option");
        assertEquals(formFieldsSection.simpleFormField.value(2), "Option");
        formFieldsSection.simpleFormField.set(3, "Fancy text area value");
        assertEquals(formFieldsSection.simpleFormField.value(3), "Fancy text area value");
    }

    @Test
    public void getPlaceHolderValueTest() {
        assertEquals(formFieldsSection.formFieldWithLabel.placeholder(1), "Simple placeholder");
        assertEquals(formFieldsSection.formFieldWithLabel.placeholder(2), "Simple placeholder");
    }

    @Test
    public void errorInputTest() {
        formFieldsSection.formFieldValidation.input(1, "test@");
        formFieldsSection.formFieldValidation.focusOut();
        assertEquals(formFieldsSection.formFieldValidation.error(1), "Not a valid email");
    }
}
