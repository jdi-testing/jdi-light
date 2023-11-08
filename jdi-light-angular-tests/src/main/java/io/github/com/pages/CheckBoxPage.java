package io.github.com.pages;

import com.epam.jdi.light.angular.elements.common.Checkbox;
import com.epam.jdi.light.angular.elements.complex.RadioButtons;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class CheckBoxPage extends NewAngularPage {
    @UI("#basic-checkbox")
    public static Checkbox basicCheckbox;

    @UI("#indeterminate-checkbox")
    public static Checkbox indeterminateCheckbox;

    @UI("#disabled-checkbox")
    public static Checkbox disabledCheckbox;

    @UI("#result-checkbox")
    public static Checkbox resultCheckbox;

    @UI(".mat-mdc-radio-group")
    public static RadioButtons modeRadioGroup;

    @UI("#checkbox-color1")
    public static Checkbox primaryColorCheckbox;

    @UI("#checkbox-color2")
    public static Checkbox accentColorCheckbox;

    @UI("#checkbox-color3")
    public static Checkbox warnColorCheckbox;

    @UI("#checkbox-required-option")
    public static Checkbox requiredCheckbox;

    @UI("//*[@class='error']")
    public static Text requiredCheckboxText;

}
