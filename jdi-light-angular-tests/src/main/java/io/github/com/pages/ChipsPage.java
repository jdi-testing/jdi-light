package io.github.com.pages;

import com.epam.jdi.light.angular.elements.complex.ChipGroup;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;
import io.github.com.custom.elements.ChipGroupWithAutocomlete;

public class ChipsPage extends NewAngularPage {

    @UI("#basic-chips-row")
    public static ChipGroup basicChips;

    @UI("#stacked-chips-list")
    public static ChipGroup stackedChips;

    @UI("#chips-autocomplete-field")
    public static ChipGroupWithAutocomlete autocompleteChips;

    @UI("#chips-with-input-field")
    public static ChipGroupWithAutocomlete inputChips;

    @UI("#chips-with-form-control")
    public static ChipGroup formControlChips;

    @UI("#chips-drag-and-drop")
    public static ChipGroup dragAndDropChips;

    @UI("#chips-avatar")
    public static ChipGroup avatarChips;

    @UI("#chips-disabled-ripple")
    public static ChipGroup disabledRippleChips;

    @UI("#chips-enabled-ripple")
    public static ChipGroup enabledRippleChips;

    @UI("#chips-disabled")
    public static ChipGroup disabledChips;

    @UI("#chips-highlighted")
    public static ChipGroup highlightedChips;

    @UI("#multiple-chips")
    public static ChipGroup multipleChips;

    @UI("#chips-with-error-state")
    public static ChipGroupWithAutocomlete errorChips;

    @UI("#basic-chips-label")
    public static Text basicSelectedValue;

    @UI("#stacked-chips-label")
    public static Text stackedSelectedValue;

}
