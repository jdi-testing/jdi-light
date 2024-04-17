package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.formFieldPage;
import static io.github.com.pages.FormFieldsPage.alwaysFloatLabel;
import static io.github.com.pages.FormFieldsPage.formFieldAppearanceInputLegacy;
import static io.github.com.pages.FormFieldsPage.formFieldAppearanceInputStandard;
import static io.github.com.pages.FormFieldsPage.formFieldDisabled;
import static io.github.com.pages.FormFieldsPage.formFieldEmailInput;
import static io.github.com.pages.FormFieldsPage.formFieldExampleContainerDropdown;
import static io.github.com.pages.FormFieldsPage.formFieldExampleContainerInputLimited;
import static io.github.com.pages.FormFieldsPage.formFieldSubscriptSizingDynamic;
import static io.github.com.pages.FormFieldsPage.formFieldSubscriptSizingFixed;
import static io.github.com.pages.FormFieldsPage.formFieldWithLabelInputSimplePlaceholder;
import static io.github.com.pages.FormFieldsPage.formFieldWithLabelInputSimplePlaceholderAndLabel;
import static io.github.com.pages.FormFieldsPage.formFieldWithLabelSelect;
import static io.github.com.pages.FormFieldsPage.hideRequiredMarker;
import static io.github.com.pages.FormFieldsPage.modifiedLayoutFormFieldColor;
import static io.github.com.pages.FormFieldsPage.prefixSuffixFormFieldPassword;
import static io.github.com.pages.FormFieldsPage.simpleFormFieldInput;
import static io.github.com.pages.FormFieldsPage.simpleFormFieldSelect;
import static io.github.com.pages.FormFieldsPage.simpleFormFieldTextarea;
import static org.hamcrest.Matchers.containsString;

public class FormFieldTests extends TestsInit {
    @BeforeMethod(alwaysRun = true)
    public void before() {
        formFieldPage.open();
        waitCondition((() -> formFieldPage.isOpened()));
        formFieldPage.checkOpened();
    }

    @Test
    public void simpleFormFieldTest() {
        simpleFormFieldInput.show();
        simpleFormFieldInput.has().label("Input");
        simpleFormFieldTextarea.has().label("Textarea");
        simpleFormFieldSelect.has().label("Select");
        simpleFormFieldInput.set("Test input value");
        simpleFormFieldInput.has().value("Test input value");
        simpleFormFieldInput.has().value(containsString("st inp"));
        simpleFormFieldSelect.is().empty();
        simpleFormFieldSelect.set("Option");
        simpleFormFieldSelect.has().value("Option");
        simpleFormFieldSelect.has().value(containsString("Option"));
        simpleFormFieldSelect.is().notEmpty();
        simpleFormFieldTextarea.set("Test text area value");
        simpleFormFieldTextarea.has().value("Test text area value");
        simpleFormFieldTextarea.has().value(containsString("area v"));
        simpleFormFieldInput.clear();
        simpleFormFieldInput.has().value("");
        simpleFormFieldTextarea.clear();
        simpleFormFieldTextarea.has().value("");
    }

    @Test
    public void formFieldWithLabelTest() {
        formFieldWithLabelInputSimplePlaceholder.show();
        formFieldWithLabelInputSimplePlaceholder.has().placeholder("Simple placeholder");
        formFieldWithLabelInputSimplePlaceholderAndLabel.has().placeholder("Simple placeholder");
        formFieldWithLabelInputSimplePlaceholderAndLabel.has().label("Both a label and a placeholder");
        formFieldWithLabelSelect.has().label("favorite Fancy label");
        formFieldWithLabelInputSimplePlaceholder.set("First input value");
        formFieldWithLabelInputSimplePlaceholder.has().value(containsString("t input v"));
        formFieldWithLabelInputSimplePlaceholderAndLabel.set("Second input value");
        formFieldWithLabelInputSimplePlaceholderAndLabel.has().value("Second input value");
        formFieldWithLabelSelect.set("Option");
        formFieldWithLabelSelect.has().value("Option");
    }

    @Test
    public void formFieldAppearanceVariantsTest() {
        formFieldAppearanceInputLegacy.show();
        formFieldAppearanceInputLegacy.doubleClick();
        formFieldAppearanceInputLegacy.set("Input 1 value");
        formFieldAppearanceInputLegacy.has().value( "Input 1 value");
        formFieldAppearanceInputLegacy.has().fieldIcon("sentiment_very_satisfied");
        formFieldAppearanceInputLegacy.is().filled();
        formFieldAppearanceInputStandard.is().outlined();
    }

    @Test
    public void formFieldWithErrorMessageTest() {
        formFieldEmailInput.show();
        formFieldEmailInput.set("test@");
        formFieldEmailInput.focusOut();
        formFieldEmailInput.has().error("Not a valid email");
        formFieldEmailInput.set(" ");
        formFieldEmailInput.has().error("You must enter a value");
        formFieldEmailInput.set("test@test.com");
        formFieldEmailInput.has().value( "test@test.com");
        formFieldEmailInput.set(" ");
        formFieldEmailInput.has().error("You must enter a value");
    }

    @Test
    public void formFieldsWithHintsTest() {
        formFieldExampleContainerInputLimited.show();
        formFieldExampleContainerInputLimited.has().hints(List.of("Max 10 characters", "0/10"));
        formFieldExampleContainerDropdown.has().hint("Here's the dropdown arrow ^");
        formFieldExampleContainerInputLimited.set("12345678901");
        formFieldExampleContainerInputLimited.has().hint("10/10");
        formFieldExampleContainerInputLimited.has().value( "1234567890");
    }

    @Test
    public void formFieldsPrefixSuffixTest() {
        prefixSuffixFormFieldPassword.show();
        prefixSuffixFormFieldPassword.set("Password");
        prefixSuffixFormFieldPassword.clickIcon();
        prefixSuffixFormFieldPassword.has().value( "Password");
        prefixSuffixFormFieldPassword.set("AnotherPassword");
        prefixSuffixFormFieldPassword.has().value( "AnotherPassword");
        prefixSuffixFormFieldPassword.clickIcon();
        prefixSuffixFormFieldPassword.has().value( "AnotherPassword");
    }

    @Test
    public void formFieldsThemesTest() {
        modifiedLayoutFormFieldColor.show();
        modifiedLayoutFormFieldColor.set("Accent");
        modifiedLayoutFormFieldColor.has().color("rgba(0, 0, 0, 0.87)");
    }

    @Test
    public void formFieldsRequiredTest() {
        formFieldWithLabelSelect.show();
        formFieldWithLabelSelect.is().required();
        hideRequiredMarker.click();
        formFieldWithLabelSelect.is().notRequired();
    }

    @Test
    public void formFieldsFloatLabelTest() {
        formFieldWithLabelSelect.show();
        alwaysFloatLabel.click();
        formFieldWithLabelSelect.has().alwaysFloatLabel();
    }

    @Test
    public void formFieldsDisabledTest() {
        formFieldDisabled.show();
        formFieldDisabled.is().disabled();
        formFieldEmailInput.is().notDisabled();
    }

    @Test
    public void formFieldsSubscriptSizingTest() {
        formFieldSubscriptSizingFixed.show();
        formFieldSubscriptSizingFixed.has().notDynamicSubscriptSizing();
        formFieldSubscriptSizingDynamic.has().dynamicSubscriptSizing();
    }
}
