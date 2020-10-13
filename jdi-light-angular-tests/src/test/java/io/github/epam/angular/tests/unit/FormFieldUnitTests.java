package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.FormFieldsSection.*;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;

public class FormFieldUnitTests extends TestsInit {
    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void getInputsTest() {
        assertEquals(simpleFormFieldInput.getInputs().size(), 1);
        assertEquals(formFieldWithLabelInputSimplePlaceholder.getInputs().size(), 2);
        assertEquals(formFieldEmailInput.getInputs().size(), 1);
        assertEquals(formFieldExampleContainerInputLimited.getInputs().size(), 1);
    }

    @Test
    public void getTextAreasTest() {
        assertEquals(simpleFormFieldInput.getTextAreas().size(), 1);
    }

    @Test
    public void getDropdownsTest() {
        assertEquals(simpleFormFieldInput.getDropdowns().size(), 1);
        assertEquals(formFieldWithLabelInputSimplePlaceholder.getDropdowns().size(), 1);
        assertEquals(formFieldExampleContainerInputLimited.getDropdowns().size(), 1);
    }

    @Test
    public void setInputsTest() {
        simpleFormFieldInput.input(1, "Fancy test input");
        assertEquals(simpleFormFieldInput.inputText(1), "Fancy test input");
        simpleFormFieldInput.clearInput(1);
        assertEquals(simpleFormFieldInput.inputText(1), "");
    }

    @Test
    public void setTextAreaTest() {
        simpleFormFieldInput.setTextArea(1, "Fancy text area value");
        assertEquals(simpleFormFieldInput.textAreaText(1), "Fancy text area value");
        simpleFormFieldInput.clearTextArea(1);
        assertEquals(simpleFormFieldInput.textAreaText(1), "");
    }

    @Test
    public void setDropdownTest() {
        modifiedLayoutFormFieldColor.select(1, "Warn");
        assertEquals(modifiedLayoutFormFieldColor.getDropdownValue(1), "Warn");
    }

    @Test
    public void setValuesTest() {
        simpleFormFieldInput.set(1, "Fancy input value");
        assertEquals(simpleFormFieldInput.value(1), "Fancy input value");
        simpleFormFieldInput.set(2, "Option");
        assertEquals(simpleFormFieldInput.value(2), "Option");
        simpleFormFieldInput.set(3, "Fancy text area value");
        assertEquals(simpleFormFieldInput.value(3), "Fancy text area value");
    }

    @Test
    public void getPlaceHolderValueTest() {
        assertEquals(formFieldWithLabelInputSimplePlaceholder.placeholder(1), "Simple placeholder");
        assertEquals(formFieldWithLabelInputSimplePlaceholder.placeholder(2), "Simple placeholder");
    }

    @Test
    public void errorInputTest() {
        formFieldEmailInput.input(1, "test@");
        formFieldEmailInput.focusOut();
        assertEquals(formFieldEmailInput.error(1), "Not a valid email");
    }
}
