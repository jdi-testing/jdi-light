package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.RippleAssert;
import com.epam.jdi.light.angular.elements.common.Checkbox;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;

/**
 * To see an example of Ripple web element please visit https://material.angular.io/components/ripple/overview.
 */

public class Ripple extends UIBaseElement<RippleAssert> {
    public static final String STYLE = "style";
    public static final int INSCRIBED_CIRCLE_RADIUS = 150;
    public static final String HEIGHT_SPX_WIDTH_SPX = "height: %spx; width: %spx;";
    public static final String LEFT_SPX_TOP_SPX = "left: %spx; top: %spx;";
    public String containerLocator = "//*[@id='ripple-container']";
    public String rippleLocator = containerLocator.concat("/div");
    public String centeredCheckboxLocator = containerLocator
            .concat("/preceding-sibling::mat-checkbox[@id='ripple-centered-checkbox']");
    public String disabledCheckboxLocator = containerLocator
            .concat("/preceding-sibling::mat-checkbox[@id='ripple-disabled-checkbox']");
    public String unboundedCheckboxLocator = containerLocator
            .concat("/preceding-sibling::mat-checkbox[@id='ripple-unbounded-checkbox']");
    public String radiusLocator = containerLocator
            .concat("/preceding-sibling::mat-form-field[@id='ripple-radius-input']//input");
    public String colorLocator = containerLocator
            .concat("/preceding-sibling::mat-form-field[@id='ripple-color-input']//input");
    public String smartSharp = "smart: #";
    public String cssSharp = "css='#";
    private final Checkbox rippleCenteredCheckbox;
    private final Checkbox rippleDisabledCheckbox;
    private final Checkbox rippleUnboundedCheckbox;

    public Ripple() {
        rippleCenteredCheckbox = new Checkbox();
        rippleDisabledCheckbox = new Checkbox();
        rippleUnboundedCheckbox = new Checkbox();
    }

    @Override
    public boolean isDisplayed() {
        return container().isDisplayed() && centeredCheckbox().isDisplayed() && disabledCheckbox().isDisplayed()
                && unboundedCheckbox().isDisplayed() && getRadiusInput().isDisplayed() && getColorInput().isDisplayed();
    }

    @JDIAction("Ripple '{name}'")
    public void ripple() {
        container().click();
    }
    /**
     * Activate ripple by coordinates.
     *
     * @param x integer coordinate of the mouse click point; bound [0, 300)
     * @param y integer coordinate of the mouse click point; bound [0, 300)
     */
    @JDIAction("Ripple '{name}' by coordinates x:'{0}'; y:'{1}'")
    public void ripple(final int x, final int y) {
        container().click(x, y);
    }

    @JDIAction("Enable '{name}' ripple")
    public void enable() {
        if (rippleDisabledCheckbox.isSelected()) {
            rippleDisabledCheckbox.click();
        }
    }

    @JDIAction("Disable '{name}' ripple")
    public void disable() {
        if (!rippleDisabledCheckbox.isSelected()) {
            rippleDisabledCheckbox.click();
        }
    }

    @JDIAction("Bound '{name}' ripple")
    public void bound() {
        if (rippleUnboundedCheckbox.isSelected()) {
            rippleUnboundedCheckbox.click();
        }
    }

    @JDIAction("Unbound '{name}' ripple")
    public void unbound() {
        if (!rippleUnboundedCheckbox.isSelected()) {
            rippleUnboundedCheckbox.click();
        }
    }

    @JDIAction("Decentralize '{name}' ripple")
    public void decentralize() {
        if (rippleCenteredCheckbox.isSelected()) {
            rippleCenteredCheckbox.click();
        }
    }

    @JDIAction("Center '{name}' ripple")
    public void center() {
        if (!rippleCenteredCheckbox.isSelected()) {
            rippleCenteredCheckbox.click();
        }
    }

    @JDIAction("Is '{name}' ripple disabled")
    @Override
    public boolean isDisabled() {
        return rippleDisabledCheckbox.isSelected();
    }

    @JDIAction("Is '{name}' ripple unbounded")
    public boolean isUnbounded() {
        return rippleUnboundedCheckbox.isSelected();
    }

    @JDIAction("Is '{name}' ripple centered")
    public boolean isCentered() {
        return rippleCenteredCheckbox.isSelected();
    }

    @JDIAction("Is '{name}' ripple active")
    public boolean isActive() {
        return getRipple().isDisplayed();
    }

    /**
     * Check the center of the ripple is as indicated.
     *
     * @param x integer coordinate of the mouse click point; bound [0, 300)
     * @param y integer coordinate of the mouse click point; bound [0, 300)
     * @return boolean value
     */
    @JDIAction("Is '{name}' ripple center by coordinates x:'{0}'; y:'{1}'")
    public boolean isRippleCenter(final int x, final int y) {
        int inputSubtract = Math.abs(x - y);
        if (getRipple().isDisplayed()) {
            String style = getRipple().attr(STYLE);
            String left = "left: -";
            int xBeginIndex = style.lastIndexOf(left) + left.length();
            int xEndIndex = style.indexOf("px; top:");
            String actualX = style.substring(xBeginIndex, xEndIndex);
            String top = "top: -";
            int yBeginIndex = style.lastIndexOf(top) + top.length();
            int yEndIndex = style.indexOf("px; height:");
            String actualY = style.substring(yBeginIndex, yEndIndex);
            int actualSubtract = Math.abs(Math.abs(
                    Math.round(Float.parseFloat(actualX)) - Math.abs(Math.round(Float.parseFloat(actualY)))));
            return Math.abs(inputSubtract - actualSubtract) <= 1;
        }
        return false;
    }

    @JDIAction("Input radius '{0}' for '{name}' ripple")
    public void setRadius(final int radius) {
        getRadiusInput().sendKeys(String.valueOf(radius));
    }

    @JDIAction("Input color '{0}' for '{name}' ripple")
    public void setColor(final String color) {
        getColorInput().sendKeys(color);
    }

    @JDIAction("Is '{name}' ripple radius: '{0}'")
    public boolean isRadius(final int radius) {
        return radius == Integer.parseInt(getRadiusInput().getValue());
    }

    @JDIAction("Is '{name}' ripple color: '{0}'")
    public boolean isColor(final String color) {
        return color.equalsIgnoreCase(getColorInput().getValue());
    }

    @JDIAction("Get '{name}' ripple color")
    public String color() {
        if (isCorrectColor()) {
            String style = getRipple().attr(STYLE);
            String backgroundColor = "background-color: ";
            int beginIndex = style.lastIndexOf(backgroundColor) + backgroundColor.length();
            int endIndex = style.indexOf("; transition-duration:");
            return style.substring(beginIndex, endIndex);
        } else {
            return "Color is not specified or has an incorrect value.";
        }
    }

    @JDIAction("Get '{name}' ripple radius")
    public int radius() {
        if (isCorrectRadius()) {
            String style = getRipple().attr(STYLE);
            String height = "height: ";
            int beginIndex = style.lastIndexOf(height) + height.length();
            int endIndex = style.indexOf("px; width:");
            int result;
            try {
                result = Integer.parseInt(style.substring(beginIndex, endIndex));
            } catch (NumberFormatException exception) {
                return -1;
            }
            return result / 2;
        } else {
            return -1;
        }
    }

    @JDIAction("Is '{name}' input radius correct")
    public boolean isCorrectRadius() {
        ripple();
        boolean isHeight = getRipple().attr(STYLE).contains("height:");
        boolean isWidth = getRipple().attr(STYLE).contains("width:");
        return isHeight && isWidth;
    }

    @JDIAction("Is '{name}' input color correct")
    public boolean isCorrectColor() {
        ripple();
        return getRipple().attr(STYLE).contains("background-color");
    }

    @JDIAction(level = DEBUG, timeout = 0)
    public void clearRadius() {
        UIElement radiusInput = getRadiusInput();
        if (!radiusInput.getValue().isEmpty()) {
            radiusInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
            radiusInput.click(getOutsidePoint().getX(), getOutsidePoint().getY());
        }
    }

    @JDIAction(level = DEBUG, timeout = 0)
    public void clearColor() {
        UIElement colorInput = getColorInput();
        if (!colorInput.getValue().isEmpty()) {
            colorInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
            colorInput.click(getOutsidePoint().getX(), getOutsidePoint().getY());
        }
    }

    @Override
    public RippleAssert is() {
        return new RippleAssert().set(this);
    }

    protected UIElement container() {
        return new UIElement(By.xpath(String.format(containerLocator,
                                                    this.uiElement.locator.printLocator().replace(smartSharp, "")
                                                            .replace(cssSharp, "").replace("'", ""))));
    }

    protected UIElement getRipple() {
        return new UIElement(By.xpath(String.format(rippleLocator,
                                                    this.uiElement.locator.printLocator().replace(smartSharp, "")
                                                            .replace(cssSharp, "").replace("'", ""))));
    }

    protected UIElement centeredCheckbox() {
        return new UIElement(By.xpath(String.format(centeredCheckboxLocator,
                                                    this.uiElement.locator.printLocator().replace(smartSharp, "")
                                                            .replace(cssSharp, "").replace("'", ""))));
    }

    protected UIElement disabledCheckbox() {
        return new UIElement(By.xpath(String.format(disabledCheckboxLocator,
                                                    this.uiElement.locator.printLocator().replace(smartSharp, "")
                                                            .replace(cssSharp, "").replace("'", ""))));
    }

    protected UIElement unboundedCheckbox() {
        return new UIElement(By.xpath(String.format(unboundedCheckboxLocator,
                                                    this.uiElement.locator.printLocator().replace(smartSharp, "")
                                                            .replace(cssSharp, "").replace("'", ""))));
    }

    protected UIElement getRadiusInput() {
        return new UIElement(By.xpath(String.format(radiusLocator,
                                                    this.uiElement.locator.printLocator().replace(smartSharp, "")
                                                            .replace(cssSharp, "").replace("'", ""))));
    }

    protected UIElement getColorInput() {
        return new UIElement(By.xpath(String.format(colorLocator,
                                                    this.uiElement.locator.printLocator().replace(smartSharp, "")
                                                            .replace(cssSharp, "").replace("'", ""))));
    }

    protected Point getOutsidePoint() {
        return new Point(uiElement.core().getRect().getWidth() + 2, uiElement.core().getRect().getHeight() + 2);
    }
}
