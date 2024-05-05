package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.vuetify.elements.complex.VueTabs;

public class TabsPage extends VuetifyPage {

    @UI("#AlignTitleTabs .v-tabs")
    public static VueTabs alignWithTitleTabs;

    @UI("#CenterActiveTabs .v-tabs")
    public static VueTabs centerActiveTabs;

    @UI("#CustomIconsTabs .v-tabs")
    public static VueTabs customIconsTabs;

    @UI("#FixedTabs .v-tabs")
    public static VueTabs fixedTabs;

    @UI("#GrowTabs .v-tabs")
    public static VueTabs growTabs;

    @UI("#IconsTextTabs .v-tabs")
    public static VueTabs iconAndTextTabs;

    @UI("#PaginationTabs .v-tabs")
    public static VueTabs paginationTabs;

    @UI("#RightTabs .v-tabs")
    public static VueTabs rightTabs;

    @UI("#VerticalTabs .v-tabs")
    public static VueTabs verticalTabs;

    @UI("#ContentTabs .v-tabs")
    public static VueTabs contentTabs;

    @UI("#DynamicTabs .v-tabs")
    public static VueTabs dynamicTabs;

    @UI("#OverflowMenuTabs .v-tabs")
    public static VueTabs overflowToMenuTabs;

    @UI("#DisabledTabs .v-tabs")
    public static VueTabs disabledTabs;

    @UI("#HrefTabs .v-tabs")
    public static VueTabs hrefTabs;

    @UI("//button[./span[contains(text(), 'Add Tab')]]")
    public static Button addButton;

    @UI("//button[./span[contains(text(), 'Remove Tab')]]")
    public static Button removeButton;
}

