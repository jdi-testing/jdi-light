package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.SparklineAssert;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.Double.parseDouble;

/**
 * To see an example of Sparkline web element please visit https://vuetifyjs.com/en/components/sparklines
 */

public class Sparkline extends UIBaseElement<SparklineAssert> implements HasAssert<SparklineAssert> {
    // The Sparkline Vue element is an SVG image built around a single SVG <path> (line) sub-element

    private UIElement getPath() {
        return core().find("path");
    }

    @JDIAction("Get '{name}' line width")
    public double getLineWidth() {
        return parseDouble(core().getAttribute("stroke-width"));
    }

    @JDIAction("Check if '{name}' is filled")
    public boolean isFilled() { return !getPath().getAttribute("fill").equals("none"); }

    @JDIAction("Get '{name}' SVG-specific path shape definition")
    public String getPathShape() {
        return getPath().getAttribute("d");
    }

    // returns an empty list if a sparkline has no data points
    @JDIAction("Get data point label texts of '{name}'")
    public List<String> getLabelTexts() {
        return core().finds("text").stream()
                .map(UIElement::getText)
                .collect(Collectors.toList());
    }

    @JDIAction("Get map representation (keys: offsets, values: stop-colors) of '{name}' linear gradient")
    public Map<String, String> getLinearGradientMap() {
        Map<String, String> linearGradientMap = new HashMap<>();
        // core.finds() somehow fails to find elements with the following selector
        core().findElements(By.cssSelector("defs stop"))
                .forEach(elem -> linearGradientMap.put(elem.getAttribute("offset"),
                        elem.getAttribute("stop-color")));
        return linearGradientMap;
    }

    @Override
    public SparklineAssert is() { return new SparklineAssert().set(this); }
}
