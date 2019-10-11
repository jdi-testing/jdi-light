package com.epam.jdi.light.ui.bootstrap.elements.complex;

import com.epam.jdi.light.common.JDIAction;


import static com.epam.jdi.light.logger.LogLevels.DEBUG;

public class Collapse extends DropdownExpand {

    @JDIAction(level = DEBUG)
    public void expand() {
        if (!isExpanded()) {
            toggle();
        }
    }

    @JDIAction(level = DEBUG)
    public void collapse() {
        if (isExpanded()) {
            toggle();
        }
    }
}
