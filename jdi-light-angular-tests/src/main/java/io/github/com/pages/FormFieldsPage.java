package io.github.com.pages;

import com.epam.jdi.light.angular.elements.common.Checkbox;
import com.epam.jdi.light.angular.elements.complex.FormField;
import com.epam.jdi.light.angular.elements.complex.radiobuttons.RadioButton;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class FormFieldsPage extends NewAngularPage {

    public static FormField formFieldSubscriptSizingFixed;
    public static FormField formFieldSubscriptSizingDynamic;
    public static FormField formFieldAppearanceInputLegacy;
    public static FormField formFieldAppearanceInputStandard;
    public static FormField simpleFormFieldInput;
    public static FormField simpleFormFieldSelect;
    public static FormField simpleFormFieldTextarea;
    public static FormField formFieldWithLabelInputSimplePlaceholder;
    public static FormField formFieldWithLabelInputSimplePlaceholderAndLabel;
    public static FormField formFieldWithLabelSelect;
    public static FormField formFieldExampleContainerInputLimited;
    public static FormField formFieldExampleContainerDropdown;
    public static FormField formFieldEmailInput;
    public static FormField prefixSuffixFormFieldPassword;
    public static FormField modifiedLayoutFormFieldColor;
    public static FormField formFieldDisabled;
    @UI("mat-checkbox[id*='mat-mdc-checkbox']")
    public static Checkbox hideRequiredMarker;
    @UI("mat-radio-button[value='always']")
    public static RadioButton alwaysFloatLabel;
}
