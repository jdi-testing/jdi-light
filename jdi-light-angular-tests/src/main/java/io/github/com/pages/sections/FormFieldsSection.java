package io.github.com.pages.sections;

import com.epam.jdi.light.angular.elements.complex.*;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.*;

public class FormFieldsSection {
    @UI("#simple-form-field-input")
    public FormFields simpleFormField;

    @UI("#form-field-with-label-input-simple-placeholder")
    public FormFields formFieldWithLabel;

    @UI("#form-field-appearance-input-legacy")
    public FormFields formFieldsVariants;

    @UI("#form-field-example-container-input-limited")
    public FormFields formFieldsHints;

    @UI("#form-field-email-input")
    public FormFields formFieldsValidation;

    @UI("#prefix-suffix-form-field-password")
    public FormFields formFieldsPrefixSuffix;

    @UI("#modified-layout-form-field-color")
    public FormFields formFieldsThemes;

    @UI("#form-field-phone-number-id")
    public FormFields fromFieldsCustomControl;

}
