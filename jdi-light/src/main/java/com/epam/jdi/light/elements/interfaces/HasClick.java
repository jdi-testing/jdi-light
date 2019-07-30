package com.epam.jdi.light.elements.interfaces;

import com.epam.jdi.light.common.ElementArea;

public interface HasClick extends ICoreElement, IClickable {
    default void click() {
        core().click();
    }
    default void doubleClick() {
        core().doubleClick();
    }
    default void rightClick() {
        core().rightClick();
    }
    default void jsClick() {
        core().jsClick();
    }
    default void click(ElementArea area) {
        core().click(area);
    }
}
