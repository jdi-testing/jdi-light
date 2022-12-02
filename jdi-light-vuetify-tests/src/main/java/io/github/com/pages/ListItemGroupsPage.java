package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Checkbox;
import com.epam.jdi.light.vuetify.elements.complex.ListItemGroups;

import java.util.List;

public class ListItemGroupsPage extends VuetifyPage {

    @UI("#ActiveClassListItemGroup .v-list-item")
    public static List<ListItemGroups> activeClassListItemGroup;

    @UI("#MandatoryListItemGroup .v-list-item")
    public static List<ListItemGroups> mandatoryListItemGroup;

    @UI("#MultipleListItemGroup .v-list-item")
    public static List<ListItemGroups> multipleListItemGroup;

    @UI("#FlatListListItemGroup .v-list-item")
    public static List<ListItemGroups> flatListItemGroup;

    @UI("#SelectionControlsListItemGroup .v-list-item")
    public static List<ListItemGroups> selectionControlsListItemGroup;

    @UI("#SelectionControlsListItemGroup div[role='option']")
    public static List<Checkbox> selectionControlsListItemGroupCheckbox;

    @UI("#WithSubgroupListItemGroup .v-list-item,#WithSubgroupListItemGroup .v-list-group")
    public static List<ListItemGroups> withSubgroupListItemGroup;
}
