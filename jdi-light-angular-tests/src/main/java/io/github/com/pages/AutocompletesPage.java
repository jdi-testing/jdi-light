package io.github.com.pages;

import com.epam.jdi.light.angular.elements.common.Button;
import com.epam.jdi.light.angular.elements.common.SlideToggle;
import com.epam.jdi.light.angular.elements.complex.AutoComplete;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

import java.util.List;

import static com.jdiai.tools.Timer.waitCondition;

public class AutocompletesPage extends NewAngularPage {

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
