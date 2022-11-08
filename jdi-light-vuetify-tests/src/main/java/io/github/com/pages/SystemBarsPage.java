package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.bars.SystemBar;
import io.github.com.custom.bars.IconBar;

import java.util.List;

public class SystemBarsPage extends VuetifyPage {

    @UI("#ColoredSystemBar .v-system-bar")
    public static List<SystemBar> coloredSystemBars;

    @UI("#ColoredSystemBar .v-system-bar.red")
    public static IconBar redColoredSystemBar;

    @UI("#system-bar-lights-out-light")
    public static SystemBar lightLightsOutSystemBar;

    @UI("#system-bar-lights-out-datk")
    public static SystemBar darkLightsOutSystemBar;

    @UI("#WindowSystemBar .v-system-bar")
    public static IconBar windowSystemBar;

    @UI("#system-bar-absolute-position")
    public static SystemBar absolutePositionSystemBar;

    @UI("#AppSystemBar .v-system-bar")
    public static SystemBar appSystemBar;

    @UI("#system-bar-high")
    public static SystemBar highSystemBar;
}
