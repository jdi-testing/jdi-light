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

    int localwidth = width;
    int localLeft = left;
    if (isSwitch(thumbIndex, value, localLeft, width)) {
      int right = localLeft + width;

      if (thumbIndex == 1) {
        String rightStyle =  thumb(2).getAttribute("style");

        setAttributes(2, value, newThumbStyle);

        setAttributes(1, right, rightStyle);
        localLeft = right;
        localwidth = value;
      } else {
        String leftStyle =  thumb(1).getAttribute("style");

        setAttributes(1, value, newThumbStyle);

        setAttributes(2, localLeft, leftStyle);
        localLeft = width;
        localwidth = value;
      }

    } else {
      setAttributes(thumbIndex, value, newThumbStyle);
      if (thumbIndex == 1) {
        localwidth += localLeft;
        localLeft = value;
      } else {
        localwidth = value;
      }

    }

    track().setAttribute(style, newStyle);
    input().setAttribute("value",localLeft + "," + width);
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
    int localLeft = left;

    switch (thumbIndex) {
      case 1: return  (value > width + localLeft);
      case 2: return (value < localLeft);
      default: break;
    }
    return false;
  }
  private String setNewStyle(String style, int thumbIndex, int value, int left, int width) {
    String localStyle = style;
    int localLeft = left;
    switch (thumbIndex) {
      case 1:
        if (value > localLeft) {
          if (value > width + localLeft) {
            localLeft = width + localLeft;
            width = value - localLeft;
          } else {
            width -= value - localLeft;
            localLeft = value;
          }

        } else {
          width += localLeft - value;
          localLeft = value;
        }
        break;
      case 2:
        width += value - width - localLeft;
        if (width < 0) {
          width = localLeft - value;
          localLeft = value;
        }
      default: break;
    }
    localStyle = localStyle.replaceAll("[-?0-9]+", "");
    int start = localStyle.indexOf(" ");
    int end = localStyle.lastIndexOf(" ");
    return localStyle.substring(0,start + 1) + localLeft + localStyle.substring(start + 1, end + 1) + width +
            localStyle.substring(end + 1);
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
