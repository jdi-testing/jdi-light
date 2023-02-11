package com.epam.jdi.light.vuetify.elements.complex.tables;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.VueCheckbox;

public class TableCheckbox extends VueCheckbox {

    @Override
    @JDIAction("Check that '{name}' is checked")
    public boolean isChecked() {
        return attr("class").contains("marked");
    }

    @Override
    @JDIAction("Check that '{name}' is unchecked")
    public boolean isUnchecked() {
        return !isChecked();
    }
}
