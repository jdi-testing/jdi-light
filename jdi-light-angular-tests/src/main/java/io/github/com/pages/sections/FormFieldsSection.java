package io.github.com.pages.sections;

import com.epam.jdi.light.angular.elements.complex.FormField;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class FormFieldsSection {

    @UI("#simple-form-field-input")
    public static FormField simpleFormFieldInput;

    @UI("#form-field-with-label-input-simple-placeholder")
    public static FormField formFieldWithLabelInputSimplePlaceholder;

    @UI("#form-field-appearance-input-legacy")
    public static FormField formFieldAppearanceInputLegacy;

    @UI("#form-field-example-container-input-limited")
    public static FormField formFieldExampleContainerInputLimited;

    @UI("#form-field-email-input")
    public static FormField formFieldEmailInput;

    @UI("#prefix-suffix-form-field-password")
    public static FormField prefixSuffixFormFieldPassword;

    @UI("#modified-layout-form-field-color")
    public static FormField modifiedLayoutFormFieldColor;
}
