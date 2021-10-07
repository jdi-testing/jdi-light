package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.SliderAssert;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.init.UIFactory.$$;

/**
 * To see an example of Breadcrumb web element please visit https://vuetifyjs.com/en/components/sliders
 * <p>
 * Created by Anna Vasileva on 05.10.2021
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
    protected String ALWAYS_SHOW = ".v-slider__ticks-container--always-show";

    protected String DISABLED = "v-slider--disabled";
    protected String READONLY = "v-slider--readonly";


    @JDIAction("Get value from '{name}'")
    public String getValue() {
        return $("input", this).getAttribute("value");
    }

    @JDIAction("Get value from '{name}'")
    protected UIElement getTrackContainer() {
        return $(TRACK_CONTAINER_LOCATOR, this);
    }

    @JDIAction("Get value from '{name}'")
    protected UIElement getThumbContainer() {
        return $(THUMB_CONTAINER_LOCATOR, this);
    }

    @JDIAction("Get value from '{name}'")
    public void slideHorizontalTo(int value) {
        double trackWidth = getTrackContainer().getSize().width;
        double minValue = Double.parseDouble(getThumbContainer().getAttribute("aria-valuemin"));
        double maxValue = Double.parseDouble(getThumbContainer().getAttribute("aria-valuemax"));
        double nowValue = Double.parseDouble(getThumbContainer().getAttribute("aria-valuenow"));
        double pixelsInUnit = trackWidth / (maxValue - minValue);
        double nowWidth = (nowValue - minValue) * pixelsInUnit;
        double xOffset = (value - minValue) * pixelsInUnit - nowWidth;
        getThumbContainer().dragAndDropTo((int) Math.round(xOffset), 0);
    }

    @JDIAction("Get fill from '{name}'")
    public UIElement getFill() {
        return $(TRACK_FILL_LOCATOR, getTrackContainer());
    }

    @JDIAction("Get background from '{name}'")
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

    @JDIAction("Get thumb label value from '{name}'")
    public String getThumbLabelValue() {
        return $(THUMB_LABEL_LOCATOR, getThumbContainer()).getValue();
    }


    @JDIAction("Get value from '{name}'")
    public boolean isThumbLabelDisplayed() {
        return !$(THUMB_LABEL_CONTAINER_LOCATOR, getThumbContainer()).getAttribute("style").contains("display: none");
    }

    @Override
    @JDIAction("Get value from '{name}'")
    public boolean isDisabled() {
        return core().hasClass(DISABLED);
    }


    public boolean isReadonly() {
        return core().hasClass(READONLY);
    }

    public boolean isAlwaysShow() {
        return $(TICKS_CONTAINER_LOCATOR, this).hasClass(ALWAYS_SHOW);
    }

    @JDIAction("Get thumb label value from '{name}'")
    public boolean checkTrickSize(int width, int height) {
        boolean flag = true;

        for($$(TICK_LOCATOR, this)::get())
            {

            }
        $$(TICK_LOCATOR, this).foreach(tick -> {
            if(!tick.getAttribute("style").contains("width: " + width + "px"))
                flag =  false;
            tick.getAttribute("style").contains("height: " + height + "px");
        });
        return true;
    }

    @Override
    public SliderAssert is() {
        return new SliderAssert().set(this);
    }
}
