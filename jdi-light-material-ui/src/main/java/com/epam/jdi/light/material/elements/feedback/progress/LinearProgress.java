package com.epam.jdi.light.material.elements.feedback.progress;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.feedback.LinearProgressAssert;

public class LinearProgress extends Progress<LinearProgressAssert> {

    @JDIAction("Is '{name}' buffer")
    public boolean isBuffer() {
        return root().hasClass("MuiLinearProgress-buffer");
    }

    @JDIAction("Get '{name}' first buffer color")
    public String firstBarColor() {
        return bar1().getCssValue("background-color");
    }

    /**
     * Get the first progress bar by searching for the specified locator
     * starting at the root of the progress element.
     *
     * @return UIElement
     */
    @JDIAction("Get '{name}' first buffer")
    public UIElement bar1() {
        return root().find(bar1);
    }

    @JDIAction("Get '{name}' second buffer color")
    public String secondBarColor() {
        return bar2().getCssValue("background-color");
    }

    /**
     * Get the second progress bar by searching for the specified locator
     * starting at the root of the progress element.
     *
     * @return UIElement
     */
    @JDIAction("Get '{name}' second buffer")
    public UIElement bar2() {
        return root().find(bar2);
    }

    @JDIAction("Get '{name}' color")
    @Override
    public String getColor() {
        return root().getCssValue("background-color");
    }

    @Override
    public LinearProgressAssert is() {
        return new LinearProgressAssert().set(this);
    }
}
