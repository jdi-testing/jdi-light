package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.vuetify.asserts.RangeSliderAssert;
import com.epam.jdi.light.vuetify.elements.common.Icon;
import com.epam.jdi.light.vuetify.elements.common.ProgressLinear;
import com.epam.jdi.light.elements.interfaces.base.HasColor;
import com.epam.jdi.light.vuetify.interfaces.HasDetailsHidden;
import com.epam.jdi.light.vuetify.interfaces.HasMeasurement;
import com.epam.jdi.light.vuetify.interfaces.HasMessages;
import com.epam.jdi.light.vuetify.interfaces.HasOrientation;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.vuetify.interfaces.IsDense;
import com.epam.jdi.light.vuetify.interfaces.IsLoading;
import com.epam.jdi.light.vuetify.interfaces.IsReadOnly;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.init.UIFactory.$$;

/**
 * To see an example of Range Slider web element please visit https://vuetifyjs.com/en/components/range-sliders
 */
public class RangeSlider extends UIBaseElement<RangeSliderAssert> implements HasLabel, HasOrientation, IsReadOnly, HasMessages, HasTheme,
    IsDense, HasColor, HasMeasurement, HasDetailsHidden, IsLoading {

    private static final String DISABLED = "v-slider--disabled";
    private static final String ALWAYS_SHOW = "v-slider__ticks-container--always-show";
    private static final String THUMB_CONTAINER_LOCATOR = ".v-slider__thumb-container";
    private static final String THUMB_LOCATOR = ".v-slider__thumb";
    private static final String THUMB_LABEL_LOCATOR = ".v-slider__thumb-label";
    private static final String THUMB_LABEL_CONTAINER_LOCATOR = ".v-slider__thumb-label-container";
    private static final String TRACK_CONTAINER_LOCATOR = ".v-slider__track-container";
    private static final String TRACK_BACKGROUND_LOCATOR = ".v-slider__track-background";
    private static final String TRACK_FILL_LOCATOR = ".v-slider__track-fill";
    private static final String TICKS_CONTAINER_LOCATOR = ".v-slider__ticks-container";
    private static final String TICK_LOCATOR = ".v-slider__tick";
    private static final String TICK_LABEL_LOCATOR = ".v-slider__tick-label";
    public static final String LABEL_LOCATOR = ".v-label";
    private static final String INPUT = "//ancestor::div[contains(@class, 'v-input--range-slider')]";
    private static final String INPUT_SLOT = "//ancestor::div[contains(@class, 'v-input__slot')]";
    private static final String APPEND_OUTER_ICON = "//div[contains(@class, 'v-input__append-outer')]//*[contains(@class, 'v-icon')]";
    private static final String PREPEND_OUTER_ICON = "//div[contains(@class, 'v-input__prepend-outer')]//*[contains(@class, 'v-icon')]";
    public static final String LOADER_LOCATOR = ".v-progress-linear";

    @JDIAction("Get '{name}' track container")
    public UIElement input() {
        return $(INPUT, this);
    }

    @JDIAction("Get '{name}' track container")
    public UIElement inputSlot() {
        return $(INPUT_SLOT, this);
    }

    @JDIAction("Get '{name}' track container")
    public UIElement trackContainer() {
        return $(TRACK_CONTAINER_LOCATOR, this);
    }

    @JDIAction("Get '{name}' track")
    public UIElement track() {
        return $(TRACK_FILL_LOCATOR, this);
    }

    @JDIAction("Get '{name}' thumb container")
    protected WebList thumbContainer() {
        return $$(THUMB_CONTAINER_LOCATOR, this);
    }

    @JDIAction("Get '{name}' track background ")
    public WebList trackBackground() {
        return $$(TRACK_BACKGROUND_LOCATOR, trackContainer());
    }

    @JDIAction("Get '{name} left thumb'")
    public UIElement leftThumb() {
        return $(THUMB_LOCATOR, thumbContainer().get(1));
    }

    @JDIAction("Get '{name}' right thumb")
    public UIElement rightThumb() {
        return $(THUMB_LOCATOR, thumbContainer().get(2));
    }

    @JDIAction("Get '{name}' thumb label")
    private List<Label> thumbLabels() {
        WebList webList = $$(THUMB_LABEL_LOCATOR, this);
        return webList.stream().map(element -> new Label().setCore(Label.class, element)).collect(Collectors.toList());
    }

    @JDIAction("Get '{name}' thumb label value")
    public List<String> thumbLabelValue() {
        return thumbLabels()
            .stream()
            .map(thumbLabel -> {
                WebList label = thumbLabel.finds("i");
                if (label.isEmpty()) {
                    return thumbLabel.find("span").getText();
                } else {
                    return label.first().getAttribute("class");
                }
            }).collect(Collectors.toList());
    }

    @JDIAction("Get '{name}' tick")
    public WebList ticks() {
        return $$(TICK_LOCATOR, this);
    }

    @JDIAction("Get '{name}' tick label value")
    public String tickLabel(int index) {
        return $$(TICK_LABEL_LOCATOR, this).get(index).getValue();
    }

    @JDIAction("Get '{name}' prepend outer icon")
    public Icon prependOuterIcon() {
        return new Icon().setCore(Icon.class, input().find(PREPEND_OUTER_ICON));
    }

    @JDIAction("Get '{name}' append outer icon")
    public Icon appendOuterIcon() {
        return new Icon().setCore(Icon.class, input().find(APPEND_OUTER_ICON));
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
    public List<Double> value() {
        return new WebList(core().findElements(By.cssSelector("input")))
            .stream()
            .map(input -> Double.parseDouble(input.getAttribute("value")))
            .collect(Collectors.toList());
    }

    @JDIAction("Get '{name}' value")
    public Double leftValue() {
        return Double.parseDouble(core().findElement(By.cssSelector("[id*='input-min']")).getAttribute("value"));
    }

    @JDIAction("Get '{name}' right value")
    public Double rightValue() {
        return Double.parseDouble(core().findElement(By.cssSelector("[id*='input-max']")).getAttribute("value"));
    }

    @JDIAction("Get '{name}' min value")
    public double minValue() {
        return Double.parseDouble(thumbContainer().get(1).getAttribute("aria-valuemin"));
    }

    @JDIAction("Get '{name}' max value")
    public double maxValue() {
        return Double.parseDouble(thumbContainer().get(1).getAttribute("aria-valuemax"));
    }

    @JDIAction("Set '{name}' left value to {0}")
    public void setLeftValue(double valueLeft) {
        Double nowLeftValue = value().get(0);
        Dimension trackSize = trackContainer().getSize();
        boolean isVertical = isVertical();
        double trackDimension = isVertical ? trackSize.height : trackSize.width;
        double offset = offset(valueLeft, trackDimension, nowLeftValue);
        if (isVertical) {
            dragAndDropToYOffsetLeft(offset);
        } else {
            dragAndDropToXOffsetLeft(offset);
        }
    }

    @JDIAction("Set '{name}' right value to {0}")
    public void setRightValue(double valueRight) {
        Double nowRightValue = value().get(1);
        Dimension trackSize = trackContainer().getSize();
        boolean isVertical = isVertical();
        double trackDimension = isVertical ? trackSize.getHeight() : trackSize.getWidth();
        double offset = offset(valueRight, trackDimension, nowRightValue);
        if (isVertical) {
            dragAndDropToYOffsetRight(offset);
        } else {
            dragAndDropToXOffsetRight(offset);
        }
    }

    @JDIAction("Set '{name}' to {0}, {1}")
    public void setValue(double valueLeft, double valueRight) {
        List<Double> nowValue = value();
        Dimension trackSize = trackContainer().getSize();
        boolean isVertical = isVertical();
        double trackDimension = isVertical ? trackSize.getHeight() : trackSize.getWidth();
        double leftOffset = offset(valueLeft, trackDimension, nowValue.get(0));
        double rightOffsetY = offset(valueRight, trackDimension, nowValue.get(1));
        if (isVertical) {
            dragAndDropToYOffsetLeft(leftOffset);
            dragAndDropToYOffsetRight(rightOffsetY);
        } else {
            dragAndDropToXOffsetLeft(leftOffset);
            dragAndDropToXOffsetRight(rightOffsetY);
        }
    }

    private double offset(double expectedValue, double trackDimension, Double nowValue) {
        double pixelsInUnit = trackDimension / (maxValue() - minValue());
        return (expectedValue - nowValue) * pixelsInUnit;
    }

    private void dragAndDropToXOffsetLeft(double offset) {
        leftThumb().dragAndDropTo((int) Math.round(offset), 0);
    }

    private void dragAndDropToXOffsetRight(double offset) {
        rightThumb().dragAndDropTo((int) Math.round(offset), 0);
    }

    private void dragAndDropToYOffsetLeft(double offset) {
        leftThumb().dragAndDropTo(0, -(int) Math.round(offset));
    }

    private void dragAndDropToYOffsetRight(double offset) {
        rightThumb().dragAndDropTo(0, -(int) Math.round(offset));
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
        return leftThumb().css("color");
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
        return thumbLabels().get(1).getSize().getHeight();
    }

    @Override
    @JDIAction("Get '{name}' height")
    public int height() {
        return inputSlot().getSize().getHeight();
    }

    @JDIAction("Clicking outside the sheet '{0}'")
    public void clickOutsideOfSlider() {
        input().click(0, 0);
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
    public boolean isTicksAlwaysShow() {
        return $(TICKS_CONTAINER_LOCATOR, this).hasClass(ALWAYS_SHOW);
    }

    @Override
    @JDIAction("Get if '{name}' is dense")
    public boolean isDense() {
        return input().attr("class").contains("--dense");
    }

    @JDIAction("Get if '{name}' is error")
    public boolean isError() {
        return input().hasClass("error--text");
    }

    @JDIAction("Get if '{name}' is success")
    public boolean isSuccess() {
        return input().hasClass("success--text");
    }

    @Override
    @JDIAction("Get if '{name}' is loading")
    public boolean isLoading() {
        return input().attr("class").contains("-loading");
    }

    @JDIAction("Get if '{name}' thumb labels is exist")
    public boolean hasThumbLabels() {
        return thumbLabels().stream().anyMatch(ICoreElement::isEnabled);
    }

    @JDIAction("Get if '{name}' has inverse label")
    public Boolean hasInverseLabel() {
        return input().attr("class").contains("--inverse-label");
    }

    @JDIAction("Get if thumb label of '{name}' displayed")
    public boolean isThumbLabelDisplayed() {
        return hasThumbLabels() && new WebList(core().findElements(By.cssSelector(THUMB_LABEL_CONTAINER_LOCATOR)))
            .stream()
            .noneMatch(label -> label.getAttribute("style").contains("display: none"));
    }

    @Override
    @JDIAction("Get if {name} has details hidden")
    public boolean hasDetailsHidden() {
        return input().attr("class").contains("-hide-details");
    }

    @Override
    public RangeSliderAssert is() {
        return new RangeSliderAssert().set(this);
    }
}
