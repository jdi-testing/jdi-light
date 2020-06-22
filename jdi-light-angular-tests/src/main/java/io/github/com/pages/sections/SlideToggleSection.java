package io.github.com.pages.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import com.epam.jdi.angular.elements.common.Checkbox;
import com.epam.jdi.angular.elements.common.SlideToggle;

public class SlideToggleSection extends Section {

    @UI("#slide-toggles-basic")
    public SlideToggle basicSlideToggle;

    @UI("#slide-toggles-configured")
    public SlideToggle resultSlideToggle;

    @UI("#slide-toggles-set_checked_checkbox")
    public Checkbox checkedCheckbox;

    @UI("#slide-toggles-set_disabled_checkbox")
    public Checkbox disableCheckbox;

    @Css("#slide-toggles-colors_radio_buttons")
    public RadioButtons colorRadioButtons;

    @UI("#slide-toggles-set_primary_color_radio")
    public Button primaryRadioButton;

    @UI("#slide-toggles-set_accent_color_radio")
    public Button accentRadioButton;

    @UI("#slide-toggles-set_warn_color_radio")
    public Button warningRadioButton;
}
