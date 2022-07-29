package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.bars.IconSystemBar;
import com.epam.jdi.light.vuetify.elements.complex.bars.SystemBar;
import java.util.List;

public class SystemBarsPage extends VuetifyPage {

    @UI("#ColoredSystemBar .v-system-bar")
    public static List<IconSystemBar> coloredSystemBars;

    @UI("#system-bar-app")
    public static SystemBar appSystemBar;
}
