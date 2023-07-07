package io.github.com.pages;

import com.epam.jdi.light.angular.elements.common.ProgressSpinner;
import com.epam.jdi.light.angular.elements.common.Slider;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class ProgressSpinnerPage extends NewAngularPage {
    public static Button showSpinner;
    public static ProgressSpinner basicProgressSpinner;
    public static ProgressSpinner configuredSpinner;
    @UI("#spinner-color mat-radio-button[value='primary']")
    public static Button progressSpinnerPrimaryColorRadio;
    @UI("#spinner-color mat-radio-button[value='accent']")
    public static Button progressSpinnerAccentColorRadio;
    @UI("#spinner-color mat-radio-button[value='warn']")
    public static Button progressSpinnerWarnColorRadio;
    @UI("#spinner-mode mat-radio-button[value='determinate']")
    public static Button progressSpinnerDeterminateModeRadio;
    @UI("#spinner-mode mat-radio-button[value='indeterminate']")
    public static Button progressSpinnerIndeterminateModeRadio;
    public static Slider progressSlider;
}
