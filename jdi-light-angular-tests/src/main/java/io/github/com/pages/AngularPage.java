package io.github.com.pages;

import com.epam.jdi.angular.elements.common.ProgressSpinner;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import io.github.com.pages.sections.CheckboxSection;
import io.github.com.pages.sections.InputSection;
import io.github.com.pages.sections.SlideToggleSection;
import io.github.com.pages.sections.ToolbarSection;

public class AngularPage extends WebPage {

    @Css("radio-overview-example .mat-radio-group")
    public static RadioButtons basicRadioButtons;

    @UI("#mat-radio-2")
    public static Button firstBasicRadioButton;

    @UI("#mat-radio-3")
    public static Button secondBasicRadioButton;

    @UI("#basic_progress_spinner")
    public static ProgressSpinner basicProgressSpinner;

    @UI("#basic_icon")
    public static Icon basicIcon;

    @UI("#svg_icon")
    public static Icon svgIcon;

    public static CheckboxSection checkboxSection;
    public static ToolbarSection toolbarSection;
    public static SlideToggleSection slideToggleSection;
    public static InputSection inputSection;
}
