package com.epam.jdi.light.vuetify.elements.composite;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.vuetify.asserts.FormsAssert;

/**
 * To see an example of Forms web element please visit https://vuetifyjs.com/en/components/forms
 */

public abstract class Forms extends Section {

    public abstract boolean validate();

    public abstract boolean isClear();

    @Override
    public FormsAssert is() {
        FormsAssert formsAssert = new FormsAssert();
        formsAssert.set(this);
        return formsAssert;
    }
}
