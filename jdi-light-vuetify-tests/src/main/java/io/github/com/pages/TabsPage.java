package io.github.com.pages;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.jdi.light.ui.html.elements.complex.Tabs;
import java.util.List;

/**
 * To see an example of Tabs web element please visit https://vuetifyjs.com/en/components/tabs/
 */

public class TabsPage extends VuetifyPage {

    @UI("//div[@id = 'AlignTitleTabs']//*[@class = 'v-tabs-slider-wrapper']/following-sibling::div")
    public static Tabs alignWithTitleTabs;

    @UI("//div[@id = 'CenterActiveTabs']//*[@class = 'v-tabs-slider-wrapper']/following-sibling::div")
    public static Tabs centerActiveTabs;

    @UI("//div[@id = 'CustomIconsTabs']//*[@class = 'v-tabs-slider-wrapper']/following-sibling::a")
    public static Tabs customIconsTabs;

    @UI("#CustomIconsTabs .v-slide-group__next")
    public static Tabs customIconsTabsButtonNext;

    @UI("#CustomIconsTabs .v-slide-group__prev")
    public static Tabs customIconsTabsButtonBack;

    @UI("//div[@id = 'FixedTabs']//*[@class = 'v-tabs-slider-wrapper']/following-sibling::div")
    public static Tabs fixedTabs;

    @UI("//div[@id = 'GrowTabs']//*[@class = 'v-tabs-slider-wrapper']/following-sibling::div")
    public static Tabs growTabs;

    @UI("//div[@id = 'IconsTextTabs']//*[@class = 'v-tabs-slider-wrapper']/following-sibling::a")
    public static Tabs iconAndTextTabs;

    @UI("#IconsTextTabs .v-icon")
    public static List<Icon> iconAndTextTabsIcon;

    @UI("//div[@id = 'PaginationTabs']//*[@class = 'v-tabs-slider-wrapper']/following-sibling::a")
    public static Tabs paginationTabs;

    @UI("#PaginationTabs .v-slide-group__next")
    public static Tabs paginationTabsButtonNext;

    @UI("#PaginationTabs .v-slide-group__prev")
    public static Tabs paginationTabsButtonBack;

    @UI("//div[@id = 'RightTabs']//*[@class = 'v-tabs-slider-wrapper']/following-sibling::div")
    public static Tabs rightTabs;

    @UI("//div[@id = 'VerticalTabs']//*[@class = 'v-tabs-slider-wrapper']/following-sibling::div")
    public static Tabs verticalTabs;

    @UI("#VerticalTabs .v-icon")
    public static List<Icon> verticalTabsIcon;

    @UI("//div[@id = 'ContentTabs']//*[@class = 'v-tabs-slider-wrapper']/following-sibling::a")
    public static Tabs contentTabs;

    @UI("//div[@id = 'DesktopTabs']//*[@class = 'v-tabs-slider-wrapper']/following-sibling::a")
    public static Tabs desktopTabs;

    @UI("#DesktopTabs .v-icon")
    public static List<Icon> desktopTabsIcon;

    @UI("//div[@id = 'DynamicHeightTabs']//*[@class = 'v-tabs-slider-wrapper']/following-sibling::div")
    public static Tabs dynamicHeightTabs;

    @UI("//div[@id = 'DynamicTabs']//*[@class = 'v-tabs-slider-wrapper']/following-sibling::div")
    public static Tabs dynamicTabs;

    @UI("//div[@id = 'DynamicTabs']//*[@class = 'v-card__text text-center']/child::button[1]")
    public static Button dynamicTabsRemoveButton;

    @UI("//div[@id = 'DynamicTabs']//*[@class = 'v-card__text text-center']/child::button[2]")
    public static Button dynamicTabsAddButton;

    @UI("//div[@id = 'OverflowMenuTabs']//*[@class = 'v-tabs-slider-wrapper']/following-sibling::a")
    public static Tabs overflowToMenuTabs;

    @UI("//div[@id = 'OverflowMenuTabs']//*[@class = 'v-tabs-slider-wrapper']/following-sibling::button")
    public static Button overflowToMenuTabsMenuButton;

    @UI("//*[@class = 'v-list grey lighten-3 v-sheet theme--light']/child::div")
    public static Tabs overflowToMenuTabsMenuElements;

    @UI("//div[@id = 'TabItemsTabs']//*[@class = 'v-tabs-slider-wrapper']/following-sibling::div")
    public static Tabs tabItemsTabs;
}

