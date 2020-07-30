package io.github.com.pages.sections;

import com.epam.jdi.light.angular.elements.common.Checkbox;
import com.epam.jdi.light.angular.elements.common.SlideToggle;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;

public class SlideToggleSection extends Section {

    @UI("#slide-toggles-basic")
    public static SlideToggle basicSlideToggle;

    @UI("#slide-toggles-configured")
    public static SlideToggle resultSlideToggle;

    @UI("#slide-toggles-set_checked_checkbox")
    public static Checkbox checkedCheckbox;

    @UI("#slide-toggles-set_disabled_checkbox")
    public static Checkbox disableCheckbox;

    @Css("#slide-toggles-colors_radio_buttons")
    public static RadioButtons colorRadioButtons;

    @UI("#slide-toggles-set_primary_color_radio")
    public static Button primaryRadioButton;

    @UI("#slide-toggles-set_accent_color_radio")
    public static Button accentRadioButton;

    @UI("#slide-toggles-set_warn_color_radio")
    public static Button warningRadioButton;
}
