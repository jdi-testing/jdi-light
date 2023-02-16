package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.ProgressLinear;

import java.util.List;

public class ProgressLinearPage extends VuetifyPage {

    @UI("#BufferValueProgress .v-progress-linear")
    public static List<ProgressLinear> bufferValueProgressLinears;

    @UI("#ColorsProgress .v-progress-linear")
    public static List<ProgressLinear> colorsProgressLinears;

    @UI("#IndeterminateProgress .v-progress-linear")
    public static List<ProgressLinear> indeterminateProgressLinears;

    @UI("#QueryProgress .v-progress-linear")
    public static ProgressLinear queryProgressLinear;

    @UI("#ReversedProgress .v-progress-linear")
    public static List<ProgressLinear> reversedProgressLinears;

    @UI("#RoundedProgress .v-progress-linear")
    public static List<ProgressLinear> roundedProgressLinears;

    @UI("#StreamProgress .v-progress-linear")
    public static List<ProgressLinear> streamProgressLinears;

    @UI("#StripedProgress .v-progress-linear")
    public static List<ProgressLinear> stripedProgressLinears;

    @UI("#DefaultProgress .v-progress-linear")
    public static List<ProgressLinear> defaultProgressLinears;
}
