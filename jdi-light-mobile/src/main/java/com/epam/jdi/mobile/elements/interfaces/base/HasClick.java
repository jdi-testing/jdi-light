package com.epam.jdi.mobile.elements.interfaces.base;

import com.epam.jdi.mobile.common.ElementArea;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
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
    default void click(ElementArea area) {
        core().click(area);
    }
}
