package io.github.com.pages;

import com.epam.jdi.light.angular.elements.common.ProgressSpinner;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import io.github.com.pages.sections.AutocompleteSection;
import io.github.com.pages.sections.BadgeSection;
import io.github.com.pages.sections.BasicButtonsSection;
import io.github.com.pages.sections.ButtonToggleSection;
import io.github.com.pages.sections.CardSection;
import io.github.com.pages.sections.CheckboxSection;
import io.github.com.pages.sections.DatepickerSection;
import io.github.com.pages.sections.DividerSection;
import io.github.com.pages.sections.GridListSection;
import io.github.com.pages.sections.InputSection;
import io.github.com.pages.sections.ListSection;
import io.github.com.pages.sections.PaginatorSection;
import io.github.com.pages.sections.RadioButtonSection;
import io.github.com.pages.sections.SelectSection;
import io.github.com.pages.sections.SlideToggleSection;
import io.github.com.pages.sections.SliderSection;
import io.github.com.pages.sections.SnackbarSection;
import io.github.com.pages.sections.TabGroupSection;
import io.github.com.pages.sections.ToolbarSection;

public class AngularPage extends WebPage {
    @Css("radio-overview-example .mat-radio-group")
    public static RadioButtons basicRadioButtons;

    @UI("#radio-option-one")
    public static Button firstBasicRadioButton;

    @UI("#radio-option-two")
    public static Button secondBasicRadioButton;

    public static ProgressSpinner basicProgressSpinner;
    public static Icon basicIcon;
    public static Icon svgIcon;

    public static RadioButtonSection radioButtonSection;
    public static CheckboxSection checkboxSection;
    public static ToolbarSection toolbarSection;
    public static SlideToggleSection slideToggleSection;
    public static InputSection inputSection;
    public static SelectSection selectSection;
    public static ListSection listSection;
    public static GridListSection gridListSection;
    public static BadgeSection badgeSection;
    public static BasicButtonsSection basicButtonsSection;
    public static AutocompleteSection autocompleteSection;
    public static SnackbarSection snackbarSection;
    public static ButtonToggleSection buttonToggleSection;
    public static PaginatorSection paginatorSection;
    public static TabGroupSection tabsSection;
    public static SliderSection sliderSection;
    public static CardSection cardSection;
    public static DividerSection dividerSection;

    public static TooltipSection tooltipSection;

    public static DatepickerSection datepickerSection;

}
