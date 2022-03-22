package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.displaydata.MUIList;
import com.epam.jdi.light.material.elements.inputs.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class MUIListPage extends WebPage {

    @UI("#simpleList")
    public static MUIList simpleList;

    @UI("#lastClickInfo")
    public static Text simpleListLastClickInfo;

    @UI("//*[.='Enable dense']")
    public static Checkbox denseCheckbox;

    @UI("//*[.='Enable secondary text']")
    public static Checkbox secondaryTextCheckbox;

    @UI("#textOnlyList")
    public static MUIList textOnlyList;

    @UI("#iconWithTextList")
    public static MUIList iconWithTextList;

    @UI("#avatarWithTextList")
    public static MUIList avatarWithTextList;

    @UI("#avatarWithTextAndIconList")
    public static MUIList avatarWithTextAndIconList;

    @UI("#selectedList")
    public static MUIList selectedListUpperHalf;

    @UI("#selectedListLowerHalf")
    public static MUIList selectedListLowerHalf;

    @UI("#checkboxList")
    public static MUIList checkboxList;

    @UI("#listWithSwitch")
    public static MUIList listWithSwitch;

    @UI("#pinnedSubheaderList")
    public static MUIList pinnedSubheaderList;
}
