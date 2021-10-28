package com.epam.jdi.light.vuetify.elements.composite;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.vuetify.asserts.FormsAssert;

public class Forms extends Section {

    public boolean validate() {
        return true;
    }

    @Override
    public FormsAssert is() {
        FormsAssert  formsAssert = new FormsAssert();
        formsAssert.set(this);
        return formsAssert;
    }
}
