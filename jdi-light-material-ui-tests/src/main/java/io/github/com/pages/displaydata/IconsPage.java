package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.displaydata.Icon;
import com.epam.jdi.light.ui.html.elements.common.Text;

import java.util.List;

public class IconsPage extends WebPage {

    @UI(".MuiGrid-grid-xs-8 > svg")
    public static List<Icon> simpleIcons;

    // @todo #5297 Fix locator to be more stable against div
    @UI("//p[@id='colorLastClick']/..//div/*")
    public static List<Icon> colorIcons;

    @UI("//p[@id='sizeLastClick']/..//div/*")
    public static List<Icon> differentSizesIcons;

    @UI("#simpleLastClick")
    public static Text simpleLastClick;

    @UI("#simpleLastHover")
    public static Text simpleLastHover;
}
