package io.github.com.pages.sections;

import com.epam.jdi.light.angular.elements.common.*;
import com.epam.jdi.light.angular.elements.complex.*;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.*;

public class AutocompleteSection {
    @UI("#autocomplete-overview-input")
    public AutoComplete autocompleteOverview;

    @UI("#autocomplete-overview-slide-toggle")
    public SlideToggle autocompleteDisableInput;

    @UI("#autocomplete-simple-input")
    public AutoComplete simpleAutocomplete;

    @UI("#autocomplete-display-value-input")
    public AutoComplete displayValueAutocomplete;

    @UI("#autocomplete-filter-input")
    public AutoComplete filterAutocomplete;

    @UI("#autocomplete-grouped-options-input")
    public AutoComplete optionGroupsAutocomplete;

    @UI("#autocomplete-first-option-highlighted-input")
    public AutoComplete autocompleteFirstOptionHighlighted;

}
