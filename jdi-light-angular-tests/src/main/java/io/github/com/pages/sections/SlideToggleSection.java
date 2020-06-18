package io.github.com.pages.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import com.epam.jdi.angular.elements.common.Checkbox;
import com.epam.jdi.angular.elements.common.SlideToggle;

public class SlideToggleSection extends Section {

    @UI("#mat-slide-toggle-1")
    public static SlideToggle basicSlideToggle;

    @UI("#mat-slide-toggle-2")
    public static SlideToggle resultSlideToggle;

    @UI("#mat-checkbox-6")
    public static Checkbox checkedCheckbox;

    @UI("#mat-checkbox-7")
    public static Checkbox disableCheckbox;

    @Css(".example-section .mat-radio-group")
    public static RadioButtons colorRadioButtons;

    @UI("#mat-radio-13")
    public static Button primaryRadioButton;

    @UI("#mat-radio-14")
    public static Button accentRadioButton;

    @UI("#mat-radio-15")
    public static Button warningRadioButton;
}
