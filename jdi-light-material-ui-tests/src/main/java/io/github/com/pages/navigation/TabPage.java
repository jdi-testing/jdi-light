package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.navigation.Tabs;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

import java.util.List;

public class TabPage extends WebPage {
    @UI("//button[contains(@aria-controls,'simple-tabpanel')]")
    public static List<Tabs> simpleTabs;

    @UI("//button[contains(@aria-controls,'scrollable-auto-tab')]")
    public static List<Tabs> scrollableTabs;

    @UI("//button[contains(@aria-controls,'scrollable-prevent-tab')]")
    public static List<Tabs> preventScrollTabs;

    @UI("//button[contains(@aria-controls,'vertical-tabpanel')]")
    public static List<Tabs> verticalTabs;

    @UI("//p")
    public static List<Text> lastItemText;

    @UI("//*[contains(@class, 'MuiTabs-scrollButtons')]")
    public static List<Button> scrollButtons;
}
