package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.FormFieldsSection.*;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;

public class FormFieldTests extends TestsInit {
    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void simpleFormFieldTest() {
        simpleFormFieldInput.show();
        simpleFormFieldInput.has().inputLabel(1, "Input");
        simpleFormFieldInput.has().textAreaLabel(1, "Textarea");
        simpleFormFieldInput.has().dropdownLabel(1, "Select");
        simpleFormFieldInput.set(1, "Test input value");
        simpleFormFieldInput.has().value(1, "Test input value");
        simpleFormFieldInput.set(2, "Option");
        simpleFormFieldInput.has().value(2, "Option");
        simpleFormFieldInput.set(3, "Test text area value");
        simpleFormFieldInput.has().value(3, "Test text area value");
        simpleFormFieldInput.input(1, "Input value");
        simpleFormFieldInput.has().inputText(1, "Input value");
        simpleFormFieldInput.has().inputText(1, containsString("Input"));
        simpleFormFieldInput.select(1, "Option");
        simpleFormFieldInput.has().dropdownText(1, "Option");
        simpleFormFieldInput.has().dropdownText(1, containsString("tion"));
        simpleFormFieldInput.setTextArea(1, "Text area value");
        simpleFormFieldInput.has().textAreaText(1, "Text area value");
        simpleFormFieldInput.has().textAreaText(1, containsString(" area v"));
        simpleFormFieldInput.clearTextArea(1);
        simpleFormFieldInput.has().textAreaText(1, "");
        simpleFormFieldInput.set(3, "Another text area value");
        simpleFormFieldInput.has().value(3, "Another text area value");
        simpleFormFieldInput.clear(1);
        simpleFormFieldInput.has().value(1, "");
        simpleFormFieldInput.clear(3);
        simpleFormFieldInput.has().value(3, "");
    }

    @Test
    public void formFieldWithLabelTest() {
        formFieldWithLabelInputSimplePlaceholder.show();
        formFieldWithLabelInputSimplePlaceholder.
            has().inputPlaceholder(1, "Simple placeholder");
        formFieldWithLabelInputSimplePlaceholder.
            has().inputPlaceholder(2, "Simple placeholder");
        formFieldWithLabelInputSimplePlaceholder.
            has().placeholder(1, "Simple placeholder");
        formFieldWithLabelInputSimplePlaceholder.
            has().placeholder(2, "Simple placeholder");
        formFieldWithLabelInputSimplePlaceholder.
            has().label(2, "Both a label and a placeholder");
        formFieldWithLabelInputSimplePlaceholder.
            has().label(3, "favorite Fancy label");
        formFieldWithLabelInputSimplePlaceholder.input(1, "First input value");
        formFieldWithLabelInputSimplePlaceholder.
            has().value(1, containsString("t input v"));
        formFieldWithLabelInputSimplePlaceholder.input(2, "Second input value");
        formFieldWithLabelInputSimplePlaceholder.select(1, "Option");
        formFieldWithLabelInputSimplePlaceholder.
            has().value(2, "Second input value");
        formFieldWithLabelInputSimplePlaceholder.
            has().value(3, "Option");
    }

    @Test
    public void formFieldAppearanceVariantsTest() {
        formFieldAppearanceInputLegacy.show();
        formFieldAppearanceInputLegacy.input(1, "Input 1 value");
        formFieldAppearanceInputLegacy.has().value(1, "Input 1 value");
        formFieldAppearanceInputLegacy.has().fieldIcon(1, "sentiment_very_satisfied");
    }

    @Test
    public void formFieldWithErrorMessageTest() {
        formFieldEmailInput.show();
        formFieldEmailInput.input(1, "test@");
        formFieldEmailInput.focusOut();
        formFieldEmailInput.has().inputError(1, "Not a valid email");
        formFieldEmailInput.clearInput(1);
        formFieldEmailInput.has().inputError(1, "You must enter a value");
        formFieldEmailInput.has().error(1, "You must enter a value");
        formFieldEmailInput.set(1, "test@test.com");
        formFieldEmailInput.has().value(1, "test@test.com");
        formFieldEmailInput.clear(1);
        formFieldEmailInput.has().inputError(1, "You must enter a value");
    }

    @Test
    public void formFieldsWithHintsTest() {
        formFieldExampleContainerInputLimited.show();
        formFieldExampleContainerInputLimited.has().hint(1, "0/10");
        formFieldExampleContainerInputLimited.has().hint(2, "Here's the dropdown arrow ^");
        formFieldExampleContainerInputLimited.set(1, "12345678901");
        formFieldExampleContainerInputLimited.has().hint(1, "10/10");
        formFieldExampleContainerInputLimited.has().inputHint(1, "10/10");
        formFieldExampleContainerInputLimited.has().value(1, "1234567890");
    }

    @Test
    public void formFieldsPrefixSuffixTest() {
        prefixSuffixFormFieldPassword.show();
        prefixSuffixFormFieldPassword.input(1, "Password");
        prefixSuffixFormFieldPassword.clickIcon(1);
        prefixSuffixFormFieldPassword.has().value(1, "Password");
        prefixSuffixFormFieldPassword.set(1, "AnotherPassword");
        prefixSuffixFormFieldPassword.has().value(1, "AnotherPassword");
        prefixSuffixFormFieldPassword.clickIcon(1);
        prefixSuffixFormFieldPassword.has().value(1, "AnotherPassword");
    }

    @Test
    public void formFieldsThemesTest() {
        modifiedLayoutFormFieldColor.show();
        modifiedLayoutFormFieldColor.set(1, "Accent");
        modifiedLayoutFormFieldColor.has().color(1, "rgba(0, 0, 0, 0.87)");
        modifiedLayoutFormFieldColor.set(2, "20");
        modifiedLayoutFormFieldColor.has().font(2, containsString("20px"));
    }
}
