package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.tools.Timer;

public class Spinner extends UIElement {
    public Spinner disappearAfter(int timeoutSec) {
        assertThat().displayed();
        new Timer(timeoutSec * 1000).wait(() -> core().isHidden());
        assertThat().hidden();
        return this;
    }
}
