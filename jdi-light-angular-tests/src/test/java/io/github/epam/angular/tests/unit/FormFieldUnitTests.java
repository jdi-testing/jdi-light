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
        assertEquals(formFieldsSection.simpleFormFieldInput.getInputs().size(), 1);
        assertEquals(formFieldsSection.formFieldWithLabelInputSimplePlaceholder.getInputs().size(), 2);
        assertEquals(formFieldsSection.formFieldEmailInput.getInputs().size(), 1);
        assertEquals(formFieldsSection.formFieldExampleContainerInputLimited.getInputs().size(), 1);
    }

    @Test
    public void getTextAreasTest() {
        assertEquals(formFieldsSection.simpleFormFieldInput.getTextAreas().size(), 1);
    }

    @Test
    public void getDropdownsTest() {
        assertEquals(formFieldsSection.simpleFormFieldInput.getDropdowns().size(), 1);
        assertEquals(formFieldsSection.formFieldWithLabelInputSimplePlaceholder.getDropdowns().size(), 1);
        assertEquals(formFieldsSection.formFieldExampleContainerInputLimited.getDropdowns().size(), 1);
    }

    @Test
    public void setInputsTest() {
        formFieldsSection.simpleFormFieldInput.input(1, "Fancy test input");
        assertEquals(formFieldsSection.simpleFormFieldInput.inputText(1), "Fancy test input");
        formFieldsSection.simpleFormFieldInput.clearInput(1);
        assertEquals(formFieldsSection.simpleFormFieldInput.inputText(1), "");
    }

    @Test
    public void setTextAreaTest() {
        formFieldsSection.simpleFormFieldInput.setTextArea(1, "Fancy text area value");
        assertEquals(formFieldsSection.simpleFormFieldInput.textAreaText(1), "Fancy text area value");
        formFieldsSection.simpleFormFieldInput.clearTextArea(1);
        assertEquals(formFieldsSection.simpleFormFieldInput.textAreaText(1), "");
    }

    @Test
    public void setDropdownTest() {
        formFieldsSection.modifiedLayoutFormFieldColor.select(1, "Warn");
        assertEquals(formFieldsSection.modifiedLayoutFormFieldColor.getDropdownValue(1), "Warn");
    }

    @Test
    public void setValuesTest() {
        formFieldsSection.simpleFormFieldInput.set(1, "Fancy input value");
        assertEquals(formFieldsSection.simpleFormFieldInput.value(1), "Fancy input value");
        formFieldsSection.simpleFormFieldInput.set(2, "Option");
        assertEquals(formFieldsSection.simpleFormFieldInput.value(2), "Option");
        formFieldsSection.simpleFormFieldInput.set(3, "Fancy text area value");
        assertEquals(formFieldsSection.simpleFormFieldInput.value(3), "Fancy text area value");
    }

    @Test
    public void getPlaceHolderValueTest() {
        assertEquals(formFieldsSection.formFieldWithLabelInputSimplePlaceholder.placeholder(1), "Simple placeholder");
        assertEquals(formFieldsSection.formFieldWithLabelInputSimplePlaceholder.placeholder(2), "Simple placeholder");
    }

    @Test
    public void errorInputTest() {
        formFieldsSection.formFieldEmailInput.input(1, "test@");
        formFieldsSection.formFieldEmailInput.focusOut();
        assertEquals(formFieldsSection.formFieldEmailInput.error(1), "Not a valid email");
    }
}
