package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.composite.VuetifyList;

import java.util.List;

public class ListsPage extends VuetifyPage {

    @UI("#DenseList .v-list")
    public static VuetifyList denseList;

    @UI("#DisabledList .v-list")
    public static VuetifyList disabledList;

    @UI("#FlatList .v-list")
    public static VuetifyList flatList;

    @UI("#DarkList .v-list")
    public static VuetifyList darkList;

    @UI("#ElevatedList .v-list")
    public static List<VuetifyList> elevatedLists;

    @UI("#NavList .v-list")
    public static VuetifyList navList;

    @UI("#RoundedList .v-list")
    public static VuetifyList roundedList;

    @UI("#ShapedList .v-list")
    public static VuetifyList shapedList;

    @UI("#SubGroupList .v-list")
    public static VuetifyList subGroupList;

    @UI("#ThreeLineList .v-list")
    public static VuetifyList threeLineList;

    @UI("#TwoLinesAndSubheaderList .v-list")
    public static VuetifyList twoLinesAndSubheaderList;

    @UI("#ActionAndItemGroupsList .v-list[2]")
    public static VuetifyList actionAndItemGroupsGeneralList;

    @UI("#ActionStackList .v-list")
    public static VuetifyList actionStackList;
}
