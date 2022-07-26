package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.vuetify.asserts.SliderAssert;
import com.epam.jdi.light.vuetify.elements.common.Icon;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.init.UIFactory.$$;

/**
 * To see an example of Slider web element please visit https://vuetifyjs.com/en/components/sliders
 */
public class Slider extends UIBaseElement<SliderAssert> implements HasLabel {

    private static final String DISABLED = "v-slider--disabled";
    private static final String READONLY = "v-slider--readonly";
    private static final String VERTICAL = "v-slider--vertical";
    private static final String HORIZONTAL = "v-slider--horizontal";
    private static final String ALWAYS_SHOW = "v-slider__ticks-container--always-show";

    private static final String THUMB_CONTAINER_LOCATOR = ".v-slider__thumb-container";
    private static final String THUMB_LOCATOR = ".v-slider__thumb";
    private static final String THUMB_LABEL_CONTAINER_LOCATOR = ".v-slider__thumb-label-container";
    private static final String THUMB_LABEL_LOCATOR = ".v-slider__thumb-label";

    private static final String TRACK_CONTAINER_LOCATOR = ".v-slider__track-container";
    private static final String TRACK_BACKGROUND_LOCATOR = ".v-slider__track-background";

    private static final String ICON_LOCATOR = ".v-icon";

    private static final String TICKS_CONTAINER_LOCATOR = ".v-slider__ticks-container";
    private static final String TICK_LOCATOR = ".v-slider__tick";
    private static final String TICK_LABEL_LOCATOR = ".v-slider__tick-label";

    private static final String HINT_LABEL_LOCATOR = ".v-messages__message";

    @JDIAction("Get track container from '{name}'")
    protected UIElement trackContainer() {
        return $(TRACK_CONTAINER_LOCATOR, this);
    }

    @JDIAction("Get track from {name}")
    public UIElement track() {
        return core().find(".v-slider__track-fill");
    }

    @JDIAction("Get thumb container from '{name}'")
    protected UIElement thumbContainer() {
        return $(THUMB_CONTAINER_LOCATOR, this);
    }

    @JDIAction("Get track background from '{name}'")
    public UIElement background() {
        return $(TRACK_BACKGROUND_LOCATOR, trackContainer());
    }

    @JDIAction("Get thumb from '{name}'")
    public UIElement thumb() {
        return $(THUMB_LOCATOR, thumbContainer());
    }

    @JDIAction("Get thumb label from '{name}'")
    public Label thumbLabel() {
        return new Label().setCore(Label.class, core().find(THUMB_LABEL_LOCATOR));
    }

    @JDIAction("Get slider icon from '{name}'")
    public Icon icon() {
        return new Icon().setCore(Icon.class, core().find(ICON_LOCATOR));
    }

    @JDIAction("Get tick from '{name}'")
    public WebList ticks() {
        return $$(TICK_LOCATOR, this);
    }

    @JDIAction("Get tick label value from '{name}'")
    public String tickLabel(int index) {
        return $$(TICK_LABEL_LOCATOR, this).get(index).getValue();
    }

    @JDIAction("Get hint message label from {name}")
    public String hintLabel() {
        try {
            return $(HINT_LABEL_LOCATOR, this).getText();
        } catch (Exception ignore) {
            return "";
        }
    }

    @JDIAction("Get value from '{name}'")
    public String value() {
        return $("input", this).getAttribute("value");
    }

    @JDIAction("Get thumb label value from '{name}'")
    public String thumbLabelValue() {
        return thumbLabel().getValue();
    }

    @JDIAction("Set horizontal slider from '{name}' to {0}")
    public void slideHorizontalTo(String givenValue) {
        double value = Double.parseDouble(givenValue);
        double trackWidth = trackContainer().getSize().width;
        double minValue = Double.parseDouble(thumbContainer().getAttribute("aria-valuemin"));
        double maxValue = Double.parseDouble(thumbContainer().getAttribute("aria-valuemax"));
        if (value < minValue || value > maxValue) {
            return;
        }
        double nowValue = Double.parseDouble(thumbContainer().getAttribute("aria-valuenow"));
        double pixelsInUnit = trackWidth / (maxValue - minValue);
        double xOffset = (value - nowValue) * pixelsInUnit;
        thumbContainer().dragAndDropTo((int) Math.round(xOffset), 0);
    }

    @JDIAction("Set vertical slider from '{name}' to {0}")
    public void slideVerticalTo(String givenValue) {
        double value = Double.parseDouble(givenValue);
        double trackHeight = trackContainer().getSize().height;
        double minValue = Double.parseDouble(thumbContainer().getAttribute("aria-valuemin"));
        double maxValue = Double.parseDouble(thumbContainer().getAttribute("aria-valuemax"));
        if (value < minValue || value > maxValue) {
            return;
        }
        double nowValue = Double.parseDouble(thumbContainer().getAttribute("aria-valuenow"));
        double pixelsInUnit = trackHeight / (maxValue - minValue);
        double yOffset = (value - nowValue) * pixelsInUnit;
        thumb().dragAndDropTo(0, -(int) Math.round(yOffset));
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

    @JDIAction("Check if {name} horizontal")
    public boolean isHorizontal() {
        return core().hasClass(HORIZONTAL);
    }

    @JDIAction("Check if ticks of '{name}' always show")
    public boolean isAlwaysShow() {
        return $(TICKS_CONTAINER_LOCATOR, this).hasClass(ALWAYS_SHOW);
    }

    @JDIAction("Check if thumb lable of '{name}' displayed")
    public boolean isThumbLabelDisplayed() {
        return !$(THUMB_LABEL_CONTAINER_LOCATOR, thumbContainer()).getAttribute("style").contains("display: none");
    }

    @Override
    public SliderAssert is() {
        return new SliderAssert().set(this);
    }

    @Override
    @JDIAction("Get '{name}' label")
    public Label label() {
        Label label = new Label().setCore(Label.class, find("label"));
        return label;
    }
}
