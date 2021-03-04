package com.epam.jdi.light.material.elements.feedback;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.annotations.JDIBufferLinear;
import com.epam.jdi.light.material.asserts.feedback.ProgressAssert;

import java.lang.reflect.Field;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static java.lang.Thread.sleep;

public class ProgressBar extends UIBaseElement<ProgressAssert> implements ISetup {
    int rotationPeriodMillis = 400;
    String root;
    String bar1;
    String bar2;
    String dashed;

    @JDIAction("Get '{name}' value ")
    public int value() throws Exception {
        if (isDeterminate()) {
            return Integer.parseInt(core().attr("aria-valuenow"));
        }
        throw new Exception("No exist 'value' attribute");
    }

    @JDIAction("Is '{name}' indeterminate")
    public Boolean isIndeterminate() {
        return !isDeterminate();
    }

    @JDIAction("Is '{name}' determinate")
    public Boolean isDeterminate() {
        return hasAttribute("aria-valuenow");
    }

    @JDIAction("Is '{name}' in progress")
    public Boolean inProgress() throws Exception {
        int position = value();
        sleep(rotationPeriodMillis);
        int currentPosition = value();
        return !(position == currentPosition);
    }

    @JDIAction("Is '{name}' shrinkDisabled")
    public Boolean isShrinkDisabled() {
        return core().find(".MuiCircularProgress-circle").hasClass("MuiCircularProgress-circleDisableShrink");
    }

    @JDIAction("Click '{name}'")
    public void click() {
        core().click();
    }

    @Override
    public ProgressAssert is() {
        return new ProgressAssert().set(this);
    }

    @Override
    public ProgressAssert has() {
        return this.is();
    }

    @JDIAction(value = "Get '{name}' max limit", level = DEBUG)
    public int max() {
        return Integer.parseInt(attr("aria-valuemax"));
    }

    @JDIAction(value = "Get '{name}' min limit", level = DEBUG)
    public int min() {
        return Integer.parseInt(attr("aria-valuemin"));
    }

    @JDIAction("Is '{name}' has correct color")
    public Boolean color(String color) {
        if (bar1 == null) {
            return color.equalsIgnoreCase(core().getCssValue("color"));
        }
        return color.equalsIgnoreCase(core().finds(bar1).first().getCssValue("background-color"));
    }

    @JDIAction("Is '{name}' has correct colors")
    public Boolean bufferColors(String color1, String color2) {
        return color1.equalsIgnoreCase(core().find(bar1).getCssValue("background-color")) &&
                color2.equalsIgnoreCase(core().find(bar2).getCssValue("background-color"));
    }

    public boolean isBuffer() {
        return core().find(dashed).isExist() &&
                core().find(bar1).isExist() &&
                core().find(bar2).isExist();
    }

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDIBufferLinear.class, ProgressBar.class))
            return;
        JDIBufferLinear j = field.getAnnotation(JDIBufferLinear.class);
        root = j.root();
        dashed = j.dashed();
        bar1 = j.bar1();
        bar2 = j.bar2();
    }
}

