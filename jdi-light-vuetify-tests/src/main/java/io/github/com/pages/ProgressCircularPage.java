package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.ProgressCircular;

import java.util.List;

public class ProgressCircularPage extends VuetifyPage {

    @UI("#ColorProgress .v-progress-circular")
    public static List<ProgressCircular> colorProgressCirculars;

    @UI("#IndeterminateProgress .v-progress-circular")
    public static List<ProgressCircular> indeterminateProgressCirculars;

    @UI("#RotateProgress .v-progress-circular")
    public static List<ProgressCircular> rotateProgressCirculars;

    @UI("#SizeWidthProgress .v-progress-circular")
    public static List<ProgressCircular> sizeWidthProgressCirculars;

}
