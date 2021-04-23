package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.inputs.SliderAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static java.lang.Integer.parseInt;

public class Slider extends UIBaseElement<SliderAssert> {

  @JDIAction(value = "Get '{name}' value")
  public int value() {
    return getInteger("aria-valuenow", thumb().core(), 0);
  }

  @JDIAction(value = "Set value '{0}' for '{name}'")
  public void setValue(int value) {
    if (this.isDisabled()){
      return;
    }

    String thumbStyle = thumb().getAttribute("style");
    int thumbStyleIndex = thumbStyle.lastIndexOf(" ");
    String newThumbStyle = thumbStyle.substring(0, thumbStyleIndex+ 1) + value + "%;";

    String trackStyle = track().getAttribute("style");

    trackStyle = setNewStyle(trackStyle, value);

    thumb().setAttribute("aria-valuenow", String.valueOf(value));
    thumb().setAttribute("style", newThumbStyle);
    track().setAttribute("style", trackStyle);
    core().find(By.tagName("input")).setAttribute("value", String.valueOf(value));
  }

  @JDIAction("Is '{name} disabled")
  @Override
  public boolean isDisabled() {
    return this.hasClass("Mui-disabled");
  }

  @JDIAction(value = "Get '{name}' orientation")
  public String orientation() {
    return thumb().attr("aria-orientation");
  }

  @JDIAction(value = "drag & drop based on percentage length of '{name}'")
  public void slideVerticalTo(int value) {
    int yOffset = getVerticalShiftInPixels(value);
    thumb().dragAndDropTo(0, yOffset);
  }

  @JDIAction(value = "drag & drop to the value '{0}' of '{name}'")
  public void slideHorizontalTo(int value) {
    double coreHorizontalWidth = core().getSize().width;
    double trackHorizontalWidth = track().getSize().width;
    double minValue = Double.parseDouble(thumb().getAttribute("aria-valuemin"));
    double maxValue = Double.parseDouble(thumb().getAttribute("aria-valuemax"));
    double pixelsInUnit = coreHorizontalWidth / (maxValue - minValue);
    double xOffset = (value - minValue) * pixelsInUnit - trackHorizontalWidth;
    thumb().dragAndDropTo((int)Math.round(xOffset), 0);
  }

//  private int getHorizontalShiftInPixels(int value) {
//    return getScaleHorizontalWidth() * value - getTrackHorizontalWidth();
//  }

  @JDIAction(value = "Move '{name}' carriage to right")
  public void moveRight() {
    thumb().click();
    thumb().sendKeys(Keys.ARROW_RIGHT);
  }

  @JDIAction(value = "Move '{name}' carriage to left")
  public void moveLeft() {
    thumb().click();
    thumb().sendKeys(Keys.ARROW_LEFT);
  }

  private int getVerticalShiftInPixels(int value) {
    return getTrackVerticalHeight() - getScaleVerticalHeight() * value;
  }

  private int getScaleVerticalHeight() {
    return core().getSize().height / 100;
  }

  private int getTrackVerticalHeight() {
    return track().getSize().height;
  }

//  private int getTrackHorizontalWidth() {
//    return track().getSize().width;
//  }
//
//  private int getScaleHorizontalWidth() {
//    return core().getSize().width / 100;
//  }

  public UIElement track() {
    return core().find(By.cssSelector(".MuiSlider-track"));
  }

  public UIElement thumb() {
    return core().find(".MuiSlider-thumb");
  }

  public static int getInteger(String attr, WebElement el, int defaultValue) {
    String value = el.getAttribute(attr);
    try {
      return parseInt(value);
    } catch (Exception ex) { return defaultValue; }
  }

  private String setNewStyle(String style, int value) {
    String styleLocal = style.replaceAll("[-?0-9]+", "");
    int perInx = styleLocal.indexOf("%");
    return styleLocal.substring(0, perInx) + 0 + styleLocal.substring(perInx, styleLocal.length() - 2)
            + value + styleLocal.substring(styleLocal.length() - 2);
  }

  @Override
  public SliderAssert is() {
    return new SliderAssert().set(this);
  }
}
