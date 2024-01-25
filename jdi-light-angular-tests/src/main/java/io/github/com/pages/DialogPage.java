package io.github.com.pages;

import com.epam.jdi.light.angular.elements.common.Button;
import com.epam.jdi.light.angular.elements.common.Input;
import com.epam.jdi.light.angular.elements.complex.AutoComplete;
import com.epam.jdi.light.angular.elements.complex.Dialog;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;
import io.github.com.custom.elements.dialog.ActionDialog;
import io.github.com.custom.elements.dialog.OverviewDialog;

public class DialogPage extends NewAngularPage {

    @UI(".mat-mdc-input-element")
    public static Input nameFormFields;

    @UI("#dialog")
    public static Button dialogOverviewButton;

    @UI("#dialog-animations-open-dialog-btn-without-animation")
    public static Button dialogWithoutAnimationsButton;

    @UI("#dialog-animations-open-dialog-btn-with-animation")
    public static Button dialogWithAnimationsButton;

    @UI("mat-dialog-container")
    public static OverviewDialog nameDialog;

    @UI("dialog-overview-example li:last-child")
    public static Text youChooseText;

    @UI("#dialog-animations-open-dialog-btn-without-animation")
    public static Button withoutAnimationButton;

    @UI("#dialog-animations-open-dialog-btn-with-animation")
    public static Button withAnimationButton;

    @UI("mat-dialog-container")
    public static Dialog withoutAnimationDialog;

    @UI("mat-dialog-container")
    public static Dialog withAnimationDialog;

    @UI("mat-form-field.ng-tns-c17-1")
    public static AutoComplete alignAction;

    @UI("mat-form-field.ng-tns-c17-7")
    public static AutoComplete disableCloseAction;

    @UI("mat-form-field.ng-tns-c17-15")
    public static AutoComplete maxHeightAutocomplete;

    @UI("mat-form-field.ng-tns-c17-17")
    public static AutoComplete minHeightAutocomplete;

    @UI("mat-form-field.ng-tns-c17-19")
    public static AutoComplete maxWidthAutocomplete;

    @UI("mat-form-field.ng-tns-c17-21")
    public static AutoComplete minWidthAutocomplete;

    @UI("mat-dialog-container")
    public static ActionDialog customizableDialog;

    @UI("#dialog-scrollable-content-open-btn")
    public static Button dialogActionButton;
}
