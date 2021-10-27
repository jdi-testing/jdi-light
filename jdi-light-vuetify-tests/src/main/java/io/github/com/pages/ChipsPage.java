package io.github.com.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import com.epam.jdi.light.vuetify.elements.common.Chip;

import java.util.List;

public class ChipsPage extends VuetifyPage {

    @UI("#ClosableChip > .v-chip")
    public static List<Chip> closableChips;

    @UI("//span[text()[contains(.,'Reset Chips')]]")
    public static Button closableChipsResetButton;

    @UI("#ColoredChip > .v-chip")
    public static List<Chip> coloredChips;

    @UI("//p[text()[contains(., 'Draggable chip')]]")
    public static UIElement draggableChipTitle;

    @UI("#DraggableChip > .v-chip")
    public static Chip draggableChip;

    @UI("//label[text()[contains(., 'Active')]]")
    public static Label filterSwitchLabel;

    @UI("#FilterChip > .v-chip")
    public static List<Chip> filterChips;

    @UI("#OutlinedChip > .v-chip")
    public static List<Chip> outlinedChips;

    @UI("#SizesChip > .v-chip")
    public static List<Chip> sizesChips;

    @UI("#ActionChip .v-chip")
    public static List<Chip> actionChips;

    @UI("#IconChip > .v-chip")
    public static List<Chip> iconChips;

    @UI(".col-12 input[type=text]")
    public static TextField customListSearchField;

    @UI("#CustomListChip [role=listitem]")
    public static WebList customListItems;

    @UI("#CustomListChip .v-chip")
    public static Chip customListChip;

    @UI("//span[text()[contains(.,'Next')]]")
    public static Button customListNextButton;

    @UI("#ExpandableChip .v-chip")
    public static Chip expandableChip;

    @UI(".v-card .v-list-item__subtitle")
    public static List<Text> expandableChipEmails;

    @UI("[role=combobox] .v-chip")
    public static List<Chip> inSelectsChips;
}
