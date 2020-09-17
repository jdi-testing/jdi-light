package io.github.epam.angular.tests.elements.complex;

import io.github.epam.*;
import org.testng.annotations.*;

import static io.github.com.StaticSite.*;
import static io.github.com.pages.AngularPage.*;
import static io.github.epam.site.steps.States.*;
import static org.hamcrest.Matchers.*;

public class FormFieldTests extends TestsInit {
    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void simpleFormFieldTest() {
        formFieldsSection.simpleFormFieldInput.show();
        formFieldsSection.simpleFormFieldInput.has().inputLabel(1, "Input");
        formFieldsSection.simpleFormFieldInput.has().textAreaLabel(1, "Textarea");
        formFieldsSection.simpleFormFieldInput.has().dropdownLabel(1, "Select");
        formFieldsSection.simpleFormFieldInput.set(1, "Test input value");
        formFieldsSection.simpleFormFieldInput.has().value(1, "Test input value");
        formFieldsSection.simpleFormFieldInput.set(2, "Option");
        formFieldsSection.simpleFormFieldInput.has().value(2, "Option");
        formFieldsSection.simpleFormFieldInput.set(3, "Test text area value");
        formFieldsSection.simpleFormFieldInput.has().value(3, "Test text area value");
        formFieldsSection.simpleFormFieldInput.input(1, "Input value");
        formFieldsSection.simpleFormFieldInput.has().inputText(1, "Input value");
        formFieldsSection.simpleFormFieldInput.has().inputText(1, containsString("Input"));
        formFieldsSection.simpleFormFieldInput.select(1, "Option");
        formFieldsSection.simpleFormFieldInput.has().dropdownText(1, "Option");
        formFieldsSection.simpleFormFieldInput.has().dropdownText(1, containsString("tion"));
        formFieldsSection.simpleFormFieldInput.setTextArea(1, "Text area value");
        formFieldsSection.simpleFormFieldInput.has().textAreaText(1, "Text area value");
        formFieldsSection.simpleFormFieldInput.has().textAreaText(1, containsString(" area v"));
        formFieldsSection.simpleFormFieldInput.clearTextArea(1);
        formFieldsSection.simpleFormFieldInput.has().textAreaText(1, "");
        formFieldsSection.simpleFormFieldInput.set(3, "Another text area value");
        formFieldsSection.simpleFormFieldInput.has().value(3, "Another text area value");
        formFieldsSection.simpleFormFieldInput.clear(1);
        formFieldsSection.simpleFormFieldInput.has().value(1, "");
        formFieldsSection.simpleFormFieldInput.clear(3);
        formFieldsSection.simpleFormFieldInput.has().value(3, "");
    }

    @Test
    public void formFieldWithLabelTest() {
        formFieldsSection.formFieldWithLabelInputSimplePlaceholder.show();
        formFieldsSection.formFieldWithLabelInputSimplePlaceholder.
            has().inputPlaceholder(1, "Simple placeholder");
        formFieldsSection.formFieldWithLabelInputSimplePlaceholder.
            has().inputPlaceholder(2, "Simple placeholder");
        formFieldsSection.formFieldWithLabelInputSimplePlaceholder.
            has().placeholder(1, "Simple placeholder");
        formFieldsSection.formFieldWithLabelInputSimplePlaceholder.
            has().placeholder(2, "Simple placeholder");
        formFieldsSection.formFieldWithLabelInputSimplePlaceholder.
            has().label(2, "Both a label and a placeholder");
        formFieldsSection.formFieldWithLabelInputSimplePlaceholder.
            has().label(3, "favorite Fancy label");
        formFieldsSection.formFieldWithLabelInputSimplePlaceholder.input(1, "First input value");
        formFieldsSection.formFieldWithLabelInputSimplePlaceholder.
            has().value(1, containsString("t input v"));
        formFieldsSection.formFieldWithLabelInputSimplePlaceholder.input(2, "Second input value");
        formFieldsSection.formFieldWithLabelInputSimplePlaceholder.select(1, "Option");
        formFieldsSection.formFieldWithLabelInputSimplePlaceholder.
            has().value(2, "Second input value");
        formFieldsSection.formFieldWithLabelInputSimplePlaceholder.
            has().value(3, "Option");
    }

    @Test
    public void formFieldAppearanceVariantsTest() {
        formFieldsSection.formFieldAppearanceInputLegacy.show();
        formFieldsSection.formFieldAppearanceInputLegacy.input(1, "Input 1 value");
        formFieldsSection.formFieldAppearanceInputLegacy.has().value(1, "Input 1 value");
        formFieldsSection.formFieldAppearanceInputLegacy.has().fieldIcon(1, "sentiment_very_satisfied");
    }

    @Test
    public void formFieldWithErrorMessageTest() {
        formFieldsSection.formFieldEmailInput.show();
        formFieldsSection.formFieldEmailInput.input(1, "test@");
        formFieldsSection.formFieldEmailInput.focusOut();
        formFieldsSection.formFieldEmailInput.has().inputError(1, "Not a valid email");
        formFieldsSection.formFieldEmailInput.clearInput(1);
        formFieldsSection.formFieldEmailInput.has().inputError(1, "You must enter a value");
        formFieldsSection.formFieldEmailInput.has().error(1, "You must enter a value");
        formFieldsSection.formFieldEmailInput.set(1, "test@test.com");
        formFieldsSection.formFieldEmailInput.has().value(1, "test@test.com");
        formFieldsSection.formFieldEmailInput.clear(1);
        formFieldsSection.formFieldEmailInput.has().inputError(1, "You must enter a value");
    }

    @Test
    public void formFieldsWithHintsTest() {
        formFieldsSection.formFieldExampleContainerInputLimited.show();
        formFieldsSection.formFieldExampleContainerInputLimited.has().hint(1, "0/10");
        formFieldsSection.formFieldExampleContainerInputLimited.has().hint(2, "Here's the dropdown arrow ^");
        formFieldsSection.formFieldExampleContainerInputLimited.set(1, "12345678901");
        formFieldsSection.formFieldExampleContainerInputLimited.has().hint(1, "10/10");
        formFieldsSection.formFieldExampleContainerInputLimited.has().inputHint(1, "10/10");
        formFieldsSection.formFieldExampleContainerInputLimited.has().value(1, "1234567890");
    }

    @Test
    public void formFieldsPrefixSuffixTest() {
        formFieldsSection.prefixSuffixFormFieldPassword.show();
        formFieldsSection.prefixSuffixFormFieldPassword.input(1, "Password");
        formFieldsSection.prefixSuffixFormFieldPassword.clickIcon(1);
        formFieldsSection.prefixSuffixFormFieldPassword.has().value(1, "Password");
        formFieldsSection.prefixSuffixFormFieldPassword.set(1, "AnotherPassword");
        formFieldsSection.prefixSuffixFormFieldPassword.has().value(1, "AnotherPassword");
        formFieldsSection.prefixSuffixFormFieldPassword.clickIcon(1);
        formFieldsSection.prefixSuffixFormFieldPassword.has().value(1, "AnotherPassword");
    }

    @Test
    public void formFieldsThemesTest() {
        formFieldsSection.modifiedLayoutFormFieldColor.show();
        formFieldsSection.modifiedLayoutFormFieldColor.set(1, "Accent");
        formFieldsSection.modifiedLayoutFormFieldColor.has().color(1, "rgba(0, 0, 0, 0.87)");
        formFieldsSection.modifiedLayoutFormFieldColor.set(2, "20");
        formFieldsSection.modifiedLayoutFormFieldColor.has().font(2, containsString("20px"));
    }
}
