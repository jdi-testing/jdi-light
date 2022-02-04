package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.ItemGroup;
import io.github.com.custom.itemGroups.PrimaryItemGroup;
import io.github.com.custom.itemGroups.SelectionItemGroup;

public class ItemGroupsPage extends VuetifyPage {

    @UI("#ActiveClassItemGroup .v-card")
    public static PrimaryItemGroup activeClassItemGroup;

    @UI("#MandatoryItemGroup .v-card")
    public static ItemGroup mandatoryItemGroup;

    @UI("#SelectionItemGroup .v-image")
    public static SelectionItemGroup selectionItemGroup;
}
