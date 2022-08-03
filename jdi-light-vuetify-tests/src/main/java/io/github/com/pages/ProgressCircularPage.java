package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.ProgressCircular;

import java.util.List;

public class ProgressCircularPage extends VuetifyPage {

    @UI("#ColorProgress .v-progress-circular")
    public static List<ProgressCircular> colorProgressSpinners;

    @UI("#IndeterminateProgress .v-progress-circular")
    public static List<ProgressCircular> indeterminateProgressSpinners;

    @UI("#RotateProgress .v-progress-circular")
    public static List<ProgressCircular> rotateProgressSpinners;

    @UI("#SizeWidthProgress .v-progress-circular")
    public static List<ProgressCircular> sizeWidthProgressSpinners;

}
