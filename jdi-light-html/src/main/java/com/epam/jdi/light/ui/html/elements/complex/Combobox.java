package com.epam.jdi.light.ui.html.elements.complex;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.HasInput;
import com.epam.jdi.light.elements.interfaces.HasPlaceholder;

// Implements TextField + Droplist
// https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_datalist
public class Combobox extends Dropdown
        implements HasPlaceholder, HasInput {
    @Override
    public UIElement core() {
        if (value != null)
            return value;
        return super.core();
    }
}
