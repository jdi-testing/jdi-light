package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.composite.VuetifyList;

public class ListsPage extends VuetifyPage {

    @UI("#DenseList .v-list")
    public static VuetifyList denseList;

    @UI("#DisabledList .v-list")
    public static VuetifyList disabledList;

    @UI("#FlatList .v-list")
    public static VuetifyList flatList;

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

    @UI("#ExpansionListsList .v-list")
    public static VuetifyList expansionListsList;

    @UI("#ActionAndItemGroupsList .v-list[1]")
    public static VuetifyList actionAndItemGroupsControlsList;

    @UI("#ActionAndItemGroupsList .v-list[2]")
    public static VuetifyList actionAndItemGroupsGeneralList;

    @UI("#ActionStackList .v-list")
    public static VuetifyList actionStackList;

    @UI("#CardListList .v-list")
    public static VuetifyList cardListList;

    @UI("#SimpleAvatarListList .v-list")
    public static VuetifyList simpleAvatarListList;

    @UI("#SingleLineListList .v-list[1]")
    public static VuetifyList singleLineRecentChatsList;

    @UI("#SingleLineListList .v-list[2]")
    public static VuetifyList singleLinePreviousChatsList;

    @UI("#SubheadingsAndDividersList .v-list[1]")
    public static VuetifyList subheadingsAndDividersGeneralList;

    @UI("#SubheadingsAndDividersList .v-list[2]")
    public static VuetifyList subheadingsAndDividersNotificationsList;
}
