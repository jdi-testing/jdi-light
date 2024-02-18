package com.epam.jdi.light.material.elements.feedback.progress;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.feedback.ProgressAssert;
import org.openqa.selenium.By;

/**
 * Represents circular progress MUI component on GUI.
 *
 * @see <a href="https://v4.mui.com/components/progress/#circular">Circular Progress MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class CircularProgress extends Progress<ProgressAssert<?, ?>> {

    /**
     * Gets progress circle.
     *
     * @return progress circle as {@link UIElement}
     */
    @JDIAction("Get '{name}' circle")
    public UIElement circle() {
        return core().find(By.tagName("circle"));
    }
}
