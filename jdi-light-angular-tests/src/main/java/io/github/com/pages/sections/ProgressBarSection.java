package io.github.com.pages.sections;

import com.epam.jdi.light.angular.elements.common.ProgressBar;
import com.epam.jdi.light.angular.elements.common.Slider;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class ProgressBarSection extends Section {

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

    @UI("#progress-bars-primary-color-radio")
    public static Button progressBarsPrimaryColorRadio;

    @UI("#progress-bars-accent-color-radio")
    public static Button progressBarsAccentColorRadio;

    @UI("#progress-bars-warn-color-radio")
    public static Button progressBarsWarnColorRadio;

    @UI("#progress-bars-determinate-mode-radio")
    public static Button progressBarsDeterminateModeRadio;

    @UI("#progress-bars-indeterminate-mode-radio")
    public static Button progressBarsIndeterminateModeRadio;

    @UI("#progress-bars-buffer-modeRadio")
    public static Button progressBarsBufferModeRadio;

    @UI("#progress-bars-query-mode-radio")
    public static Button progressBarsQueryModeRadio;

    @UI("#progress-bars-progress-slider")
    public static Slider progressBarsProgressSlider;

    @UI("#progress-bars-buffer-slider")
    public static Slider progressBarsBufferSlider;
}
