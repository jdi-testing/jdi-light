package com.epam.jdi.light.material.elements.feedback.progress;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.annotations.JProgress;
import com.epam.jdi.light.material.asserts.feedback.LinearProgressAssert;
import java.lang.reflect.Field;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

/**
 * Represents linear progress MUI component on GUI.
 *
 * @see <a href="https://mui.com/components/progress/#linear">Linear Progress MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class LinearProgress extends Progress<LinearProgressAssert> {

    /**
     * Locator for the first progress bar.
     */
    protected String firstBar;

    /**
     * Locator for the second progress bar.
     */
    protected String secondBar;

    /**
     * Checks if the progress is linear buffer or not. Linear buffer progress has extra bar that shows additional progress.
     * It might indicate some activity or loading from the server.
     *
     * @return {@code true} if the progress is linear buffer, otherwise {@code false}
     * @see <a href='https://mui.com/components/progress/#linear-buffer'>Linear buffer MUI documentation</a>
     */
    @JDIAction("Check that '{name}' is linear buffer")
    public boolean isBuffer() {
        return core().hasClass("MuiLinearProgress-buffer");
    }

    /**
     * Gets the color of the first progress bar in form like "rgba(120, 1, 60, 0.52)".
     *
     * @return the first progress bar color as {@link String}
     */
    @JDIAction("Get '{name}' first buffer color")
    public String firstBarColor() {
        return firstBar().css("background-color");
    }

    /**
     * Gets the first progress bar.
     *
     * @return the first progress bar as {@link UIElement}
     */
    @JDIAction("Get '{name}' first buffer")
    public UIElement firstBar() {
        return core().find(firstBar);
    }

    /**
     * Gets the color of the second progress bar in form like "rgba(120, 1, 60, 0.52)".
     *
     * @return the second progress bar color as {@link String}
     */
    @JDIAction("Get '{name}' second buffer color")
    public String secondBarColor() {
        return secondBar().css("background-color");
    }

    /**
     * Gets the second progress bar.
     *
     * @return the second progress bar as {@link UIElement}
     */
    @JDIAction("Get '{name}' second buffer")
    public UIElement secondBar() {
        return core().find(secondBar);
    }

    @JDIAction("Get '{name}' color")
    @Override
    public String color() {
        return core().css("background-color");
    }

    @Override
    public void setup(Field field) {
        super.setup(field);
        if (fieldHasAnnotation(field, JProgress.class, Progress.class)) {
            JProgress j = field.getAnnotation(JProgress.class);
            firstBar = j.firstBar();
            secondBar = j.secondBar();
        }
    }

    @Override
    public LinearProgressAssert is() {
        return new LinearProgressAssert().set(this);
    }
}
