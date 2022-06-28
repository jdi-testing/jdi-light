package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.complex.Tabs;
import com.epam.jdi.light.vuetify.elements.complex.ChipGroup;

import java.util.List;

public class ChipGroupsPage extends VuetifyPage {

    @UI("#ColumnChipGroup .v-chip-group")
    public static ChipGroup columnChipGroup;

    @UI("#FilterResultsChipGroup .v-chip-group")
    public static List<ChipGroup> filterResultsChipGroup;

    @UI("#MandatoryChipGroup .v-chip-group")
    public static ChipGroup mandatoryChipGroup;

    @UI("#MandatoryChipGroup .v-slide-group__next")
    public static Tabs mandatoryGroupButtonNext;

    @UI("#MandatoryChipGroup .v-slide-group__prev")
    public static Tabs mandatoryGroupButtonBack;

    @UI("#MultipleChipGroup .v-chip-group")
    public static ChipGroup multipleChipGroup;

    @UI("#MultipleChipGroup .v-slide-group__next")
    public static Tabs multipleGroupButtonNext;

    @UI("#MultipleChipGroup .v-slide-group__prev")
    public static Tabs multipleGroupButtonBack;

    @UI("#ProductCardChipGroup .v-chip-group")
    public static ChipGroup productCardChipGroup;
}
