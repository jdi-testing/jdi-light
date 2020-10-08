package io.github.com.pages.sections;

import com.epam.jdi.light.angular.elements.complex.Chips;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class ChipsSection extends Section {

    public static Chips chips;

    @UI("#mat-chip-list-0")
    public static Chips basicChipsRow;

    @UI("#mat-chip-list-1")
    public static Chips stackedChipsList;

    @UI("#basic-chips-label")
    public static Text basicSelectedValue;

    @UI("#stacked-chips-label")
    public static Text stackedSelectedValue;

    @UI("#chips-autocomplete-field")
    public static Chips chipsAutocompleteField;

    @UI("#mat-chip-list-input-0")
    public static Chips chipsAutocompleteInput;

    @UI("#mat-chip-list-2")
    public static Chips autocompleteChipsList;

    @UI("#chips-with-input-field")
    public static Chips chipsWithInputField;

    @UI("#mat-chip-list-input-1")
    public static Chips chipsWithInputInput;

    @UI("#mat-chip-list-3")
    public static Chips chipsWithInputList;

}