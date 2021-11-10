package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.complex.DropdownAssert;
import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.vuetify.elements.complex.Select;

public class SelectAssert extends DropdownAssert {


    public SelectAssert one() {
        return this;
    }

    public SelectAssert two() {
        return this;
    }


    @Override
    public Select element() {
        return (Select) super.element();
    }

}
