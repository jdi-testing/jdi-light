package io.github.com.pages.sections;

import com.epam.jdi.light.angular.elements.common.Checkbox;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class CheckboxSection {

    @UI("#basic-checkbox")
    public static Checkbox basicCheckbox;

    @UI("#checked-checkbox")
    public static Checkbox checkedCheckbox;

    @UI("#checked-checkbox")
    public static Checkbox indeterminateCheckbox;

    @UI("#disabled-checkbox")
    public static Checkbox disabledCheckbox;

    @UI("#result-checkbox")
    public static Checkbox resultCheckbox;

    @UI("#align-before-radio-button")
    public static Button alignBeforeRadioButton;

    @UI("#align-after-radio-button")
    public static Button alignAfterRadioButton;
}
