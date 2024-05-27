package io.github.com.custom.elements;

import com.epam.jdi.light.angular.elements.complex.AutoComplete;
import com.epam.jdi.light.angular.elements.complex.ChipGroup;
import com.epam.jdi.light.common.JDIAction;

public class ChipGroupWithAutocomlete extends ChipGroup {

    @JDIAction("Get '{name}' input field")
    public AutoComplete inputField() {
        return new AutoComplete().setCore(AutoComplete.class, core().find("input"));
    }
}
