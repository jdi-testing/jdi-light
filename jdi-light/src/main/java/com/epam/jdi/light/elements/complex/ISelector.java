package com.epam.jdi.light.elements.complex;

import com.epam.jdi.light.common.TextTypes;
import com.epam.jdi.light.elements.interfaces.HasText;
import com.epam.jdi.light.elements.interfaces.IBaseElement;
import com.epam.jdi.light.elements.interfaces.INamed;

import java.util.List;

public interface ISelector extends IBaseElement, HasText, INamed, IHasSize {
    String selected();
    boolean selected(String option);
    List<String> values();
    List<String> values(TextTypes type);
    List<String> listEnabled();
    List<String> listDisabled();
}
