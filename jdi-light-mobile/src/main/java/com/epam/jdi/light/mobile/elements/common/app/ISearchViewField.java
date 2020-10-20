package com.epam.jdi.light.mobile.elements.common.app;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.logger.LogLevels;

public interface ISearchViewField extends ICoreElement {

    @JDIAction(value = "Check that '{name}' is expanded", level = LogLevels.DEBUG)
    boolean isExpanded();

    @JDIAction(value = "Check that '{name}' has text value", level = LogLevels.DEBUG)
    String getValue();

    @JDIAction(value = "Input '{name}' into input field", level = LogLevels.DEBUG)
    void input(String value);

    @JDIAction(value = "Clear '{name}' from input field", level = LogLevels.DEBUG)
    void clear();
}
