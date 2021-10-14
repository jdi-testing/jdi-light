package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Button;
import com.epam.jdi.light.vuetify.elements.common.ProgressBar;

import java.util.List;

public class ProgressLinearPage extends VuetifyPage {

    @UI("#BufferValueProgress .v-progress-linear")
    public static List<ProgressBar> bufferValueProgressBars;

    @UI("#ColorsProgress .v-progress-linear")
    public static List<ProgressBar> colorsProgressBars;

    @UI("#IndeterminateProgress .v-progress-linear")
    public static List<ProgressBar> indeterminateProgressBars;

    @UI("#QueryProgress .v-progress-linear")
    public static ProgressBar queryProgressBar;

    @UI("#ReversedProgress .v-progress-linear")
    public static List<ProgressBar> reversedProgressBars;

    @UI("#RoundedProgress .v-progress-linear")
    public static List<ProgressBar> roundedProgressBars;

    @UI("#StreamProgress .v-progress-linear")
    public static List<ProgressBar> streamProgressBars;

    @UI("#StripedProgress .v-progress-linear")
    public static List<ProgressBar> stripedProgressBars;

    @UI("#DefaultProgress .v-progress-linear")
    public static List<ProgressBar> defaultProgressBars;

    @UI("#DeterminateProgress .v-progress-linear")
    public static List<ProgressBar> determinateProgressBars;

    @UI("#FileLoaderProgress .v-progress-linear")
    public static ProgressBar fileLoaderProgressBar;

    @UI("#ToolbarProgress .v-progress-linear")
    public static ProgressBar toolbarProgressBar;

    @UI("//div[@id='ToolbarProgress']//ancestor::span[contains(text(), 'Start loading')]")
    public static Button startLoading;

}
