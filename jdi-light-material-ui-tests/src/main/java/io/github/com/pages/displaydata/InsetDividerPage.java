package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.displaydata.Divider;
import com.epam.jdi.light.material.elements.displaydata.Icon;
import com.epam.jdi.light.ui.html.elements.common.Text;

import java.util.List;

public class InsetDividerPage extends WebPage {

    @UI("li.MuiDivider-root")
    public static List<Divider> insetDividers;

    @UI("//div[@class='MuiListItemAvatar-root']")
    public static List<Icon> iconList;

    @UI("//div[@class='MuiListItemText-root MuiListItemText-multiline']//span")
    public static List<Text> titleTextList;

    @UI("//div[@class='MuiListItemText-root MuiListItemText-multiline']//p")
    public static List<Text> dateTextList;
}
