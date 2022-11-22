package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.vuetify.asserts.SparklineAssert;
import com.epam.jdi.light.vuetify.interfaces.HasMeasurement;
import com.epam.jdi.light.vuetify.interfaces.IsFilled;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.Double.parseDouble;

/**
 * The Sparkline Vue element is an SVG image built around a single SVG <path> (line) sub-element
 * To see an example of Sparkline web element please visit https://vuetifyjs.com/en/components/sparklines
 */

public class Sparkline extends UIBaseElement<SparklineAssert> implements HasAssert<SparklineAssert>, HasMeasurement,
        HasLabel, IsFilled {

    private UIElement getPath() {
        return core().find("path");
    }

    @JDIAction("Get '{name}' line width")
    public double getLineWidth() {
        return parseDouble(core().getAttribute("stroke-width"));
    }

    @Override
    @JDIAction("Check if '{name}' is filled")
    public boolean isFilled() { return !getPath().getAttribute("fill").equals("none"); }

    @JDIAction("Get '{name}' SVG-specific path shape definition")
    public String getPathShape() {
        return getPath().getAttribute("d");
    }

    /**
     *
     * @return {@code List<String> LabelTexts} if a sparkline has data points, otherwise - an empty list
     */
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

    @JDIAction("Check that '{name}' has type bar")
    public boolean isBar() {
        return find("clipPath").isExist();
    }

    @JDIAction("Check that '{name}' has type trendline")
    public boolean isTrendline() {
        return find("path").isExist();
    }

    @JDIAction("Get '{name}' label font size")
    public int labelFontSize() {
        return Integer.parseInt(find("g").css("font-size").replace("px", ""));
    }

    @JDIAction("Check that '{name}' has visible labels")
    public boolean hasLabels() {
        return !getLabelTexts().isEmpty();
    }

    @JDIAction("Check that '{name}' has visible labels")
    public int lineWidth() {
        return Integer.parseInt(core().getAttribute("stroke-width"));
    }

    @JDIAction("Get '{name}' bars")
    public List<UIElement> bars() {
        return finds("clipPath rect");
    }

    @JDIAction("Get '{name}' bars width")
    public List<Integer> getBarsWidth() {
        List<Integer> barsWidth = new ArrayList<>();
        for (UIElement bar : bars()) {
            barsWidth.add(Integer.parseInt(bar.getAttribute("width")));
        }
        return barsWidth;
    }

    @JDIAction("Get '{name}' bar width")
    public int getBarWidth() {
        return Integer.parseInt(bars().get(1).getAttribute("width"));
    }

    @JDIAction("Get '{name}' bars height")
    public List<Integer> getBarsHeight() {
        List<Integer> barsHeight = new ArrayList<>();
        for (UIElement bar : bars()) {
            barsHeight.add(Integer.parseInt(bar.getAttribute("height")));
        }
        return barsHeight;
    }

    @Override
    public SparklineAssert is() { return new SparklineAssert().set(this); }
}
