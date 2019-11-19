package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.tools.Timer;

/**
 * To see an example of Spinner web element please visit https://getbootstrap.com/docs/4.3/components/spinners/
 */

public class Spinner extends UIElement {
    public Spinner disappearAfter(int timeoutSec) {
        assertThat().displayed();
        new Timer(timeoutSec * 1000).wait(() -> core().isHidden());
        assertThat().hidden();
        return this;
    }
}
