package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Icon;

import java.util.List;

public class IconsPage extends VuetifyPage {

    @UI("#ColorIcon .v-icon")
    public static List<Icon> colorIcons;

    @UI("#ClickIcon .v-icon")
    public static Icon clickIcon;

    @UI("#ButtonsIcon .v-icon")
    public static List<Icon> buttonsIcons;

    @UI("#FontAwesomeIcon .v-icon")
    public static List<Icon> fontAwesomeIcons;

    @UI("#MaterialDesignIcon .v-icon")
    public static List<Icon> materialDesignIcons;

    @UI("#MDISvgIcon .v-icon")
    public static List<Icon> mdiSvgIcons;

}
