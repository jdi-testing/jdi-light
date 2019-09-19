package com.epam.jdi.light.ui.bootstrap.interfaces;

import com.epam.jdi.light.elements.interfaces.common.IsText;

public interface IsJumbotron extends IsText {
    default String getValue() { return getText(); }
}