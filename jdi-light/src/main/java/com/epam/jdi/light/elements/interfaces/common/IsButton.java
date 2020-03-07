package com.epam.jdi.light.elements.interfaces.common;

import com.epam.jdi.light.elements.interfaces.base.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public interface IsButton extends HasClick, IsText, HasValue {
    default String getValue() { return getText(); }
}
