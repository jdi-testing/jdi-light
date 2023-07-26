package io.github.com.pages;

import com.epam.jdi.light.angular.elements.complex.Chips;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class ChipsPage extends NewAngularPage{
    //TODO remove unused fields

    @UI("#basic-chips-row")
    public static Chips basicChipsRow;

    @UI("#stacked-chips-list")
    public static Chips stackedChipsList;

    @UI("#basic-chips-label")
    public static Text basicSelectedValue;

    @UI("#stacked-chips-label")
    public static Text stackedSelectedValue;

    @UI("#chips-autocomplete-field")
    public static Chips chipsAutocompleteField;

    @UI("#mat-mdc-chip-list-input-0")
    public static Chips chipsAutocompleteInput;

    @UI("#mat-chip-list-2")
    public static Chips autocompleteChipsList;

    @UI("#chips-with-input-field")
    public static Chips chipsWithInputField;

    @UI("#mat-mdc-chip-list-input-1")
    public static Chips chipsWithInputInput;

    @UI("#mat-chip-list-3")
    public static Chips chipsWithInputList;

    @UI("#chips-disabled")
    public static Chips chipsDisabled;

    @UI("#chips-highlighted")
    public static Chips chipsHighlighted;
}
