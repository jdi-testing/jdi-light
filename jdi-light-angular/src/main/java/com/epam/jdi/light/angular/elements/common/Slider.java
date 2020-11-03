package com.epam.jdi.light.angular.elements.common;

import com.epam.jdi.light.angular.asserts.SliderAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.base.SetValue;
import org.openqa.selenium.Keys;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.light.ui.html.HtmlUtils.getDouble;

/**
 * To see an example of Slider web element please visit https://material.angular.io/components/slider/overview.
 */

public class Slider extends UIBaseElement<SliderAssert> implements HasLabel, SetValue {

    @JDIAction(value = "Get '{name}' min limit", level = DEBUG)
    public double min() {
        return getDouble("aria-valuemin", core(), 0);
    }

    @JDIAction(value = "Get '{name}' max limit", level = DEBUG)
    public double max() {
        return getDouble("aria-valuemax", core(), 100);
    }

    @JDIAction(value = "Get '{name}' value", level = DEBUG)
    public double value() {
        return getDouble("aria-valuenow", core(), 0);
    }

    @JDIAction(value = "Get '{name}' orientation", level = DEBUG)
    public String orientation() {
        return core().attr("aria-orientation");
    }

    @JDIAction(value = "Is '{name}' inverted", level = DEBUG)
    public boolean isInverted() {
        return core().hasClass("mat-slider-axis-inverted");
    }

    @JDIAction(value = "Is '{name}' thumb label displayed", level = DEBUG)
    public boolean isThumbLabelDisplayed() {
        return core().find(".mat-slider-thumb-label-text").isVisible();
    }

    @JDIAction(value = "Set value '{0}' for '{name}'", level = DEBUG)
    public void setupValue(double value) {
        core().setAttribute("aria-valuenow", value + "");

        UIElement sliderTrackBackground = core().find(".mat-slider-track-background");
        UIElement sliderTrackFill = core().find(".mat-slider-track-fill");
        UIElement sliderThumbContainer = core().find(".mat-slider-thumb-container");

        reflectSliderChangeOnUI(value, sliderTrackBackground, sliderTrackFill, sliderThumbContainer);
    }

    public void setValue(String value) {
        core().setAttribute("aria-valuenow", value);

        UIElement sliderTrackBackground = core().find(".mat-slider-track-background");
        UIElement sliderTrackFill = core().find(".mat-slider-track-fill");
        UIElement sliderThumbContainer = core().find(".mat-slider-thumb-container");

        reflectSliderChangeOnUI(Double.parseDouble(value), sliderTrackBackground, sliderTrackFill, sliderThumbContainer);
    }

    private void reflectSliderChangeOnUI(double value, UIElement sliderTrackBackground, UIElement sliderTrackFill, UIElement sliderThumbContainer) {
        double max = max();
        String currentTrackBackground = sliderTrackBackground.attr("style");
        String currentTrackFill = sliderTrackFill.attr("style");
        String currentThumbContainer = sliderThumbContainer.attr("style");

        String newTrackBackgroundValue = (1 - (value / max)) + "";
        String newTrackFillValue = value / max + "";
        String newThumbValue = (int) ((1 - (value / max)) * 100) + "";

        int backgroundStartPoint = currentTrackBackground.indexOf("3d(");
        int backgroundEndPoint = currentTrackBackground.indexOf(",");
        int fillStartPoint = currentTrackFill.indexOf("3d(");
        int fillEndPoint = currentTrackFill.indexOf(",");
        int thumbStartPoint = currentThumbContainer.indexOf("-");
        int thumbEndPoint = currentThumbContainer.indexOf("%");

        String newTrackBackground = currentTrackBackground.substring(0, backgroundStartPoint + 3) + newTrackBackgroundValue + currentTrackBackground.substring(backgroundEndPoint);
        String newTrackFill = currentTrackFill.substring(0, fillStartPoint + 3) + newTrackFillValue + currentTrackFill.substring(fillEndPoint).replace("display: none;", "");
        String newThumbContainer = currentThumbContainer.substring(0, thumbStartPoint) + "-" + newThumbValue + currentThumbContainer.substring(thumbEndPoint);

        sliderTrackBackground.setAttribute("style", newTrackBackground);
        sliderTrackFill.setAttribute("style", newTrackFill);
        sliderThumbContainer.setAttribute("style", newThumbContainer);
    }

    @JDIAction(value = "drag & drop based on percentage length of '{name}'", level = DEBUG)
    public void slide(double percentage) {
        int xOffset = (int) Math.round(percentage * getStepInPixels(core()));
        core().find(".mat-slider-thumb").dragAndDropTo(xOffset, 0);
    }

    private Double getStepInPixels(UIElement uiElement) {
        return core().getSize().width / 100.0;
    }

    @JDIAction(value = "Move '{name}' carriage to right", level = DEBUG)
    public void moveRight() {
        core().sendKeys(Keys.ARROW_RIGHT);
    }

    @JDIAction(value = "Move '{name}' carriage to left", level = DEBUG)
    public void moveLeft() {
        core().sendKeys(Keys.ARROW_LEFT);
    }

    @JDIAction("Is '{name} disabled")
    @Override
    public boolean isDisabled() {
        return core().attr("aria-disabled").equals("true");
    }

    @JDIAction("Is '{name} enabled")
    @Override
    public boolean isEnabled() {
        return !isDisabled();
    }

    @Override
    public String getValue() {
        return value() + "";
    }

    @Override
    public SliderAssert is() {
        return new SliderAssert().set(this);
    }
}
