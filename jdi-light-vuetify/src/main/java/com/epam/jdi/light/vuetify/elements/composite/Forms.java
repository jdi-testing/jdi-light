package com.epam.jdi.light.vuetify.elements.composite;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.vuetify.asserts.FormsAssert;

public class Forms extends Section {

    public boolean validate() {
        return false;
    }

    public boolean isClear() {
        return false;
    }

    @Override
    public FormsAssert is() {
        FormsAssert formsAssert = new FormsAssert();
        formsAssert.set(this);
        return formsAssert;
    }
}
