package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.*;

import java.util.List;

public class IconsPage extends WebPage {
    @UI("//div[contains(@class, 'MuiGrid-grid-xs-8')][1]/*[name()='svg']")
    public static List<UIElement> filled;

    @UI("//div[contains(@class, 'MuiGrid-grid-xs-8')][2]/*[name()='svg']")
    public static List<UIElement> outlined;

    @UI("//div[contains(@class, 'MuiGrid-grid-xs-8')][3]/*[name()='svg']")
    public static List<UIElement> rounded;

    @UI("//div[contains(@class, 'MuiGrid-grid-xs-8')][4]/*[name()='svg']")
    public static List<UIElement> twoTone;

    @UI("//div[contains(@class, 'MuiGrid-grid-xs-8')][5]/*[name()='svg']")
    public static List<UIElement> sharp;

    @UI("//div[contains(@class, 'MuiGrid-grid-xs-8')][6]/*[name()='svg']")
    public static List<UIElement> edgeCase;

    @UI("#simpleLastClick")
    public static Text simpleLastClick;

    @UI("#simpleLastHover")
    public static Text simpleLastHover;

    @UI("//h2[text()='Color']/following::*[name()='svg']")
    public static List<UIElement> color;

    @UI("#colorLastClick")
    public static Text colorLastClick;

    @UI("#colorLastHover")
    public static Text colorLastHover;

    @UI("//h2[text()='Size']/following::*[name()='svg']")
    public static List<UIElement> size;

    @UI("#sizeLastClick")
    public static Text sizeLastClick;

    @UI("#sizeLastHover")
    public static Text sizeLastHover;
}
