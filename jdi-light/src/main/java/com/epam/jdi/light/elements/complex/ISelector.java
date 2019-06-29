package com.epam.jdi.light.elements.complex;

import com.epam.jdi.light.common.TextType;
import com.epam.jdi.light.elements.base.IBaseElement;
import com.epam.jdi.light.elements.interfaces.INamed;

import java.util.List;

public interface ISelector extends IBaseElement, INamed, IHasSize {
    String selected();
    boolean selected(String option);
    List<String> values();
    List<String> values(TextType type);
    List<String> listEnabled();
    List<String> listDisabled();
}
