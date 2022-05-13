package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.inputs.SliderRangeAssert;
import com.epam.jdi.light.material.interfaces.inputs.ISlider;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

/**
 * To see an example of Slider web element please visit
 * https://mui.com/components/slider/
 */

public class SliderRange extends UIBaseElement<SliderRangeAssert> implements ISlider {


    private static final String ARIA_VALUENOW = "aria-valuenow";
    private static final String STYLE = "style";
    private static final String ARIA_VALUETEXT = "aria-valuetext";


    private UIElement input() {
        return core().find(By.tagName("input"));
    }

    private void setAttributes(int thumbIndex, int value, String newThumbStyle) {
        thumb(thumbIndex).setAttribute(ARIA_VALUENOW, String.valueOf(value));
        thumb(thumbIndex).setAttribute(STYLE, newThumbStyle);
        thumb(thumbIndex).setAttribute(ARIA_VALUETEXT, String.valueOf(value));
    }

    private void reflectionSetValue(int thumbIndex, String newThumbStyle,
                                  String newStyle, int value, int left, int width) {

        int localWidth = width;
        int localLeft = left;
        if (isSwitch(thumbIndex, value, localLeft, localWidth)) {
            int right = localLeft + localWidth;

            if (thumbIndex == 1) {
                String rightStyle =  thumb(2).getAttribute("style");
                setAttributes(2, value, newThumbStyle);
                setAttributes(1, right, rightStyle);
                localLeft = right;
                localWidth = value;
            } else {
                String leftStyle =  thumb(1).getAttribute("style");

                setAttributes(1, value, newThumbStyle);

                setAttributes(2, localLeft, leftStyle);
                localLeft = localWidth;
                localWidth = value;
            }
        } else {
            setAttributes(thumbIndex, value, newThumbStyle);
            if (thumbIndex == 1) {
                localWidth += localLeft;
                localLeft = value;
            } else {
                localWidth = value;
            }
        }
        track().setAttribute(STYLE, newStyle);
        input().setAttribute("value", localLeft + "," + localWidth);
    }

//    @JDIAction(value = "Set value '{value}' for '{name}'")
//    public void setValue(int thumbIndex, int value) {
//        String thumbStyle = thumb(thumbIndex).getAttribute(STYLE);
//        int thumbStyleIndex = thumbStyle.lastIndexOf(" ");
//        String newThumbStyle = thumbStyle.substring(0, thumbStyleIndex + 1) + value + "%;";
//
//        String trackStyle = track().getAttribute(STYLE);
//
//        String[] styles = trackStyle.replaceAll("[^-?0-9]+", " ").trim().split(" ");
//
//        int left = Integer.parseInt(styles[0]);
//        int width = Integer.parseInt(styles[1]);
//        String newStyle = setNewStyle(trackStyle, thumbIndex, value, left, width);
//
//        reflectionSetValue(thumbIndex, newThumbStyle, newStyle, value, left, width);
//
//    }

    private boolean isSwitch(int thumbIndex, int value, int left, int width) {
        boolean result = false;

        switch (thumbIndex) {
            case 1:
                result = value > width + left;
                break;
            case 2:
                result = value < left;
                break;
            default: break;
        }
        return result;
    }

//    private String setNewStyle(String style, int thumbIndex, int value, int left, int width) {
//        String localStyle = style;
//        int localLeft = left;
//        int localWidth = width;
//        switch (thumbIndex) {
//            case 1:
//                if (value > localLeft) {
//                if (value > localWidth + localLeft) {
//                        localLeft = localWidth + localLeft;
//                        localWidth = value - localLeft;
//                    } else {
//                        localWidth -= value - localLeft;
//                        localLeft = value;
//                    }
//                } else {
//                    localWidth += localLeft - value;
//                    localLeft = value;
//                }
//                break;
//            case 2:
//                localWidth += value - localWidth - localLeft;
//                if (localWidth < 0) {
//                    localWidth = localLeft - value;
//                    localLeft = value;
//                }
//                break;
//            default: break;
//        }
//        localStyle = localStyle.replaceAll("[-?0-9]+", "");
//        int start = localStyle.indexOf(" ");
//        int end = localStyle.lastIndexOf(" ");
//        return localStyle.substring(0, start + 1) + localLeft + localStyle.substring(start + 1, end + 1) + localWidth
//                + localStyle.substring(end + 1);
//    }

//    public UIElement thumb(int index) {
//        return core().finds(".MuiSlider-thumb").get(index);
//    }

//    @JDIAction(value = "Move '{name}' carriage to right")
//    public void moveRight(int thumbIndex) {
//        thumb(thumbIndex).click();
//        thumb(thumbIndex).sendKeys(Keys.ARROW_RIGHT);
//    }

//    @JDIAction(value = "Move '{name}' carriage to left")
//    public void moveLeft(int thumbIndex) {
//        thumb(thumbIndex).click();
//        thumb(thumbIndex).sendKeys(Keys.ARROW_LEFT);
//    }

//    @JDIAction(value = "Get '{name}' orientation")
//    public Orientation orientation() {
//        return thumb(1).attr("aria-orientation");
//    }

//    @JDIAction(value = "Get '{name}' value")
//    public int value(int index) {
//        return getInteger(ARIA_VALUENOW, thumb(index).core(), 0);
//    }

    @JDIAction(value = "drag & drop to the value '{0}' of '{name}'")
    public void slideHorizontalTo(int thumbIndex,  int value) {
        int xOffset = getHorizontalShiftInPixels(thumbIndex, value);
        thumb(thumbIndex).dragAndDropTo(xOffset, 0);
    }

    private int getHorizontalShiftInPixels(int thumbIndex,  int value) {
        return (value - Integer.parseInt(value(thumbIndex))) * getScaleHorizontalWidth();
    }

    private int getScaleHorizontalWidth() {
        return core().getSize().width / 100;
    }

    @Override
    public SliderRangeAssert is() {
        return new SliderRangeAssert().set(this);
    }
}
