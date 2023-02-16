package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Switch;
import com.epam.jdi.light.vuetify.elements.complex.ChipGroup;

import java.util.List;

public class ChipGroupsPage extends VuetifyPage {

    @UI("#ColumnChipGroup .v-chip-group")
    public static ChipGroup columnChipGroup;

    @UI("#FilterResultsChipGroup .v-chip-group")
    public static List<ChipGroup> filterResultsChipGroup;

    @UI("#MandatoryChipGroup .v-chip-group")
    public static ChipGroup mandatoryChipGroup;

    @UI("#MultipleChipGroup .v-chip-group")
    public static ChipGroup multipleChipGroup;

    @UI(".v-input--switch")
    public static List<Switch> switches;

    @UI("#AdjustableChipGroup .v-chip-group")
    public static ChipGroup adjustableChipGroup;
}
