package com.epam.jdi.light.angular.elements.complex.radiobuttons;

import com.epam.jdi.light.angular.asserts.radiobuttons.RadioGroupAssert;
import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import java.util.List;
import java.util.stream.Collectors;

/**
 * To see an example of RadioButtons web element please visit https://material.angular.io/components/radio/overview.
 */

public class RadioGroup extends UIListBase<UISelectAssert<RadioGroupAssert, RadioGroup>> {

    @JDIAction("Click '{name}' radio button with value '{0}'")
    public void click(String value) {
        getRadioButtonByValue(value).click();
    }

    @JDIAction("'{name}' radio button  with value '{0}' is checked")
    public boolean isChecked(String value) {
        return getRadioButtonByValue(value).isChecked();
    }

    @JDIAction("Get radio-button by value '{0}'")
    public RadioButton getRadioButtonByValue(String value) {
        return radioButtons().stream()
                             .filter(radioButton -> radioButton.value().equalsIgnoreCase(value))
                             .findFirst()
                             .orElse(null);
    }
    @JDIAction("Get '{name}' checked radio-button")
    public RadioButton getCheckedRadioButton() {
        return radioButtons().stream()
                             .filter(RadioButton::isChecked)
                             .findFirst()
                             .orElse(null);
    }

    public List<RadioButton> radioButtons() {
        return finds("mat-radio-button").stream()
                           .map(e -> new RadioButton().setCore(RadioButton.class, e))
                           .collect(Collectors.toList());
    }

    @JDIAction("'{name}' label is in before position")
    public boolean isGroupBeforePosition() {
        return core().attr("labelposition").equalsIgnoreCase("before");
    }

    @Override
    @JDIAction("'{name}' is disabled")
    public boolean isDisabled() {
        return core().hasAttribute("disabled");
    }

    @Override
    @JDIAction("'{name}' is enabled")
    public boolean isEnabled() { return  core().hasAttribute("enabled"); }

    @JDIAction("'{name}' is required")
    public boolean isRequired() {
        return core().hasAttribute("required");
    }

    @Override
    public RadioGroupAssert is() {
        return new RadioGroupAssert().set(this);
    }

    @Override
    public RadioGroupAssert has() {
        return is();
    }
}
