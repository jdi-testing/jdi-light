package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.vuetify.asserts.SliderAssert;
import com.epam.jdi.light.vuetify.elements.common.Icon;
import com.epam.jdi.light.vuetify.elements.common.ProgressLinear;
import com.epam.jdi.light.vuetify.interfaces.HasColor;
import com.epam.jdi.light.vuetify.interfaces.HasDetailsHidden;
import com.epam.jdi.light.vuetify.interfaces.HasMeasurement;
import com.epam.jdi.light.vuetify.interfaces.HasMessages;
import com.epam.jdi.light.vuetify.interfaces.HasOrientation;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.vuetify.interfaces.IsDense;
import com.epam.jdi.light.vuetify.interfaces.IsLoading;
import com.epam.jdi.light.vuetify.interfaces.IsReadOnly;

import java.util.List;

import static com.epam.jdi.light.common.Exceptions.runtimeException;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.init.UIFactory.$$;

/**
 * To see an example of Slider web element please visit https://vuetifyjs.com/en/components/sliders
 */
public class Slider extends UIBaseElement<SliderAssert> implements HasLabel, HasOrientation, IsReadOnly, HasMessages, HasTheme,
    IsDense, HasColor, HasMeasurement, HasDetailsHidden, IsLoading {

    public static final String LABEL_LOCATOR = ".v-label";
    private static final String DISABLED = "v-slider--disabled";
    private static final String ALWAYS_SHOW = "v-slider__ticks-container--always-show";
    private static final String THUMB_CONTAINER_LOCATOR = ".v-slider__thumb-container";
    private static final String THUMB_LOCATOR = ".v-slider__thumb";
    private static final String THUMB_LABEL_LOCATOR = ".v-slider__thumb-label";
    private static final String TRACK_CONTAINER_LOCATOR = ".v-slider__track-container";
    private static final String TRACK_FILL_LOCATOR = ".v-slider__track-fill";
    private static final String TRACK_BACKGROUND_LOCATOR = ".v-slider__track-background";
    private static final String TICKS_CONTAINER_LOCATOR = ".v-slider__ticks-container";
    private static final String TICK_LOCATOR = ".v-slider__tick";
    private static final String TICK_LABEL_LOCATOR = ".v-slider__tick-label";
    private static final String INPUT = "//ancestor::div[contains(@class, 'v-input')]";
    private static final String INPUT_SLOT = "//ancestor::div[contains(@class, 'v-input__slot')]";
    private static final String APPEND_OUTER_ICON = "//ancestor::div[contains(@class, 'v-input')]//div[contains" +
        "(@class, 'v-input__append-outer')]//button[contains(@class, 'v-icon')]";
    private static final String PREPEND_OUTER_ICON = "//ancestor::div[contains(@class, 'v-input')]//div[contains" +
        "(@class, 'v-input__prepend-outer')]//button[contains(@class, 'v-icon')]";
    public static final String LOADER_LOCATOR = ".v-progress-linear";

    @JDIAction("Get '{name}' track container")
    protected UIElement input() {
        return $(INPUT, this);
    }

    @JDIAction("Get '{name}' track container")
    protected UIElement inputSlot() {
        return $(INPUT_SLOT, this);
    }

    @JDIAction("Get '{name}' track container")
    protected UIElement trackContainer() {
        return $(TRACK_CONTAINER_LOCATOR, this);
    }

    @JDIAction("Get '{name}' track")
    public UIElement track() {
        return $(TRACK_FILL_LOCATOR, this);
    }

    @JDIAction("Get '{name}' thumb container")
    protected UIElement thumbContainer() {
        return $(THUMB_CONTAINER_LOCATOR, this);
    }

    @JDIAction("Get '{name}' track background")
    public UIElement trackBackground() {
        return $(TRACK_BACKGROUND_LOCATOR, trackContainer());
    }

    @JDIAction("Get '{name}' thumb")
    public UIElement thumb() {
        return $(THUMB_LOCATOR, thumbContainer());
    }

    @JDIAction("Get '{name}' tick")
    public WebList ticks() {
        return $$(TICK_LOCATOR, this);
    }

    @JDIAction("Get '{name}' tick label value")
    public String tickLabel(int index) {
        return $$(TICK_LABEL_LOCATOR, this).get(index).getValue();
    }

    @JDIAction("Get '{name}' thumb label")
    public Label thumbLabel() {
        return new Label().setCore(Label.class, core().find(THUMB_LABEL_LOCATOR));
    }

    @JDIAction("Get '{name}' slider prepend outer icon")
    public Icon prependOuterIcon() {
        return new Icon().setCore(Icon.class, core().find(PREPEND_OUTER_ICON));
    }

    @JDIAction("Get '{name}' slider append outer icon")
    public Icon appendOuterIcon() {
        return new Icon().setCore(Icon.class, core().find(APPEND_OUTER_ICON));
    }

    @JDIAction("Get '{name}' loader")
    public ProgressLinear loader() {
        return new ProgressLinear().setCore(ProgressLinear.class, inputSlot().find(LOADER_LOCATOR));
    }

    @Override
    @JDIAction("Get '{name}' label")
    public Label label() {
        return new Label().setCore(Label.class, inputSlot().find(LABEL_LOCATOR));
    }

    @Override
    @JDIAction("Get '{name}' messages text by locator '{0}'")
    public List<UIElement> messages(String locator) {
        return input().finds(locator);
    }

    @JDIAction("Get '{name}' value")
    public double value() {
        return Double.parseDouble($("input", this).getAttribute("value"));
    }

    @JDIAction("Get '{name}' min value")
    public double minValue() {
        return Double.parseDouble(thumbContainer().getAttribute("aria-valuemin"));
    }
    @JDIAction("Get '{name}' max value")
    public double maxValue() {
        return Double.parseDouble(thumbContainer().getAttribute("aria-valuemax"));
    }

    @JDIAction("Set '{name}' slider to '{0}'")
    public void setValue(Double value) {
        double minValue = minValue();
        double maxValue = maxValue();
        UIElement thumb = thumbContainer();
        UIElement track = trackContainer();
        if (value < minValue || value > maxValue) {
            throw runtimeException(String.format("The value %f is not valid for interval [%f, %f]", value, minValue, maxValue));
        }
        double nowValue = Double.parseDouble(thumb.getAttribute("aria-valuenow"));
        boolean isVertical = isVertical();
        double trackSize = isVertical ? track.getSize().height : track.getSize().width;
        double pixelsInUnit = trackSize / (maxValue - minValue);
        double offset = (value - nowValue) * pixelsInUnit;
        if(!isVertical) {
            thumb.dragAndDropTo((int) Math.round(offset), 0);
        } else {
            thumb.dragAndDropTo(0, -(int) Math.round(offset));
        }
    }

    @JDIAction("Get '{name}' ticks size")
    public int ticksSize() {
        return Integer.parseInt(ticks().get(1).css("width").replace("px", ""));
    }
    @Override
    @JDIAction("Get '{name}' background color")
    public String backgroundColor() {
        return inputSlot().css("background-color");
    }
    @JDIAction("Get '{name}' thumb color")
    public String thumbColor() {
        return thumb().css("color");
    }

    @JDIAction("Get '{name}' track fill color")
    public String trackFillColor() {
        return track().css("background-color");
    }

    @JDIAction("Get '{name}' track background color")
    public String trackBackgroundColor() {
        return trackBackground().css("background-color");
    }

    @JDIAction("Get '{name}' thumb size")
    public int thumbSize() {
        return Integer.parseInt(thumb().css("font-size").replace("px", ""));
    }

    @Override
    @JDIAction("Get '{name}' height")
    public int height() {
        return inputSlot().getSize().getHeight();
    }

    @JDIAction("Clicking outside the sheet '{0}'")
    public void clickOutsideOfSlider() {
        core().click(0, 0);
    }

    @Override
    @JDIAction("Get if '{name}' disabled")
    public boolean isDisabled() {
        return core().hasClass(DISABLED);
    }

    @Override
    @JDIAction("Get if '{name}' enabled")
    public boolean isEnabled() {
        return !isDisabled();
    }

    @JDIAction("Get if ticks of '{name}' always show")
    public boolean isAlwaysShow() {
        return $(TICKS_CONTAINER_LOCATOR, this).hasClass(ALWAYS_SHOW);
    }

    @Override
    @JDIAction("Check that '{name}' is dense")
    public boolean isDense() {
        return input().attr("class").contains("--dense");
    }

    @JDIAction("Check that '{name}' is error")
    public boolean isError() {
        return input().hasClass("error--text");
    }

    @JDIAction("Check that '{name}' is success")
    public boolean isSuccess() {
        return input().hasClass("success--text");
    }

    @Override
    @JDIAction("Check that '{name}' is loading")
    public boolean isLoading() {
        return input().attr("class").contains("-loading");
    }

    @JDIAction("Check that '{name}' thumb label is exist")
    public boolean hasThumbLabel() {
        return thumbLabel().isExist();
    }

    @JDIAction("Get '{name}' inverse label")
    public Boolean hasInverseLabel() {
        return input().attr("class").contains("--inverse-label");
    }

    @Override
    @JDIAction("Check that {name} has details hidden")
    public boolean hasDetailsHidden() {
        return input().attr("class").contains("-hide-details");
    }

    @Override
    public SliderAssert is() {
        return new SliderAssert().set(this);
    }
}
