package com.epam.jdi.light.elements.complex;

import com.epam.jdi.light.asserts.complex.DropdownAssert;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.interfaces.complex.IsCombobox;

import static com.epam.jdi.light.common.Exceptions.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
// Implements TextField + Droplist
// https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_datalist
public class Combobox extends UIListBase<DropdownAssert> implements IsCombobox {
    public boolean isExpanded() { throw exception("isExpanded can not be used with this element"); }
    @Override
    public DropdownAssert is() {
        return new DropdownAssert().set(this);
    }
}
