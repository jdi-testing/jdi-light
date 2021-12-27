package com.epam.jdi.light.material.elements.feedback.progress;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.feedback.ProgressAssert;
import org.openqa.selenium.By;

public class CircularProgress extends Progress<ProgressAssert<?, ?>> {

    /**
     * Get progress circle by searching for the tag 'circle'
     * starting at the root of the progress element.
     *
     * @return UIElement
     */
    @JDIAction("Get '{name}' circle")
    public UIElement circle() {
        return root().find(By.tagName("circle"));
    }
}
