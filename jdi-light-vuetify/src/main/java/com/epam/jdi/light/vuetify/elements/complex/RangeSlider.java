package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.asserts.RangeSliderAssert;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.init.UIFactory.$$;

/**
 * To see an example of Range Slider web element please visit https://vuetifyjs.com/en/components/range-sliders
 */
public class RangeSlider extends UIBaseElement<RangeSliderAssert> {
    protected String THUMB_CONTAINER_LOCATOR = ".v-slider__thumb-container";
    protected String THUMB_LOCATOR = ".v-slider__thumb";
    protected String THUMB_LABEL_CONTAINER_LOCATOR = ".v-slider__thumb-label-container";
    protected String THUMB_LABEL_LOCATOR = ".v-slider__thumb-label";

    protected String TRACK_CONTAINER_LOCATOR = ".v-slider__track-container";
    protected String TRACK_BACKGROUND_LOCATOR = ".v-slider__track-background";
    protected String TRACK_FILL_LOCATOR = ".v-slider__track-fill";

    protected String TICKS_CONTAINER_LOCATOR = ".v-slider__ticks-container";
    protected String TICK_LOCATOR = ".v-slider__tick";
    protected String ALWAYS_SHOW = "v-slider__ticks-container--always-show";
    protected String TICK_LABEL_LOCATOR = ".v-slider__tick-label";

    protected String DISABLED = "v-slider--disabled";
    protected String VERTICAL = "v-slider--vertical";

    @JDIAction("Get track container from '{name}'")
    protected UIElement getTrackContainer() {
        return $(TRACK_CONTAINER_LOCATOR, this);
    }

    @JDIAction("Get track background from '{name}'")
    public WebList getBackground() {
        return $$(TRACK_BACKGROUND_LOCATOR, getTrackContainer());
    }

    @JDIAction("Get thumb container from '{name}'")
    protected WebList getThumbContainer() {
        return $$(THUMB_CONTAINER_LOCATOR, this);
    }

    @JDIAction("Get left thumb from '{name}'")
    public UIElement getLeftThumb() {
        return $(THUMB_LOCATOR, getThumbContainer().get(1));
    }

    @JDIAction("Get right thumb from '{name}'")
    public UIElement getRightThumb() {
        return $(THUMB_LOCATOR, getThumbContainer().get(2));
    }

    @JDIAction("Get thumb label from '{name}'")
    public WebList getThumbLabel() {
        return $$(THUMB_LABEL_LOCATOR, this);
    }

    @JDIAction("Get tick label value from '{name}'")
    public String getTickLabel(int index) {
        return $$(TICK_LABEL_LOCATOR, this).get(index).getValue();
    }

    @JDIAction("Get value from '{name}'")
    public List<Integer> getValue() {
        return new WebList(core().findElements(By.cssSelector("input")))
                .stream()
                .map(input -> Integer.parseInt(input.getAttribute("value")))
                .collect(Collectors.toList());
    }

    @JDIAction("Get thumb label value from '{name}'")
    public List<String> getThumbLabelValue() {
        return getThumbLabel()
                .stream()
                .map(thumbLabel -> thumbLabel.find("i").getAttribute("class"))
                .collect(Collectors.toList());
    }

    @JDIAction("Set horizontal slider from '{name}' to {0}, {1}")
    public void slideHorizontalTo(int valueLeft, int valueRight) {
        double trackWidth = getTrackContainer().getSize().width;
        double minValue = Double.parseDouble(getThumbContainer().get(1).getAttribute("aria-valuemin"));
        double maxValue = Double.parseDouble(getThumbContainer().get(1).getAttribute("aria-valuemax"));
        List<Double> nowValue = Arrays.stream(getThumbContainer().get(1).getAttribute("aria-valuenow").split(","))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        double pixelsInUnit = trackWidth / (maxValue - minValue);
        double xOffsetLeft = (valueLeft - nowValue.get(0)) * pixelsInUnit;
        getLeftThumb().dragAndDropTo((int) Math.round(xOffsetLeft), 0);
        double xOffsetRight = (valueRight - nowValue.get(1)) * pixelsInUnit;
        getRightThumb().dragAndDropTo((int) Math.round(xOffsetRight), 0);
    }

    @JDIAction("Set vertical slider from '{name}' to {0}, {1}")
    public void slideVerticalTo(int valueLeft, int valueRight) {
        double trackHeight = getTrackContainer().getSize().height;
        double minValue = Double.parseDouble(getThumbContainer().get(1).getAttribute("aria-valuemin"));
        double maxValue = Double.parseDouble(getThumbContainer().get(1).getAttribute("aria-valuemax"));
        List<Double> nowValue = Arrays.stream(getThumbContainer().get(1).getAttribute("aria-valuenow").split(","))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        double pixelsInUnit = trackHeight / (maxValue - minValue);
        double yOffsetLeft = (valueLeft - minValue) * pixelsInUnit - (nowValue.get(0) - minValue) * pixelsInUnit;
        getLeftThumb().dragAndDropTo(0, -(int) Math.round(yOffsetLeft));
        double yOffsetRight = (valueRight - minValue) * pixelsInUnit - (nowValue.get(1) - minValue) * pixelsInUnit;
        getRightThumb().dragAndDropTo(0, -(int) Math.round(yOffsetRight));
    }

    @Override
    @JDIAction("Check if '{name}' disabled")
    public boolean isDisabled() {
        return core().hasClass(DISABLED);
    }

    @JDIAction("Check if '{name}' vertical")
    public boolean isVertical() {
        return core().hasClass(VERTICAL);
    }

    @JDIAction("Check if ticks of '{name}' always show")
    public boolean isAlwaysShow() {
        return $(TICKS_CONTAINER_LOCATOR, this).hasClass(ALWAYS_SHOW);
    }

    @JDIAction("Check if thumb label of '{name}' displayed")
    public boolean isThumbLabelDisplayed() {
        return new WebList(core().findElements(By.cssSelector(THUMB_LABEL_CONTAINER_LOCATOR)))
                .stream()
                .noneMatch(label -> label.getAttribute("style").contains("display: none"));
    }

    @Override
    public RangeSliderAssert is() {
        return new RangeSliderAssert().set(this);
    }
}
