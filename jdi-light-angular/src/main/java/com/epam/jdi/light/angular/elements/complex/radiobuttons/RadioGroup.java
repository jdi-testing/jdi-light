package com.epam.jdi.light.angular.elements.complex.radiobuttons;

import com.epam.jdi.light.angular.asserts.radiobuttons.RadioGroupAssert;
import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @JDIAction("Get radio button by value '{0}'")
    public RadioButton getRadioButtonByValue(String value) {
        return radioButtonStream()
                             .filter(radioButton -> radioButton.value().equalsIgnoreCase(value))
                             .findFirst()
                             .orElse(null);
    }

    @JDIAction("Get radio button by label '{0}'")
    public RadioButton getRadioButtonByLabel(String value) {
        return radioButtonStream()
                .filter(radioButton -> radioButton.labelText().equalsIgnoreCase(value))
                .findFirst()
                .orElse(null);
    }

    @JDIAction("Get '{name}' checked radio button")
    public RadioButton checkedRadioButton() {
        return radioButtonStream()
                             .filter(RadioButton::isChecked)
                             .findFirst()
                             .orElse(null);
    }

    @JDIAction("Get inner radio buttons list from {name}")
    public List<RadioButton> radioButtons() {
        return radioButtonStream().collect(Collectors.toList());
    }

    @JDIAction("'{name}' labels are in before position")
    public boolean isLabelsBeforePosition() {
        return core().attr("labelposition").equalsIgnoreCase("before");
    }

    @Override
    @JDIAction("'{name}' is disabled")
    public boolean isDisabled() {
        return core().hasAttribute("disabled");
    }

    @Override
    @JDIAction("'{name}' is enabled")
    public boolean isEnabled() {
        return !isDisabled();
    }

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

    protected Stream<RadioButton> radioButtonStream() {
        return finds("mat-radio-button").stream()
                .map(e -> new RadioButton().setCore(RadioButton.class, e));
    }
}
