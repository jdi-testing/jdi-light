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

/**
 * To see an example of Sparkline web element please visit https://v2.vuetifyjs.com/en/components/sparklines
 */

public class Sparkline extends UIBaseElement<SparklineAssert> implements HasAssert<SparklineAssert>, HasMeasurement,
        HasLabel, IsFilled {

    private UIElement getPath() {
        return core().find("path");
    }

    @Override
    @JDIAction("Get if '{name}' is filled")
    public boolean isFilled() {
        return !getPath().getAttribute("fill").equals("none");
    }

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

    @JDIAction("Get if '{name}' has type bar")
    public boolean isBar() {
        return core().find("clipPath").isExist();
    }

    @JDIAction("Get if '{name}' has type trendline")
    public boolean isTrendline() {
        return core().find("path").isExist();
    }

    @JDIAction("Get '{name}' label font size")
    public int labelFontSize() {
        return Integer.parseInt(core().find("g").css("font-size").replace("px", ""));
    }

    @JDIAction("Get if '{name}' has visible labels")
    public boolean hasLabels() {
        return !getLabelTexts().isEmpty();
    }

    @JDIAction("Get if '{name}' has visible labels")
    public int lineWidth() {
        return Integer.parseInt(core().getAttribute("stroke-width"));
    }

    @JDIAction("Get '{name}' bars")
    public List<UIElement> bars() {
        return core().finds("clipPath rect");
    }

    @JDIAction("Get '{name}' bars width")
    public List<Integer> getBarsWidths() {
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
    public List<Integer> getBarsHeights() {
        List<Integer> barsHeight = new ArrayList<>();
        for (UIElement bar : bars()) {
            barsHeight.add(Integer.parseInt(bar.getAttribute("height")));
        }
        return barsHeight;
    }

    @Override
    public SparklineAssert is() {
        return new SparklineAssert().set(this);
    }
}
