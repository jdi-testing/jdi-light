package io.github.com.pages;

import com.epam.jdi.light.angular.elements.common.ProgressBar;
import com.epam.jdi.light.angular.elements.common.Slider;
import com.epam.jdi.light.angular.elements.complex.RadioGroup;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class ProgressBarPage extends NewAngularPage {
    @UI("#show-indeterminate-progress-bar-button")
    public static Button showIndeterminateProgressBarButton;
    @UI("#mat-progress-bar-indeterminate")
    public static ProgressBar matProgressBarIndeterminate;
    @UI("#show-buffer-progress-bar-button")
    public static Button showBufferProgressBarButton;
    @UI("#mat-progress-bar-buffer")
    public static ProgressBar matProgressBarBuffer;
    @UI("#mat-progress-bar-determinate")
    public static ProgressBar matProgressBarDeterminate;
    @UI("#mat-progress-bar-query")
    public static ProgressBar matProgressBarQuery;
    @UI("#mat-progress-bar-configurable")
    public static ProgressBar matProgressBarConfigurable;
    @UI(".example-section:nth-of-type(1) .mat-mdc-radio-group")
    public static RadioGroup colorRadioGroup;
    @UI(".example-section:nth-of-type(2) .mat-mdc-radio-group")
    public static RadioGroup modeRadioGroup;
    @UI("#progress-bars-query-mode-radio")
    public static Button progressBarsQueryModeRadio;
    @UI("#progress-bars-progress-slider")
    public static Slider progressBarsProgressSlider;
    @UI("#progress-bars-buffer-slider")
    public static Slider progressBarsBufferSlider;
}
