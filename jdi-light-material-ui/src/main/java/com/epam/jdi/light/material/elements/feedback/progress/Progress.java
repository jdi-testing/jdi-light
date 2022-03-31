package com.epam.jdi.light.material.elements.feedback.progress;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.material.annotations.JProgress;
import com.epam.jdi.light.material.asserts.feedback.ProgressAssert;
import com.epam.jdi.light.material.interfaces.base.HasColor;
import java.lang.reflect.Field;
import java.util.NoSuchElementException;

import static com.epam.jdi.light.driver.WebDriverByUtils.NAME_TO_LOCATOR;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

/**
 * Represents progress MUI component on GUI.
 *
 * @see <a href="https://mui.com/components/progress/">Progress MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public abstract class Progress<A extends ProgressAssert<?, ?>> extends UIBaseElement<A>
    implements ISetup, HasLabel, HasColor {

    /**
     * Locator for progress root.
     */
    protected String root;

    /**
     * Locator for label.
     */
    protected String labelLocator;

    /**
     * Gets the progress label by searching for the specified locator starting at the root of the page.
     *
     * @return progress label as {@link Label}
     */
    @JDIAction("Get '{name}' label")
    @Override
    public Label label() {
        return new Label().setCore(Label.class, $(labelLocator));
    }

    /**
     * Gets the current value of progress.
     *
     * @return current progress value as {@code int}
     * @throws NoSuchElementException if 'value' attribute doesn't exist
     *                                (i.e. the progress is indeterminate)
     */
    @JDIAction("Get '{name}' value now")
    public int getValueNow() {
        if (isDeterminate()) {
            return Integer.parseInt(core().attr("aria-valuenow"));
        }
        throw new NoSuchElementException("No exist 'value' attribute");
    }

    /**
     * Gets the max value of progress.
     *
     * @return max progress value as {@code int}
     */
    @JDIAction(value = "Get '{name}' max limit")
    public int maxValue() {
        return Integer.parseInt(core().attr("aria-valuemax"));
    }

    /**
     * Gets the min value of progress.
     *
     * @return min progress value as {@code int}
     */
    @JDIAction(value = "Get '{name}' min limit")
    public int minValue() {
        return Integer.parseInt(core().attr("aria-valuemin"));
    }

    @JDIAction("Get '{name}' color")
    @Override
    public String color() {
        return core().getCssValue("color");
    }

    /**
     * Checks if the progress is determinate or not (i.e. has value attribute or not).
     * Determinate indicators display how long an operation will take.
     *
     * @return {@code true} if the progress is determinate, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' is determinate")
    public boolean isDeterminate() {
        return core().hasAttribute("aria-valuenow");
    }

    /**
     * Checks if the progress is determinate or not (i.e. has value attribute or not).
     * Indeterminate indicators visualize an unspecified wait time.
     *
     * @return {@code true} if the progress is indeterminate, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' is indeterminate")
    public boolean isIndeterminate() {
        return !isDeterminate();
    }

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JProgress.class, Progress.class)) {
            return;
        }
        JProgress j = field.getAnnotation(JProgress.class);
        root = j.root();
        labelLocator = j.label();
        base().setLocator(NAME_TO_LOCATOR.execute(root));
    }

    @Override
    public A is() {
        return (A) new ProgressAssert<>().set(this);
    }
}
