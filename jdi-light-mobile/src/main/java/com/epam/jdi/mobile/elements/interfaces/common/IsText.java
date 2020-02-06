package com.epam.jdi.mobile.elements.interfaces.common;

import com.epam.jdi.mobile.common.TextTypes;
import com.epam.jdi.mobile.elements.interfaces.base.ICoreElement;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public interface IsText extends ICoreElement {
    default String getText() { return core().getText(); }
    default String text() { return getText(); }
    default String text(TextTypes type) { return core().text(type); }
    default String getValue() { return getText(); }
    default boolean isEmpty() { return getText().isEmpty(); }
    default boolean isNotEmpty() { return !isEmpty(); }
}
