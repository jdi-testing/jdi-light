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

    protected static final String DISABLED = "v-slider--disabled";
    protected static final String VERTICAL = "v-slider--vertical";

    protected String thumbContainerLocator = ".v-slider__thumb-container";
    protected String thumbLocator = ".v-slider__thumb";
    protected String thumbLabelContainerLocator = ".v-slider__thumb-label-container";
    protected String thumbLabelLocator = ".v-slider__thumb-label";

    protected String trackContainerLocator = ".v-slider__track-container";
    protected String trackBackgroundLocator = ".v-slider__track-background";
    protected String trackFillLocator = ".v-slider__track-fill";

    protected String ticksContainerLocator = ".v-slider__ticks-container";
    protected String tickLocator = ".v-slider__tick";
    protected String alwaysShow = "v-slider__ticks-container--always-show";
    protected String tickLabelLocator = ".v-slider__tick-label";

    @JDIAction("Get track container from '{name}'")
    protected UIElement getTrackContainer() {
        return $(trackContainerLocator, this);
    }

    @JDIAction("Get track background from '{name}'")
    public WebList getBackground() {
        return $$(trackBackgroundLocator, getTrackContainer());
    }

    @JDIAction("Get thumb container from '{name}'")
    protected WebList getThumbContainer() {
        return $$(thumbContainerLocator, this);
    }

    @JDIAction("Get left thumb from '{name}'")
    public UIElement getLeftThumb() {
        return $(thumbLocator, getThumbContainer().get(1));
    }

    @JDIAction("Get right thumb from '{name}'")
    public UIElement getRightThumb() {
        return $(thumbLocator, getThumbContainer().get(2));
    }

    @JDIAction("Get thumb label from '{name}'")
    public WebList getThumbLabel() {
        return $$(thumbLabelLocator, this);
    }

    @JDIAction("Get tick label value from '{name}'")
    public String getTickLabel(int index) {
        return $$(tickLabelLocator, this).get(index).getValue();
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
        return $(ticksContainerLocator, this).hasClass(alwaysShow);
    }

    @JDIAction("Check if thumb label of '{name}' displayed")
    public boolean isThumbLabelDisplayed() {
        return new WebList(core().findElements(By.cssSelector(thumbLabelContainerLocator)))
                .stream()
                .noneMatch(label -> label.getAttribute("style").contains("display: none"));
    }

    @Override
    public RangeSliderAssert is() {
        return new RangeSliderAssert().set(this);
    }
}
