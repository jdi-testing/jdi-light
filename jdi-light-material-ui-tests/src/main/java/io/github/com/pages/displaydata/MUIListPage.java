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
    public MUISimpleList simpleList;

    @UI("#lastClickInfo")
    public Text simpleListLastClickInfo;

    @UI("//*[.='Enable dense']")
    public Checkbox denseCheckbox;

    @UI("//*[.='Enable secondary text']")
    public Checkbox secondaryTextCheckbox;

    @UI("#textOnlyList")
    public MUISimpleList textOnlyList;

    @UI("#iconWithTextList")
    public MUISimpleList iconWithTextList;

    @UI("#avatarWithTextList")
    public MUISimpleList avatarWithTextList;

    @UI("#avatarWithTextAndIconList")
    public MUICustomList avatarWithTextAndIconList;

    @UI("#selectedList")
    public MUISimpleList selectedListUpperHalf;

    @UI("#selectedListLowerHalf")
    public MUISimpleList selectedListLowerHalf;

    @UI("#checkboxList")
    public MUIContainerList checkboxList;

    @UI("#listWithSwitch")
    public MUIContainerList listWithSwitch;

    @UI("#pinnedSubheaderList")
    public MUISimpleList pinnedSubheaderList;
}
