package com.epam.jdi.light.elements.complex;

import com.epam.jdi.light.elements.base.BaseElement;
import com.epam.jdi.light.elements.interfaces.INamed;

import java.util.List;

public interface ISelector extends BaseElement, INamed {
    boolean selected(String option);
    List<String> checked();
    List<String> values();
    List<String> listEnabled();
    List<String> listDisabled();
    WebList allUI(Object... args);
}
