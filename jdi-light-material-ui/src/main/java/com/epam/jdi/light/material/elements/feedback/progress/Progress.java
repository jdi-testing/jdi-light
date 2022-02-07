package com.epam.jdi.light.material.elements.feedback.progress;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.material.annotations.JProgress;
import com.epam.jdi.light.material.asserts.feedback.ProgressAssert;
import com.epam.jdi.light.material.interfaces.base.HasColor;

import java.lang.reflect.Field;
import java.util.NoSuchElementException;

/**
 * To see an example of Progress web element please visit
 * https://mui.com/components/progress/
 */

public abstract class Progress<A extends ProgressAssert<?, ?>> extends UIBaseElement<A>
        implements ISetup, HasLabel, HasColor {

    protected String root;
    // TODO: bar1 and bar2 are a part of LinearProgress only, should be moved
    protected String bar1;
    protected String bar2;
    protected String labelLocator;

    @JDIAction("Get '{name}' value now")
    public int getValueNow() {
        if (isDeterminate()) {
            return Integer.parseInt(root().attr("aria-valuenow"));
        }
        throw new NoSuchElementException("No exist 'value' attribute");
    }

    @JDIAction("Is '{name}' determinate")
    public boolean isDeterminate() {
        return root().hasAttribute("aria-valuenow");
    }

    /**
     * Get the progress root by searching for the specified locator starting at the root of the page.
     *
     * @return UIElement
     */
    protected UIElement root() {
        return find(root);
    }

    @JDIAction(value = "Get '{name}' max limit")
    public int maxValue() {
        return Integer.parseInt(root().attr("aria-valuemax"));
    }

    @JDIAction(value = "Get '{name}' min limit")
    public int minValue() {
        return Integer.parseInt(root().attr("aria-valuemin"));
    }

    @JDIAction("Get '{name}' color")
    @Override
    public String getColor() {
        return root().getCssValue("color");
    }

    /**
     * Get the progress label by searching for the specified locator starting at the root of the page.
     *
     * @return Label
     */
    @JDIAction("Get '{name}' label")
    @Override
    public Label label() {
        return new Label().setCore(Label.class, core().find(labelLocator));
    }

    @JDIAction("Is '{name}' displayed")
    @Override
    public boolean isDisplayed() {
        return root().isDisplayed();
    }

    @JDIAction("Is '{name}' indeterminate")
    public boolean isIndeterminate() {
        return !isDeterminate();
    }

    @Override
    public A is() {
        return (A) new ProgressAssert<>().set(this);
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

