package com.epam.jdi.light.ui.bootstrap.elements.complex;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.tools.Timer;

public class Spinner extends Section  {
    public boolean disappearAfter(int timeoutSec) {
        assertThat().displayed();

        boolean result = new Timer(timeoutSec * 1000)
                .wait(() -> this.core().isHidden());
       assertThat().hidden();
        return  result;
    }
}
