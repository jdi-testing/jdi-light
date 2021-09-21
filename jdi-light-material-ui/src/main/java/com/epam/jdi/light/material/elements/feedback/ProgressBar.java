package com.epam.jdi.light.material.elements.feedback;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.annotations.JDIProgressBar;
import com.epam.jdi.light.material.asserts.feedback.ProgressAssert;

import java.lang.reflect.Field;
import java.util.NoSuchElementException;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

/**
 * To see an example of Progress web element please visit
 * https://mui.com/components/progress/
 */

public class ProgressBar extends UIBaseElement<ProgressAssert> implements ISetup {
    public static final String BACKGROUND_COLOR = "background-color";
    private String root;
    private String bar1;
    private String bar2;

    @JDIAction("Get '{name}' value ")
    public int getValueNow() {
        if (isDeterminate()) {
            return Integer.parseInt(this.find(root).attr("aria-valuenow"));
        }
        throw new NoSuchElementException("No exist 'value' attribute");
    }

    @JDIAction("Is '{name}' indeterminate")
    public Boolean isIndeterminate() {
        return !isDeterminate();
    }

    @JDIAction("Is '{name}' determinate")
    public Boolean isDeterminate() {
        return this.find(root).hasAttribute("aria-valuenow");
    }

    @Override
    public ProgressAssert is() {
        return new ProgressAssert().set(this);
    }

    @Override
    public ProgressAssert has() {
        return this.is();
    }

    @JDIAction(value = "Get '{name}' max limit")
    public int getMaxValue() {
        return Integer.parseInt(this.find(root).attr("aria-valuemax"));
    }

    @JDIAction(value = "Get '{name}' min limit")
    public int getMinValue() {
        return Integer.parseInt(this.find(root).attr("aria-valuemin"));
    }

    @JDIAction("Is '{name}' has correct color")
    public Boolean isColorCorrect(String color) {
        if (bar1.equals("")) {
            return color.equalsIgnoreCase(this.find(root).getCssValue("color"));
        }
        return color.equalsIgnoreCase(finds(bar1).first().getCssValue(BACKGROUND_COLOR));
    }

    @JDIAction("Is '{name}' has correct colors")
    public Boolean bufferColors(String color1, String color2) {
        return color1.equalsIgnoreCase(core().find(bar1).getCssValue(BACKGROUND_COLOR)) &&
                color2.equalsIgnoreCase(core().find(bar2).getCssValue(BACKGROUND_COLOR));
    }

    public boolean isBuffer() {
        return this.find(root).hasClass("MuiLinearProgress-buffer");
    }

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDIProgressBar.class, ProgressBar.class))
            return;
        JDIProgressBar j = field.getAnnotation(JDIProgressBar.class);
        root = j.root();
        bar1 = j.bar1();
        bar2 = j.bar2();
    }
}

