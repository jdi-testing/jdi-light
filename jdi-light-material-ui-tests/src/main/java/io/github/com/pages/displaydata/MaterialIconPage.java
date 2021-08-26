package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.jdi.light.ui.html.elements.common.Text;

import java.util.List;

public class MaterialIconPage extends WebPage {

    @UI("//h2[text()='Access Alarm']/following::*[name()='svg']")
    public static List<Icon> iconsList;

    @UI("#miconLastClick")
    public static Text lastClick;

    @UI("#miconLastHover")
    public static Text lastHover;
}
