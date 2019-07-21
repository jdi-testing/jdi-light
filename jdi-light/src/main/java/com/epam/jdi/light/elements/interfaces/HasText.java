package com.epam.jdi.light.elements.interfaces;

import com.epam.jdi.light.common.TextType;

public interface HasText extends IBaseElement {
    default String getText() { return core().getText(); }
    default String text() { return core().text(); }
    default String text(TextType type) { return core().text(type); }
}
