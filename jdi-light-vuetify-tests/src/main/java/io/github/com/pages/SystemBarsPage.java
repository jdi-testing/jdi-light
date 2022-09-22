package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import io.github.com.custom.bars.IconBar;
import com.epam.jdi.light.vuetify.elements.complex.bars.SystemBar;
import java.util.List;

public class SystemBarsPage extends VuetifyPage {

    @UI("#ColoredSystemBar .v-system-bar")
    public static List<SystemBar> coloredSystemBars;

    @UI("#ColoredSystemBar .v-system-bar.red")
    public static IconBar redColoredSystemBar;

    @UI("#WindowSystemBar .v-system-bar")
    public static IconBar windowSystemBar;

    @UI("#AppSystemBar .v-system-bar")
    public static SystemBar appSystemBar;
}
