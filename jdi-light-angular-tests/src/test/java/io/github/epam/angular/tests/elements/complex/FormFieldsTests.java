package io.github.epam.angular.tests.elements.complex;

import io.github.epam.*;
import org.testng.annotations.*;

import static io.github.com.StaticSite.*;
import static io.github.com.pages.AngularPage.*;
import static io.github.epam.site.steps.States.*;
import static org.hamcrest.Matchers.*;

public class FormFieldsTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void simpleFormFieldTest() {
        formFieldsSection.simpleFormField.show();
        formFieldsSection.simpleFormField.has().inputLabel(1, "Input");
        formFieldsSection.simpleFormField.has().textAreaLabel(1, "Textarea");
        formFieldsSection.simpleFormField.has().dropdownLabel(1, "Select");
        formFieldsSection.simpleFormField.set(1, "Test input value");
        formFieldsSection.simpleFormField.has().value(1, "Test input value");
        formFieldsSection.simpleFormField.set(2, "Option");
        formFieldsSection.simpleFormField.has().value(2, "Option");
        formFieldsSection.simpleFormField.set(3, "Test text area value");
        formFieldsSection.simpleFormField.has().value(3, "Test text area value");
        formFieldsSection.simpleFormField.input(1, "Input value");
        formFieldsSection.simpleFormField.has().inputText(1, "Input value");
        formFieldsSection.simpleFormField.has().inputText(1, containsString("Input"));
        formFieldsSection.simpleFormField.select(1, "Option");
        formFieldsSection.simpleFormField.has().dropdownText(1, "Option");
        formFieldsSection.simpleFormField.has().dropdownText(1, containsString("tion"));
        formFieldsSection.simpleFormField.setTextArea(1, "Text area value");
        formFieldsSection.simpleFormField.has().textAreaText(1, "Text area value");
        formFieldsSection.simpleFormField.has().textAreaText(1, containsString(" area v"));
        formFieldsSection.simpleFormField.clearTextArea(1);
        formFieldsSection.simpleFormField.has().textAreaText(1, "");
        formFieldsSection.simpleFormField.set(3, "Another text area value");
        formFieldsSection.simpleFormField.has().value(3, "Another text area value");
        formFieldsSection.simpleFormField.clear(1);
        formFieldsSection.simpleFormField.has().value(1, "");
        formFieldsSection.simpleFormField.clear(3);
        formFieldsSection.simpleFormField.has().value(3, "");
    }

    @Test
    public void formFieldWithLabelTest() {
        formFieldsSection.formFieldWithLabel.show();
        formFieldsSection.formFieldWithLabel.has().inputPlaceholder(1, "Simple placeholder");
        formFieldsSection.formFieldWithLabel.has().inputPlaceholder(2, "Simple placeholder");
        formFieldsSection.formFieldWithLabel.has().placeholder(1, "Simple placeholder");
        formFieldsSection.formFieldWithLabel.has().placeholder(2, "Simple placeholder");
        formFieldsSection.formFieldWithLabel.has().label(2, "Both a label and a placeholder");
        formFieldsSection.formFieldWithLabel.has().label(3, "favorite Fancy label");
        formFieldsSection.formFieldWithLabel.input(1, "First input value");
        formFieldsSection.formFieldWithLabel.has().value(1, containsString("t input v"));
        formFieldsSection.formFieldWithLabel.input(2, "Second input value");
        formFieldsSection.formFieldWithLabel.select(1, "Option");
        formFieldsSection.formFieldWithLabel.has().value(2, "Second input value");
        formFieldsSection.formFieldWithLabel.has().value(3, "Option");
    }

    @Test
    public void formFieldAppearanceVariantsTest() {
        formFieldsSection.formFieldsVariants.show();
        formFieldsSection.formFieldsVariants.input(1, "Input 1 value");
        formFieldsSection.formFieldsVariants.has().value(1, "Input 1 value");
        formFieldsSection.formFieldsVariants.has().fieldIcon(1, "sentiment_very_satisfied");
    }

    @Test
    public void formFieldWithErrorMessageTest() {
        formFieldsSection.formFieldsValidation.show();
        formFieldsSection.formFieldsValidation.input(1, "test@");
        formFieldsSection.formFieldsValidation.focusOut();
        formFieldsSection.formFieldsValidation.has().inputError(1, "Not a valid email");
        formFieldsSection.formFieldsValidation.clearInput(1);
        formFieldsSection.formFieldsValidation.has().inputError(1, "You must enter a value");
        formFieldsSection.formFieldsValidation.set(1, "test@test.com");
        formFieldsSection.formFieldsValidation.has().value(1, "test@test.com");
        formFieldsSection.formFieldsValidation.clear(1);
        formFieldsSection.formFieldsValidation.has().inputError(1, "You must enter a value");
    }

    @Test
    public void formFieldsWithHintsTest() {
        formFieldsSection.formFieldsHints.show();
        formFieldsSection.formFieldsHints.has().hint(1, "0/10");
        formFieldsSection.formFieldsHints.has().hint(2, "Here's the dropdown arrow ^");
        formFieldsSection.formFieldsHints.set(1, "12345678901");
        formFieldsSection.formFieldsHints.has().hint(1, "10/10");
        formFieldsSection.formFieldsHints.has().inputHint(1, "10/10");
        formFieldsSection.formFieldsHints.has().value(1, "1234567890");
    }

    @Test
    public void formFieldsPrefixSuffixTest() {
        formFieldsSection.formFieldsPrefixSuffix.show();
        formFieldsSection.formFieldsPrefixSuffix.input(1, "Password");
        formFieldsSection.formFieldsPrefixSuffix.clickIcon(1);
        formFieldsSection.formFieldsPrefixSuffix.has().value(1, "Password");
        formFieldsSection.formFieldsPrefixSuffix.set(1, "AnotherPassword");
        formFieldsSection.formFieldsPrefixSuffix.has().value(1, "AnotherPassword");
        formFieldsSection.formFieldsPrefixSuffix.clickIcon(1);
        formFieldsSection.formFieldsPrefixSuffix.has().value(1, "AnotherPassword");
    }

    @Test
    public void formFieldsThemesTest() {
        formFieldsSection.formFieldsThemes.show();
        formFieldsSection.formFieldsThemes.set(1, "Accent");
        formFieldsSection.formFieldsThemes.has().color(1, "rgba(0, 0, 0, 0.87)");
        formFieldsSection.formFieldsThemes.set(2, "20");
        formFieldsSection.formFieldsThemes.has().font(2, containsString("20px"));
    }

}
