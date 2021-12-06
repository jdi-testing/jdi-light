package com.epam.jdi.light.material.interfaces.inputs;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.material.elements.inputs.Adornment;

import java.util.List;
import java.util.stream.Collectors;

public interface HasAdornment extends ICoreElement {

    default Adornment adornment() {
        return new Adornment().setCore(Adornment.class, find(".MuiInputAdornment-root"));
    }

    default List<Adornment> adornments() {
        return finds(".MuiInputAdornment-root").stream()
                .map(element -> element.setCore(Adornment.class, element))
                .collect(Collectors.toList());
    }
}
