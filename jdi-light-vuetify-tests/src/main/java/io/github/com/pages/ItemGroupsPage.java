package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;
import com.epam.jdi.light.vuetify.elements.complex.ItemGroup;
import com.epam.jdi.light.vuetify.elements.complex.TextArea;
import com.epam.jdi.light.vuetify.elements.complex.TextField;
import io.github.com.custom.itemGroups.PrimaryItemGroup;
import io.github.com.custom.itemGroups.SelectionItemGroup;

public class ItemGroupsPage extends VuetifyPage {

    /**
     * @todo #5298 v-card is locator for the Card class, so wrong logic is used
     */

    @UI("#ActiveClassItemGroup .v-card")
    public static PrimaryItemGroup activeClassItemGroup;

    @UI("#MandatoryItemGroup .v-card")
    public static ItemGroup mandatoryItemGroup;

    @UI("#MultipleItemGroup .v-card")
    public static ItemGroup multipleItemGroup;

    @UI("#ChipsItemGroup .v-text-field")
    public static TextField textField;

    @UI("#ChipsItemGroup .v-textarea")
    public static TextArea textArea;

    @UI("#ChipsItemGroup .v-chip")
    public static ItemGroup chipsItemGroup;

    @UI("#ChipsItemGroup button")
    public static VuetifyButton button;

    @UI("#SelectionItemGroup .v-image")
    public static SelectionItemGroup selectionItemGroup;
}
