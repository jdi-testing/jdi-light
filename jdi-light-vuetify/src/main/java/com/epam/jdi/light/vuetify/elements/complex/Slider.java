package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.vuetify.asserts.SliderAssert;
import com.epam.jdi.light.vuetify.elements.common.Icon;
import com.epam.jdi.light.vuetify.interfaces.HasMessages;
import com.epam.jdi.light.vuetify.interfaces.HasOrientation;
import com.epam.jdi.light.vuetify.interfaces.IsReadOnly;

import java.util.List;

import static com.epam.jdi.light.common.Exceptions.runtimeException;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.init.UIFactory.$$;

/**
 * To see an example of Slider web element please visit https://vuetifyjs.com/en/components/sliders
 */
public class Slider extends UIBaseElement<SliderAssert> implements HasLabel, HasOrientation, IsReadOnly, HasMessages {

    private static final String DISABLED = "v-slider--disabled";
    private static final String ALWAYS_SHOW = "v-slider__ticks-container--always-show";
    private static final String THUMB_CONTAINER_LOCATOR = ".v-slider__thumb-container";
    private static final String THUMB_LOCATOR = ".v-slider__thumb";
    private static final String THUMB_LABEL_CONTAINER_LOCATOR = ".v-slider__thumb-label-container";
    private static final String THUMB_LABEL_LOCATOR = ".v-slider__thumb-label";
    private static final String TRACK_CONTAINER_LOCATOR = ".v-slider__track-container";
    private static final String TRACK_BACKGROUND_LOCATOR = ".v-slider__track-background";
    private static final String PREPEND_OUTER_ICON = "//ancestor::div[contains(@class, 'v-input')]//div[contains" +
            "(@class, 'v-input__prepend-outer')]//button[contains(@class, 'v-icon')]";
    private static final String APPEND_OUTER_ICON = "//ancestor::div[contains(@class, 'v-input')]//div[contains" +
            "(@class, 'v-input__append-outer')]//button[contains(@class, 'v-icon')]";
    private static final String PREPEND_INNER_ICON = "//ancestor::div[contains(@class, 'v-input')]//div[contains" +
            "(@class, 'v-input__prepend-inner')]//button[contains(@class, 'v-icon')]";
    private static final String APPEND_INNER_ICON = "//ancestor::div[contains(@class, 'v-input')]//div[contains" +
            "(@class, 'v-input__append-inner')]//button[contains(@class, 'v-icon')]";
    private static final String TICKS_CONTAINER_LOCATOR = ".v-slider__ticks-container";
    private static final String TICK_LOCATOR = ".v-slider__tick";
    private static final String TICK_LABEL_LOCATOR = ".v-slider__tick-label";
    private static final String MESSAGE_LOCATOR = "//ancestor::*[contains(@class, 'v-messages__message')]";
    private static final String ERROR_MESSAGE_LOCATOR = "//ancestor::div[contains(@class, 'error--text')]//*[contains(@class, 'v-messages__message')]";
    private static final String SUCCESS_MESSAGE_LOCATOR = "//ancestor::div[contains(@class, 'success--text')]//*[contains" +
            "(@class, 'v-messages__message')]";

    @JDIAction("Get '{name}' track container")
    protected UIElement trackContainer() {
        return $(TRACK_CONTAINER_LOCATOR, this);
    }

    @JDIAction("Get '{name}' track")
    public UIElement track() {
        return core().find(".v-slider__track-fill");
    }

    @JDIAction("Get '{name}' thumb container")
    protected UIElement thumbContainer() {
        return $(THUMB_CONTAINER_LOCATOR, this);
    }

    @JDIAction("Get '{name}' track background")
    public UIElement background() {
        return $(TRACK_BACKGROUND_LOCATOR, trackContainer());
    }

    @JDIAction("Get '{name}' thumb")
    public UIElement thumb() {
        return $(THUMB_LOCATOR, thumbContainer());
    }

    @JDIAction("Get '{name}' thumb label")
    public Label thumbLabel() {
        return new Label().setCore(Label.class, core().find(THUMB_LABEL_LOCATOR));
    }

    @JDIAction("Get '{name}' slider prepend outer icon")
    public Icon prependOuterIcon() {
        return new Icon().setCore(Icon.class, core().find(PREPEND_OUTER_ICON));
    }

    @JDIAction("Get '{name}' slider prepend inner icon")
    public Icon prependInnerIcon() {
        return new Icon().setCore(Icon.class, core().find(PREPEND_INNER_ICON));
    }

    @JDIAction("Get '{name}' slider append outer icon")
    public Icon appendOuterIcon() {
        return new Icon().setCore(Icon.class, core().find(APPEND_OUTER_ICON));
    }

    @JDIAction("Get '{name}' slider prepend inner icon")
    public Icon appendInnerIcon() {
        return new Icon().setCore(Icon.class, core().find(APPEND_INNER_ICON));
    }

    @JDIAction("Get '{name}' tick")
    public WebList ticks() {
        return $$(TICK_LOCATOR, this);
    }

    @JDIAction("Get if '{name}' thumb label is exist")
    public boolean hasThumbLabel() {
        return thumbLabel().isExist();
    }

    @JDIAction("Get '{name}' tick label value")
    public String tickLabel(int index) {
        return $$(TICK_LABEL_LOCATOR, this).get(index).getValue();
    }

    @Override
    @JDIAction("Get '{name}' messages")
    public List<UIElement> messages() {
        return messages(MESSAGE_LOCATOR);
    }

    @Override
    @JDIAction("Get '{name}' messages text")
    public List<String> messagesText() {
        return messagesText(MESSAGE_LOCATOR);
    }

    @Override
    @JDIAction("Get '{name}' error messages")
    public List<String> errorMessagesText() {
        return messagesText(ERROR_MESSAGE_LOCATOR);
    }

    @Override
    @JDIAction("Get '{name}' success messages")
    public List<String> successMessagesText() {
        return messagesText(SUCCESS_MESSAGE_LOCATOR);
    }


    @JDIAction("Get '{name}' value")
    public double value() {
        return Double.parseDouble($("input", this).getAttribute("value"));
    }

    @JDIAction("Get '{name}' thumb label value")
    public int thumbLabelValue() {
        return Integer.parseInt(thumbLabel().getValue());
    }

    @JDIAction("Set '{name}' horizontal slider to '{0}'")
    public void slideHorizontalTo(Double givenValue) {
        double value = givenValue;
        double trackWidth = trackContainer().getSize().width;
        UIElement thumb = thumbContainer();
        double minValue = Double.parseDouble(thumb.getAttribute("aria-valuemin"));
        double maxValue = Double.parseDouble(thumb.getAttribute("aria-valuemax"));
        if (value < minValue || value > maxValue) {
            throw runtimeException(String.format("The value %f is not valid for interval [%f, %f]", value, minValue, maxValue));
        }
        double nowValue = Double.parseDouble(thumb.getAttribute("aria-valuenow"));
        double pixelsInUnit = trackWidth / (maxValue - minValue);
        double xOffset = (value - nowValue) * pixelsInUnit;
        thumb.dragAndDropTo((int) Math.round(xOffset), 0);
    }

    @JDIAction("Set vertical slider from '{name}' to {0}")
    public void slideVerticalTo(Double givenValue) {
        double value = givenValue;
        double trackHeight = trackContainer().getSize().height;
        UIElement thumb = thumbContainer();
        double minValue = Double.parseDouble(thumb.getAttribute("aria-valuemin"));
        double maxValue = Double.parseDouble(thumb.getAttribute("aria-valuemax"));
        if (value < minValue || value > maxValue) {
            throw runtimeException(String.format("The value %f is not valid for interval [%f, %f]", value, minValue, maxValue));
        }
        double nowValue = Double.parseDouble(thumb.getAttribute("aria-valuenow"));
        double pixelsInUnit = trackHeight / (maxValue - minValue);
        double yOffset = (value - nowValue) * pixelsInUnit;
        thumb.dragAndDropTo(0, -(int) Math.round(yOffset));
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

    @JDIAction("Get if thumb label of '{name}' displayed")
    public boolean isThumbLabelDisplayed() {
        return !$(THUMB_LABEL_CONTAINER_LOCATOR, thumbContainer()).getAttribute("style").contains("display: none");
    }

    @Override
    @JDIAction("Get '{name}' label")
    public Label label() {
        Label label = new Label().setCore(Label.class, find("label"));
        return label;
    }

    @JDIAction("Get '{name}' ticks height")
    public int ticksHeight() {
        return Integer.parseInt(ticks().get(1).css("height").replace("px", ""));
    }

    @JDIAction("Get '{name}' ticks width")
    public int ticksWidth() {
        return Integer.parseInt(ticks().get(1).css("width").replace("px", ""));
    }

    @JDIAction("Get '{name}' thumb color")
    public String thumbColor() {
        return thumb().css("color");
    }

    @JDIAction("Get '{name}' track color")
    public String trackColor() {
        return track().css("background-color");
    }

    @JDIAction("Get '{name}' track background color")
    public String backgroundTrackColor() {
        return background().css("background-color");
    }

    @JDIAction("Get '{name}' thumb size")
    public int thumbSize() {
        return Integer.parseInt(thumb().css("font-size").replace("px", ""));
    }

    @Override
    public SliderAssert is() {
        return new SliderAssert().set(this);
    }
}
