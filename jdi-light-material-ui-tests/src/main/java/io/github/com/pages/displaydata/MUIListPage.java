package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.displaydata.MUIContainerList;
import com.epam.jdi.light.material.elements.displaydata.MUISimpleList;
import com.epam.jdi.light.material.elements.inputs.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.Text;
import io.github.com.custom.elements.MUICustomList;

public class MUIListPage extends WebPage {

    @UI("#simpleList")
    public static MUISimpleList simpleList;

    @UI("#lastClickInfo")
    public static Text simpleListLastClickInfo;

    @UI("//*[.='Enable dense']")
    public static Checkbox denseCheckbox;

    @UI("//*[.='Enable secondary text']")
    public static Checkbox secondaryTextCheckbox;

    @UI("#textOnlyList")
    public static MUISimpleList textOnlyList;

    @UI("#iconWithTextList")
    public static MUISimpleList iconWithTextList;

    @UI("#avatarWithTextList")
    public static MUISimpleList avatarWithTextList;

    @UI("#avatarWithTextAndIconList")
    public static MUICustomList avatarWithTextAndIconList;

    @UI("#selectedList")
    public static MUISimpleList selectedListUpperHalf;

    @UI("#selectedListLowerHalf")
    public static MUISimpleList selectedListLowerHalf;

    @UI("#checkboxList")
    public static MUIContainerList checkboxList;

    @UI("#listWithSwitch")
    public static MUIContainerList listWithSwitch;

    @UI("#pinnedSubheaderList")
    public static MUISimpleList pinnedSubheaderList;
}
