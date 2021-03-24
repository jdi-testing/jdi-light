package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.inputs.SliderRangeAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.epam.jdi.light.material.elements.inputs.Slider.getInteger;

public class SliderRange extends UIBaseElement<SliderRangeAssert> {

  private final static String areaValueNow = "aria-valuenow";
  private final static String style = "style";
  private final static String ariaValueText = "aria-valuetext";
  private int iOiginalValue; //auxiliary variable to keep original integer values;
  private int Localvariable; //local variable for substitution instead of parameter reflectionSetValue to Avoid reassigning parameters

  public UIElement track() {
    return core().find(By.cssSelector(".MuiSlider-track"));
  }

  private UIElement input() {
    return core().find(By.tagName("input"));
  }

  private void setAttributes(int thumbIndex, int value, String newThumbStyle) {
    thumb(thumbIndex).setAttribute(areaValueNow, String.valueOf(value));
    thumb(thumbIndex).setAttribute(style, newThumbStyle);
    thumb(thumbIndex).setAttribute(ariaValueText, value + "°C");
  }

  private void reflectionSetValue(int thumbIndex, String newThumbStyle,
                                  String newStyle, int value, int left, int width) {
    iOiginalValue = left;
    Localvariable = left;
    if (isSwitch(thumbIndex, value, Localvariable, width)) {
      int right = Localvariable + width;

      if (thumbIndex == 1) {
        String rightStyle =  thumb(2).getAttribute("style");

        setAttributes(2, value, newThumbStyle);

        setAttributes(1, right, rightStyle);
        Localvariable = right;
        width = value;
      } else {
        String leftStyle =  thumb(1).getAttribute("style");

        setAttributes(1, value, newThumbStyle);

        setAttributes(2, Localvariable, leftStyle);
        Localvariable = width;
        width = value;
      }

    } else {
      setAttributes(thumbIndex, value, newThumbStyle);
      if (thumbIndex == 1) {
        width += Localvariable;
        Localvariable = value;
      } else {
        width = value;
      }
    }

    track().setAttribute(style, newStyle);
    input().setAttribute("value", Localvariable + "," + width);
  }

  @JDIAction(value = "Set value '{value}' for '{name}'")
  public void setValue(int thumbIndex, int value) {
    String thumbStyle = thumb(thumbIndex).getAttribute(style);
    int thumbStyleIndex = thumbStyle.lastIndexOf(" ");
    String newThumbStyle = thumbStyle.substring(0, thumbStyleIndex+ 1) + value + "%;";

    String trackStyle = track().getAttribute(style);

    String[] styles = trackStyle.replaceAll("[^-?0-9]+", " ").trim().split(" ");

    int left = Integer.parseInt(styles[0]);
    int width = Integer.parseInt(styles[1]);
    String newStyle = setNewStyle(trackStyle, thumbIndex, value, left, width);

    reflectionSetValue(thumbIndex, newThumbStyle, newStyle, value, left, width);

  }

  private boolean isSwitch(int thumbIndex, int value, int left, int width) {
    switch (thumbIndex) {
      case 1: return  (value > width + left);
      case 2: return (value < left);
      default: break;
    }
    return false;
  }

  private String setNewStyle(String style, int thumbIndex, int value, int left, int width) {
   iOiginalValue = left;
    Localvariable = left;
    switch (thumbIndex) {
      case 1:
        if (value > Localvariable) {
          if (value > width + Localvariable) {
            Localvariable = width + Localvariable;
            width = value - Localvariable;
          } else {
            width -= value - Localvariable;
            Localvariable = value;
          }

        } else {
          width += Localvariable - value;
          Localvariable = value;
        }
        break;
      case 2:
        width += value - width - Localvariable;
        if (width < 0) {
          width = Localvariable - value;
          Localvariable = value;
        }
      default: break;
    }
    style = style.replaceAll("[-?0-9]+", "");
    int start = style.indexOf(" ");
    int end = style.lastIndexOf(" ");
    return style.substring(0,start + 1) + left + style.substring(start + 1, end + 1) + width +
        style.substring(end + 1);
  }

  public UIElement thumb(int index) {
    return core().finds(".MuiSlider-thumb").get(index);
  }

  @JDIAction(value = "Move '{name}' carriage to right")
  public void moveRight(int thumbIndex) {
    thumb(thumbIndex).click();
    thumb(thumbIndex).sendKeys(Keys.ARROW_RIGHT);
  }

  @JDIAction(value = "Move '{name}' carriage to left")
  public void moveLeft(int thumbIndex) {
    thumb(thumbIndex).click();
    thumb(thumbIndex).sendKeys(Keys.ARROW_LEFT);
  }

  @JDIAction(value = "Get '{name}' orientation")
  public String orientation() {
    return thumb(1).attr("aria-orientation");
  }

  @JDIAction(value = "Get '{name}' value")
  public int value(int index) {
    return getInteger(areaValueNow, thumb(index).core(), 0);
  }
  @JDIAction(value = "drag & drop to the value '{0}' of '{name}'")
  public void slideHorizontalTo(int thumbIndex,  int value) {
    int xOffset = getHorizontalShiftInPixels(thumbIndex, value);
    thumb(thumbIndex).dragAndDropTo(xOffset, 0);
  }
  private int getHorizontalShiftInPixels(int thumbIndex,  int value) {
    return (value - value(thumbIndex)) * getScaleHorizontalWidth();
  }

  private int getScaleHorizontalWidth() {
    return core().getSize().width / 100;
  }

  @Override
  public SliderRangeAssert is() {
    return new SliderRangeAssert().set(this);
  }
}