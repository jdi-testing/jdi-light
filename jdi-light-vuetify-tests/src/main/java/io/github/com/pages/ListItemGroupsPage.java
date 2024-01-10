package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.VueCheckbox;
import com.epam.jdi.light.vuetify.elements.complex.ListItemGroup;

import java.util.List;

public class ListItemGroupsPage extends VuetifyPage {

    @UI("#ActiveClassListItemGroup .v-list-item-group")
    public static ListItemGroup activeClassListItemGroup;

    @UI("#MandatoryListItemGroup .v-list-item-group")
    public static ListItemGroup mandatoryListItemGroup;

    @UI("#MultipleListItemGroup .v-list-item-group")
    public static ListItemGroup multipleListItemGroup;

    @UI("#FlatListListItemGroup .v-list-item-group")
    public static ListItemGroup flatListItemGroup;

    @UI("#SelectionControlsListItemGroup .v-list-item-group")
    public static ListItemGroup selectionControlsListItemGroup;

    @UI("#SelectionControlsListItemGroup div[role='option']")
    public static List<VueCheckbox> selectionControlsListItemGroupCheckbox;

    @UI("#WithSubgroupListItemGroup .v-list-item-group")
    public static ListItemGroup withSubgroupListItemGroup;
}
