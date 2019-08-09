package com.epam.jdi.light.elements.interfaces.common;

import com.epam.jdi.light.common.TextTypes;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

public interface IsText extends ICoreElement {
    default String getText() { return core().getText(); }
    default String text() { return getText(); }
    default String text(TextTypes type) { return core().text(type); }
    default String getValue() { return getText(); }
}
