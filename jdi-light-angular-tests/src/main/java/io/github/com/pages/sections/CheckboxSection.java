package io.github.com.pages.sections;

import com.epam.jdi.light.angular.elements.common.Checkbox;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class CheckboxSection {

    @UI("#checkboxes-basic_checkbox")
    public static Checkbox basicCheckbox;

    @UI("#checkboxes-set_checked_checkbox")
    public static Checkbox configurableCheckedCheckbox;

    @UI("#checkboxes-set_indeterminate_checkbox")
    public static Checkbox configurableIndeterminateCheckbox;

    @UI("#checkboxes-text_before_checkbox_radio")
    public static Button configurableCheckboxAlignBeforeRadioButton;

    @UI("#checkboxes-text_after_checkbox_radio")
    public static Button configurableCheckboxAlignAfterRadioButton;

    @UI("#checkboxes-set_disabled_checkbox")
    public static Checkbox configurableDisabledCheckbox;

    @UI("#checkboxes-configured_checkbox")
    public static Checkbox configurableResultCheckbox;
}
