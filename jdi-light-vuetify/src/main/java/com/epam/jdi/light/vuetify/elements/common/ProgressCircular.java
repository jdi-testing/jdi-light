package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.vuetify.asserts.ProgressCircularAssert;
import com.epam.jdi.light.elements.interfaces.base.HasColor;
import com.epam.jdi.light.vuetify.interfaces.HasMeasurement;
import org.openqa.selenium.By;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.epam.jdi.light.common.Exceptions.runtimeException;

/**
 * To see an example of Progress Spinner web element please visit https://vuetifyjs.com/en/components/progress-circular/
 */

public class ProgressCircular extends UIBaseElement<ProgressCircularAssert> implements HasLabel,
        HasColor, HasMeasurement {

    @Override
    @JDIAction("'{name}' has {0} color")
    public String color() {
        return core().find("svg").getCssValue("color");
    }

    @JDIAction("'{name}' is spinning")
    public boolean isSpinning() {
        return core().getAttribute("class").contains("v-progress-circular--indeterminate");
    }

    @JDIAction("Gets '{name}' line thickness")
    public int getThickness() {
        Matcher mt = Pattern.compile("viewBox=\"(?:[\\d\\.]* ){2}([\\d\\.]*) ([\\d\\.]*)")
                .matcher(core().find(By.cssSelector("svg")).getAttribute("outerHTML"));
        if (mt.find()) {
            float viewBox = Math.max(Float.parseFloat(mt.group(1)), Float.parseFloat(mt.group(2)));
            float sizePx = Math.min(width(), height());
            float strokeWidth = Float.parseFloat(core().find(By.cssSelector("svg circle")).getAttribute("stroke-width"));
            return Math.round(sizePx * strokeWidth / viewBox);
        } else {
            throw runtimeException("viewBox is not found");
        }
    }

    @JDIAction("'Get {name}' text")
    public String getText() {
        return core().getText();
    }

    @JDIAction("'Get {name}' value")
    public int getValue() {
        return Integer.parseInt(core().getAttribute("aria-valuenow"));
    }

    @JDIAction("'Get {name}' start angle")
    public int getRotate() {
        Matcher mt = Pattern.compile("transform: rotate\\((-?\\d*)deg\\)").matcher(core().find(By.cssSelector("svg")).getAttribute("style"));
        if (mt.find()) {
            return Integer.parseInt(mt.group(1));
        }
        return 0;
    }

    public ProgressCircularAssert is() {
        return new ProgressCircularAssert().set(this);
    }

    public ProgressCircularAssert has() {
        return is();
    }
}
