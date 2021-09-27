package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Chip;

import java.util.List;

public class ChipsPage extends VuetifyPage {

    @UI("#ClosableChip > .v-chip")
    public static List<Chip> closableChips;

    @UI("#ColoredChip > .v-chip")
    public static List<Chip> coloredChips;

    @UI("#DraggableChip > .v-chip")
    public static Chip draggableChip;

    @UI("#FilterChip > .v-chip")
    public static List<Chip> filterChips;

    @UI("#LabelChip > .v-chip")
    public static List<Chip> labelChips;

    @UI("#NoRippleChip > .v-chip")
    public static Chip noRippleChip;

    @UI("#OutlinedChip > .v-chip")
    public static List<Chip> outlinedChips;

    @UI("#SizesChip > .v-chip")
    public static List<Chip> sizesChips;

    @UI("#ActionChip > .v-chip")
    public static List<Chip> actionChips;

    @UI("#IconChip > .v-chip")
    public static List<Chip> iconChips;

    @UI("#CustomListChip > .v-chip")
    public static List<Chip> customListChips;

    @UI("#ExpandableChip > .v-chip")
    public static Chip expandableChip;

    @UI("#FilteringChip > .v-chip")
    public static List<Chip> filteringChips;

    @UI("[role=combobox] .v-chip")
    public static List<Chip> inSelectsChips;
}
