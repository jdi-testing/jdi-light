package io.github.com.pages;

import com.epam.jdi.light.angular.elements.complex.Snackbar;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;

public class SnackBarPage extends AngularPage {
    @UI("#snack-bar-custom-component-input")
    public static TextField durationInput;

    @UI("#snack-bar-custom-component-button")
    public static Button showCustomSnackbarButton;

    @UI("#snack-bar-custom-component")
    public static Snackbar customSnackbar;

    @UI("#snack-bar-message-input")
    public static TextField basicSnackbarMessageInput;

    @UI("#snack-bar-action-input")
    public static TextField basicSnackbarActionInput;

    @UI("#snack-bar-open-button")
    public static Button showBasicSnackbarButton;
    @UI("//simple-snack-bar")
    public static Snackbar snackbar;

    @JDropdown(root = "mat-form-field.mat-mdc-form-field-type-mat-select:has(#snack-bar-position-horizontal-select)", value = "span.mat-mdc-select-min-line", list = "//ancestor::body//mat-option")
    public static Dropdown horizontalPositionDropdown;

    @JDropdown(root = "mat-form-field.mat-mdc-form-field-type-mat-select:has(#snack-bar-position-vertival-select)", value = "span.mat-mdc-select-min-line", list = "//ancestor::body//mat-option")
    public static Dropdown verticalPositionDropdown;

    @UI("#snack-bar-position-open-button")
    public static Button showPositionSnackbarButton;
}
