package io.github.com.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;
import com.epam.jdi.light.vuetify.elements.complex.VuetifyTabs;
import java.util.List;

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

    @UI("#VerticalTabs .v-card__text")
    public static Text verticalTabsText;

    @UI("#ContentTabs")
    public static VuetifyTabs contentTabs;

    @UI("#ContentTabs .v-window__container")
    public static UIElement contentTabsContainer;

    @UI("#DesktopTabs")
    public static VuetifyTabs desktopTabs;

    @UI("#DesktopTabs .v-window__container")
    public static UIElement desktopTabsContainer;

    @UI("#DynamicHeightTabs .v-text-field")
    public static TextField dynamicHeightSearch;

    @UI("#DynamicHeightTabs")
    public static VuetifyTabs dynamicHeightTabs;

    @UI("#DynamicTabs")
    public static VuetifyTabs dynamicTabs;

    @UI("#OverflowMenuTabs")
    public static VuetifyTabs overflowToMenuTabs;

    @UI("#TabItemsTabs")
    public static VuetifyTabs tabItemsTabs;

    @UI("button.v-btn--text.theme--light")
    public static List<VuetifyButton> addRemoveButton;
}

