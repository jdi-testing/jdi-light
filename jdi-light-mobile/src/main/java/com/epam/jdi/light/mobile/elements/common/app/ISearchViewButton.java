package com.epam.jdi.light.mobile.elements.common.app;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.logger.LogLevels;

public interface ISearchViewButton extends ICoreElement {

        @JDIAction(value = "Make '{name}' expanded", level = LogLevels.DEBUG)
        void setExpanded();
}



