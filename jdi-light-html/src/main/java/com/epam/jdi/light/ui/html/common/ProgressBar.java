package com.epam.jdi.light.ui.html.common;

import static com.epam.jdi.light.common.Exceptions.exception;

public interface ProgressBar extends Button {
    default String getValue() {
        return getAttribute("value");
    }
    default int max() {
        try {
            return Integer.parseInt(getAttribute("value"));
        } catch (Exception ex) { throw exception("Can't parse value"); }
    }
    default int min() {
        try {
            return Integer.parseInt(getAttribute("value"));
        } catch (Exception ex) { throw exception("Can't parse value"); }
    }
}
