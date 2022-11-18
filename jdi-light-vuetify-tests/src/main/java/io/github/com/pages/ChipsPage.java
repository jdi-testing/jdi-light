package io.github.com.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Chip;
import com.epam.jdi.light.vuetify.elements.common.Switch;
import io.github.com.custom.CompositeLabelChip;

import java.util.List;

public class ChipsPage extends VuetifyPage {

    @UI("#ClosableChip > .v-chip")
    public static List<Chip> closableChips;

    @UI("#ColoredChip > .v-chip")
    public static List<Chip> coloredChips;

    @UI("#DraggableChip > .v-chip")
    public static Chip draggableChip;

    @UI("//label[text()[contains(., 'Active')]]")
    public static Label filterSwitchLabel;

    @UI("#FilterChip > .v-chip")
    public static List<Chip> filterChips;

    @UI("#LabelChip > .v-chip")
    public static List<Chip> labelChips;

    @UI("#OutlinedChip > .v-chip")
    public static List<Chip> outlinedChips;

    @UI("#SizesChip > .v-chip")
    public static List<Chip> sizesChips;

    @UI("#ActionChip .v-chip")
    public static List<Chip> actionChips;

    @UI("#IconChip > .v-chip")
    public static List<Chip> iconChips;

    @UI("#CustomListChip [role=listitem]")
    public static WebList customListItems;

    @UI("#CustomListChip .v-chip")
    public static List<Chip> customListChipsList;

    @UI("#ExpandableChip .v-chip")
    public static Chip expandableChip;

    @UI("div[role='menu']")
    public static Menu expandableMenu;

    @UI("[role=combobox] .v-chip")
    public static List<CompositeLabelChip> inSelectsChips;

    @UI("#DisabledChip .v-chip")
    public static Chip disabledChip;

    @UI("#DisabledChip .v-input--switch")
    public static Switch disableSwitch;

    @UI("#DarkChip .v-chip")
    public static Chip darkChip;

    @UI("#DarkChip .v-input--switch")
    public static Switch darkSwitch;
}
