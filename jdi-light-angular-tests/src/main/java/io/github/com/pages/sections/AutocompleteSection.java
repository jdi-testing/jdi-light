package io.github.com.pages.sections;

import com.epam.jdi.angular.elements.common.*;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.*;

public class AutocompleteSection {
    @UI("#mat-input-0")
    public AutoComplete autocompleteOverview;

    @UI("#mat-slide-toggle-3-input")
    public SlideToggle autocompleteDisableInput;

    @UI("#mat-input-1")
    public AutoComplete simpleAutocomplete;

    @UI("#mat-input-2")
    public AutoComplete displayValueAutocomplete;

    @UI("#mat-input-3")
    public AutoComplete filterAutocomplete;

    @UI("#mat-input-4")
    public AutoComplete optionGroupsAutocomplete;

    @UI("#autocomplete_firstoption")
    public AutoComplete autocompleteFirstOptionHighlighted;

}
