package com.epam.jdi.light.material.elements.feedback.progress;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.annotations.JProgress;
import com.epam.jdi.light.material.asserts.feedback.LinearProgressAssert;
import java.lang.reflect.Field;

public class LinearProgress extends Progress<LinearProgressAssert> {

    protected String bar1;
    protected String bar2;

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
    public String color() {
        return root().getCssValue("background-color");
    }

    @Override
    public LinearProgressAssert is() {
        return new LinearProgressAssert().set(this);
    }

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JProgress.class, Progress.class)) {
            return;
        }
        JProgress j = field.getAnnotation(JProgress.class);
        root = j.root();
        bar1 = j.bar1();
        bar2 = j.bar2();
        labelLocator = j.label();
    }
}
