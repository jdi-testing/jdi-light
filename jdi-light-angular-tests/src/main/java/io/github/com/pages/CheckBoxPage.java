package io.github.com.pages;

import com.epam.jdi.light.angular.elements.common.Checkbox;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class CheckBoxPage extends NewAngularPage {
    @UI("#basic-checkbox")
    public static Checkbox basicCheckbox;

    @UI("#checked-checkbox")
    static Checkbox checkedCheckbox;

    @UI("#indeterminate-checkbox")
    public static Checkbox indeterminateCheckbox;

    @UI("#disabled-checkbox")
    public static Checkbox disabledCheckbox;

    @UI("#result-checkbox")
    public static Checkbox resultCheckbox;

    @UI("#align-before-radio-button")
    public static Button alignBeforeRadioButton;

    @UI("#align-after-radio-button")
    public static Button alignAfterRadioButton;

    @UI("#checkbox-aria-label")
    public static Checkbox ariaLabelCheckbox;

    @UI("#checkbox-color1")
    public static Checkbox primaryColorCheckbox;

    @UI("#checkbox-color2")
    public static Checkbox accentColorCheckbox;

    @UI("#checkbox-color3")
    public static Checkbox warnColorCheckbox;

    @UI("#checkbox-disable-ripple")
    public static Checkbox disableRippleCheckbox;

    @UI("#checkbox-required-option")
    public static Checkbox requiredCheckbox;

}
