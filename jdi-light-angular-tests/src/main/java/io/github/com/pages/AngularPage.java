package io.github.com.pages;

import com.epam.jdi.angular.elements.common.Checkbox;
import com.epam.jdi.angular.elements.common.ProgressSpinner;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.*;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import io.github.com.pages.sections.InputsForm;
import io.github.com.pages.sections.SlideToggleSection;

public class AngularPage extends WebPage {
    @Css("radio-overview-example .mat-radio-group")
    public static RadioButtons basicRadioButtons;

    @UI("#mat-radio-2")
    public static Button firstBasicRadioButton;

    @UI("#mat-radio-3")
    public static Button secondBasicRadioButton;

    @UI("#basic_progress_spinner")
    public static ProgressSpinner basicProgressSpinner;

    @UI("#basic_icon")
    public static Icon basicIcon;

    @UI("#svg_icon")
    public static Icon svgIcon;

    @UI("#mat-checkbox-1")
    public static Checkbox basicCheckbox;

    @UI("#mat-checkbox-2")
    public static Checkbox configurableCheckedCheckbox;

    @UI("#mat-checkbox-3")
    public static Checkbox configurableIndeterminateCheckbox;

    @UI("#mat-radio-11-input")
    public static Checkbox configurableCheckboxAlignBeforeRadioButton;

    @UI("#mat-radio-10-input")
    public static Checkbox configurableCheckboxAlignAfterRadioButton;

    @UI("#mat-checkbox-4")
    public static Checkbox configurableDisabledCheckbox;

    @UI("#mat-checkbox-5")
    public static Checkbox configurableResultCheckbox;

    public static SlideToggleSection slideToggleSection;

    @UI("#mat-input-12")
    public static TextField foodBasicInput;

    @UI("#mat-input-13")
    public static TextField leaveACommentBasicInput;

    @UI("#mat-input-15")
    public static TextField emailErrorStateMatcherInput;

    @UI(".ng-tns-c94-39 mat-error")
    public static Text errorStateMatcherMessageInput;

    @UI("#mat-input-16")
    public static TextArea autoSizeTextArea;

    @UI("#mat-input-17")
    public static TextArea clearableInput;

    @UI(".ng-tns-c94-43 button")
    public static Button clearableInputButton;

    @UI("#mat-input-18")
    public static TextField emailInput;

    @UI(".ng-tns-c94-44 mat-error")
    public static Text errorMessageInput;

    @UI("input-form-example form")
    public static InputsForm inputsForm;

    @UI("#mat-input-27")
    public static TextField messageHintInput;

    @UI(".ng-tns-c94-53 mat-hint:first-of-type")
    public static Text messageHint;

    @UI(".ng-tns-c94-53 mat-hint:last-of-type")
    public static Text messageCounterHint;

    @UI(".ng-tns-c94-54 .mat-form-field-prefix")
    public static UIElement prefixInput;

    @UI(".ng-tns-c94-54 .mat-form-field-suffix")
    public static UIElement suffixInput;

    @UI("#mat-input-28")
    public static TextField telephoneInput;
}
