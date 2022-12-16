package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.vuetify.asserts.ProgressCircularAssert;
import org.openqa.selenium.By;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * To see an example of Progress Spinner web element please visit https://vuetifyjs.com/en/components/progress-circular/
 */

public class ProgressCircular extends UIBaseElement<ProgressCircularAssert> implements HasLabel{

    @JDIAction("'{name}' has {0} color")
    public String hasColor() {
        return find("svg").getCssValue("color");
    }

    @JDIAction("Get '{name}'  height")
    public String height() {
        return core().getCssValue("height");
    }

    @JDIAction("Get '{name}'  width")
    public String width() {
        return core().getCssValue("width");
    }

    @JDIAction("'{name}' is spinning")
    public boolean isSpinning() {
       return core().getAttribute("class").contains("v-progress-circular--indeterminate");
    }

    @JDIAction("Gets '{name}' line thickness")
    public int getThickness() {
        Matcher mt = Pattern.compile("viewBox=\"(?:[\\d\\.]* ){2}([\\d\\.]*) ([\\d\\.]*)").matcher(core().find(By.cssSelector("svg")).getAttribute("outerHTML"));
        mt.find();
        float viewBox = Math.max(Float.parseFloat(mt.group(1)), Float.parseFloat(mt.group(2)));
        float sizePx = Math.min(Float.parseFloat(width().split("px")[0]), Float.parseFloat(height().split("px")[0]));
        float strokeWidth = Float.parseFloat(core().find(By.cssSelector("svg circle")).getAttribute("stroke-width"));
        return Math.round(sizePx*strokeWidth/viewBox);
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
        mt.find();
        return Integer.parseInt(mt.group(1));
    }

    public ProgressCircularAssert is() {
        return new ProgressCircularAssert().set(this);
    }

    public ProgressCircularAssert has() {
        return is();
    }
}
