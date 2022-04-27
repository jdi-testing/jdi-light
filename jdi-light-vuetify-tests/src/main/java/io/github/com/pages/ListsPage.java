package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Checkbox;
import com.epam.jdi.light.vuetify.elements.common.Subheader;
import com.epam.jdi.light.vuetify.elements.complex.VuetifyList;
import java.util.List;

public class ListsPage extends VuetifyPage {

    @UI("#DenseList .v-list-item")
    public static VuetifyList denseList;

    @UI("#DisabledList .v-list-item")
    public static VuetifyList disabledList;

    @UI("#FlatList .v-list-item")
    public static VuetifyList flatList;

    @UI("#NavList .v-list--dense .v-list-item")
    public static VuetifyList navList;

    @UI("#RoundedList .v-list-item")
    public static VuetifyList roundedList;

    @UI("#ShapedList .v-list-item")
    public static VuetifyList shapedList;

    @UI("#SubGroupList .v-list-group__items .v-list-group")
    public static VuetifyList subGroupList;

    @UI("#ThreeLineList .v-list-item")
    public static VuetifyList threeLineList;

    @UI("#TwoLinesAndSubheaderList .v-list-item")
    public static VuetifyList twoLinesAndSubheaderList;

    @UI("#TwoLinesAndSubheaderList .v-subheader")
    public static List<Subheader> twoLinesAndSubheaderListSubheader;

    @UI("#ExpansionListsList .v-list-group--no-action")
    public static VuetifyList expansionListsList;

    @UI("#ActionAndItemGroupsList .v-list-item")
    public static VuetifyList actionAndItemGroupsList;

    @UI("#ActionAndItemGroupsList div[role='option']")
    public static List<Checkbox> actionAndItemGroupsListCheckbox;

    @UI("#ActionStackList .v-list-item")
    public static VuetifyList actionStackList;

    @UI("#CardListList .v-list-item")
    public static VuetifyList cardListList;

    @UI("#SimpleAvatarListList .v-list-item")
    public static VuetifyList simpleAvatarListList;

    @UI("#SingleLineListList .v-list-item")
    public static VuetifyList singleLineListList;

    @UI("#SubheadingsAndDividersList .v-list-item")
    public static VuetifyList subheadingsAndDividersList;

    @UI("#SubheadingsAndDividersList div[role='option']")
    public static List<Checkbox> subheadingsAndDividersListCheckbox;
}
