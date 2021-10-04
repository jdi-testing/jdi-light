package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Icon;

import java.util.List;

public class IconsPage extends VuetifyPage {

    @UI("#ColorIcon i")
    public static List<Icon> colorIcons;

    @UI("#ClickIcon")
    public static Icon clickIcon;

    @UI("#ButtonsIcon")
    public static List<Icon> buttonsIcons;

    @UI("#FontAwesomeIcon")
    public static List<Icon> fontAwesomeIcons;

    @UI("#MaterialDesignIcon")
    public static List<Icon> materialDesignIcons;

    @UI("#MDISvgIcon")
    public static List<Icon> mdiSvgIcons;

}
