package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.displaydata.list.MUIList;
import com.epam.jdi.light.material.elements.displaydata.list.SimpleList;
import com.epam.jdi.light.material.elements.inputs.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.Text;
import io.github.com.custom.elements.CustomSiteListItem;
import io.github.com.custom.elements.MUICustomList;

public class MUIListPage extends WebPage {

    @UI("#simpleList")
    public static SimpleList simpleList;

    @UI("#lastClickInfo")
    public static Text simpleListLastClickInfo;

    @UI("//*[.='Enable dense']")
    public static Checkbox denseCheckbox;

    @UI("//*[.='Enable secondary text']")
    public static Checkbox secondaryTextCheckbox;

    @UI("#textOnlyList")
    public static SimpleList textOnlyList;

    @UI("#iconWithTextList")
    public static SimpleList iconWithTextList;

    @UI("#avatarWithTextList")
    public static SimpleList avatarWithTextList;

    @UI("#avatarWithTextAndIconList")
    public static MUICustomList avatarWithTextAndIconList;

    @UI("#selectedList")
    public static SimpleList selectedListUpperHalf;

    @UI("#selectedListLowerHalf")
    public static SimpleList selectedListLowerHalf;

    @UI("#checkboxList")
    public static MUIList<CustomSiteListItem> checkboxList;

    @UI("#listWithSwitch")
    public static MUIList<CustomSiteListItem> listWithSwitch;

    @UI("#pinnedSubheaderList")
    public static SimpleList pinnedSubheaderList;
}
