package io.github.com.pages;

import com.epam.jdi.light.angular.elements.common.*;
import com.epam.jdi.light.elements.composite.*;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.*;
import com.epam.jdi.light.ui.html.elements.common.*;
import com.epam.jdi.light.ui.html.elements.complex.*;
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

    public static CheckboxSection checkboxSection;
    public static SlideToggleSection slideToggleSection;
    public static InputSection inputSection;
    public static AutocompleteSection autocompleteSection;
}
