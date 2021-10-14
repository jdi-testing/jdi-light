package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.asserts.SliderAssert;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.init.UIFactory.$$;

/**
 * To see an example of Breadcrumb web element please visit https://vuetifyjs.com/en/components/sliders
 */
public class Slider extends UIBaseElement<SliderAssert> {

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
    protected String READONLY = "v-slider--readonly";
    protected String VERTICAL = "v-slider--vertical";

    @JDIAction("Get track container from '{name}'")
    protected UIElement getTrackContainer() {
        return $(TRACK_CONTAINER_LOCATOR, this);
    }

    @JDIAction("Get thumb container from '{name}'")
    protected UIElement getThumbContainer() {
        return $(THUMB_CONTAINER_LOCATOR, this);
    }

    @JDIAction("Get track fill from '{name}'")
    public UIElement getFill() {
        return $(TRACK_FILL_LOCATOR, getTrackContainer());
    }

    @JDIAction("Get track background from '{name}'")
    public UIElement getBackground() {
        return $(TRACK_BACKGROUND_LOCATOR, getTrackContainer());
    }

    @JDIAction("Get thumb from '{name}'")
    public UIElement getThumb() {
        return $(THUMB_LOCATOR, getThumbContainer());
    }

    @JDIAction("Get thumb label from '{name}'")
    public UIElement getThumbLabel() {
        return $(THUMB_LABEL_LOCATOR, getThumbContainer());
    }

    @JDIAction("Get tick from '{name}'")
    public WebList getTicks() {
        return $$(TICK_LOCATOR, this);
    }

    @JDIAction("Get tick label value from '{name}'")
    public String getTickLabel(int index) {
        return $$(TICK_LABEL_LOCATOR, this).get(index).getValue();
    }

    @JDIAction("Get value from '{name}'")
    public String getValue() {
        return $("input", this).getAttribute("value");
    }

    @JDIAction("Get thumb label value from '{name}'")
    public String getThumbLabelValue() {
        return getThumbLabel().getValue();
    }

    @JDIAction("Set horizontal slider from '{name}' to {0}")
    public void slideHorizontalTo(int value) {
        double trackWidth = getTrackContainer().getSize().width;
        double minValue = Double.parseDouble(getThumbContainer().getAttribute("aria-valuemin"));
        double maxValue = Double.parseDouble(getThumbContainer().getAttribute("aria-valuemax"));
        double nowValue = Double.parseDouble(getThumbContainer().getAttribute("aria-valuenow"));
        double pixelsInUnit = trackWidth / (maxValue - minValue);
        double xOffset = (value - nowValue) * pixelsInUnit;
        getThumbContainer().dragAndDropTo((int) Math.round(xOffset), 0);
    }

    @JDIAction("Set vertical slider from '{name}' to {0}")
    public void slideVerticalTo(int value) {
        double trackHeight = getTrackContainer().getSize().height;
        double minValue = Double.parseDouble(getThumbContainer().getAttribute("aria-valuemin"));
        double maxValue = Double.parseDouble(getThumbContainer().getAttribute("aria-valuemax"));
        double nowValue = Double.parseDouble(getThumbContainer().getAttribute("aria-valuenow"));
        double pixelsInUnit = trackHeight / (maxValue - minValue);
        double yOffset = (value - nowValue) * pixelsInUnit;
        getThumb().dragAndDropTo(0, -(int) Math.round(yOffset));
    }

    @Override
    @JDIAction("Check if '{name}' disabled")
    public boolean isDisabled() {
        return core().hasClass(DISABLED);
    }

    @JDIAction("Check if '{name}' readonly")
    public boolean isReadonly() {
        return core().hasClass(READONLY);
    }

    @JDIAction("Check if '{name}' vertical")
    public boolean isVertical() {
        return core().hasClass(VERTICAL);
    }

    @JDIAction("Check if ticks of '{name}' always show")
    public boolean isAlwaysShow() {
        return $(TICKS_CONTAINER_LOCATOR, this).hasClass(ALWAYS_SHOW);
    }

    @JDIAction("Check if thumb lable of '{name}' displayed")
    public boolean isThumbLabelDisplayed() {
        return !$(THUMB_LABEL_CONTAINER_LOCATOR, getThumbContainer()).getAttribute("style").contains("display: none");
    }

    @Override
    public SliderAssert is() {
        return new SliderAssert().set(this);
    }
}
