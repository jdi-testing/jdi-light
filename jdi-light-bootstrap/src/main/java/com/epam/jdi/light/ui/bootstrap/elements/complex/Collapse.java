package com.epam.jdi.light.ui.bootstrap.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.dropdown.DropdownExpand;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;

/**
 * To see an example of Collapse web element please visit https://getbootstrap.com/docs/4.3/components/collapse/#example
 */

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
