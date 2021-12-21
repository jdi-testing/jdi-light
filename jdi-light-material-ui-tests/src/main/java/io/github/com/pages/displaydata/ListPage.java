package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.displaydata.List;
import com.epam.jdi.light.material.elements.inputs.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class ListPage extends WebPage {

    @UI("#simpleList")
    public static List simpleList;

    @UI("#lastClickInfo")
    public static Text simpleListLastClickInfo;

    @UI("//*[.='Enable dense']")
    public static Checkbox denseCheckbox;

    @UI("//*[.='Enable secondary text']")
    public static Checkbox secondaryTextCheckbox;

    @UI("#textOnlyList")
    public static List textOnlyList;

    @UI("#iconWithTextList")
    public static List iconWithTextList;

    @UI("#avatarWithTextList")
    public static List avatarWithTextList;

    @UI("#avatarWithTextAndIconList")
    public static List avatarWithTextAndIconList;

    @UI("#selectedList")
    public static List selectedListUpperHalf;

    @UI("#selectedListLowerHalf")
    public static List selectedListLowerHalf;

    @UI("#checkboxList")
    public static List checkboxList;

    @UI("#listWithSwitch")
    public static List listWithSwitch;

    @UI("#pinnedSubheaderList")
    public static List pinnedSubheaderList;
}
