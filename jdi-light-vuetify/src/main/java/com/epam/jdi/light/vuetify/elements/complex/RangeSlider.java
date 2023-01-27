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

    private static final String DISABLED_CLASS = "v-slider--disabled";
    private static final String VERTICAL_CLASS = "v-slider--vertical";
    private static final String ALWAYS_SHOW_CLASS = "v-slider__ticks-container--always-show";

    private String thumbContainerLocator = ".v-slider__thumb-container";
    private String thumbLocator = ".v-slider__thumb";
    private String thumbLabelContainerLocator = ".v-slider__thumb-label-container";
    private String thumbLabelLocator = ".v-slider__thumb-label";

    private String trackContainerLocator = ".v-slider__track-container";
    private String trackBackgroundLocator = ".v-slider__track-background";

    private String ticksContainerLocator = ".v-slider__ticks-container";
    private String tickLabelLocator = ".v-slider__tick-label";

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
        UIElement thumb = getThumbContainer().get(1);
        double minValue = Double.parseDouble(thumb.getAttribute("aria-valuemin"));
        double maxValue = Double.parseDouble(thumb.getAttribute("aria-valuemax"));
        List<Double> nowValue = Arrays.stream(thumb.getAttribute("aria-valuenow").split(","))
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
        UIElement thumb = getThumbContainer().get(1);
        double minValue = Double.parseDouble(thumb.getAttribute("aria-valuemin"));
        double maxValue = Double.parseDouble(thumb.getAttribute("aria-valuemax"));
        List<Double> nowValue = Arrays.stream(thumb.getAttribute("aria-valuenow").split(","))
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
        return core().hasClass(DISABLED_CLASS);
    }

    @JDIAction("Check if '{name}' vertical")
    public boolean isVertical() {
        return core().hasClass(VERTICAL_CLASS);
    }

    @JDIAction("Check if ticks of '{name}' always show")
    public boolean isAlwaysShow() {
        return $(ticksContainerLocator, this).hasClass(ALWAYS_SHOW_CLASS);
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
