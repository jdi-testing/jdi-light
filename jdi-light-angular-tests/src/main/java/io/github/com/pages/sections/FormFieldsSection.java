package io.github.com.pages.sections;

import com.epam.jdi.light.angular.elements.complex.*;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.*;

public class FormFieldsSection {
    @UI("#simple-form-field-input")
    public FormField simpleFormField;

    @UI("#form-field-with-label-input-simple-placeholder")
    public FormField formFieldWithLabel;

    @UI("#form-field-appearance-input-legacy")
    public FormField formFieldVariants;

    @UI("#form-field-example-container-input-limited")
    public FormField formFieldHints;

    @UI("#form-field-email-input")
    public FormField formFieldValidation;

    @UI("#prefix-suffix-form-field-password")
    public FormField formFieldPrefixSuffix;

    @UI("#modified-layout-form-field-color")
    public FormField formFieldThemes;

    @UI("#form-field-phone-number-id")
    public FormField fromFieldsCustomControl;

}
