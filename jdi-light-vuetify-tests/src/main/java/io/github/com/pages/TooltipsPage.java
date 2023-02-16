package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import com.epam.jdi.light.vuetify.elements.common.Icon;
import com.epam.jdi.light.vuetify.elements.common.Tooltip;

import java.util.List;

public class TooltipsPage extends VuetifyPage {

    @UI("//span[contains(text(), 'Button')]/ancestor::button")
    public static Button buttonWithTooltip;

    @UI("i.mdi-home")
    public static Icon homeIconWithTooltip;

    @UI("//span[contains(text(), 'This text has a tooltip')]")
    public static TextField textWithTooltip;

    @UI("//span[contains(text(), 'toggle')]/ancestor::button")
    public static Button toggleButtonWithTooltip;

    @UI("i.mdi-cart")
    public static Icon cartIconWithTooltip;

    @UI("div.v-tooltip__content")
    public static Tooltip tooltip;

    @UI("//h2[contains(text(), 'Color')]/..//button")
    public static List<Button> coloredButtons;

}
