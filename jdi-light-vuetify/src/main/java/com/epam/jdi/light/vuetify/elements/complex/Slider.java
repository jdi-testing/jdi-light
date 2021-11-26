package com.epam.jdi.light.vuetify.elements.complex;

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

    private static final String DISABLED = "v-slider--disabled";
    private static final String READONLY = "v-slider--readonly";
    private static final String VERTICAL = "v-slider--vertical";
    private static final String ALWAYS_SHOW = "v-slider__ticks-container--always-show";

    private String thumbContainerLocator = ".v-slider__thumb-container";
    private String thumbLocator = ".v-slider__thumb";
    private String thumbLabelContainerLocator = ".v-slider__thumb-label-container";
    private String thumbLabelLocator = ".v-slider__thumb-label";

    private String trackContainerLocator = ".v-slider__track-container";
    private String trackBackgroundLocator = ".v-slider__track-background";
    private String trackFillLocator = ".v-slider__track-fill";

    private String ticksContainerLocator = ".v-slider__ticks-container";
    private String tickLocator = ".v-slider__tick";
    private String tickLabelLocator = ".v-slider__tick-label";

    @JDIAction("Get track container from '{name}'")
    protected UIElement getTrackContainer() {
        return $(trackContainerLocator, this);
    }

    @JDIAction("Get thumb container from '{name}'")
    protected UIElement getThumbContainer() {
        return $(thumbContainerLocator, this);
    }

    @JDIAction("Get track fill from '{name}'")
    public UIElement getFill() {
        return $(trackFillLocator, getTrackContainer());
    }

    @JDIAction("Get track background from '{name}'")
    public UIElement getBackground() {
        return $(trackBackgroundLocator, getTrackContainer());
    }

    @JDIAction("Get thumb from '{name}'")
    public UIElement getThumb() {
        return $(thumbLocator, getThumbContainer());
    }

    @JDIAction("Get thumb label from '{name}'")
    public UIElement getThumbLabel() {
        return $(thumbLabelLocator, getThumbContainer());
    }

    @JDIAction("Get tick from '{name}'")
    public WebList getTicks() {
        return $$(tickLocator, this);
    }

    @JDIAction("Get tick label value from '{name}'")
    public String getTickLabel(int index) {
        return $$(tickLabelLocator, this).get(index).getValue();
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
        return $(ticksContainerLocator, this).hasClass(ALWAYS_SHOW);
    }

    @JDIAction("Check if thumb lable of '{name}' displayed")
    public boolean isThumbLabelDisplayed() {
        return !$(thumbLabelContainerLocator, getThumbContainer()).getAttribute("style").contains("display: none");
    }

    @Override
    public SliderAssert is() {
        return new SliderAssert().set(this);
    }
}
