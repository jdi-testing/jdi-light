package io.github.com.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.VuetifyTabs;

public class TabsPage extends VuetifyPage {

    @UI("#AlignTitleTabs")
    public static VuetifyTabs alignWithTitleTabs;

    @UI("#CenterActiveTabs")
    public static VuetifyTabs centerActiveTabs;

    @UI("#CustomIconsTabs")
    public static VuetifyTabs customIconsTabs;

    @UI("#FixedTabs")
    public static VuetifyTabs fixedTabs;

    @UI("#GrowTabs")
    public static VuetifyTabs growTabs;

    @UI("#IconsTextTabs")
    public static VuetifyTabs iconAndTextTabs;

    @UI("#PaginationTabs")
    public static VuetifyTabs paginationTabs;

    @UI("#RightTabs")
    public static VuetifyTabs rightTabs;

    @UI("#VerticalTabs")
    public static VuetifyTabs verticalTabs;

    @UI("#ContentTabs")
    public static VuetifyTabs contentTabs;

    @UI("#DesktopTabs")
    public static VuetifyTabs desktopTabs;

    @UI("#DesktopTabs .v-window__container")
    public static UIElement desktopTabsContainer;

    @UI("#DynamicHeightTabs")
    public static VuetifyTabs dynamicHeightTabs;

    @UI("#DynamicTabs")
    public static VuetifyTabs dynamicTabs;

    @UI("#OverflowMenuTabs")
    public static VuetifyTabs overflowToMenuTabs;

    @UI("#TabItemsTabs")
    public static VuetifyTabs tabItemsTabs;
}

