package com.epam.jdi.light.elements.interfaces.base;

import com.epam.jdi.light.elements.interfaces.common.IsText;

public interface IListBase extends IsText, HasClick {
    boolean isSelected();
    String getTagName();
}
