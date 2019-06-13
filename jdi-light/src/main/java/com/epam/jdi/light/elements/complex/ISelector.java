package com.epam.jdi.light.elements.complex;

import com.epam.jdi.light.elements.base.IBaseElement;
import com.epam.jdi.light.elements.interfaces.INamed;

import java.util.List;

public interface ISelector extends IBaseElement, INamed, IHasSize {
    boolean selected(String option);
    List<String> values();
    List<String> innerValues();
    List<String> listEnabled();
    List<String> listDisabled();
}
