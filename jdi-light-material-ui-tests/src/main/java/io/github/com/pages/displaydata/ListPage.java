package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.displaydata.List;
import com.epam.jdi.light.material.elements.inputs.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class ListPage extends WebPage {
    @UI(".MuiList-root[aria-label='List items']") // TODO set test IDs
    public static List simpleList;

    @UI("#lastClickInfo")
    public static Text simpleListLastClickInfo;

    @UI("//*[.='Enable dense']")
    public static Checkbox denseCheckbox;

    @UI("//*[.='Enable secondary text']")
    public static Checkbox secondaryTextCheckbox;

    @UI("//*[@id='__next']/div/div/div[2]/div/div/div/div[2]/div[2]/div[1]/div/ul")
    public static List textOnlyList;

    @UI("//*[@id='__next']/div/div/div[2]/div/div/div/div[2]/div[2]/div[2]/div/ul")
    public static List iconWithTextList;

    @UI("//*[@id='__next']/div/div/div[2]/div/div/div/div[2]/div[3]/div[1]/div/ul")
    public static List avatarWithTextList;

    @UI("//*[@id='__next']/div/div/div[2]/div/div/div/div[2]/div[3]/div[2]/div/ul")
    public static List avatarWithTextAndIconList;

    @UI("#selectedList")
    public static List selectedListUpperHalf;

    @UI("[aria-label='secondary mailbox folder']")
    public static List selectedListLowerHalf;

    @UI("//*[@id='__next']/div/div/div[2]/div/div/div/div[2]/ul[1]")
    public static List checkboxList;

    @UI("//*[@id='__next']/div/div/div[2]/div/div/div/div[2]/ul[2]")
    public static List listWithSwitch;

    @UI("//*[@id='__next']/div/div/div[2]/div/div/div/div[2]/ul[3]")
    public static List pinnedSubheaderList;
}
