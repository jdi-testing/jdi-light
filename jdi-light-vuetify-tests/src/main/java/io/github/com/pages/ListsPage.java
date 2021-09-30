package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Checkbox;
import com.epam.jdi.light.vuetify.elements.common.Subheader;
import com.epam.jdi.light.vuetify.elements.complex.Lists;
import java.util.List;

public class ListsPage extends VuetifyPage {

    @UI("#DenseList .v-list-item")
    public static Lists denseList;

    @UI("#DisabledList .v-list-item")
    public static Lists disabledList;

    @UI("#FlatList .v-list-item")
    public static Lists flatList;

    @UI("#NavList .v-list--dense .v-list-item")
    public static Lists navList;

    @UI("#RoundedList .v-list-item")
    public static Lists roundedList;

    @UI("#ShapedList .v-list-item")
    public static Lists shapedList;

    @UI("#SubGroupList .v-list-group__items .v-list-group")
    public static Lists subGroupList;

    @UI("#ThreeLineList .v-list-item")
    public static Lists threeLineList;

    @UI("#TwoLinesAndSubheaderList .v-list-item")
    public static Lists twoLinesAndSubheaderList;

    @UI("#TwoLinesAndSubheaderList .v-subheader")
    public static List<Subheader> twoLinesAndSubheaderListSubheader;

    @UI("#ExpansionListsList .v-list-group--no-action")
    public static Lists expansionListsList;

    @UI("#ActionAndItemGroupsList .v-list-item")
    public static Lists actionAndItemGroupsList;

    @UI("#ActionAndItemGroupsList .v-item-group div[role='option']")
    public static List<Checkbox> actionAndItemGroupsListCheckbox;

    @UI("#ActionStackList .v-list-item")
    public static Lists actionStackList;

    @UI("#CardListList .v-list-item")
    public static Lists cardListList;

    @UI("#SimpleAvatarListList .v-list-item")
    public static Lists simpleAvatarListList;

    @UI("#SingleLineListList .v-list-item")
    public static Lists singleLineListList;

    @UI("#SubheadingsAndDividersList .v-list-item")
    public static Lists subheadingsAndDividersList;

    @UI("#SubheadingsAndDividersList .v-item-group div[role='option']")
    public static List<Checkbox> subheadingsAndDividersListCheckbox;
}
