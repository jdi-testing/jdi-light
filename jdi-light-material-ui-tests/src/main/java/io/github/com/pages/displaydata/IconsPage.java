package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

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
    public static UIElement simpleLastClick;

    @UI("#simpleLastHover")
    public static UIElement simpleLastHover;

    @UI("//div[contains(@class, 'MuiBox-root')]/div/h2[2]/following-sibling::div[1]/div[1]/*[name()='svg']")
    public static List<UIElement> color;

    @UI("#colorLastClick")
    public static UIElement colorLastClick;

    @UI("#colorLastHover")
    public static UIElement colorLastHover;

    @UI("//div[contains(@class, 'MuiBox-root')]/div/h2[3]/following-sibling::div[1]/div[1]/*[name()='svg']")
    public static List<UIElement> size;

    @UI("#sizeLastClick")
    public static UIElement sizeLastClick;

    @UI("#sizeLastHover")
    public static UIElement sizeLastHover;
}
