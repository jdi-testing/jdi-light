package com.epam.jdi.light.material.interfaces.inputs;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.material.elements.inputs.Adornment;

public interface HasAdornment extends ICoreElement {
    default Adornment adornment() {
        return new Adornment().setCore(Adornment.class, find(".MuiInputAdornment-root"));
    }
}
