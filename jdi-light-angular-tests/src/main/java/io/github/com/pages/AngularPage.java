package io.github.com.pages;

import com.epam.jdi.light.angular.elements.common.ProgressSpinner;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import io.github.com.pages.sections.*;

public class AngularPage extends WebPage {
    @Css("radio-overview-example .mat-radio-group")
    public static RadioButtons basicRadioButtons;

    @UI("#radio-option-one")
    public static Button firstBasicRadioButton;

    @UI("#radio-option-two")
    public static Button secondBasicRadioButton;

    @UI("#basic_progress_spinner")
    public static ProgressSpinner basicProgressSpinner;

    @UI("#basic_icon")
    public static Icon basicIcon;

    @UI("#svg_icon")
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
    public static ButtonToggleSection buttonToggleSection;
}
