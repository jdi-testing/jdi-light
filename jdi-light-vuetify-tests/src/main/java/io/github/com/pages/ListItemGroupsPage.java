package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Checkbox;
import com.epam.jdi.light.vuetify.elements.complex.ListItemGroups;
import java.util.List;

public class ListItemGroupsPage extends VuetifyPage {

    @UI("#ActiveClassListItemGroup .v-list-item")
    public static ListItemGroups activeClassListItemGroup;

    @UI("#MandatoryListItemGroup .v-list-item")
    public static ListItemGroups mandatoryListItemGroup;

    @UI("#MultipleListItemGroup .v-list-item")
    public static ListItemGroups multipleListItemGroup;

    @UI("#FlatListListItemGroup .v-list-item")
    public static ListItemGroups flatListListItemGroup;

    @UI("#SelectionControlsListItemGroup .v-list-item")
    public static ListItemGroups selectionControlsListItemGroup;

    @UI("#SelectionControlsListItemGroup div[role='option']")
    public static List<Checkbox> selectionControlsListItemGroupCheckbox;

}
