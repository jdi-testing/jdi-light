package com.epam.jdi.light.elements.interfaces.common;

import com.epam.jdi.light.elements.interfaces.base.HasPlaceholder;

public interface IsInput extends IsText, HasPlaceholder {
    default void sendKeys(CharSequence... value) { core().sendKeys(value); }
    default void setText(String value) {
        core().setText(value);
    }
    default void clear() { core().clear(); }
    default void input(String value) {
        core().input(value);
    }
    default void focus() { core().focus(); }
}
